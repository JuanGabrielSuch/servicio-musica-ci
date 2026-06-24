package src;

import org.junit.Before;
import org.junit.Test;
import static org.junit.Assert.*;

public class TestParticionEstado {
    private BibliotecaMusical biblioteca;
    private Cancion cancion;

    @Before
    public void setUp() {
        biblioteca = new BibliotecaMusical();
        cancion = new Cancion("Bink's Sake", "Brook", 200);
    }

    // ==================== MÉTODOS M (Modificadores de estado) ====================
    @Test
    public void testMetodosModificadores() {
        // agregarCancionACatalogo y registrarUsuario cambian el estado interno (añaden datos)
        biblioteca.agregarCancionACatalogo(cancion);
        Usuario u = new Usuario("Luffy", "Premium");
        biblioteca.registrarUsuario(u);
        
        assertEquals(1, biblioteca.getCatalogoCanciones().size());
        assertEquals(1, biblioteca.getUsuarios().size());
    }

    // ==================== MÉTODOS NM (No Modificadores de estado) ====================
    @Test
    public void testMetodosNoModificadores() {
        // Primero preparamos el estado para poder buscar
        biblioteca.agregarCancionACatalogo(cancion); 
        
        // buscarCancionPorTitulo NO cambia el estado, solo hace una consulta
        java.util.List<Cancion> resultado = biblioteca.buscarCancionPorTitulo("Bink's Sake");
        
        assertFalse(resultado.isEmpty());
        assertEquals("Brook", resultado.get(0).getArtista());
    }
}