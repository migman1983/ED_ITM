package pr_pilaestudiante;

import java.util.Scanner;

public class Estudiante {
    private String nombre;
    private int edad;
    private int codigo;
    private String genero;
    private double notaDef;

    public Estudiante() {}

    public Estudiante(int codigo, String nombre, int edad, String genero, double notaDef) {
        this.codigo = codigo;
        this.nombre = nombre;
        this.edad = edad;
        this.genero = genero;
        this.notaDef = notaDef;
    }

    public Estudiante leerDatos(int codigo, Scanner sc) {
        System.out.print("Ingrese nombre de estudiante: ");
        nombre = sc.nextLine();
        System.out.print("Ingrese genero de estudiante: ");
        genero = sc.nextLine();
        System.out.print("Ingrese edad de estudiante: ");
        edad = Integer.parseInt(sc.nextLine());
        System.out.print("Ingrese nota definitiva de estudiante: ");
        notaDef = Double.parseDouble(sc.nextLine());
        return new Estudiante(codigo, nombre, edad, genero, notaDef);
    }

    public int obtenerCodigo() { return codigo; }
    public void asignarCodigo(int codigo) { this.codigo = codigo; }
    public String obtenerNombre() { return nombre; }
    public void asignarNombre(String nombre) { this.nombre = nombre; }
    public int obtenerEdad() { return edad; }
    public void asignarEdad(int edad) { this.edad = edad; }
    public String obtenerGenero() { return genero; }
    public void asignarGenero(String genero) { this.genero = genero; }
    public double obtenerNotaDef() { return notaDef; }
    public void asignarNotaDef(double notaDef) { this.notaDef = notaDef; }

    @Override
    public String toString() {
        return "Estudiante{codigo=" + codigo + ", nombre='" + nombre +
               "', edad=" + edad + ", genero='" + genero +
               "', notaDef=" + notaDef + "}";
    }
}
