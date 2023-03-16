package carlosPedido;

import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import ficherosEscrituraLectura.TratamientoFicheros;

/**
 * @author Carlos Carrillo V 0.2 Añadida la funcionalidad de Creacion de
 *         clientes y productos para iniciar automaticamente desde un txt
 *
 */
public class GestionPedidos extends TratamientoFicheros {

	public void comprobarTelefono() {

	}
//////////////Rutas Absolutas
	@SuppressWarnings("unused")
	public static void main(String[] args) throws FileNotFoundException, IOException {
		String rutaCliente = "C:/Users/Carlos Carrillo/eclipse-workspace/GestionPedidos2/src/carlosPedido/Cliente.txt";
		double totalefectivo = 0;
		Scanner sc = new Scanner(System.in);

		System.out.println("#####MENU INICIAL#####");
		System.out.println("Debes de crear 3 clientes ");
		System.out.println("Y 5 productos");
		System.out.println("Pulsa intro para continuar");
		String a = sc.nextLine();

		// Creacion de los clientes

		// Intentar implementar una automatizacion de la creacion de 3 clientes y 5
		// productos
		// Si quiero dar la opcion de crear cliente hacer menu con switch

		System.out.println("1. Crear un Cliente Nuevo");
		System.out.println("2. Continuar con el cliente ya creado");

		Cliente cliente1 = new Cliente("", "", null, "", "", null);
		Cliente cliente2 = new Cliente("", "", null, "", "", null);
		Cliente cliente3 = new Cliente("", "", null, "", "", null);
		Cliente cliente4 = new Cliente("", "", null, "", "", null);

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
			cliente4 = new Cliente(nombre4, apellido4, null, telefono4, direccion4, null);
			
			// Escribir los datos del cliente4 en el archivo "Cliente.txt"
			try {
				// Crear un objeto FileWriter con la opción append a true para no sobreescribir
				// el contenido existente
				FileWriter fw = new FileWriter(rutaCliente, true);
				// Crear un objeto PrintWriter para escribir los datos en el archivo
				PrintWriter pw = new PrintWriter(fw);
				// Escribir los datos del cliente4 en el archivo separados por comas
				pw.println(cliente4.getNombre() + "," + cliente4.getApellidos() + "," + cliente4.getTelefono() + ","
						+ cliente4.getDireccion());
				// Cerrar el objeto PrintWriter
				pw.close();
			} catch (IOException e) {
				System.out.println("Error al escribir en el archivo " + rutaCliente);
				e.printStackTrace();
			}

			break;
		case 2:

			
			System.out.println(" Has elegido: Continuar con el cliente ya creado");
			List<String[]> clientes = fileScannerCliente(
					"C:/Users/Carlos Carrillo/eclipse-workspace/GestionPedidos2/src/carlosPedido/Cliente.txt");

			// Verificar que el archivo contiene suficientes líneas para crear los clientes
			if (clientes.size() < 3) {
				System.out.println("El archivo no contiene suficientes líneas para crear los clientes.");
				break;
			}

			// Crear el primer cliente con los datos del primer elemento de la lista
			String[] datosCliente1 = clientes.get(0);
			String nombre1 = datosCliente1[0];
			String apellido1 = datosCliente1[1];
			String telefono1 = datosCliente1[2];
			String direccion1 = datosCliente1[3];

			cliente1 = new Cliente(nombre1, apellido1, null, telefono1, direccion1, null);

			// Crear el segundo cliente con los datos del segundo elemento de la lista
			String[] datosCliente2 = clientes.get(1);
			String nombre2 = datosCliente2[0];
			String apellido2 = datosCliente2[1];
			String telefono2 = datosCliente2[2];
			String direccion2 = datosCliente2[3];
			cliente2 = new Cliente(nombre2, apellido2, null, telefono2, direccion2, null);

			// Crear el tercer cliente con los datos del tercer elemento de la lista
			String[] datosCliente3 = clientes.get(2);
			String nombre3 = datosCliente2[0];
			String apellido3 = datosCliente2[1];
			String telefono3 = datosCliente2[2];
			String direccion3 = datosCliente2[3];
			cliente3 = new Cliente(nombre2, apellido2, null, telefono2, direccion2, null);
			break;

		default:
			System.out.println("Valor introducido no valido");
			break;
		}
		//Cargar Productos
		Producto b = new Producto();

		ArrayList<Producto> prueba = b.cargarProductos();

		// MENU PEDIDOS

		System.out.println("#####MENU PEDIDOS#####");
		System.out.println("1.Realizar Pedidos");

		/*
		 * En realizar pedidos, primero nos pedirá el cliente con el teléfono y luego el
		 * producto o los productos si son mas de uno
		 */

		System.out.println("Introduce el telefono del cliente");
		// Boolean para comprobar cliente

		String telefono = sc.next();

		boolean esCliente1 = false;
		boolean esCliente2 = false;
		boolean esCliente3 = false;
		boolean esCliente4 = false;
		
////////////////////Cambiar por switch parseInt antes y parseString Despues?
		
		if (telefono.equals(cliente1.getTelefono())) {
			System.out.println("Hola Cliente1:");
			esCliente1 = true;
		} else if (telefono.equals(cliente2.getTelefono())) {
			System.out.println("Hola Cliente2:");
			esCliente2 = true;
		} else if (telefono.equals(cliente3.getTelefono())) {
			System.out.println("Hola Cliente3:");
			esCliente3 = true;
		} else if (telefono.equals(cliente4.getTelefono())) {
			System.out.println("Hola Cliente4:");
			esCliente4 = true;

		} else {
			System.out.println("No existe ese cliente");
		}

		if (esCliente1 || esCliente2 || esCliente3 || esCliente4) {

			System.out.println("###Seleccione el producto que desea:");

			System.out.println("1.Producto 1: " + prueba.get(0).getNombre() + " " + prueba.get(0).getPrecio() + "€");
			System.out.println("2.Producto 2: " + prueba.get(1).getNombre() + " " + prueba.get(1).getPrecio() + "€");
			System.out.println("3.Producto 3: " + prueba.get(2).getNombre() + " " + prueba.get(2).getPrecio() + "€");
			System.out.println("4.Producto 4: " + prueba.get(3).getNombre() + " " + prueba.get(3).getPrecio() + "€");
			System.out.println("5.Producto 5: " + prueba.get(4).getNombre() + " " + prueba.get(4).getPrecio() + "€");
			int p;
			Pedido pedido = new Pedido();
			int stockRestante = 0;
			do {

				if (stockRestante < 0) {
					break;
				} else {

					System.out.println("Dime el numero del producto o 0 para finalizar");
					p = sc.nextInt();
					sc.nextLine();

					switch (p) {

					case 0: {

						if (esCliente1) {
							cliente1.realizarPedido(pedido);
						} else if (esCliente2) {
							cliente2.realizarPedido(pedido);
						} else if (esCliente3) {
							cliente3.realizarPedido(pedido);
						} else if (esCliente4) {
							cliente4.realizarPedido(pedido);
						}

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
						sc.nextLine();
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
						sc.nextLine();
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
						sc.nextLine();
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
						sc.nextLine();
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
						sc.nextLine();
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
