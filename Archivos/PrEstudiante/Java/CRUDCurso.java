
package estudiante;

import static estudiante.Validacion.*;



public class CRUDCurso 
{
    public CRUDCurso() 
    {
     
    }
    
    public void IngresarCurso(Archivo objArchivo) 
    {   
       Curso objC = new Curso();
       int idCurso= leerEntero("Ingresar Codigo del curso: ");
       
        if(Buscar(objArchivo,idCurso) == false) 
         {//si no lo encuentra
            objC = objC.ingresarDatos(idCurso);//lee toda la informacion y recibe el objeto
            Grabar(objArchivo,objC);  //metodo que graba fisicamente el registro en memoria
         }
        else 
        {
            System.out.println("*****Curso YA existe en el archivo*****");
        }//Fin if 
    }//fin  de ingresar Estudiante
    
  public void Grabar(Archivo objArchivos, Curso objC ) 
    {
        objArchivos.abrirModoEscritura("DatosCursos.txt");
        objArchivos.escribir(objC.toString()); //se graba o escribe o imprime el registro fisicamente en el archivo
        objArchivos.cerrarModoEscritura();
     }//fin  Grabar Estudiante
  
  public boolean Buscar(Archivo objArch, int idCurso) //busca en un vector tipo Estudiante
    { 
        boolean sw=false;
        int cod;
        try 
        {
            Curso objC = new Curso();
            int tamaño = objArch.contadorLineas("DatosCurso.txt");
            objArch.abrirModoLectura("DatosCursos.txt");
            Curso vecC[] = new Curso[tamaño];
            vecC = objArch.leerCurso();//retorna el vector tipo objeto y se le asigna al vector definido en esta clase
            int i=0;
            int cantRegistros = objArch.contadorLineas("DatosCursos.txt");
            while (i<= cantRegistros) 
            {
               objC = vecC[i];
               cod = objC.getIdCurso();
               if(cod == idCurso)
                {
                    sw = true;
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
  
  
  public Curso Consultar(Archivo objArchivo, int codCurso) 
  {
    objArchivo.abrirModoLectura("DatosCursos.txt");
    Curso[] Curso = objArchivo.leerCurso();
    objArchivo.cerrarModoLectura();

    for (Curso c : Curso) 
     {
        if (c != null && c.getIdCurso() == codCurso) 
        {
            return c; // Devuelve el objeto Estudiante encontrado
        }
     }
    return null; // Si no existe
  }
  
  public void Actualizar(Archivo objArchivos, int idCurso)
   {
    String nombre, programa, tipo;
    int cod,creditos;
    objArchivos.abrirModoLectura("DatosCursos.txt");
    int op;
    if(objArchivos.archivo.exists()== true)
    {
     int cantLineas = objArchivos.contadorLineas("DatosCursos.txt");
     Curso vecC[] = new Curso[cantLineas];
     try
      {
       boolean sw = false;
       Curso objC = new Curso();
       vecC = objArchivos.leerCurso();//Almacenamos cada registro del archivo en un vector tipo hospital
       int i =0;
       while (i < cantLineas) 
        {
         objC = vecC[i]; 
         cod = objC.getIdCurso();
         nombre = objC.getNombre();
         programa= objC.getPrograma();
         tipo = objC.getTipo();
         creditos = objC.getCreditos();
         if(cod==idCurso)
         {
          sw = true;
          System.out.println("Se actualizará el registro del curso: "+idCurso);
          do
           {
            op = leerEntero(" 1. creditos █ 2. nombre █ 3. programa █ 4. tipo");
            switch(op)
             {
              case 1:
               creditos = leerCreditos("Ingrese la nueva cantidad de creditos del Curso: ");
               break;
              case 2:
               nombre = leerString("Ingrese el nuevo nombre del Curso: ");
               break;
              case 3:
               programa = leerString("Ingrese el nuevo programa al que pertenece el Curso: ");
               break;
              case 4:
               tipo = leerTipoPrograma("Ingrese el nuevo tipo: 1. remoto / 2. virtual / 3. presencial");
               break;
             }  
           }while(op<2);
           objC = new Curso(idCurso,nombre,programa, tipo,creditos);
           vecC[i]= objC;
           System.out.println(" registro actualizado"+ objC.toString());
          }
         else
         {
          vecC[i]= objC;
         }
         i++;
        }
       if(sw ==false)
        {
          System.out.println("El Curso No existe");
        }  
     objArchivos.cerrarModoLectura();
     }catch (Exception e)
      {
       System.out.println("***Archivo leido y cerrado correctamente*****");
       objArchivos.cerrarModoLectura();
      }
     grabarActualizacion(vecC, objArchivos);
    }
  else 
   {
    System.out.println("No existe un archivo para actualizar");
   }
 
  }
   
  public void grabarActualizacion(Curso[] vecC, Archivo objArchCopy) 
     {   
        Curso objC;
        objArchCopy.cerrarModoLectura(); // se cierra el archivo que se encuentra en modo lectura
        objArchCopy.eliminaArchivo("DatosCursos.txt"); // se elimina el archivo original
        objArchCopy.abrirModoEscritura("DatosCursos.txt");
        for(int i = 0; i<vecC.length;i++)
        {
         objC = vecC[i];
         String texto = "";
         texto = objC.toString();//con este metodo se da la estructura al registro
         objArchCopy.escribir(texto); //se graba o escribe o imprime el registro fisicamente en el archivo 
        }
        objArchCopy.cerrarModoEscritura();
    } 
  
  public String Mostrar(Archivo objArch) 
    { 
        String cadena=" ";//cadena para el almacenamiento de todos los registros
        Curso objC;
        //int tamaño;
        try {
             int cantRegistros = objArch.contadorLineas("DatosCursos.txt");
             //tamaño = objArch.contadorLineas("DatosEstudiantes.txt");
             Curso vecC[] = new Curso[cantRegistros];
             objArch.abrirModoLectura("DatosCursos.txt");
           
            vecC = objArch.leerCurso();//retorna el vector tipo objeto y se le asigna al definido en esta clase
            int i =0;
            //int cantRegistros = objArch.contadorLineas("DatosEstudiantes.txt");
            while (i<=cantRegistros)//mientras no llegue hasta la última línea del archivo
            {
              objC = vecC[i];
              cadena=cadena+"[ "+objC.toString()+" ]\n";//se anexan cada registro a la cadena
              i++;
            }//fin mientras */
            objArch.cerrarModoLectura();
            
        } catch (Exception e)
        {
             System.out.println("***Archivo leído y cerrado correctamente*****");
        }
        return cadena;
    }//fin de método mostrar 
  
  public String EliminarRegistro(Archivo objArchivos, int cod) 
  {
        try 
        {
            // 1. Leer todos los Estudiante
            objArchivos.abrirModoLectura("DatosCursos.txt");
            Curso[] todos = objArchivos.leerCurso();
            objArchivos.cerrarModoLectura();

            if (todos == null || todos.length == 0) 
            {
                return "No hay Estudiante registrados.";
            }

            // 2. Contar Estudiante que NO coinciden con el ID a eliminar
            int contador = 0;
            String eliminado = "";
            for (Curso c : todos) 
            {
                if (c != null && (c.getIdCurso()!=cod))
                {
                    contador++;
                } else if (c != null) 
                {
                    eliminado = c.toString();
                }
            }

            // 3. Si no se encontró el cliente
            if (eliminado.isEmpty()) 
            {
                return "Estudiante no encontrado.";
            }

            // 4. Crear nuevo array sin el cliente eliminado
            Curso[] nuevos = new Curso[contador];
            int index = 0;
            for (Curso c : todos) 
            {
                if (c != null && (c.getIdCurso()!= cod)) 
                {
                    nuevos[index] = c;
                    index++;
                }
            }

            // 5. Regenerar archivo
            objArchivos.eliminaArchivo("DatosCursos.txt");
            for (Curso c : nuevos) 
            {
                if (c != null) 
                {
                    Grabar(objArchivos, c);
                }
            }

            return "Eliminado: " + eliminado;

        } catch (Exception e) 
           {
            return "Error al eliminar: " + e.getMessage();
           }
    }
      
}
