

package estudiante;
import java.util.Scanner;
import static estudiante.Validacion.*;

public class AppEstudiante 
{
    static Archivo objArchivo = new Archivo();
    static CRUDEstudiante crudE = new CRUDEstudiante();
    static CRUDDocente crudD = new CRUDDocente();
    static CRUDCurso crudC = new CRUDCurso();
    static CRUDBoletin crudB = new CRUDBoletin();
    public static void main(String[] args)
    {
        Menu m = new Menu();
        int op;
        System.out.println(menuPrincipal());
        op = leerEntero("Seleccione una opción: ");
        do
        {
         switch(op)
         {
            case 1: 
                m.menuArchivoEstudiante(); 
                break;
            case 2:
                m.menuArchivoDocente(); 
                break;
            case 3:
                m.menuArchivoCurso(); 
                break;
            case 4:
                m.menuArchivoBoletin(); 
                break;
            default:
                System.out.println("Opcion no encontrada");
         }        
        }while(op<5);
   
    }
    
    public static String menuPrincipal() 
    {
        return (" **** MENU Principal ****\n"
                + "1. Menu Estudiannte\n"
                + "2. Menu Docente\n"
                + "3. Menu Curso\n"
                + "4. Menu Boletin\n"
                + "5. Salir\n");

    }
    public static String menuArchivoE() 
    {
        return (" **** MENU ARCHIVO Estudiante ****\n"
                + "1. Ingresar Estudiannte\n"
                + "2. Imprimir todo el Archivo\n"
                + "3. Consultar Estudiante\n"
                + "4. Eliminar un Estudiante\n"
                + "5. actualizar un Estudiante\n"
                + "6. Cambiar nombre al archivo\n"
                + "7. Eliminar un archivo\n"
                + "8. Finalizar Menu\n");

    }
    
    public static String menuArchivoD() 
    {
            return (" **** MENU ARCHIVO Docente ****\n"
                + "1. Ingresar Docente\n"
                + "2. Imprimir todo el Archivo\n"
                + "3. Consultar Docente\n"
                + "4. Eliminar un Docente\n"
                + "5. actualizar un Docente\n"
                + "6. Cambiar nombre al archivo\n"
                + "7. Eliminar un archivo\n"
                + "8. Finalizar Menu\n");
    }
    
    public static String menuArchivoC() 
    {
      return (" **** MENU ARCHIVO Curso ****\n"
                + "1. Ingresar Curso\n"
                + "2. Imprimir todo el Archivo\n"
                + "3. Consultar Curso\n"
                + "4. Eliminar un Curso\n"
                + "5. actualizar un Curso\n"
                + "6. Cambiar nombre al archivo\n"
                + "7. Eliminar un archivo\n"
                + "8. Finalizar Menu\n");

    }  
        public static String menuArchivoB() 
    {
      return (" **** MENU ARCHIVO Boletin ****\n"
                + "1. Ingresar Boletin\n"
                + "2. Imprimir todo el Archivo\n"
                + "3. Consultar Boletin\n"
                + "4. Eliminar un Boletin\n"
                + "5. actualizar un Boletin\n"
                + "6. Cambiar nombre al archivo\n"
                + "7. Eliminar un archivo\n"
                + "8. Finalizar Menu\n");

    }  
   
}