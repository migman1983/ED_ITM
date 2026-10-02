package pr_pilaestudiante;

public class Pila {
    private int maxsize;
    private int size;
    private Nodo top;

    public Pila() {
        this(10);
    }

    public Pila(int n) {
        maxsize = n;
        top = null;
        size = 0;
    }

    public boolean isEmpty() {
        return size <= 0;
    }

    public boolean isFull() {
        return size >= maxsize;
    }

    public void push(Object d) {
        if (!isFull()) {
            Nodo nuevo = new Nodo(d);
            nuevo.asignarSig(top);
            top = nuevo;
            size++;
        } else {
            System.out.println("***** DESBORDAMIENTO DE PILA *****");
        }
    }

    public Object peek() {
        return isEmpty() ? null : top.obtenerDato();
    }

    public Object pop() {
        if (isEmpty()) {
            System.out.println("***** SUBDESBORDAMIENTO DE PILA *****");
            return null;
        }

        Object d = top.obtenerDato();
        top = top.obtenerSig();
        size--;
        return d;
    }

    public Nodo obtenerTop() { return top; }
    public void asignarTop(Nodo top) { this.top = top; }
    public int obtenerMaxsize() { return maxsize; }
    public void asignarMaxsize(int maxsize) { this.maxsize = maxsize; }
    public int obtenerSize() { return size; }
    public void asignarSize(int size) { this.size = size; }
}
