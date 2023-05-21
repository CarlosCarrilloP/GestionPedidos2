package carlosPedido;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.Scanner;

import conexionBBDD.Conexion;
import conexionBBDD.TestConexion;
import ficherosEscrituraLectura.TratamientoFicheros;

/**
 * @author Carlos Carrillo V 0.3 Añadida la funcionalidad:
 * 
 *         Conexion con la base de datos
 *         Carga de clientes
 *         Carga de productos
 *         Guardado de un cliente nuevo
 */
public class GestionPedidos extends TratamientoFicheros {
	/**
     * Lista de clientes cargados.
     */
	static ArrayList<Cliente> clientes = Cliente.cargarClienteBBDD();
	/**
     * Sentencia SQL para insertar datos en la tabla de clientes.
     */
	private static String insertTableSQL;

	/**
     * Método principal que ejecuta la gestión de pedidos.
     *
     * @param args Argumentos de línea de comandos (no se utilizan).
     * @throws FileNotFoundException Si no se encuentra un archivo.
     * @throws IOException           Si ocurre un error de entrada/salida.
     */
	@SuppressWarnings("unused")
	public static void main(String[] args) throws FileNotFoundException, IOException {
		Conexion conexion = new Conexion();
		Connection cn = null;
		Statement stm = null;
		ResultSet rs = null;

		String rutaCliente = "C:/Users/Carlos Carrillo/eclipse-workspace/GestionPedidos2/src/carlosPedido/Cliente.txt";
		double totalefectivo = 0;
		Scanner sc = new Scanner(System.in);

		System.out.println("#####MENU INICIAL#####");
		System.out.println("Debes de crear 3 clientes ");
		System.out.println("Y 5 productos");
		System.out.println("Pulsa intro para continuar");
		String a = sc.nextLine();

		// Creacion de los clientes

		System.out.println("1. Crear un Cliente Nuevo");
		System.out.println("2. Continuar con el cliente ya creado");

		Cliente cliente1 = new Cliente("", "", "", "");
		Cliente cliente2 = new Cliente("", "", "", "");
		Cliente cliente3 = new Cliente("", "", "", "");
		Cliente cliente4 = new Cliente("", "", "", "");

		int selectClient = sc.nextInt();

		switch (selectClient) {
		case 1:
			System.out.println("Has elegido: Crear un cliente nuevo");
			System.out.print("Ingresa el nombre del Cliente nuevo: ");
			sc.nextLine();
			String nombre4 = sc.nextLine();
			System.out.print("Ingresa el apellido del Cliente nuevo: ");
			String apellido4 = sc.nextLine();
			System.out.print("Ingresa el telefono del Cliente nuevo: ");
			String telefono4 = sc.nextLine();
			System.out.print("Ingresa la dirección del Cliente nuevo: ");
			String direccion4 = sc.nextLine();

			// Crear el cliente4 con los datos ingresados por el usuario
			cliente4 = new Cliente(nombre4, apellido4, telefono4, direccion4);

			PreparedStatement ps = null;

			// Sentencia SQL para insertar en la base de datos
			insertTableSQL = "INSERT INTO cliente (nombre,apellidos,telefono,direccion) VALUES (?,?,?,?)";

			try {

				cn = conexion.conectar();
				ps = cn.prepareStatement(insertTableSQL);

				ps.setString(1, nombre4);
				ps.setString(2, apellido4);
				ps.setString(3, telefono4);
				ps.setString(4, direccion4);
				ps.executeUpdate();

				System.out.println("El registro ha sido insertado con exito en la base de datos");

			} catch (SQLException e) { // TODO: handle exception

				e.printStackTrace();

			} finally { // Liberar recursos revisar el orden en el que se cierran
			
				TestConexion.cerrar_conexion3(cn, stm, rs);
			}

			

			break;
		case 2:
			System.out.println(" Has elegido: Continuar con el cliente ya creado");
			ArrayList<Cliente> clientes = Cliente.cargarClienteBBDD();

			break;
		}
		// Cargar Productos
		
		Producto b = new Producto();

		ArrayList<Producto> prueba = b.cargarProductosBBDD();

		// MENU PEDIDOS

		System.out.println("#####MENU PEDIDOS#####");
		System.out.println("1.Realizar Pedidos");

		/*
		 * En realizar pedidos, primero nos pedirá el cliente con el teléfono y luego el
		 * producto o los productos si son mas de uno
		 */

		System.out.println("Introduce el número de teléfono del cliente:");
		String telefono = sc.next();

		boolean encontrado = false;
		Cliente clienteEncontrado = null;

		for (Cliente cliente : clientes) {
		    if (cliente.telefono.equals(telefono)) {
		        encontrado = true;
		        clienteEncontrado = cliente;
		        break;
		    }
		}

		if (encontrado) {
		    System.out.println("¡Hola: " + clienteEncontrado.nombre + ", bienvenido de nuevo!");

		    System.out.println("###Seleccione el producto que desea:");
		    for (int i = 0; i < prueba.size(); i++) {
		        System.out.println((i + 1) + ". " + prueba.get(i).getNombre() + " " + prueba.get(i).getPrecio() + "€");
		    }

		    int p;
		    Pedido pedido = new Pedido();
		    int stockRestante = 0;
		    do {
		        if (stockRestante < 0) {
		            break;
		        } else {
		            System.out.println("Dime el número del producto o 0 para finalizar");
		            p = sc.nextInt();

		            switch (p) {
		                case 0: {
		                    clienteEncontrado.realizarPedido(pedido);
		                    totalefectivo = pedido.toString2();
		                    System.out.println(pedido.toString());
		               
		                

						// Metodo del ticket
						totalefectivo = pedido.toString2();
						System.out.println(pedido.toString());
						break;
					}

					// Submenu productos, se le resta 30 al stock, si es menor de 5, sale un mensaje
					// en pantalla.
					case 1: {
						System.out.println("¿Cuánta cantidad de " + prueba.get(0).getNombre() + " deseas?");
						int cantidad = sc.nextInt();
						;
						int i;
						prueba.get(0).realizarPedido(cantidad);
						prueba.get(0).setCantidad(cantidad);

						stockRestante = prueba.get(0).mostrarStock() - cantidad;

						if (stockRestante > 5 && stockRestante <= 30) {
							System.out.println("Stock restante de " + prueba.get(0).getNombre() + ": " + stockRestante);
						} else if (stockRestante <= 5 && stockRestante >= 0) {
							System.out.println("Quedan menos de 5 unidades de " + prueba.get(0).getNombre());
						} else {
							System.out.println("No hay suficiente Stock");
							break;
						}

						if (pedido.getProducto1() == null) {
							pedido.agregarProducto1(prueba.get(0));
						} else if (pedido.getProducto2() == null) {
							pedido.agregarProducto2(prueba.get(0));
						}

						break;
					}

					case 2: {
						System.out.println("¿Cuánta cantidad de " + prueba.get(1).getNombre() + " deseas?");
						int cantidad = sc.nextInt();

						int i;
						prueba.get(1).realizarPedido(cantidad);
						prueba.get(1).setCantidad(cantidad);

						stockRestante = prueba.get(1).mostrarStock() - cantidad;

						if (stockRestante > 5 && stockRestante <= 30) {
							System.out.println("Stock restante de " + prueba.get(1).getNombre() + ": " + stockRestante);
						} else if (stockRestante <= 5 && stockRestante >= 0) {
							System.out.println("Quedan menos de 5 unidades de " + prueba.get(1).getNombre());
						} else {
							System.out.println("No hay suficiente Stock");
							break;
						}

						if (pedido.getProducto1() == null) {
							pedido.agregarProducto1(prueba.get(1));
						} else if (pedido.getProducto2() == null) {
							pedido.agregarProducto2(prueba.get(1));
						}
						break;
					}
					case 3: {
						System.out.println("¿Cuánta cantidad de " + prueba.get(2).getNombre() + " deseas?");
						int cantidad = sc.nextInt();

						int i;
						prueba.get(2).realizarPedido(cantidad);
						prueba.get(2).setCantidad(cantidad);

						stockRestante = prueba.get(2).mostrarStock() - cantidad;

						if (stockRestante > 5 && stockRestante <= 30) {
							System.out.println("Stock restante de " + prueba.get(2).getNombre() + ": " + stockRestante);
						} else if (stockRestante <= 5 && stockRestante >= 0) {
							System.out.println("Quedan menos de 5 unidades de " + prueba.get(2).getNombre());
						} else {
							System.out.println("No hay suficiente Stock");
						}

						if (pedido.getProducto1() == null) {
							pedido.agregarProducto1(prueba.get(2));
						} else if (pedido.getProducto2() == null) {
							pedido.agregarProducto2(prueba.get(2));
						}
						break;
					}
					case 4: {
						System.out.println("¿Cuánta cantidad de " + prueba.get(3).getNombre() + " deseas?");
						int cantidad = sc.nextInt();

						int i;
						prueba.get(3).realizarPedido(cantidad);
						prueba.get(3).setCantidad(cantidad);

						stockRestante = prueba.get(3).mostrarStock() - cantidad;

						if (stockRestante > 5 && stockRestante <= 30) {
							System.out.println("Stock restante de " + prueba.get(3).getNombre() + ": " + stockRestante);
						} else if (stockRestante <= 5 && stockRestante >= 0) {
							System.out.println("Quedan menos de 5 unidades de " + prueba.get(3).getNombre());
						} else {
							System.out.println("No hay suficiente Stock");
						}

						if (pedido.getProducto1() == null) {
							pedido.agregarProducto1(prueba.get(3));
						} else if (pedido.getProducto2() == null) {
							pedido.agregarProducto2(prueba.get(3));
						}
						break;
					}
					case 5: {
						System.out.println("¿Cuánta cantidad de " + prueba.get(4).getNombre() + " deseas?");
						int cantidad = sc.nextInt();

						int i;
						prueba.get(4).realizarPedido(cantidad);
						prueba.get(4).setCantidad(cantidad);

						stockRestante = prueba.get(4).mostrarStock() - cantidad;

						if (stockRestante > 5 && stockRestante <= 30) {
							System.out.println("Stock restante de " + prueba.get(4).getNombre() + ": " + stockRestante);
						} else if (stockRestante <= 5 && stockRestante >= 0) {
							System.out.println("Quedan menos de 5 unidades de " + prueba.get(4).getNombre());
						} else {
							System.out.println("No hay suficiente Stock");
						}

						if (pedido.getProducto1() == null) {
							pedido.agregarProducto1(prueba.get(4));
						} else if (pedido.getProducto2() == null) {
							pedido.agregarProducto2(prueba.get(4));
						}
						break;
					}
					default:
						System.out.println("Opcion no valida");

					}
				}
			} while (p != 0);

		}

		PasarelaDePago efectivo = new PasarelaDePago();

		efectivo.efectivopago(totalefectivo);
		sc.close();

	}
}
