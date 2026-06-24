package src;
import org.junit.Test;
import org.junit.Before;
import static org.junit.Assert.*;

public class BibliotecaMusicalTest {
    private BibliotecaMusical biblioteca;
    private Cancion cancion1;
    private Usuario usuarioPremium;

    // Esta anotación hace que este método se ejecute SIEMPRE antes de cada prueba
    // Sirve para preparar los datos limpios al empezar
    @Before
    public void setUp() {
        biblioteca = new BibliotecaMusical();
        cancion1 = new Cancion("Bohemian Rhapsody", "Queen", 355);
        usuarioPremium = new Usuario("Juan", "Premium");
    }

    // ==================== 4 CASOS DE ÉXITO ====================

    @Test
    public void testAssertEqualsExito() {
        // Comprueba si el texto esperado coincide con el del método
        assertEquals("Bohemian Rhapsody", cancion1.getTitulo());
    }

    @Test
    public void testAssertTrueExito() {
        biblioteca.registrarUsuario(usuarioPremium);
        // Comprueba si la condición de dentro es verdadera
        assertTrue(biblioteca.getUsuarios().size() == 1);
    }

    @Test
    public void testAssertFalseExito() {
        Usuario usuarioGratis = new Usuario("Pedro", "Gratis");
        Playlist p = usuarioGratis.crearPlaylist("Mis Favoritas");
        Usuario otro = new Usuario("Ana", "Gratis");
        
        // Como Pedro es "Gratis", no debería poder compartir la playlist con Ana
        usuarioGratis.compartirPlaylist(p, otro);
        assertFalse(otro.getPlaylists().contains(p));
    }

    @Test
    public void testAssertNotNullExito() {
        Playlist nueva = usuarioPremium.crearPlaylist("Rock clasico");
        // Comprueba que el objeto creado no sea nulo
        assertNotNull(nueva);
    }

    // ==================== 4 CASOS DE FALLO (FORZADOS) ====================

   // @Test
    public void testAssertNullFallo() {
        // Va a fallar porque el catálogo se inicializa vacío en el constructor, no es null
        assertNull(biblioteca.getCatalogoCanciones());
    }

    //@Test
    public void testAssertSameFallo() {
        Cancion cancionDuplicada = new Cancion("Bohemian Rhapsody", "Queen", 355);
        // Va a fallar porque "assertSame" mira si son exactamente el mismo objeto en la memoria,
        // y aunque tengan los mismos datos, los creamos por separado
        assertSame(cancion1, cancionDuplicada);
    }

 //   @Test
    public void testAssertNotSameFallo() {
        // Va a fallar porque estamos diciendo que NO son el mismo objeto, pero en verdad sí lo son
        assertNotSame(usuarioPremium, usuarioPremium);
    }

   // @Test
    public void testAssertArrayEqualsFallo() {
        String[] esperado = {"Bohemian Rhapsody"};
        String[] resultado = {"Another One Bites The Dust"};
        // Va a fallar porque los elementos de los arrays son completamente distintos
        assertArrayEquals(esperado, resultado);
    }
}
