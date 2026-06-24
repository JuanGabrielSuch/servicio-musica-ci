package src;
import java.util.ArrayList;
import java.util.List;

public class Usuario {
    private String nombreUsuario;
    private List<Playlist> playlists;
    private String tipoSuscripcion;

    public Usuario(String nombreUsuario, String tipoSuscripcion) {
        this.nombreUsuario = nombreUsuario;
        this.tipoSuscripcion = tipoSuscripcion;
        this.playlists = new ArrayList<>();
    }

    public String getNombreUsuario() {
        return nombreUsuario;
    }

    public String getTipoSuscripcion() {
        return tipoSuscripcion;
    }

    public List<Playlist> getPlaylists() {
        return playlists;
    }

    public Playlist crearPlaylist(String nombrePlaylist) {
        Playlist nuevaPlaylist = new Playlist(nombrePlaylist);
        this.playlists.add(nuevaPlaylist);
        return nuevaPlaylist; // El PDF pide que la devuelva
    }

    public void eliminarPlaylist(Playlist playlist) {
        this.playlists.remove(playlist);
    }

    public void compartirPlaylist(Playlist playlist, Usuario otroUsuario) {
        // Implementamos la regla de negocio del PDF: Posiblemente solo Premium
        if (this.tipoSuscripcion.equalsIgnoreCase("Premium")) {
            otroUsuario.getPlaylists().add(playlist);
        }
    }
}