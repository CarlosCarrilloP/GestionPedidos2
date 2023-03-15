package ficherosEscrituraLectura;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class TratamientoFicheros {

	// Muestra contenido
	public static void muestraContenido(String archivo) throws FileNotFoundException, IOException {
		String cadena;
		FileReader f = new FileReader(archivo);
		BufferedReader b = new BufferedReader(f);
		while ((cadena = b.readLine()) != null) {
			System.out.println(cadena);
		}
		b.close();
	}

	// Metodo fileScanner Cliente
	public static List<String[]> fileScannerCliente(String archivo) {
<<<<<<< Updated upstream
		String ruta = archivo;
		File f = new File(ruta);
		System.out.println("La ruta del fichero es: " + f.getAbsolutePath());
		Scanner s;
		List<String[]> clientes = new ArrayList<>();
		try {
			s = new Scanner(f);
			while (s.hasNextLine()) {
				String linea = s.nextLine();
				Scanner sl = new Scanner(linea);
				sl.useDelimiter("\\s*,\\s*");
				String[] datosCliente = new String[4];
				datosCliente[0] = sl.next();
				datosCliente[1] = sl.next();
				datosCliente[2] = sl.next();
				datosCliente[3] = sl.next();
				clientes.add(datosCliente);
			}
			s.close();
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		}
		return clientes;
	}
=======
	    String ruta = archivo;
	    File f = new File(ruta);
	    System.out.println("La ruta del fichero es: " + f.getAbsolutePath());
	    Scanner s;
	    List<String[]> clientes = new ArrayList<>();
	    try {
	        s = new Scanner(f);
	        int i = 0; // contador de clientes para agregar solo los 3 primeros de la lista en el caso de que haya mas de 3.
	        while (s.hasNextLine() && i < 3) {
	            String linea = s.nextLine();
	            Scanner sl = new Scanner(linea);
	            sl.useDelimiter("\\s*,\\s*");
	            String[] datosCliente = new String[4];
	            datosCliente[0] = sl.next();
	            datosCliente[1] = sl.next();
	            datosCliente[2] = sl.next();
	            datosCliente[3] = sl.next();
	            clientes.add(datosCliente);
	            i++;
	        }
	        s.close();
	    } catch (FileNotFoundException e) {
	        e.printStackTrace();
	    }
	    return clientes;
	}

>>>>>>> Stashed changes
//Metodo fileScanner para Productos
	public static List<String[]> fileScannerProducto(String archivo) {
		String ruta = archivo;
		File f = new File(ruta);
		System.out.println("La ruta del fichero es: " + f.getAbsolutePath());
		Scanner s;
		List<String[]> productosList = new ArrayList<>();
		try {
			s = new Scanner(f);
			while (s.hasNextLine()) {
				String linea = s.nextLine();
				Scanner sl = new Scanner(linea);
				sl.useDelimiter("\\s*,\\s*");
				String[] nproducto1 = new String[3];
				nproducto1[0] = sl.next();
				nproducto1[1] = sl.next();
				nproducto1[2] = sl.next();

				productosList.add(nproducto1);
			}
			s.close();
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		}
		return productosList;
	}

	/*
	 * public static void fileScanner2(String archivo) {
	 * 
	 * String ruta =
	 * "C:/Users/Carlos Carrillo/eclipse-workspace/carlosPedido/src/carlosPedido/Cliente.txt"
	 * ; File f = new File(ruta); System.out.println("La ruta del fichero es: " +
	 * f.getAbsolutePath()); Scanner s; try { s = new Scanner(f); while
	 * (s.hasNextLine()) { String linea = s.nextLine(); Scanner sl = new
	 * Scanner(linea); sl.useDelimiter("\\s*,\\s*"); System.out.println(sl.next());
	 * System.out.println(sl.next()); System.out.println(sl.next());
	 * System.out.println(sl.next()); } s.close(); } catch (FileNotFoundException e)
	 * { // PrintWriter pw = null; e.printStackTrace(); // e.printStackTrace(pw);
	 * 
	 * }
	 * 
	 * 
	 * }
	 */

	// Metodo Escribe fichero
	public static void escribeFichero() {

		String ruta = "C:/Users/Carlos Carrillo/eclipse-workspace/carlosPedido/src/carlosPedido/Cliente.txt";
		FileWriter fichero = null;
		PrintWriter pw = null;
		try {
			// Añadir flag a true para no machacar contenido del fichero de escritura
			fichero = new FileWriter(ruta, true);
			pw = new PrintWriter(fichero);

			for (int i = 0; i < 10; i++) {
				pw.println("Modelo " + i);
			}

		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			try {
				// Nuevamente aprovechamos el finally para
				// asegurarnos que se cierra el fichero.
				if (null != fichero) {
					fichero.close();
				}
			} catch (Exception e2) {
				e2.printStackTrace();
			}
		}

	}

}
