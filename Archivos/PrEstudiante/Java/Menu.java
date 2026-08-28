/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package estudiante;

import static estudiante.AppEstudiante.crudE;
import static estudiante.AppEstudiante.crudD;
import static estudiante.AppEstudiante.crudC;
import static estudiante.AppEstudiante.crudB;
import static estudiante.AppEstudiante.menuArchivoE;
import static estudiante.AppEstudiante.menuArchivoD;
import static estudiante.AppEstudiante.menuArchivoC;
import static estudiante.AppEstudiante.menuArchivoB;
import static estudiante.AppEstudiante.objArchivo;
import static estudiante.Validacion.leerEntero;
import java.util.Scanner;

/**
 *
 * @author miguelmanosalva
 */
public class Menu 
{
   public static void menuArchivoEstudiante() 
    {
        Scanner sc = new Scanner(System.in);
        int opE, idEstudiante;
        String nombreNuevo="";
        do {
            opE = leerEntero(menuArchivoE());
            switch (opE) {
                case 1:
                    System.out.println("*******************************************\n");
                    idEstudiante = leerEntero("Digite el ID del Estudiante a registrar: ");
                    crudE.IngresarEstudiante(objArchivo, idEstudiante);
                    break;
                case 2:
                    System.out.println("*******************************************\n");
                    System.out.println("Los Registros del Archivo Estudiante son: \n" + crudE.Mostrar(objArchivo));
                    break;
                case 3:
                    System.out.println("*******************************************\n");
                    idEstudiante = leerEntero("Digite el IDEstudiante del cliente a consultar: ");
                    System.out.println("El cliente consultado es:\n " + crudE.Consultar(objArchivo, idEstudiante).estructuraRegistro());
                    break;
                case 4: // Actualizar
                    idEstudiante = Validacion.leerEntero("ID a eliminar: ");
                    System.out.println(crudE.Eliminar(objArchivo, idEstudiante));
                    break;
                case 5: // Actualizar
                    idEstudiante = Validacion.leerEntero("ID a actualizar: ");
                    crudE.Actualizar(objArchivo, idEstudiante);
                    break;
                case 6:
                    System.out.println("*******************************************\n");
                    System.out.println("Ingrese el nuevo nombre del archivo: ");
                    nombreNuevo = sc.nextLine();
                    objArchivo.renombrarArchivo(nombreNuevo + ".txt");
                    break;
                case 7:
                   if(nombreNuevo.isEmpty())
                      objArchivo.eliminaArchivo("datosEstudiante.txt");
                    else 
                      objArchivo.eliminaArchivo(nombreNuevo);
                    break;
            }
        } while (opE < 7);

    } 
   
   public static void menuArchivoDocente() 
    {
        Scanner sc = new Scanner(System.in);
        int opE, idDocente;
        String nombreNuevo="";
        do {
            opE = leerEntero(menuArchivoD());
            switch (opE) {
                case 1:
                    System.out.println("*******************************************\n");
                    crudD.IngresarDocente(objArchivo);
                    break;
                case 2:
                    System.out.println("*******************************************\n");
                    System.out.println("Los Registros del Archivo Docente son: \n" + crudD.Mostrar(objArchivo));
                    break;
                case 3:
                    System.out.println("*******************************************\n");
                    idDocente = leerEntero("Digite el IDDocente del cliente a consultar: ");
                    System.out.println("El cliente consultado es:\n " + crudD.Consultar(objArchivo, idDocente).toString());
                    break;
                case 4: // Actualizar
                    idDocente = Validacion.leerEntero("ID a eliminar: ");
                    System.out.println(crudD.EliminarRegistro(objArchivo, idDocente));
                    break;
                case 5: // Actualizar
                    idDocente = Validacion.leerEntero("ID a actualizar: ");
                    crudD.Actualizar(objArchivo, idDocente);
                    break;
                case 6:
                    System.out.println("*******************************************\n");
                    System.out.println("Ingrese el nuevo nombre del archivo: ");
                    nombreNuevo = sc.nextLine();
                    objArchivo.renombrarArchivo(nombreNuevo + ".txt");
                    break;
                case 7:
                   if(nombreNuevo.isEmpty())
                      objArchivo.eliminaArchivo("datosDocente.txt");
                    else 
                      objArchivo.eliminaArchivo(nombreNuevo);
                    break;
            }
        } while (opE < 7);

    } 
      
