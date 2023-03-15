package carlosPedido;

import java.io.FileNotFoundException;
<<<<<<< Updated upstream
import java.io.IOException;
=======
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
>>>>>>> Stashed changes
import java.util.List;
import java.util.Scanner;

import ficherosEscrituraLectura.TratamientoFicheros;

/**
 * @author Carlos Carrillo V 0.2 Añadida la funcionalidad de Creacion de
 *         clientes y productos para iniciar automaticamente desde un txt
 *
 */
public class GestionPedidos extends TratamientoFicheros {
<<<<<<< Updated upstream
=======

	public void comprobarTelefono() {

	}
>>>>>>> Stashed changes

	@SuppressWarnings("unused")
	public static void main(String[] args) throws FileNotFoundException, IOException {
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
<<<<<<< Updated upstream

		String ruta = "C:/Users/Carlos Carrillo/eclipse-workspace/carlosPedido/src/carlosPedido/Cliente.txt";

		List<String[]> clientes = fileScannerCliente(
				"C:/Users/Carlos Carrillo/eclipse-workspace/carlosPedido/src/carlosPedido/Cliente.txt");

		// Crear el primer cliente con los datos del primer elemento de la lista
		String[] datosCliente1 = clientes.get(0);
		String nombre1 = datosCliente1[0];
		String apellido1 = datosCliente1[1];
		String telefono1 = datosCliente1[2];
		String direccion1 = datosCliente1[3];
		Cliente cliente1 = new Cliente(nombre1, apellido1, null, telefono1, direccion1, null);

		// Crear el segundo cliente con los datos del segundo elemento de la lista
		String[] datosCliente2 = clientes.get(1);
		String nombre2 = datosCliente2[0];
		String apellido2 = datosCliente2[1];
		String telefono2 = datosCliente2[2];
		String direccion2 = datosCliente2[3];
		Cliente cliente2 = new Cliente(nombre2, apellido2, null, telefono2, direccion2, null);

		// Crear el tercer cliente con los datos del tercer elemento de la lista
		String[] datosCliente3 = clientes.get(2);
		String nombre3 = datosCliente2[0];
		String apellido3 = datosCliente2[1];
		String telefono3 = datosCliente2[2];
		String direccion3 = datosCliente2[3];
		Cliente cliente3 = new Cliente(nombre2, apellido2, null, telefono2, direccion2, null);

		// Productos
		List<String[]> productosList = fileScannerProducto(
				"C:/Users/Carlos Carrillo/eclipse-workspace/carlosPedido/src/carlosPedido/Producto.txt");
		String[] nproducto1 = productosList.get(0);
		String nombreproducto1 = nproducto1[0];
		Double precio1 = Double.parseDouble(nproducto1[1]);
		int cantidad1 = Integer.parseInt(nproducto1[2]);
		Producto producto1 = new Producto(nombreproducto1, precio1, cantidad1);

		String[] nproducto2 = productosList.get(1);
		String nombreproducto2 = nproducto2[0];
		Double precio2 = Double.parseDouble(nproducto2[1]);
		int cantidad2 = Integer.parseInt(nproducto2[2]);
		Producto producto2 = new Producto(nombreproducto2, precio2, cantidad2);

		String[] nproducto3 = productosList.get(2);
		String nombreproducto3 = nproducto3[0];
		Double precio3 = Double.parseDouble(nproducto3[1]);
		int cantidad3 = Integer.parseInt(nproducto3[2]);
		Producto producto3 = new Producto(nombreproducto3, precio3, cantidad3);

		String[] nproducto4 = productosList.get(3);
		String nombreproducto4 = nproducto4[0];
		Double precio4 = Double.parseDouble(nproducto4[1]);
		int cantidad4 = Integer.parseInt(nproducto4[2]);
		Producto producto4 = new Producto(nombreproducto4, precio4, cantidad4);

		String[] nproducto5 = productosList.get(4);
		String nombreproducto5 = nproducto5[0];
		Double precio5 = Double.parseDouble(nproducto5[1]);
		int cantidad5 = Integer.parseInt(nproducto5[2]);
		Producto producto5 = new Producto(nombreproducto5, precio5, cantidad5);

		// Ticket? Cuando tenga lo anterior lo vemos
/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
		/*
		 * System.out.print("Ingresa el nombre del Cliente 1: ");
		 * 
		 * String nombre1 = sc.nextLine();
		 * System.out.print("Ingresa el apellido del Cliente 1: "); String apellido1 =
		 * sc.nextLine(); System.out.print("Ingresa el telefono del Cliente 1: ");
		 * String telefono1 = sc.nextLine();
		 * System.out.print("Ingresa la dirección del Cliente 1: "); String direccion1=
		 * sc.nextLine();
		 * 
		 * Cliente cliente1 = new Cliente(nombre1, apellido1, null, telefono1,
		 * direccion1, null);
		 * 
		 * System.out.print("Ingresa el nombre del Cliente 2: "); String nombre2 =
		 * sc.nextLine(); System.out.print("Ingresa el apellido del Cliente 2: ");
		 * String apellido2 = sc.nextLine();
		 * System.out.print("Ingresa el telefono del Cliente 2: "); String telefono2 =
		 * sc.nextLine(); System.out.print("Ingresa la dirección del Cliente 2: ");
		 * String direccion2 = sc.nextLine(); Cliente cliente2 = new Cliente(nombre2,
		 * apellido2, null, telefono2, direccion2, null);
		 * 
		 * System.out.print("Ingresa el nombre del Cliente 3: "); String nombre3 =
		 * sc.nextLine(); System.out.print("Ingresa el apellido del Cliente 3: ");
		 * String apellido3 = sc.nextLine();
		 * System.out.print("Ingresa el telefono del Cliente 3: "); String telefono3 =
		 * sc.nextLine(); System.out.print("Ingresa la dirección del Cliente 3: ");
		 * String direccion3 = sc.nextLine();
		 * 
		 * Cliente cliente3 = new Cliente(nombre3, apellido3, null, telefono3,
		 * direccion3, null);
		 */

		// Relleno de stock a 30 unidades llamando al metodo

		// muestraContenido(rutaProducto);

=======
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
			String ruta1 = "C:/Users/Carlos Carrillo/eclipse-workspace/carlosPedido/src/carlosPedido/Cliente.txt";
			// Escribir los datos del cliente4 en el archivo "Cliente.txt"
			try {
				// Crear un objeto FileWriter con la opción append a true para no sobreescribir
				// el contenido existente
				FileWriter fw = new FileWriter(ruta1, true);
				// Crear un objeto PrintWriter para escribir los datos en el archivo
				PrintWriter pw = new PrintWriter(fw);
				// Escribir los datos del cliente4 en el archivo separados por comas
				pw.println(cliente4.getNombre() + "," + cliente4.getApellidos() + "," + cliente4.getTelefono() + ","
						+ cliente4.getDireccion());
				// Cerrar el objeto PrintWriter
				pw.close();
			} catch (IOException e) {
				System.out.println("Error al escribir en el archivo " + ruta1);
				e.printStackTrace();
			}

			break;
		case 2:

			String ruta = "C:/Users/Carlos Carrillo/eclipse-workspace/carlosPedido/src/carlosPedido/Cliente.txt";
			System.out.println(" Has elegido: Continuar con el cliente ya creado");
			List<String[]> clientes = fileScannerCliente(
					"C:/Users/Carlos Carrillo/eclipse-workspace/carlosPedido/src/carlosPedido/Cliente.txt");

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

		Producto b = new Producto();

		ArrayList<Producto> prueba = b.cargarProductos();

		// Ticket? Cuando tenga lo anterior lo vemos
/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
		/*
		 * System.out.print("Ingresa el nombre del Cliente 1: ");
		 * 
		 * String nombre1 = sc.nextLine();
		 * System.out.print("Ingresa el apellido del Cliente 1: "); String apellido1 =
		 * sc.nextLine(); System.out.print("Ingresa el telefono del Cliente 1: ");
		 * String telefono1 = sc.nextLine();
		 * System.out.print("Ingresa la dirección del Cliente 1: "); String direccion1=
		 * sc.nextLine();
		 * 
		 * Cliente cliente1 = new Cliente(nombre1, apellido1, null, telefono1,
		 * direccion1, null);
		 * 
		 * System.out.print("Ingresa el nombre del Cliente 2: "); String nombre2 =
		 * sc.nextLine(); System.out.print("Ingresa el apellido del Cliente 2: ");
		 * String apellido2 = sc.nextLine();
		 * System.out.print("Ingresa el telefono del Cliente 2: "); String telefono2 =
		 * sc.nextLine(); System.out.print("Ingresa la dirección del Cliente 2: ");
		 * String direccion2 = sc.nextLine(); Cliente cliente2 = new Cliente(nombre2,
		 * apellido2, null, telefono2, direccion2, null);
		 * 
		 * System.out.print("Ingresa el nombre del Cliente 3: "); String nombre3 =
		 * sc.nextLine(); System.out.print("Ingresa el apellido del Cliente 3: ");
		 * String apellido3 = sc.nextLine();
		 * System.out.print("Ingresa el telefono del Cliente 3: "); String telefono3 =
		 * sc.nextLine(); System.out.print("Ingresa la dirección del Cliente 3: ");
		 * String direccion3 = sc.nextLine();
		 * 
		 * Cliente cliente3 = new Cliente(nombre3, apellido3, null, telefono3,
		 * direccion3, null);
		 */

		// Relleno de stock a 30 unidades llamando al metodo

		// muestraContenido(rutaProducto);

>>>>>>> Stashed changes
		/*
		 * System.out.print("Ingresa el producto 1: "); String nproducto1 =
		 * sc.nextLine();
		 * 
		 * Producto producto1 = new Producto(nproducto1, 9.99, 1);
		 * 
		 * System.out.print("Ingresa el producto 2: "); String nproducto2 =
		 * sc.nextLine();
		 * 
		 * Producto producto2 = new Producto(nproducto2, 12.99, 0);
		 * 
		 * System.out.print("Ingresa el producto 3: "); String nproducto3 =
		 * sc.nextLine();
		 * 
		 * Producto producto3 = new Producto(nproducto3, 15.99, 1);
		 * 
		 * System.out.print("Ingresa el producto 4: "); String nproducto4 =
		 * sc.nextLine();
		 * 
		 * Producto producto4 = new Producto(nproducto4, 1.99, 1);
		 * 
		 * System.out.print("Ingresa el producto 5: "); String nproducto5 =
		 * sc.nextLine();
		 * 
		 * Producto producto5 = new Producto(nproducto5, 4.99, 1);
		 */
////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
		// MENU PEDIDOS

		System.out.println("#####MENU PEDIDOS#####");
		System.out.println("1.Realizar Pedidos");

		/*
		 * En realizar pedidos, primero nos pedirá el cliente con el teléfono y luego el
		 * producto o los productos si son mas de uno
		 */

		System.out.println("Introduce el telefono del cliente");
		// Boolean para comprobar cliente
<<<<<<< Updated upstream
		String telefono = sc.nextLine();
=======

		String telefono = sc.next();

>>>>>>> Stashed changes
		boolean esCliente1 = false;
		boolean esCliente2 = false;
		boolean esCliente3 = false;
		boolean esCliente4 = false;

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
<<<<<<< Updated upstream
		// Submenu
		if (esCliente1 || esCliente2 || esCliente3) {
=======

		if (esCliente1 || esCliente2 || esCliente3 || esCliente4) {
>>>>>>> Stashed changes

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
<<<<<<< Updated upstream
=======
					sc.nextLine();
>>>>>>> Stashed changes

					switch (p) {

					case 0: {

						if (esCliente1) {
							cliente1.realizarPedido(pedido);
<<<<<<< Updated upstream

						} else if (esCliente2) {
							cliente2.realizarPedido(pedido);

						} else if (esCliente3) {
							cliente3.realizarPedido(pedido);

						}

						// Metodo del ticket
						totalefectivo = pedido.toString2();
						System.out.println(pedido.toString());
						break;
					}
					// Submenu productos, se le resta 30 al stock, si es menor de 5, sale un mensaje
					// en pantalla.
					case 1: {
						System.out.println("¿Cuánta cantidad de " + producto1.getNombre() + " deseas?");
						int cantidad = sc.nextInt();
						int i;
						producto1.realizarPedido(cantidad);
						producto1.setCantidad(cantidad);

						stockRestante = producto2.mostrarStock() - cantidad;

						if (stockRestante > 5 && stockRestante <= 30) {
							System.out.println("Stock restante de " + producto1.getNombre() + ": " + stockRestante);
						} else if (stockRestante <= 5 && stockRestante >= 0) {
							System.out.println("Quedan menos de 5 unidades de " + producto1.getNombre());
=======
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
>>>>>>> Stashed changes
						} else {
							System.out.println("No hay suficiente Stock");
							break;
						}
<<<<<<< Updated upstream

					}

						if (pedido.getProducto1() == null) {
							pedido.agregarProducto1(producto1);
						} else if (pedido.getProducto2() == null) {
							pedido.agregarProducto2(producto1);
						}

						break;

					case 2: {
						System.out.println("¿Cuánta cantidad de " + producto2.getNombre() + " deseas?");
						int cantidad = sc.nextInt();
						int i;
						producto2.realizarPedido(cantidad);
						producto2.setCantidad(cantidad);

						stockRestante = producto2.mostrarStock() - cantidad;

						if (stockRestante > 5 && stockRestante <= 30) {
							System.out.println("Stock restante de " + producto2.getNombre() + ": " + stockRestante);
						} else if (stockRestante <= 5 && stockRestante >= 0) {
							System.out.println("Quedan menos de 5 unidades de " + producto2.getNombre());
						} else {
							System.out.println("No hay suficiente Stock");
							break;
						}

						if (pedido.getProducto1() == null) {
							pedido.agregarProducto1(producto2);
						} else if (pedido.getProducto2() == null) {
							pedido.agregarProducto2(producto2);
						}
						break;
					}
					case 3: {
						System.out.println("¿Cuánta cantidad de " + producto3.getNombre() + " deseas?");
						int cantidad = sc.nextInt();
						int i;
						producto3.realizarPedido(cantidad);
						producto3.setCantidad(cantidad);

						stockRestante = producto2.mostrarStock() - cantidad;

						if (stockRestante > 5 && stockRestante <= 30) {
							System.out.println("Stock restante de " + producto3.getNombre() + ": " + stockRestante);
						} else if (stockRestante <= 5 && stockRestante >= 0) {
							System.out.println("Quedan menos de 5 unidades de " + producto3.getNombre());
						} else {
							System.out.println("No hay suficiente Stock");
						}

						if (pedido.getProducto1() == null) {
							pedido.agregarProducto1(producto3);
						} else if (pedido.getProducto2() == null) {
							pedido.agregarProducto2(producto3);
						}
						break;
					}
					case 4: {
						System.out.println("¿Cuánta cantidad de " + producto4.getNombre() + " deseas?");
						int cantidad = sc.nextInt();
						int i;
						producto4.realizarPedido(cantidad);
						producto4.setCantidad(cantidad);

						stockRestante = producto2.mostrarStock() - cantidad;

						if (stockRestante > 5 && stockRestante <= 30) {
							System.out.println("Stock restante de " + producto4.getNombre() + ": " + stockRestante);
						} else if (stockRestante <= 5 && stockRestante >= 0) {
							System.out.println("Quedan menos de 5 unidades de " + producto4.getNombre());
						} else {
							System.out.println("No hay suficiente Stock");
						}

						if (pedido.getProducto1() == null) {
							pedido.agregarProducto1(producto4);
						} else if (pedido.getProducto2() == null) {
							pedido.agregarProducto2(producto4);
						}
						break;
					}
					case 5: {
						System.out.println("¿Cuánta cantidad de " + producto5.getNombre() + " deseas?");
						int cantidad = sc.nextInt();
						int i;
						producto5.realizarPedido(cantidad);
						producto5.setCantidad(cantidad);

						stockRestante = producto2.mostrarStock() - cantidad;

						if (stockRestante > 5 && stockRestante <= 30) {
							System.out.println("Stock restante de " + producto5.getNombre() + ": " + stockRestante);
						} else if (stockRestante <= 5 && stockRestante >= 0) {
							System.out.println("Quedan menos de 5 unidades de " + producto5.getNombre());
						} else {
							System.out.println("No hay suficiente Stock");
						}

						if (pedido.getProducto1() == null) {
							pedido.agregarProducto1(producto5);
						} else if (pedido.getProducto2() == null) {
							pedido.agregarProducto2(producto5);
						}
						break;
					}
					default:

						break;
					}
=======

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
>>>>>>> Stashed changes
				}
			} while (p != 0);

		}
<<<<<<< Updated upstream
=======

>>>>>>> Stashed changes
		PasarelaDePago efectivo = new PasarelaDePago();

		efectivo.efectivopago(totalefectivo);
		sc.close();

	}

}
