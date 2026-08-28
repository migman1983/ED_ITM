package estudiante;

import static estudiante.Validacion.*;

 /*Crear un archivo que relacione a un estudiante con un curso y con un docente

** nota:
  + Se debe validar que cada elemento que se está relacionando exista en otros archivos.
  + Se debe garantizar que un registro sea único

ojo.. un estudiante no puede matricular la misma materia mas de una vez
ojo.. un estudiante no puede ver la misma materia con otro docente

----------------------------------------------------------------------

1. Crear un archivo Boletin.txt
2. El archivo debe almacenar el IDEstudiante, IDDocente, IDCurso, notaFinal
3. ingresar datos 

*/

public class CRUDBoletin 
{
 public void ingresar(Archivo objA, int idEstudiante, int idDocente, int idCurso)
   {
      Boletin objB = new Boletin();
      if (buscarDatosArchivos(objA, idEstudiante, idDocente,idCurso)&&buscarBoletin(objA, idEstudiante,idDocente, idCurso))
      { 
       objB = objB.ingresarDatos(idEstudiante, idDocente, idCurso);
       grabar(objA, objB);
      } 
       else
         {
           System.out.println("Registro no puede ser almacenado");
         }
    }

  public boolean buscarDatosArchivos(Archivo objA, int idEstudiante, int idDocente, int idCurso)
    {
       // abrimos archivo estudiante
       objA.abrirModoLectura("DatosEstudiante.txt");  
       int cl = 0;
       cl = objA.contadorLineas("DatosEstudiante.txt");
       Estudiante[] vecE = new Estudiante[cl];
       vecE = objA.leerEstudiante();
       objA.cerrarModoLectura();
       // abrimos archivo Docente
       objA.abrirModoLectura("DatosDocente.txt");  
       cl = 0;
       cl = objA.contadorLineas("DatosDocente.txt");
       Docente[] vecD = new Docente[cl];
       vecD = objA.leerDocente();
       objA.cerrarModoLectura();
       // abrimos archivo Curso
       objA.abrirModoLectura("DatosCurso.txt");
       cl = 0;
       cl = objA.contadorLineas("DatosCurso.txt");
       Curso[] vecC = new Curso[cl];
       vecC = objA.leerCurso();
       objA.cerrarModoLectura();
       int cont = 0;
       for(int i = 0; i <vecE.length;i++)
        {
         if(vecE[i].getIdEstudiante()== idEstudiante)
          {
           cont++;
           break;
          }
        }
       for(int i = 0; i <vecD.length;i++)
       {
         if(vecD[i].getIdDocente() == idDocente)
         {
          cont++;
          break;
         }
       }
       for(int i = 0; i <vecC.length;i++)
        {
         if(vecC[i].getIdCurso()== idCurso)
         {
          cont++;
          break;
         }
       }
      return cont == 3;
  }

  public boolean buscarBoletin(Archivo objA, int idEstudiante, int idDocente, int idCurso)
  {
     objA.abrirModoLectura("DatosBoletin.txt");  
     int cl = 0;
     boolean sw = true;
     cl = objA.contadorLineas("DatosBoletin.txt");
     Boletin[] vecB = new Boletin[cl];
     vecB = objA.leerBoletin();
     objA.cerrarModoLectura(); 
     for(int i = 0; i <vecB.length;i++)
     {
       if((vecB[i].getIdEstudiante()== idEstudiante)&&(vecB[i].getIdCurso()== idCurso))
         sw = false;
       
     }
      return sw;
  } 
  
  public void grabar(Archivo objA, Boletin objB)
  {    
    objA.abrirModoEscritura("DatosBoletin.txt");
    objA.escribir(objB.estructuraRegistro());
    objA.cerrarModoEscritura();
  }

  public Boletin Consultar(Archivo objArchivo, int idEstudiante) 
  {
    objArchivo.abrirModoLectura("DatosBoletin.txt");
    Boletin[] Boletin = objArchivo.leerBoletin();
    objArchivo.cerrarModoLectura();

    for (Boletin e : Boletin) 
     {
        if ((e != null) && (e.getIdEstudiante() == idEstudiante)) 
        {
            return e; // Devuelve el objeto Estudiante encontrado
        }
     }
    return null; // Si no existe
  }
  
