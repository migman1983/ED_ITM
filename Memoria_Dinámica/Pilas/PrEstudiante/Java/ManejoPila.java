package pr_pilaestudiante;

import java.util.Scanner;

public class ManejoPila {
    public Pila ingresarPila(Pila objPila, Scanner sc) {
        System.out.print("¿Desea ingresar un estudiante? 1. Si  2. No: ");
        int op = Integer.parseInt(sc.nextLine());

        while (op == 1) {
            System.out.print("Ingrese el código del nuevo estudiante: ");
            int cod = Integer.parseInt(sc.nextLine());

            if (!buscar(objPila, cod)) {
                Estudiante estudiante = new Estudiante();
                objPila.push(estudiante.leerDatos(cod, sc));
                System.out.println("Estudiante agregado correctamente.");
            } else {
                System.out.println("Estudiante ya existe en la pila.");
            }

            System.out.print("¿Desea ingresar otro estudiante? 1. Si  2. No: ");
            op = Integer.parseInt(sc.nextLine());
        }

        return objPila;
    }

    public String imprimir(Pila objPila) {
        Pila aux = new Pila(objPila.obtenerMaxsize());
        StringBuilder texto = new StringBuilder();

        while (!objPila.isEmpty()) {
            Estudiante info = (Estudiante) objPila.pop();
            texto.append(info).append(System.lineSeparator());
            aux.push(info);
        }

        restaurar(objPila, aux);
        return texto.length() == 0 ? "La pila está vacía" : texto.toString();
    }

    private void restaurar(Pila pila, Pila aux) {
        while (!aux.isEmpty()) {
            pila.push(aux.pop());
        }
    }

    public boolean buscar(Pila objPila, int cod) {
        Pila aux = new Pila(objPila.obtenerMaxsize());
        boolean encontrado = false;

        while (!objPila.isEmpty()) {
            Estudiante estudiante = (Estudiante) objPila.pop();
            if (estudiante.obtenerCodigo() == cod) {
                encontrado = true;
            }
            aux.push(estudiante);
        }

        restaurar(objPila, aux);
        return encontrado;
    }

    public Estudiante eliminar(Pila objPila, int cod) {
        Pila aux = new Pila(objPila.obtenerMaxsize());
        Estudiante eliminado = null;

        while (!objPila.isEmpty()) {
            Estudiante estudiante = (Estudiante) objPila.pop();

            if (estudiante.obtenerCodigo() == cod) {
                eliminado = estudiante;
            } else {
                aux.push(estudiante);
            }
        }

        restaurar(objPila, aux);
        return eliminado;
    }

    public Estudiante consultar(Pila objPila, int cod) {
        Pila aux = new Pila(objPila.obtenerMaxsize());
        Estudiante encontrado = null;

        while (!objPila.isEmpty()) {
            Estudiante estudiante = (Estudiante) objPila.pop();

            if (estudiante.obtenerCodigo() == cod) {
                encontrado = estudiante;
            }

            aux.push(estudiante);
        }

        restaurar(objPila, aux);
        return encontrado;
    }

    public void actualizarNotaDef(Pila objPila, int cod, Scanner sc) {
        Pila aux = new Pila(objPila.obtenerMaxsize());
        boolean encontrado = false;

        while (!objPila.isEmpty()) {
            Estudiante estudiante = (Estudiante) objPila.pop();

            if (estudiante.obtenerCodigo() == cod) {
                encontrado = true;
                System.out.print("Ingrese la nueva nota definitiva: ");
                double nota = Double.parseDouble(sc.nextLine());
                estudiante.asignarNotaDef(nota);
                System.out.println("La nota fue actualizada exitosamente.");
            }

            aux.push(estudiante);
        }

        restaurar(objPila, aux);

        if (!encontrado) {
            System.out.println("El código del estudiante no existe en la pila.");
        }
    }
}
