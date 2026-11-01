package playlist;
public class Main {
    public static void main(String[] args) {
 
           ListaArtista playlist = new ListaArtista();
             playlist.agregar(new Cancion("Titi me pregunto", "Bad Bunny", 240));
             playlist.agregar(new Cancion("Amorfoda", "Bad Bunny", 320));
             playlist.agregar(new Cancion("La cancion", "Bad Bunny", 200));
             
             playlist.agregar(new Cancion("Rojo", "J balvin", 340));
             playlist.agregar(new Cancion("Ay vamos", "J balvin", 400));
             
             System.out.println("Playlist completa:");
             playlist.imprimir();
             int total = playlist.duracionTotalArtista("Bad Bunny");
             System.out.println("La duracion total consecutiva de Bad Bunny: "+total+"segundos");
             
             int actualizadas = playlist.actualizarNombreArtista("Bad Bunny", "Benito");
        System.out.println("\nCanciones actualizadas: " + actualizadas);
        System.out.println("Playlist despues de actualizar el nombre del artista:");
        playlist.imprimir();
        // Esperado: las 3 canciones de "Bad Bunny" ahora deben decir "Benito"

}
    
}
