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

	// Get and Set

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre.toLowerCase();
	}

	public String getApellidos() {
		return apellidos;
	}

	public void setApellidos(String apellidos) {
		this.apellidos = apellidos.toUpperCase();
	}

	public Date getFechaDeAlta() {
		return fechaDeAlta;
	}

	public void setFechaDeAlta(Date fechaDeAlta) {
		if (fechaDeAlta == null) {
			this.fechaDeAlta = new Date();

		} else {
			this.fechaDeAlta = fechaDeAlta;

		}

	}

	public String getTelefono() {
		return telefono;
	}

	// Metodo setTelefono limita a 9 la longitud del telefono y que empiece por
	// 6,7,8 o 9
	public void setTelefono(String telefono) {
		if (telefono.length() == 9 && (telefono.startsWith("6") || telefono.startsWith("7") || telefono.startsWith("8")
				|| telefono.startsWith("9"))) {

			this.telefono = telefono;
		} else {
			System.out.println("ERROR");
		}

	}

	public String getDireccion() {
		return direccion;
	}

	public void setDireccion(String direccion) {
		this.direccion = direccion;
	}

	public String getHistorial() {
		return historial;
	}

	public void setHistorial(String historial) {
		this.historial = historial;
	}

	// Constructor vacio

	public Cliente() {
		
	}

	// Constructor
	public Cliente(String nombre, String apellidos, String telefono, String direccion) {
		
		this.nombre = nombre.toLowerCase();
		this.apellidos = apellidos.toUpperCase();
	

		if (telefono.length() == 9 && (telefono.startsWith("6") || telefono.startsWith("7") || telefono.startsWith("8")
				|| telefono.startsWith("9"))) {

			this.telefono = telefono;
		} else {
			//System.out.println("FORMATO DE TELEFONO INCORRECTO");
		}

		this.direccion = direccion;
		
	}

	
	 /* Metodo: Este metodo es el metodo agregarPedido y realizarPedido, ya que en la
	 * practica, los nombra diferentes, y pide lo mismo.
	 */

	
	

	public void realizarPedido(Pedido pedido) {

		this.historial = this.historial + pedido.getCodigoPedido();

	}
	
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

public static ArrayList<Cliente> cargarClienteBBDD(){
		
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
