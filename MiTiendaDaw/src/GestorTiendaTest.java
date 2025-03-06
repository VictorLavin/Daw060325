import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.Test;

class GestorTiendaTest {

    GestorTienda gestor = new GestorTienda();

    @Test
    void testCalcularDescuento() {
        // Prueba para 10 o más productos (10%)
        assertEquals(10.0, gestor.calcularDescuento(100.0, 10), 10);
        
        // Prueba para entre 5 y 9 productos (5%)
        assertEquals(5.0, gestor.calcularDescuento(100.0, 5), 5);

        // Prueba para menos de 5 productos (0%)
        assertEquals(0.0, gestor.calcularDescuento(100.0, 3), 3);
    }

    @Test
    void testCategorizarProducto() {
        assertEquals("Económico", gestor.categorizarProducto(5.0));
        assertEquals("Estándar", gestor.categorizarProducto(25.0));
        assertEquals("Premium", gestor.categorizarProducto(100.0));
    }

    @Test
    void testBuscarProducto() {
        String[] inventario = {"Ordenador", "Teclado", "Ratón", "Monitor"};
        
        // Producto encontrado (sin importar mayúsculas/minúsculas)
        assertEquals("Teclado", gestor.buscarProducto(inventario, "teclado"));
        
        // Producto no encontrado
        assertNull(gestor.buscarProducto(inventario, "Impresora")); 
    }
}

