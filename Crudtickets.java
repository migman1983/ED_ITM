//Esto es lo que hice en el parcial, pero en java
public class CRUDTickets {

    // METODO 1 
    // Retorna una Cola con los tickets en estado "en espera".
    public Cola extraccionInformacionTicketsEspera(Archivo objA) {

        objA.abrirArchivoModoLectura("TicketsIngresados.txt");
        int cl = objA.contadorLineas("TicketsIngresados.txt");
        Tickets[] vecTickets = new Tickets[cl];
        vecTickets = objA.leerTickets();
        objA.cerrarModoLectura();

        // Cuenta los tickets "en espera"
        int contEspera = 0;
        for (int k = 0; k < cl; k++) {
            if (vecTickets[k].obtenerEstado().equals("en espera")) {
                contEspera++;
            }
        }
        Cola colaEspera = new Cola(contEspera);

        // Mete a la cola los tickets en espera
        for (int k = 0; k < cl; k++) {
            if (vecTickets[k].obtenerEstado().equals("en espera")) {
                colaEspera.push(vecTickets[k]);
            }
        }
        return colaEspera;
    }

    // METODO 2 
    // Retorna una Pila con los tickets en estado "atendido".
    public Pila extraccionInformacionTicketsAtendidos(Archivo objA) {

        objA.abrirArchivoModoLectura("TicketsIngresados.txt");
        int cl = objA.contadorLineas("TicketsIngresados.txt");
        Tickets[] vecTickets = new Tickets[cl];
        vecTickets = objA.leerTickets();
        objA.cerrarModoLectura();

        int contAtendidos = 0;
        for (int k = 0; k < cl; k++) {
            if (vecTickets[k].obtenerEstado().equals("atendido")) {
                contAtendidos++;
            }
        }

        // Crea la pila del tamano justo y apila los atendidos.
        Pila pilaAtendidos = new Pila(contAtendidos);
        for (int k = 0; k < cl; k++) {
            if (vecTickets[k].obtenerEstado().equals("atendido")) {
                pilaAtendidos.push(vecTickets[k]);
            }
        }

        return pilaAtendidos;
    }

    // METODO 3
    // Recibe la cola, atiende cada ticket y actualiza el archivo.
    public void atencionTickets(Cola c, Archivo objA) {

        while (!c.isEmpty()) {


            Tickets t = (Tickets) c.pop();

            // Cambia el estado del ticket (solo en memoria por ahora)
            t.modificarEstado("atendido");

            objA.abrirArchivoModoLectura("TicketsIngresados.txt");
            int cl = objA.contadorLineas("TicketsIngresados.txt");
            Tickets[] vecTickets = new Tickets[cl];
            vecTickets = objA.leerTickets();
            objA.cerrarModoLectura();

            // Busca el ticket por id y le copia el nuevo estado.
            for (int k = 0; k < cl; k++) {
                if (vecTickets[k].obtenerIdTicket() == t.obtenerIdTicket()) {
                    vecTickets[k].modificarEstado(t.obtenerEstado());
                }
            }

            objA.eliminarArchivo("TicketsIngresados.txt");
            objA.abrirModoEscritura("TicketsIngresados.txt");
            for (int k = 0; k < cl; k++) {
                // toString() convierte el ticket en una linea de texto
                objA.escribir(vecTickets[k].toString());
            }
            objA.cerrarModoEscritura();
        }
    }

    // METODO 4 

    public Pila auditoriaTickets(Pila p, Archivo objA) {

        Pila pNoCumple = new Pila(p.obtenerTamanio());

        Tickets t;

        objA.abrirModoEscritura("auditados.txt");

        while (!p.isEmpty()) {
            t = (Tickets) p.pop();
            if (t.obtenerIdTicket() >= 1 && t.obtenerIdTicket() <= 50) {
                objA.escribir(t.toString());
            } else {
                pNoCumple.push(t);
            }
        }

        objA.cerrarModoEscritura()
          
        // Se pasa otra vez a pRetorno para recuperar el orden original.
        Pila pRetorno = new Pila(pNoCumple.obtenerTamanio());
        while (!pNoCumple.isEmpty()) {
            pRetorno.push(pNoCumple.pop());
        }
        return pRetorno;
    }
}
