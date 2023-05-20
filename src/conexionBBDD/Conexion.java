package conexionBBDD;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class Conexion {
	
	/*pasar estos datos a un fichero de texto conf.txt*/
	private static final String Nombre_BD = "gestionpedidos";
	private static final String UBICACION = "localhost";
	private static final String PUERTO = "3306";
	private static final String CONTROLADOR="com.mysql.jdbc.Driver";
	private static final String URL= "jdbc:mysql://"+ UBICACION + ":" + PUERTO + "/" + Nombre_BD +"?characterEncoding=utf8";
	private static final String USUARIO="root";
	private static final String CLAVE="5681";
	
	public Connection conectar() {
		Connection conexion = null;
		
		try {

			Class.forName(CONTROLADOR);
			conexion = DriverManager.getConnection(URL, USUARIO,
					CLAVE);

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
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	

	/*private static final String CONFIG_FILE_PATH = "C:/Users/Carlos Carrillo/eclipse-workspace/GestionPedidos2/src/carlosPedido/config.txt";

    public Connection conectar() {
        Connection conexion = null;

        try {
            String nombreBD = "";
            String ubicacion = "";
            String puerto = "";
            String controlador = "";
            String usuario = "";
            String clave = "";

            // Leer datos del archivo de configuración
            BufferedReader reader = new BufferedReader(new FileReader(CONFIG_FILE_PATH));
            String line;
            while ((line = reader.readLine()) != null) {
                if (line.startsWith("Nombre_BD")) {
                    nombreBD = line.substring(line.indexOf("=") + 1).trim();
                } else if (line.startsWith("UBICACION")) {
                    ubicacion = line.substring(line.indexOf("=") + 1).trim();
                } else if (line.startsWith("PUERTO")) {
                    puerto = line.substring(line.indexOf("=") + 1).trim();
                } else if (line.startsWith("CONTROLADOR")) {
                    controlador = line.substring(line.indexOf("=") + 1).trim();
                } else if (line.startsWith("USUARIO")) {
                    usuario = line.substring(line.indexOf("=") + 1).trim();
                } else if (line.startsWith("CLAVE")) {
                    clave = line.substring(line.indexOf("=") + 1).trim();
                }
            }
            reader.close();

            // Crear la URL de conexión
            String url = "jdbc:mysql://" + ubicacion + ":" + puerto + "/" + nombreBD + "?characterEncoding=utf8";

            // Establecer la conexión
            Class.forName(controlador);
            conexion = DriverManager.getConnection(url, usuario, clave);

            System.out.println("Conexión exitosa");

        } catch (IOException e) {
            System.out.println("Error al leer el archivo de configuración");
            e.printStackTrace();
        } catch (ClassNotFoundException e) {
            System.out.println("Error al cargar el controlador");
            e.printStackTrace();
        } catch (SQLException e) {
            System.out.println("Error de conexión");
            e.printStackTrace();
        }

        return conexion;
    }*/
	
	
	
	
}
