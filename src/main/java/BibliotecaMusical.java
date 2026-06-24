package src;
import java.util.ArrayList;
import java.util.List;

public class BibliotecaMusical {
    private List<Cancion> catalogoCanciones;
    private List<Usuario> usuarios;

    public BibliotecaMusical() {
        this.catalogoCanciones = new ArrayList<>();
        this.usuarios = new ArrayList<>();
    }

    public void agregarCancionACatalogo(Cancion cancion) {
        this.catalogoCanciones.add(cancion);
    }

    public void registrarUsuario(Usuario usuario) {
        this.usuarios.add(usuario);
    }

    public List<Cancion> buscarCancionPorTitulo(String titulo) {
        List<Cancion> resultados = new ArrayList<>();
        for (Cancion c : catalogoCanciones) {
            if (c.getTitulo().equalsIgnoreCase(titulo)) {
                resultados.add(c);
            }
        }
        return resultados;
    }

    public List<Cancion> buscarCancionPorArtista(String artista) {
        List<Cancion> resultados = new ArrayList<>();
        for (Cancion c : catalogoCanciones) {
            if (c.getArtista().equalsIgnoreCase(artista)) {
                resultados.add(c);
            }
        }
        return resultados;
    }

    public List<Playlist> buscarPlaylistPorNombre(String nombre) {
        List<Playlist> resultados = new ArrayList<>();
        // Doble bucle tradicional: recorremos usuarios y luego sus playlists
        for (Usuario u : usuarios) {
            for (Playlist p : u.getPlaylists()) {
                if (p.getNombre().equalsIgnoreCase(nombre)) {
                    resultados.add(p);
                }
            }
        }
        return resultados;
    }
    
    // Métodos extra para ayudar con las pruebas luego
    public List<Cancion> getCatalogoCanciones() {
        return catalogoCanciones;
    }

    public List<Usuario> getUsuarios() {
        return usuarios;
    }
}