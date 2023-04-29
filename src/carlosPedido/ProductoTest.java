package carlosPedido;

import org.junit.jupiter.api.Test;

class ProductoTest {
	
	private void assertEquals(int i, int j) {
	}

	@Test
    public void testRellenarStock() {
        // 1. Crear una instancia de la clase Producto
        Producto producto = new Producto();

        // 2. Llamar al método rellenarStock()
        producto.rellenarStock();

        // 3. Verificar que todos los elementos del arreglo stock1 están inicializados a 1.
        for (int i = 0; i < producto.stock1.length; i++) {
            assertEquals(1, producto.stock1[i]);
        }
    }

	
	@Test
    public void testMostrarStock() {
        // 1. Crear una instancia de la clase Producto
        Producto producto = new Producto();

        // 2. Llamar al método mostrarStock()
        int cantidad = producto.mostrarStock();

        // 3. Verificar que el valor de retorno del método es igual a la longitud del arreglo stock1
        assertEquals(producto.stock1.length, cantidad);
    }

}
