clase CRUDTickets {

  public Cola extraccionInformacionTicketsEspera(Archivo objA) {
    objA.abrirModoLectura("TicketsIngresados.txt")
    entero cl = objA.contadorLineas("TicketsIngresados.txt")
    Tickets vecTickets[] = nuevo Tickets[cl]
    vecTickets = objA.leer()
    objA.cerrarModoLectura()

    Cola c = nueva Cola()
    para (entero i = 0; i < cl; i++) {
      si (vecTickets[i].obtenerEstado() == "en espera") {
        c.push(vecTickets[i])
      }
    }
    retornar c
  }

  public Pila extraccionInformacionTicketsAtendidos(Archivo objA) {
    objA.abrirModoLectura("TicketsIngresados.txt")
    entero cl = objA.contadorLineas("TicketsIngresados.txt")
    Tickets vecTickets[] = nuevo Tickets[cl]
    vecTickets = objA.leer()
    objA.cerrarModoLectura()

    Pila p = nueva Pila()
    para (entero i = 0; i < cl; i++) {
      si (vecTickets[i].obtenerEstado() == "atendido") {
        p.push(vecTickets[i])
      }
    }
    retornar p
  }

  public vacio atencionTickets(Archivo objA, Cola c) {
    objA.abrirModoLectura("TicketsIngresados.txt")
    entero cl = objA.contadorLineas("TicketsIngresados.txt")
    Tickets vecTickets[] = nuevo Tickets[cl]
    vecTickets = objA.leer()
    objA.cerrarModoLectura()

    mientras (c.isEmpty() == falso) {
      Tickets t = (Tickets) c.pop()

      para (entero i = 0; i < cl; i++) {
        si (vecTickets[i].obtenerIdTicket() == t.obtenerIdTicket()) {
          vecTickets[i].asignarEstado("atendido")
        }
      }

      objA.abrirModoEscritura("TicketsIngresados.txt")
      para (entero j = 0; j < cl; j++) {
        objA.escribir(vecTickets[j].toString())
      }
      objA.cerrarModoEscritura()
    }
  }

  public Pila auditoriaTickets(Archivo objA, Pila p) {
    Pila pendientes = nueva Pila()
    objA.abrirModoEscritura("auditados.txt")
    mientras (p.isEmpty() == falso) {
      Tickets t = (Tickets) p.pop()
      si (t.obtenerCodIncidencia() >= 1 y t.obtenerCodIncidencia() <= 50) {
        objA.escribir(t.toString())
      } sino {
        pendientes.push(t)
      }
    }
    objA.cerrarModoEscritura()
    retornar pendientes
  }
}
