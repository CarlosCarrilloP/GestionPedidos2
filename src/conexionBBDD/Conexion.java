package conexionBBDD;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import ficherosEscrituraLectura.TratamientoFicheros;
/**
 * Clase utilizada para establecer una conexión a la base de datos.
 */
public class Conexion extends TratamientoFicheros {

	private static  String Nombre_BD ;
	private static  String UBICACION;
	private static  String PUERTO;
	private static  String CONTROLADOR= "com.mysql.jdbc.Driver";
	private static  String URL = "jdbc:mysql://" + UBICACION + ":" + PUERTO + "/" + Nombre_BD
			+ "?characterEncoding=utf8";
	private static  String USUARIO;
	private static  String CLAVE;
	
	

	public Conexion(String nombre_BD2, String ubicacion2, String puerto2, String controlador2, String usuario2,
			String clave2) {
		
	}

	public Conexion() {
		
	}
	
	
	
	/**
     * Establece una conexión a la base de datos.
     *
     * @return La conexión establecida.
     */
	
	
	private static List<String[]> obtenerDatosConexion(String rutaArchivo) throws IOException {
	    List<String[]> datosConexion = new ArrayList<>();
	    BufferedReader br = new BufferedReader(new FileReader(rutaArchivo));
	    String linea;

	    while ((linea = br.readLine()) != null) {
	        String[] datos = linea.split(",");
	        datosConexion.add(datos);
	    }

	    br.close();
	    return datosConexion;
	}

	static {

		try {
			Class.forName(CONTROLADOR);
			
		} catch (ClassNotFoundException e) {
			
			
			System.out.println("Error al cargar el controlador");
			e.printStackTrace();
		}
	}
	
	
	public static Connection conectar() {
		Connection conexion=null;
		
		
		TratamientoFicheros fichero = new TratamientoFicheros();
		String[] datosConexion= TratamientoFicheros.fileScannerConexion();
		Nombre_BD=datosConexion[0];
		UBICACION=datosConexion[1];
		PUERTO= datosConexion[2];
		USUARIO=datosConexion[3];
		CLAVE = datosConexion[4];
		String URL = "jdbc:mysql://" + UBICACION + ":" + PUERTO + "/" + Nombre_BD
				+ "?characterEncoding=utf8";
		
		try {
			
			conexion = DriverManager.getConnection(URL, USUARIO, CLAVE);

			System.out.println("Conexion correcta");

	
		} catch (SQLException e) {
			System.out.println("Error de conexion");
			e.printStackTrace();
		}
		return  conexion;
	}

}
