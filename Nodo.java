package playlist;

public class Nodo {
   private final Cancion cancion;
   private Nodo siguiente;
 
   public Nodo (Cancion cancion){
       this.cancion = cancion;
       this.siguiente = null; 
   }
   
   public Cancion getCancion(){
    return cancion;
   }
   public Nodo getSiguiente(){
       return siguiente;
   }
   public void setSiguiente(Nodo siguiente){
       this.siguiente = siguiente;
   }
}
