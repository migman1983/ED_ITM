package RutaExpress;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;

public class CRUDCliente 
{
    BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

  public CRUDCliente()
  {
  }
  public void ingresarRegistro(Archivo arch, String cc)
   {

       int cl = arch.contadorLineas("DatosClientes.txt");
       Cliente[] vecC =  new Cliente[cl];
       arch.abrirModoLectura("DatosClientes.txt");
       vecC = arch.leerCliente();
       arch.cerrarModoLectura();
       int i = 0;
       boolean sw = false;
       while(i<cl)
       {
        if(cc.equalsIgnoreCase(vecC[i].obtenerCedula()))
        {
          sw = true;
          break;
        }   
        i++;
       }    
       if(!sw)1||(cl == 0)
       {  
        //  1. abrir archivo mode Escritura
         arch.abrirModoEscritura("DatosClientes.txt"); 
        // 2. crear el objeto que vamos a guardar
         Cliente c = new Cliente();
         c = c.ingresarDatos(cc);
        //3. escribir en el archivo
         String registro = c.toString();
         arch.escribir(registro);
        //4. cerrar el archivo en modo EScritura
         arch.cerrarModoEscritura();
       }
       else
       {
           System.out.println("Cedula ya existe en el archivo");   
       }
   }
   public void ConsultatrCliente(Archivo arch , String cedula){
       arch.abrirModoLectura("DatosClientes.txt");
       int cl = arc.contadorLineas("DatosClientes.txt");
       Cliente[] vecC = new Cliente[cl];
       vecC = arch.leerCliente();
       arch.cerrarModoLectura();
       boolean sw = true;
       for (int i = 0; i<vecC.[i].obtenerCedula()){
           if(cedula == vecC[i].obtenerCedula()){
               System.out.println("usuario existente");
               System.out.println("Datos = {cedula : " + cedula + ", Nombre : " + vecC[i].obtenerNombre() + ", telefono : " + vecC[i].obtenerTelefono() + "}");
               boolean sw = false ;
               break;
           }
       }
       if(sw){
          System.out.println("Usuario no existe");   

       }
      }
      
    public void actualizarRegistro(Archivo arch, String cedula){
       arch.abrirModoLectura("DatosClientes.txt");
       int cl = arc.contadorLineas("DatosClientes.txt");
       Cliente[] vecC = new Cliente[cl];
       vecC = arch.leerCliente();
       int i = 0;
       int opcion = 0 ;
       boolean sw = false;
       while (i<cl){
           if(cedula == veC[i].obtenerCedula()){
               do {
               System.out.println("Seleccione el dato a actualizar");
               System.out.println("1. Nombre");
               System.out.println("2. telefono");
               String opcion = reader.readLine();
                if (!opcion.equals("1") && !opcion.equals("2")) {
                    System.out.println("Opcion invalida.");
                  }
               }
               while (!opcion.equals("1") && opcion.equals("2"));
               switch (opcion){
                   case 1:
                      String nombre;
                      System.out.println("1. Nombre");
                      nombre = reader.readLine();
                      vecC[i].asignarNombre(nombre);
                       break;
                    case 2:
                      String telefono;
                      System.out.println("2. telefono");
                      telefono = reader.readLine();
                      vecC[i].asignarTelefono(telefono);
                      break;
                    default:
                       System.out.println("la opción no es valida. no se actualizará el registro");
                       break;
                }
                sw = true;
            i++;
           }
       }
       arch.cerrarModoLectura();
       arch.eliminarArchivo("DatosClientes.txt");
       arch.abrirModoEscritura("DatosClientes.txt");
       for (Cliente c: Clientes){
           arch.escribir(vecC[c].convertirCadena());
       }
       
        arch.cerrarModoEscritura()
    }
    public void eliminarRegistro(Archivo arch,String cedula){
       arch.abrirModoLectura("DatosClientes.txt");
       int cl = arc.contadorLineas("DatosClientes.txt");
       Cliente[] vecC = new Cliente[cl];
       vecC = arch.leerCliente();
       arch.cerrarModoLectura()
       if(cl == 0;){
           System.out.println("no hay registros");
       }
       int i = 0;
       int sw = false;
       while(i < cl ){
           if(cedula == vecC[i].obtenerNombre){
           sw = true;
           System.out.println("usuario existente");
           System.out.println("Datos = {cedula : " + cedula + ", Nombre : " + vecC[i].obtenerNombre() + ", telefono : " + vecC[i].obtenerTelefono() + "}");
           break;
          }
        i++;  

       }
       if(!sw){
           System.out.println("usuario no existe");
       }
       arch.eliminarArchivo("DatosClientes.txt");
       arch.abrirModoEscritura("DatosClientes.txt");
       for(int j = 0;j<cl;i++){
           if(j != i){
               arch.escribir(vecC[j].convertirCadena())
           }
       }
       arch.cerrarModoEscritura();
       System.out.println("registro");

    }
   }