   public static void menuArchivoCurso() 
    {
        Scanner sc = new Scanner(System.in);
        int opE, idCurso;
        String nombreNuevo="";
        do {
            opE = leerEntero(menuArchivoC());
            switch (opE) {
                case 1:
                    System.out.println("*******************************************\n");
                    crudC.IngresarCurso(objArchivo);
                    break;
                case 2:
                    System.out.println("*******************************************\n");
                    System.out.println("Los Registros del Archivo Curso son: \n" + crudC.Mostrar(objArchivo));
                    break;
                case 3:
                    System.out.println("*******************************************\n");
                    idCurso = leerEntero("Digite el IDCurso del ccurso a consultar: ");
                    System.out.println("El cliente consultado es:\n " + crudC.Consultar(objArchivo, idCurso).toString());
                    break;
                case 4: // Actualizar
                    idCurso = Validacion.leerEntero("ID a eliminar: ");
                    System.out.println(crudC.EliminarRegistro(objArchivo, idCurso));
                    break;
                case 5: // Actualizar
                    idCurso = Validacion.leerEntero("ID a actualizar: ");
                    crudC.Actualizar(objArchivo, idCurso);
                    break;
                case 6:
                    System.out.println("*******************************************\n");
                    System.out.println("Ingrese el nuevo nombre del archivo: ");
                    nombreNuevo = sc.nextLine();
                    objArchivo.renombrarArchivo(nombreNuevo + ".txt");
                    break;
                case 7:
                   if(nombreNuevo.isEmpty())
                      objArchivo.eliminaArchivo("datosCurso.txt");
                    else 
                      objArchivo.eliminaArchivo(nombreNuevo);
                    break;
            }
        } while (opE < 7);

    }    
     
   public static void menuArchivoBoletin() 
    {
        Scanner sc = new Scanner(System.in);
        int opE, idCurso, idEstudiante, idDocente;
        String nombreNuevo="";
        do {
            opE = leerEntero(menuArchivoB());
            switch (opE) {
                case 1:
                    System.out.println("*******************************************\n");
                    idEstudiante = leerEntero("Digite el ID del Estudiante a registrar: ");
                    idDocente = leerEntero("Digite el ID del Docente a registrar: ");
                    idCurso = leerEntero("Digite el ID del Curso a registrar: ");
                    crudB.ingresar(objArchivo, idEstudiante, idDocente, idCurso);
                    break;
                case 2:
                    System.out.println("*******************************************\n");
                    System.out.println("Los Registros del Archivo Curso son: \n" + crudB.Mostrar(objArchivo));
                    break;
                case 3:
                    System.out.println("*******************************************\n");
                    idCurso = leerEntero("Digite el IDCurso del cliente a consultar: ");
                    System.out.println("El cliente consultado es:\n " + crudB.Consultar(objArchivo, idCurso).toString());
                    break;
                case 4: // Actualizar
                    idCurso = Validacion.leerEntero("ID a eliminar: ");
                    System.out.println(crudB.EliminarRegistro(objArchivo, idCurso));
                    break;
                case 5: // Actualizar
                    idEstudiante = Validacion.leerEntero("ID de estudiante para actualizar su norta: ");
                    idCurso = Validacion.leerEntero("ID de curso para actualizar su nota: ");
                    crudB.ActualizarNota(objArchivo, idEstudiante, idCurso);
                    break;
                case 6:
                    System.out.println("*******************************************\n");
                    System.out.println("Ingrese el nuevo nombre del archivo: ");
                    nombreNuevo = sc.nextLine();
                    objArchivo.renombrarArchivo(nombreNuevo + ".txt");
                    break;
                case 7:
                   if(nombreNuevo.isEmpty())
                      objArchivo.eliminaArchivo("datosBoletin.txt");
                    else 
                      objArchivo.eliminaArchivo(nombreNuevo);
                    break;
            }
        } while (opE < 7);

    }      
    
}
