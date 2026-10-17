public class CRUD_Tickets
{

  //1. Primer Método
  public Cola extraerInformaciónTicketsEnEspera(Archivo archivo)
  {
    archivo.abrirModoLectura("Tickets_Ingresados.txt");
    int tamañoVector=archivo.contarLineas("Tickets_Ingresados.txt");
    Ticket[] vectorTickets=leerTickets("Tickets_Ingresados.txt");
    archivo.cerrarModoLectura();

    int contadorEnEspera=0;
    for(int i=0; i<vectorTickets.length(); i++)
    {
      if(vectorTickets[i].getEstado().equalsIgnoreCase("en espera"))
      {
        contadorEnEspera++;
      }
    }

    Cola colaEspera= new Cola(contadorEnEspera);
    for(int i=0; i<vectorTickets.length; i++)
    {
      if(vectorTickets[i].getEstado().equalsIgnoreCase("en espera"))
      {
        colaEspera.push(vectorTickets[i]);
      }
    }
    
    return colaEspera;

  }

  //2. Segundo Método
  public Pila extraerInformaciónTicketsAtendidos(Archivo archivo)
  {
    archivo.abrirModoLectura("Tickets_Ingresados.txt");
    int tamañoVector=archivo.contarLineas("Tickets_Ingresados.txt");
    Ticket[] vectorTickets=leerTickets("Tickets_Ingresados.txt");
    archivo.cerrarModoLectura();

    int contadorAtendidos=0;
    for(int i=0; i<vectorTickets.length(); i++)
    {
      if(vectorTickets[i].getEstado().equalsIgnoreCase("atendido"))
      {
        contadorAtendidos++;
      }
    }

    Pila pilaAtendidos=new Pila(contadorAtendidos);
    for(int i=0; i<vectorTickets.length(); i++)
    {
      if(vectorTickets[i].getEstado().equalsIgnoreCase("atendido))
      {
        pilaAtendidos.push(vectorTickets[i]);
      }
    }

    return pilaAtendidos;
  }

  //3. Tercer Método
  public void AtenciónTickets(Archivo, Cola colaEspera)
  {
    Ticket ticket=new Ticket();
    while(!colaEpsera.estaVacia())
    {
      ticket=(Ticket) colaEspera.pop();
      ticket.setEstado("atentido");
      archivo.abrirModoEscritura("Tickets_Ingresados.txt");
      archivo.escribir(ticket.toString());
      archivo.cerrarModoEscritura();
    }
  }

  //4. Cuarto Método
  public Pila AuditoriaTickets(Archivo archivo, Pila pilaAtendidos)
  {
    Ticket ticket=new Ticket();
    Pila pilaAuxiiar=new Pila(pilaAtendidos.obtenerTamaño());

    while(!pilaAtendidos.estaVacia())
    {
      ticket=(Ticket) pilaAtendidos.pop();
      if(ticket.getCodIncidencia()>=1 && ticket.getCodIncidencia()<=50)
      {
        archivo.abrirModoEscritura("auditados.txt");
        archivo.escribir(ticket.toString());
        archivo.cerrarModoEscritura();
      }
      else
      {
        pilaAuxiliar.push(ticket);
      }
    }

    while(!pilaAuxiliar.estaVacia())
    {
      pilaAtendidos.push(pilaAuxiliar.pop());
    }

    return pilaAtendidos;
  }
  
}
