package estudiante;
import static estudiante.Validacion.*;
//import static eps.fv.Validaciones.*;
import java.util.Arrays;
import java.util.Scanner;

/* 
 - ingresar
 - eliminar 
 - mostrar
 - consultar
*/

public class CRUDEstudiante 
{
   public CRUDEstudiante() 
    {
     
    }
    
    public void IngresarEstudiante(Archivo objArchivo, int idEstudiante) {   
        Estudiante objE = new Estudiante();
        if(Buscar(objArchivo,idEstudiante) == false) {//si no lo encuentra
            objE = objE.datosEstudiante(idEstudiante);//lee toda la informacion y recibe el objeto
            Grabar(objArchivo,objE);  //metodo que graba fisicamente el registro en memoria
        }
        else {
            System.out.println("*****Estudiante YA existe en el archivo*****");
        }//Fin if 
    }//fin  de ingresar Estudiante
    
  public void Grabar(Archivo objArchivos, Estudiante objE ) 
    {
        objArchivos.abrirModoEscritura("DatosEstudiante.txt");
        objArchivos.escribir(objE.estructuraRegistro()); //se graba o escribe o imprime el registro fisicamente en el archivo
        objArchivos.cerrarModoEscritura();
     }//fin  Grabar Estudiante
  
  public boolean Buscar(Archivo objArch, int idEstudiante) 
    { 
        boolean sw=false;
        int cod;
        try {
            Estudiante objE = new Estudiante();
            int tamaño = objArch.contadorLineas("DatosEstudiante.txt");
            objArch.abrirModoLectura("DatosEstudiante.txt");
            Estudiante vecE[] = new Estudiante[tamaño];
            vecE = objArch.leerEstudiante();//retorna el vector tipo objeto y se le asigna al vector definido en esta clase
            int i=0;
            int cantRegistros = objArch.contadorLineas("DatosEstudiante.txt");
            while (i<= cantRegistros) 
            {
               objE = vecE[i];
               cod = objE.getIdEstudiante();
               if(cod == idEstudiante)
                {
                    sw=true;
                    break;
                }
               i++;
            }//fin mientras
            objArch.cerrarModoLectura();

        } catch (Exception e)
        {
             System.out.println("***Archivo leido y cerrado correctamente*****");
        }
        return sw;
        
    }//fin de buscar*/
  
  public Estudiante Consultar(Archivo objArchivo, int idEstudiante) {
    objArchivo.abrirModoLectura("DatosEstudiante.txt");
    Estudiante[] Estudiante = objArchivo.leerEstudiante();
    objArchivo.cerrarModoLectura();

    for (Estudiante e : Estudiante) {
        if (e != null && e.getIdEstudiante() == idEstudiante) {
            return e; // Devuelve el objeto Estudiante encontrado
        }
    }
    return null; // Si no existe
}
  
  public void Actualizar(Archivo objArchivos, int codE)
{
    double notaFinal;
    String nombre, apellido;
    int estrato, edad, codEstudiante;
    objArchivos.abrirModoLectura("DatosEstudiante.txt");
    int op;
    if(objArchivos.archivo.exists()== true)
    {
     int cantLineas = objArchivos.contadorLineas("DatosEstudiante.txt");
     Estudiante vecE[] = new Estudiante[cantLineas];
     try
      {
       boolean sw = false;
       int regV = 0;
       Estudiante objE = new Estudiante();
       vecE = objArchivos.leerEstudiante();//Almacenamos cada registro del archivo en un vector tipo hospital
       int i =0;
       while (i < cantLineas) 
        {
         objE = vecE[i]; 
         codEstudiante = objE.getIdEstudiante();
         nombre = objE.getNombre();
         apellido = objE.getApellido();
         edad = objE.getEdad();
         estrato = objE.getEstrato();
         if(codE == codEstudiante)
         {
          sw = true;
          System.out.println("Se actualizará el registro cuyo Estudiante es: "+codE);
          do
           {
            op = leerEntero(" 1. edad , 2.estrato, ");
            switch(op)
             {
              case 1:
               edad= leerEntero("Ingrese la nueva edad del estudiante: ");
               break;
              case 2:
               estrato = leerEstrato("Ingrese el nuevo estrato del estudiante: ");
               break;
            }  
           }while(op<3);
          objE = new Estudiante(codEstudiante,nombre,apellido, edad,estrato);
          vecE[i]= objE;
          System.out.println(" registro actualizado"+ objE.estructuraRegistro());
        }
        else
         {
          vecE[i]= objE;
         }
         i++;
        }
       if(sw ==false)
        {
          System.out.println("El Estudiante No existe");
        }  
     objArchivos.cerrarModoLectura();
     }catch (Exception e)
      {
       System.out.println("***Archivo leido y cerrado correctamente*****");
       objArchivos.cerrarModoLectura();
      }
     grabarActualizacion(vecE, objArchivos);
    }
  else 
   {
    System.out.println("No existe un archivo para actualizar");
   }
 
 }
  
