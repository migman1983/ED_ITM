
package RutaExpress;

public class CRUDCliente 
{
 private Scanner sc = new Scanner(System.in);
  public CRUDCliente()
  {
      
  }

   public void IngresarRegistroCliente(Archivo arch, String cc)
   {
     /* 1.1 validar que la cedula no se encuentre en el archivo:
         tenemos que recorrer el archivo para llevarlo a un vector tipo Cliente
         recorrer el vector para identificar que la cedula ingresada no se encuentre
         registrada en el archivo */
        int cl =  arch.contadorLineas("DatosClientes.txt");
        arch.abrirModoLectura("DatosClientes.txt");
        Cliente[] vecC = new Cliente[cl];
        vecC = arch.leerCliente();
        arch.cerrarModoLectura();
        int i = 0;
        boolean sw =  false;
        while(i < cl)
        {
          if(cc.equalsIgnoreCase(vecC[i].obtenerCedula()))
          {
           sw = true;
           break;
          }
          i++;   
        }
        if((!sw)||(cl == 0))
         {
         //  1. abrir archivo mode Escritura
           arch.abrirModoEscritura("DatosClientes.txt");
         // 2. crear el objeto que vamos a guardar
           Cliente c = new Cliente();
           c = c.ingresarDatos(cc);
         // 3. escribir en el archivo
           String registro = c.convertirCadena();
           arch.escribir(registro);
        // 4. cerrar el archivo en modo EScritura
           arch.cerrarModoEscritura();
         } 
        else
        {
          System.out.println("la cedula ya se encuentra registrada");
        }          
   }
   
public void consultarCliente(Archivo arch, String cedula)
{
  //1. abrir archivo en modo lectura
   arch.abrirModoLectura("DatosClientes.txt");
  //2. contar las lineas del archivo y almacenarlo en una variable
   int cl = arch.contadorLineas("DatosClientes.txt");
  //3.  Crear el vector que va a almacenar los registros que hay en el archivo
    Cliente[] vecC = new Cliente[cl];  
  //4. Pasar los registros del archivo al vector
    vecC = arch.leerCliente();
   //4.1 cerramos el archivo en modo lectura
    arch.cerrarModoLectura();
  //5. recorrer el vector para identificar si la cedula existe
    boolean sw = true;
   for(int i=0; i < vecC.length; i++)
    {
     if(cedula.equalsIgnoreCase(vecC[i].obtenerCedula()))
     {
      System.out.println("usuario existente");
      System.out.println("Datos = {cedula: "+ cedula + " nombre: "+ vecC[i].obtenerNombre() +" telefono: "+ vecC[i].obtenerTelefono()+ "} ");
      sw = false; 
       break;
     }
    }
    if(sw)
     System.out.println("usuario no existe");
 }

public void actualizarRegistro(Archivo arch, String cedula)
{       
 //1. abrimos archivo de clientes en modo lectura
   arch.abrirModoLectura("DatosClientes.txt");
 //2. recorrer el archivo para contar los registros del archivo
   int cl = arch.contadorLineas("DatosClientes.txt");
 //3. crear vector tipo Cliente que su tamaño sea de acuerdo a la cantidad registros encontrados
    Cliente[] vecC = new Cliente[cl];
 //4. asignarle al vector los registros identificados en el archivo y cerrar archivo en modo lectura
    vecC = arch.leerCliente();
 /*5. recorrer el vector para encontrar la cedula y realizar la actualización. para eso se
    necesita una estructura ciclica y dentro de la estrcutura se compara las cedulas y si 
    se encuentra un match entre la cedula consultada con la registrada en el vector, se debería
    pedir el dato a actualizar (nombre o telefono) y actualizar el objeto en la posición que se 
    encuentra en el vector*/
     int i = 0;
     int opcion = 0;
     boolean sw = false;
     
     while(i<cl)
     {
       if(cedula.equalsIgnoreCase(vecC[i].obtenerCedula()))
        {
         System.out.println("seleccione el dato a actualizar: ");
         System.out.println("1. nombre");
         System.out.println("2. telefono");
         opcion = sc.nextInt();    
         switch(opcion)
         {
          case 1:
               String nombre;
               System.out.println("ingrese el nuevo nombre del Cliente:");
               nombre = sc.next();
               vecC[i].asignarNombre(nombre);
               break;
            case 2:
               String telefono;
               System.out.println("ingrese el nuevo telefono del Cliente:");
               telefono = sc.next();
               vecC[i].asignarTelefono(telefono);
               break;
            default:
               System.out.println("la opción no es valida. no se actualizará el registro");
           }
         sw = true;
         break;
        }     
       /* de que manera podríamos "obligar" al usuario que ingrese un valor valido en la opción para que pueda actualizarse 
          un registro */
         i++;
     }
     
  //6.Cerrar modo Escritura y Eliminar el archivo
     arch.cerrarModoLectura();
     arch.eliminaArchivo("DatosClientes.txt");
   
  //7. abrir archivo en modo escritura
    arch.abrirModoEscritura("DatosClientes.txt");
  //8. volver a crear el archivo con la información que se encuentra en el vector
    for(Cliente c: Cliente)
     {
      arch.escribir(vecC[c].convertirCadena());   
     }
         
  //9. cerrar archivo en modo escritura
    arch.cerrarModoEscritura();
}

public void eliminarRegistro(Archivo arch, String cedula)
{
   //1. abrir archivo en modo lectura
   arch.abrirModoLectura("DatosClientes.txt");
  //2. contar las lineas del archivo y almacenarlo en una variable
   int cl = arch.contadorLineas("DatosClientes.txt");
  //3.  Crear el vector que va a almacenar los registros que hay en el archivo
    Cliente[] vecC = new Cliente[cl];  
  //4. Pasar los registros del archivo al vector
    vecC = arch.leerCliente();
   //4.1 cerramos el archivo en modo lectura
    arch.cerrarModoLectura();
   //5. recorrer el vector para encontrar la cedula y guardar su posición
    int i = 0;
    int posicion = -1;
    boolean sw = false;
    while(i < cl)
    {
      if(cedula.equalsIgnoreCase(vecC[i].obtenerCedula()))
      {   
         sw = true;
         posicion = i;
         break;
      }
      i++;
    }

   //6. validar si la cedula fue encontrada
   // 6.1 crear un nuevo vector de tamaño (cl - 1) sin el cliente eliminado
      Cliente[] vecNuevo = new Cliente[cl - 1];
    if(!sw)
      System.out.println("la cedula no se encuentra registrada");
     else
      {
        int j = 0;
        int k = 0;
        while(j < cl)
        {
         if(j != posicion)
         {
           vecNuevo[k] = vecC[j];
           k++;
         }
          j++;
        }
      }
      // 6.2 eliminar el archivo original
        arch.eliminaArchivo("DatosClientes.txt");

      // 6.3 abrir archivo en modo escritura
        arch.abrirModoEscritura("DatosClientes.txt");

      // 6.4 volver a crear el archivo con la información del vector actualizado (sin el registro eliminado)
        int m = 0;
        while(m < (cl - 1))
        {
          arch.escribir(vecNuevo[m].convertirCadena());
          m++;
        }

      // 6.5 cerrar archivo en modo escritura
        arch.cerrarModoEscritura();
        System.out.println("registro eliminado con éxito");
   } 
   
}   
