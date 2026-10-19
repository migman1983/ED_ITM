public class CRUDTickets {

    public Cola extraccionInformacionTicketsEspera(Archivo objA) {
        objA.abrirModoLectura("TicketsIngresados.txt");
        int cl = objA.contadorLineas("TicketsIngresados.txt");
        Tickets[] vecTickets = new Tickets[cl];
        vecTickets = objA.leer();
        objA.cerrarModoLectura();

        Cola c = new Cola();
        for (int i = 0; i < cl; i++) {
            if (vecTickets[i].obtenerEstado().equals("en espera")) {
                c.push(vecTickets[i]);
            }
        }
        return c;
    }

    public Pila extraccionInformacionTicketsAtendidos(Archivo objA) {
        objA.abrirModoLectura("TicketsIngresados.txt");
        int cl = objA.contadorLineas("TicketsIngresados.txt");
        Tickets[] vecTickets = new Tickets[cl];
        vecTickets = objA.leer();
        objA.cerrarModoLectura();

        Pila p = new Pila();
        for (int i = 0; i < cl; i++) {
            if (vecTickets[i].obtenerEstado().equals("atendido")) {
                p.push(vecTickets[i]);
            }
        }
        return p;
    }

    public void atencionTickets(Archivo objA, Cola c) {
        objA.abrirModoLectura("TicketsIngresados.txt");
        int cl = objA.contadorLineas("TicketsIngresados.txt");
        Tickets[] vecTickets = new Tickets[cl];
        vecTickets = objA.leer();
        objA.cerrarModoLectura();

        while (!c.isEmpty()) {
            Tickets t = (Tickets) c.pop();

            for (int i = 0; i < cl; i++) {
                if (vecTickets[i].obtenerIdTicket() == t.obtenerIdTicket()) {
                    vecTickets[i].asignarEstado("atendido");
                }
            }

            objA.abrirModoEscritura("TicketsIngresados.txt");
            for (int j = 0; j < cl; j++) {
                objA.escribir(vecTickets[j].toString());
            }
            objA.cerrarModoEscritura();
        }
    }

    public Pila auditoriaTickets(Archivo objA, Pila p) {
        Pila pendientes = new Pila();
        objA.abrirModoEscritura("auditados.txt");
        while (!p.isEmpty()) {
            Tickets t = (Tickets) p.pop();
            if (t.obtenerCodIncidencia() >= 1 && t.obtenerCodIncidencia() <= 50) {
                objA.escribir(t.toString());
            } else {
                pendientes.push(t);
            }
        }
        objA.cerrarModoEscritura();
        return pendientes;
    }
}