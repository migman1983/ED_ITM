package playlist;

public class Cancion {
    private final String titulo;
    private String artista;
    private final int duracionSegundos;

    public Cancion(String titulo, String artista, int duracionSegundos) {
        this.titulo = titulo;
        this.artista = artista;
        this.duracionSegundos = duracionSegundos;
    }

    public String getTitulo() {
        return titulo;
    }

    public String getArtista() {
        return artista;
    }

    public void setArtista(String artista) {
        this.artista = artista;
    }

    public int getDuracionSegundos() {
        return duracionSegundos;
    }

    @Override
    public String toString() {
        return titulo + " - " + artista + " (" + duracionSegundos + "s)";
    }
}
