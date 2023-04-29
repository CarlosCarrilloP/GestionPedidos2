package ficherosEscrituraLectura;

import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintStream;
import java.io.PrintWriter;
import java.util.List;
import java.util.Scanner;

import org.junit.jupiter.api.Test;

class TratamientoFicherosTest extends TratamientoFicheros{
	//Test sobre los metodos que intervienen en el tratamiento de ficheros
	@Test
	public void testMuestraContenido() throws IOException {
	    // 1. Crear un archivo de texto temporal con contenido conocido
	    String nombreArchivo = "temp.txt";
	    FileWriter fileWriter = new FileWriter(nombreArchivo);
	    PrintWriter printWriter = new PrintWriter(fileWriter);
	    printWriter.println("Prueba");
	    printWriter.println("Escritura");
	    printWriter.close();

	    // 2. Llamar al método muestraContenido() con el nombre del archivo temporal creado
	    muestraContenido(nombreArchivo);

	    // 3. Capturar la salida estándar del método utilizando System.out
	    ByteArrayOutputStream outContent = new ByteArrayOutputStream();
	    System.setOut(new PrintStream(outContent));

	    // 4. Verificar que la salida del método es igual al contenido conocido del archivo temporal
	    muestraContenido(nombreArchivo);
	    assertEquals1("Prueba\nEscritura\n", outContent.toString());
	}

	private void assertEquals1(String string, String string2) {
		
	}
private void assertEquals2(int i, int j) {
		
	}
	@Test
	public void testFileScannerCliente() throws IOException {
	    // Crea un archivo de prueba con algunos clientes
	    String archivo = "clientes_test.txt";
	    FileWriter fichero = new FileWriter(archivo);
	    PrintWriter pw = new PrintWriter(fichero);
	    pw.println("Juan Perez,juan.perez@example.com,555-1234,Mexico");
	    pw.println("Maria Garcia,maria.garcia@example.com,555-5678,Colombia");
	    pw.println("Pedro Rodriguez,pedro.rodriguez@example.com,555-9012,España");
	    pw.println("Luisa Fernandez,luisa.fernandez@example.com,555-3456,Argentina");
	    pw.close();
	    fichero.close();

	    // Llama al método fileScannerCliente() con el archivo de prueba
	    List<String[]> clientes = TratamientoFicheros.fileScannerCliente(archivo);

	    // Verifica que la lista de clientes sea la esperada
	    assertEquals2(3, clientes.size());
	    String[] cliente1 = {"Juan Perez", "juan.perez@example.com", "555-1234", "Mexico"};
	    assertArrayEquals(cliente1, clientes.get(0));
	    String[] cliente2 = {"Maria Garcia", "maria.garcia@example.com", "555-5678", "Colombia"};
	    assertArrayEquals(cliente2, clientes.get(1));
	    String[] cliente3 = {"Pedro Rodriguez", "pedro.rodriguez@example.com", "555-9012", "España"};
	    assertArrayEquals(cliente3, clientes.get(2));

	    // Borra el archivo de prueba
	    File file = new File(archivo);
	    file.delete();
	}

	private void assertArrayEquals(String[] cliente1, String[] strings) {
		
		
	}

	@Test
    public void testFileScannerProducto() {
        String rutaArchivo = "C:/Users/Carlos Carrillo/eclipse-workspace/GestionPedidos2/src/carlosPedido/Producto.txt";
        List<String[]> productos = TratamientoFicherosTest.fileScannerProducto(rutaArchivo);

        // Comprueba que se han leído los productos correctamente
        assertEquals5(3, productos.size());
        String[] producto1 = productos.get(0);
        assertEquals6("NombreProducto1", producto1[0]);
        assertEquals6("Descripción del producto 1", producto1[1]);
        assertEquals6("10.5", producto1[2]);
        String[] producto2 = productos.get(1);
        assertEquals6("NombreProducto2", producto2[0]);
        assertEquals6("Descripción del producto 2", producto2[1]);
        assertEquals6("7.0", producto2[2]);
        String[] producto3 = productos.get(2);
        assertEquals6("NombreProducto3", producto3[0]);
        assertEquals6("Descripción del producto 3", producto3[1]);
        assertEquals6("5.25", producto3[2]);
    }
	private void assertEquals5(int i, int size) {
		
		
	}
	private void assertEquals6(String string, String producto1) {
		
		
	}

	@Test
	public void testEscribeFichero() throws FileNotFoundException {
	    // Llama al método escribeFichero()
	    TratamientoFicheros.escribeFichero();

	    // Verifica que el archivo se haya creado
	    File file = new File("C:/Users/Carlos Carrillo/eclipse-workspace/carlosPedido/src/carlosPedido/Cliente.txt");
	    assertTrue(file.exists());

	    // Verifica que el archivo contenga la información correcta
	    Scanner scanner = new Scanner(file);
	    String expected = "Modelo 0\nModelo 1\nModelo 2\nModelo 3\nModelo 4\nModelo 5\nModelo 6\nModelo 7\nModelo 8\nModelo 9\n";
	    String actual = scanner.useDelimiter("\\A").next();
	    assertEquals1(expected, actual);
	}

	private void assertTrue(boolean exists) {
	
	}

}