  public void ActualizarNota(Archivo objArchivos, int idEstudiante, int idCurso)
   {
    double nota;
    objArchivos.abrirModoLectura("DatosBoletin.txt");
    int op;
    if(objArchivos.archivo.exists()== true)
    {
     int cantLineas = objArchivos.contadorLineas("DatosBoletin.txt");
     Boletin vecB[] = new Boletin[cantLineas];
     try
      {
       boolean sw = false;
       Boletin objB = new Boletin();
       vecB = objArchivos.leerBoletin();
       int i =0;
       while (i < cantLineas) 
        {
         if((vecB[i].getIdEstudiante() == idEstudiante)&&(objB.getIdCurso() == idCurso))
         {
           nota = leerNota("Ingrese La nueva nota del estudiante para el curso: ");
           vecB[i].setNotaFinal(nota);
           System.out.println(" registro actualizado"+ vecB[i].toString());
         }
         i++;
        }
       if(sw ==false)
        {
          System.out.println("El Boletin No existe");
        }  
     objArchivos.cerrarModoLectura();
     }catch (Exception e)
      {
       System.out.println("***Archivo leido y cerrado correctamente*****");
       objArchivos.cerrarModoLectura();
      }
     grabarActualizacion(vecB, objArchivos);
    }
  else 
   {
    System.out.println("No existe un archivo para actualizar");
   }
 
  }
   
  public void grabarActualizacion(Boletin[] vecB, Archivo objArchCopy) 
     {   
        //Boletin objB;
        objArchCopy.cerrarModoLectura(); // se cierra el archivo que se encuentra en modo lectura
        objArchCopy.eliminaArchivo("DatosBoletin.txt"); // se elimina el archivo original
        objArchCopy.abrirModoEscritura("DatosBoletin.txt");
        for(int i = 0; i<vecB.length;i++)
        {
         String texto = "";
         texto = vecB[i].estructuraRegistro();
         objArchCopy.escribir(texto); //se graba o escribe o imprime el registro fisicamente en el archivo 
        }
        objArchCopy.cerrarModoEscritura();
    } 
  
  public String Mostrar(Archivo objArch) 
    { 
        String cadena=" ";//cadena para el almacenamiento de todos los registros
        try {
             int cantRegistros = objArch.contadorLineas("DatosBoletin.txt");
             //tamaño = objArch.contadorLineas("DatosEstudiantes.txt");
             Boletin vecB[] = new Boletin[cantRegistros];
             objArch.abrirModoLectura("DatosBoletin.txt");
           
            vecB = objArch.leerBoletin();//retorna el vector tipo objeto y se le asigna al definido en esta clase
            int i =0;
            //int cantRegistros = objArch.contadorLineas("DatosEstudiantes.txt");
            while (i<=cantRegistros)//mientras no llegue hasta la última línea del archivo
            {
              cadena=cadena+"[ "+vecB[i].estructuraRegistro()+" ]\n";//se anexan cada registro a la cadena
              i++;
            }//fin mientras */
            objArch.cerrarModoLectura();
            
        } catch (Exception e)
        {
             System.out.println("***Archivo leído y cerrado correctamente*****");
        }
        return cadena;
    }//fin de método mostrar 
  
  public String EliminarRegistro(Archivo objArchivos, int idEstudiante) 
  {
        try 
        {
            objArchivos.abrirModoLectura("DatosBoletin.txt");
            Boletin[] todos = objArchivos.leerBoletin();
            objArchivos.cerrarModoLectura();

            if (todos == null || todos.length == 0) 
            {
                return "No hay Boletin registrados para el estudiante.";
            }

            // 2. Contar Estudiante que NO coinciden con el ID a eliminar
            int contador = 0;
            String eliminado = "";
            for (Boletin b : todos) 
            {
                if (b != null && (b.getIdEstudiante() != idEstudiante)) 
                {
                    contador++;
                } else if (b != null) 
                {
                    eliminado = b.estructuraRegistro();
                }
            }

            // 3. Si no se encontró el cliente
            if (eliminado.isEmpty()) 
            {
                return "Boletin no encontrado.";
            }

            // 4. Crear nuevo array sin el cliente eliminado
            Boletin[] nuevos = new Boletin[contador];
            int index = 0;
            for (Boletin b : todos) 
            {
                if (b != null && (b.getIdEstudiante()!= idEstudiante)) 
                {
                    nuevos[index] = b;
                    index++;
                }
            }

            // 5. Regenerar archivo
            objArchivos.eliminaArchivo("DatosBoletin.txt");
            for (Boletin b : nuevos) 
            {
                if (b != null) 
                {
                    grabar(objArchivos, b);
                }
            }

            return "Eliminado: " + eliminado;

        } catch (Exception e) 
           {
            return "Error al eliminar: " + e.getMessage();
           }
    }
   
     
    
}
