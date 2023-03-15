package carlosPedido;

import java.util.ArrayList;

import ficherosEscrituraLectura.TratamientoFicheros;

public class Producto extends TratamientoFicheros {
	// Atributos
	String nombre;
	double precio;
	int cantidad;
	int cantidad1 = 0;
	private int stock;
	private int stock1[] = new int[30];

	// Constructor vacío

	public Producto() {
		super();
	}

	// Constructor con parámetros
	public Producto(String nombre, double precio, int cantidad) {
		this.nombre = nombre.toUpperCase();
		this.precio = precio;
		this.cantidad = cantidad;
	}

	// Getters y setters para los atributos de la clase
	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre.toUpperCase();
	}

	public double getPrecio() {
		return precio;
	}

	public void setPrecio(double precio) {
		this.precio = precio;
	}

	public int getCantidad() {
		return cantidad;
	}

	public int setCantidad(int cantidad) {
		return this.cantidad = cantidad;
	}

	// Metodos para el stock

	public int getStock() {
		return this.stock;
	}

	// Rellenar stock
	public void rellenarStock() {

		for (int i = 0; i < stock1.length; i++) {

			stock1[i] = 1;

		}

	}

	public int mostrarStock() {
		// Inicializo la variable a 0 de nuevo porque si no, el valor de cantidad1 es
		// erroneo
		cantidad1 = 0;
		for (int i = 0; i < stock1.length; i++) {

			cantidad1++;

		}

		return cantidad1;
	}

	// Metodo realizar pedido
	public void realizarPedido(int cantidad) {
		cantidad1 = cantidad1 - cantidad;
	}
	
	
	public ArrayList<Producto> cargarProductos() {
		
		
		// Productos
				ArrayList<String[]> productosList = (ArrayList<String[]>) fileScannerProducto(
						"C:/Users/Carlos Carrillo/eclipse-workspace/GestionPedidos2/src/carlosPedido/Producto.txt");
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
				
				ArrayList<Producto> productos= new ArrayList<Producto>() ;
				productos.add(producto1);
				productos.add(producto2);
				productos.add(producto3);
				productos.add(producto4);
				productos.add(producto5);
				
				
				return productos;
		
	}

	



}

