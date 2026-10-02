
package pr_pilaestudiante;

import java.util.Scanner;


public class PilaEstudiante {

  
    public static void main(String[] args)
    {
       Scanner sc = new Scanner(System.in);
        Pila pila = new Pila(10);
        ManejoPila manejo = new ManejoPila();
        int opcion;

        do {
            System.out.println();
            System.out.println("========================================");
            System.out.println("       GESTIÓN DE PILA ESTUDIANTE       ");
            System.out.println("========================================");
            System.out.println("1. Ingresar estudiante");
            System.out.println("2. Mostrar estudiantes");
            System.out.println("3. Consultar estudiante");
            System.out.println("4. Buscar estudiante");
            System.out.println("5. Eliminar estudiante");
            System.out.println("6. Actualizar nota definitiva");
            System.out.println("7. Ver elemento en el tope");
            System.out.println("8. Retirar elemento de la pila");
            System.out.println("9. Mostrar estado de la pila");
            System.out.println("0. Salir");
            System.out.print("Seleccione una opción: ");

            opcion = Integer.parseInt(sc.nextLine());

            switch (opcion) {
                case 1:
                    pila = manejo.ingresarPila(pila, sc);
                    break;
                case 2:
                    System.out.println("ESTUDIANTES EN LA PILA");
                    System.out.println("-----------------------");
                    System.out.println(manejo.imprimir(pila));
                    break;
                case 3:
                    System.out.print("Ingrese el código del estudiante a consultar: ");
                    int codigoConsulta = Integer.parseInt(sc.nextLine());
                    Estudiante resultadoConsulta = manejo.consultar(pila, codigoConsulta);

                    if (resultadoConsulta == null) {
                        System.out.println("El estudiante no existe en la pila.");
                    } else {
                        System.out.println("Estudiante encontrado:");
                        System.out.println(resultadoConsulta);
                    }
                    break;
                case 4:
                    System.out.print("Ingrese el código del estudiante a buscar: ");
                    int codigoBuscar = Integer.parseInt(sc.nextLine());

                    if (manejo.buscar(pila, codigoBuscar)) {
                        System.out.println("El estudiante existe en la pila.");
                    } else {
                        System.out.println("El estudiante NO existe en la pila.");
                    }
                    break;
                case 5:
                    System.out.print("Ingrese el código del estudiante a eliminar: ");
                    int codigoEliminar = Integer.parseInt(sc.nextLine());
                    Estudiante eliminado = manejo.eliminar(pila, codigoEliminar);

                    if (eliminado == null) {
                        System.out.println("No se encontró el estudiante.");
                    } else {
                        System.out.println("Estudiante eliminado:");
                        System.out.println(eliminado);
                    }
                    break;
                case 6:
                    System.out.print("Ingrese el código del estudiante: ");
                    int codigoActualizar = Integer.parseInt(sc.nextLine());
                    manejo.actualizarNotaDef(pila, codigoActualizar, sc);
                    break;
                case 7:
                    if (pila.isEmpty()) {
                        System.out.println("La pila está vacía.");
                    } else {
                        System.out.println("Elemento en el tope:");
                        System.out.println(pila.peek());
                    }
                    break;
                case 8:
                    if (pila.isEmpty()) {
                        System.out.println("La pila está vacía.");
                    } else {
                        System.out.println("Elemento retirado:");
                        System.out.println(pila.pop());
                    }
                    break;
                case 9:
                    System.out.println("ESTADO DE LA PILA");
                    System.out.println("-----------------");
                    System.out.println("Capacidad máxima: " + pila.obtenerMaxsize());
                    System.out.println("Cantidad de elementos: " + pila.obtenerSize());

                    if (pila.isEmpty()) {
                        System.out.println("Estado: VACÍA");
                    } else if (pila.isFull()) {
                        System.out.println("Estado: LLENA");
                    } else {
                        System.out.println("Estado: DISPONIBLE");
                    }
                    break;
                case 0:
                    System.out.println("Programa finalizado.");
                    break;
                default:
                    System.out.println("Opción no válida.");
            }
        } while (opcion != 0);
        sc.close();
    }  
        
    }
    

