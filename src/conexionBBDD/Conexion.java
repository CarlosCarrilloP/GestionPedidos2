package conexionBBDD;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
/**
 * Clase utilizada para establecer una conexión a la base de datos.
 */
public class Conexion {

	/* pasar estos datos a un fichero de texto conf.txt */
	private static final String Nombre_BD = "gestionpedidos";
	private static final String UBICACION = "localhost";
	private static final String PUERTO = "3306";
	private static final String CONTROLADOR = "com.mysql.jdbc.Driver";
	private static final String URL = "jdbc:mysql://" + UBICACION + ":" + PUERTO + "/" + Nombre_BD
			+ "?characterEncoding=utf8";
	private static final String USUARIO = "root";
	private static final String CLAVE = "5681";
	
	/**
     * Establece una conexión a la base de datos.
     *
     * @return La conexión establecida.
     */
	public Connection conectar() {
		Connection conexion = null;

		try {

			Class.forName(CONTROLADOR);
			conexion = DriverManager.getConnection(URL, USUARIO, CLAVE);

			System.out.println("Conexion correcta");

		} catch (ClassNotFoundException e) {

			System.out.println("Error al cargar el controlador");
			e.printStackTrace();
		} catch (SQLException e) {
			System.out.println("Error de conexion");
			e.printStackTrace();
		}
		return conexion;
	}

}
