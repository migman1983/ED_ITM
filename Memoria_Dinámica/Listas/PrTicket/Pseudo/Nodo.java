
package pr_listasimple;


public class Nodo 
{
    private Object dato;
    private Nodo sig;
    private Nodo ant;

    public Nodo() {
        this.dato = null;
        this.sig = null;
        this.ant = null;
    }

    public Nodo(Object d) {
        this.dato = d;
        this.sig = null;
        this.ant = null;
    }

    public Nodo(Nodo li, Object d, Nodo ld) {
        this.dato = d;
        this.sig = ld;
        this.ant = li;
    }

    public Object obtenerDato() {
        return dato;
    }

    public void asignarDato(Object dato) {
        this.dato = dato;
    }

    public Nodo obtenerAnt() {
        return ant;
    }

    public void asignarAnt(Nodo ant) {
        this.ant = ant;
    }

    public Nodo obtenerSig() {
        return sig;
    }

    public void asignarSig(Nodo sig) {
        this.sig = sig;
    }
   
    
}
