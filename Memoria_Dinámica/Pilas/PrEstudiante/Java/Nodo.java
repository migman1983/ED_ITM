package pr_pilaestudiante;

public class Nodo {
    private Object dato;
    private Nodo sig;
    private Nodo ant;

    public Nodo() {}

    public Nodo(Object dato) {
        this.dato = dato;
    }

    public Nodo(Nodo li, Object dato, Nodo ld) {
        this.dato = dato;
        this.sig = ld;
        this.ant = li;
    }

    public Object obtenerDato() { return dato; }
    public void asignarDato(Object dato) { this.dato = dato; }
    public Nodo obtenerAnt() { return ant; }
    public void asignarAnt(Nodo ant) { this.ant = ant; }
    public Nodo obtenerSig() { return sig; }
    public void asignarSig(Nodo sig) { this.sig = sig; }
}