  public void grabarActualizacion(Estudiante[] vecE, Archivo objArchCopy) 
     {   
        Estudiante objE;
        objArchCopy.cerrarModoLectura(); // se cierra el archivo que se encuentra en modo lectura
        objArchCopy.eliminaArchivo("DatosEstudiante.txt"); // se elimina el archivo original
        for(int i = 0; i<vecE.length;i++)
        {
         objArchCopy.abrirModoEscritura("DatosEstudiante.txt");
         objE = vecE[i];
         String texto = "";
         texto = objE.estructuraRegistro();//con este metodo se da la estructura al registro
         objArchCopy.escribir(texto); //se graba o escribe o imprime el registro fisicamente en el archivo 
         objArchCopy.cerrarModoEscritura();
        }
        
    } 
  public String Mostrar(Archivo objArch) 
    { 
        String cadena="";//cadena para el almacenamiento de todos los registros
        Estudiante objE;
        //int tamaño;
        try {
             int cantRegistros = objArch.contadorLineas("DatosEstudiante.txt");
             //tamaño = objArch.contadorLineas("DatosEstudiantes.txt");
             Estudiante vecE[] = new Estudiante[cantRegistros];
             objArch.abrirModoLectura("DatosEstudiante.txt");
           
            vecE = objArch.leerEstudiante();//retorna el vector tipo objeto y se le asigna al definido en esta clase
            int i =0;
            //int cantRegistros = objArch.contadorLineas("DatosEstudiantes.txt");
            while (i<=cantRegistros)//mientras no llegue hasta la última línea del archivo
            {
              objE = vecE[i];
              cadena=cadena+"[ "+objE.estructuraRegistro()+" ]\n";//se anexan cada registro a la cadena
              i++;
            }//fin mientras */
            objArch.cerrarModoLectura();
            
        } catch (Exception e)
        {
             System.out.println("***Archivo leído y cerrado correctamente*****");
        }
        return cadena;
    }//fin de método mostrar 
  
  public String Eliminar(Archivo objArchivos, int idEst) {
        try {
            // 1. Leer todos los Estudiante
            objArchivos.abrirModoLectura("DatosEstudiante.txt");
            Estudiante[] todos = objArchivos.leerEstudiante();
            objArchivos.cerrarModoLectura();

            if (todos == null || todos.length == 0) {
                return "No hay Estudiante registrados.";
            }

            // 2. Contar Estudiante que NO coinciden con el ID a eliminar
            int contador = 0;
            String eliminado = "";
            for (Estudiante e : todos) {
                if (e != null && e.getIdEstudiante() != idEst) {
                    contador++;
                } else if (e != null) {
                    eliminado = e.estructuraRegistro();
                }
            }

            // 3. Si no se encontró el cliente
            if (eliminado.isEmpty()) {
                return "Estudiante no encontrado.";
            }

            // 4. Crear nuevo array sin el cliente eliminado
            Estudiante[] nuevos = new Estudiante[contador];
            int index = 0;
            for (Estudiante e : todos) {
                if (e != null && e.getIdEstudiante() != idEst) {
                    nuevos[index] = e;
                    index++;
                }
            }

            // 5. Regenerar archivo
            objArchivos.eliminaArchivo("DatosEstudiante.txt");
            for (Estudiante e : nuevos) {
                if (e != null) {
                    Grabar(objArchivos, e);
                }
            }

            return "Eliminado: " + eliminado;

        } catch (Exception e) {
            return "Error al eliminar: " + e.getMessage();
        }
    }

}
