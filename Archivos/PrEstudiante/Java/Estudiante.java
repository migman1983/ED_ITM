
package estudiante;
import java.util.Scanner;
import static estudiante.Validacion.*;

public class Estudiante 
{
  private int idEstudiante, estrato;
  private String nombre, apellido;
  private int edad;

  // métodos contructores
  public Estudiante()
  {
      
  }       
 
    // sobrecarga del constructor
   public Estudiante(int idEstudiante, String nombre, String apellido,int estrato, int edad)
   {
    this.idEstudiante = idEstudiante;
    this.estrato = estrato;
    this.nombre = nombre;
    this.apellido = apellido;
    this.edad = edad;

   }       
    
  public Estudiante datosEstudiante(int idEstudiante)
  {       
    Scanner sc = new Scanner(System.in);  
    System.out.println("******************** DATOS ESTUDIANTE *********************");
    nombre = leerString("ingrese el nombre");
    apellido = leerString("ingrese apellido: ");
    edad = leerEntero("ingrese edad: ");
    estrato = leerEstrato("ingrese estrato: ");
    Estudiante est = new Estudiante(idEstudiante,nombre,apellido, edad,estrato);
    return est;
  }  
    public int getIdEstudiante() {
        return idEstudiante;
    }

    public void setIdEstudiante(int idEstudiante) {
        this.idEstudiante = idEstudiante;
    }
    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }
    public String getApellido() {
        return apellido;
    }

    public void setApellido(String apellido) {
        this.apellido = apellido;
    }
    public int getEdad() {
        return edad;
    }

    public void setEdad(int edad) {
        this.edad = edad;
    }
    public int getEstrato() {
        return estrato;
    }

    public void setEstrato(int estrato) {
        this.estrato = estrato;
    }

  public String estructuraRegistro()
  {   
    return + idEstudiante +"|"+ nombre +"|"+ apellido +"|"+ edad + "|"+ estrato;
  }
}
