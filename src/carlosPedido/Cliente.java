package carlosPedido;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import conexionBBDD.Conexion;
import conexionBBDD.TestConexion;
import ficherosEscrituraLectura.TratamientoFicheros;

public class Cliente extends TratamientoFicheros {

	// Atributos

	String nombre;
	String apellidos;
	Date fechaDeAlta;
	String telefono;
	String direccion;
	String historial;
	private static String selectTableSQL;

	// Getters and Setters
	/**
	 * Obtiene el nombre del cliente.
	 * 
	 * @return El nombre del cliente.
	 */

	public String getNombre() {
		return nombre;
	}

	/**
	 * Establece el nombre del cliente.
	 * 
	 * @param nombre El nombre del cliente.
	 */

	public void setNombre(String nombre) {
		this.nombre = nombre.toLowerCase();
	}

	public String getApellidos() {
		return apellidos;
	}

	/**
	 * Obtiene los apellidos del cliente.
	 * 
	 * @return Los apellidos del cliente.
	 */
	public void setApellidos(String apellidos) {
		this.apellidos = apellidos.toUpperCase();
	}

	public Date getFechaDeAlta() {
		return fechaDeAlta;
	}
	/**
     * Establece la fecha de alta del cliente.
     * Si la fecha de alta es nula, se asigna la fecha actual.
     * @param fechaDeAlta La fecha de alta del cliente.
     */
	public void setFechaDeAlta(Date fechaDeAlta) {
		if (fechaDeAlta == null) {
			this.fechaDeAlta = new Date();

		} else {
			this.fechaDeAlta = fechaDeAlta;

		}

	}
	/**
     * Obtiene el teléfono del cliente.
     * @return El teléfono del cliente.
     */
	public String getTelefono() {
		return telefono;
	}

	/**
     * Establece el teléfono del cliente.
     * El teléfono debe tener una longitud de 9 caracteres y empezar por 6, 7, 8 o 9.
     * @param telefono El teléfono del cliente.
     */
	public void setTelefono(String telefono) {
		if (telefono.length() == 9 && (telefono.startsWith("6") || telefono.startsWith("7") || telefono.startsWith("8")
				|| telefono.startsWith("9"))) {

			this.telefono = telefono;
		} else {
			System.out.println("ERROR");
		}

	}
	/**
     * Obtiene la dirección del cliente.
     * @return La dirección del cliente.
     */
	public String getDireccion() {
		return direccion;
	}
	/**
     * Establece la dirección del cliente.
     * @param direccion La dirección del cliente.
     */
	public void setDireccion(String direccion) {
		this.direccion = direccion;
	}
	/**
     * Obtiene el historial del cliente.
     * @return El historial del cliente.
     */
	public String getHistorial() {
		return historial;
	}
	/**
     * Establece el historial del cliente.
     * @param historial El historial del cliente.
     */
	public void setHistorial(String historial) {
		this.historial = historial;
	}

	// Constructor vacio
	/**
     * Constructor vacío de la clase Cliente.
     */
	public Cliente() {

	}

	// Constructor
	/**
     * Constructor de la clase Cliente.
     * @param nombre     El nombre del cliente.
     * @param apellidos  Los apellidos del cliente.
     * @param telefono   El teléfono del cliente.
     * @param direccion  La dirección del cliente.
     */
	public Cliente(String nombre, String apellidos, String telefono, String direccion) {

		this.nombre = nombre.toLowerCase();
		this.apellidos = apellidos.toUpperCase();

		if (telefono.length() == 9 && (telefono.startsWith("6") || telefono.startsWith("7") || telefono.startsWith("8")
				|| telefono.startsWith("9"))) {

			this.telefono = telefono;
		} else {
			// System.out.println("FORMATO DE TELEFONO INCORRECTO");
		}

		this.direccion = direccion;

	}

	/*
	 * Este metodo es el metodo agregarPedido y realizarPedido, ya que en la
	 * practica, los nombra diferentes, y pide lo mismo.
	 */

	public void realizarPedido(Pedido pedido) {

		this.historial = this.historial + pedido.getCodigoPedido();

	}
	 /**
     * Lee los clientes desde un archivo y los retorna como una lista.
     * @param rutaArchivo La ruta del archivo de clientes.
     * @return Una lista de objetos Cliente leídos desde el archivo.
     */
	public static List<Cliente> leerClientesDesdeArchivo(String rutaArchivo) {
		List<Cliente> clientes = new ArrayList<>();

		try {
			List<String[]> datosClientes = fileScannerCliente(rutaArchivo);

			for (String[] datos : datosClientes) {
				String nombre = datos[0];
				String apellido = datos[1];
				String telefono = datos[2];
				String direccion = datos[3];
				Cliente cliente = new Cliente(nombre, apellido, telefono, direccion);
				clientes.add(cliente);
			}
		} catch (Exception e) {
			System.out.println("Error al leer el archivo de clientes: " + e.getMessage());
		}

		return clientes;
	}
	/**
     * Carga los clientes desde la base de datos y los retorna como una lista.
     * @return Una lista de objetos Cliente cargados desde la base de datos.
     */
	public static ArrayList<Cliente> cargarClienteBBDD() {

		Conexion conexion4 = new Conexion();
		Connection cn4 = null;
		Statement stm4 = null;
		ResultSet rs4 = null;

		selectTableSQL = "SELECT * FROM cliente";
		ArrayList<Cliente> clientes = new ArrayList<>();
		try {
			// Abrimos la conexion con la base de datos
			cn4 = conexion4.conectar();
			stm4 = cn4.createStatement();
			// Pasamos la consulta al ResultSet
			rs4 = stm4.executeQuery(selectTableSQL);

			while (rs4.next()) {
				String nombre = rs4.getString("nombre");
				String apellido = rs4.getString("apellidos");
				String telefono = rs4.getString("telefono");
				String direccion = rs4.getString("direccion");
				Cliente cliente = new Cliente(nombre, apellido, telefono, direccion);
				clientes.add(cliente);

			}
			System.out.println("Clientes Cargados");
		} catch (SQLException e) {
			e.printStackTrace();

		} finally {

			TestConexion.cerrar_conexion3(cn4, stm4, rs4);
		}
		return clientes;
	}

}
