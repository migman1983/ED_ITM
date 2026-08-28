
package estudiante;

import static estudiante.Validacion.*;


import java.util.Scanner;

public class Docente
{
  private String nombre, titulo;
  private int idDocente, edad, experiencia;
  public Docente()
  {
      
  }   

  public Docente(int idDocente, String nombre, String titulo, int experiencia, int edad) 
  {        
        this.idDocente = idDocente;
        this.nombre = nombre;
        this.titulo = titulo;
        this.experiencia = experiencia;
        this.edad = edad;
  }
  
  public Docente ingresarDatos(int idDocente)
  {
   Scanner sc = new Scanner(System.in);
   nombre = leerString("Ingresar nombre del docente: ");
   titulo = leerTitulo("Ingrese el título del docente 1. especialista / 2. magister / 3. doctor: ");
   edad = leerEdadDocente("Ingresar edad del docente");
   experiencia = leerExperienciaDocente("Ingrese la experiencia del docente: ");
   return new Docente(idDocente,nombre,titulo,experiencia,edad);
  }      
   
    public int getIdDocente() 
    {
        return idDocente;
    }

    public void setIdDocente(int idDocente) 
    {
        this.idDocente = idDocente;
    }

    public String getTitulo() 
    {
        return titulo;
    }

    public void setTitulo(String titulo) 
    {
        this.titulo = titulo;
    }

    public String getNombre() 
    {
        return nombre;
    }

    public void setNombre(String nombre) 
    {
        this.nombre = nombre;
    }

    public int getExperiencia() {
        return experiencia;
    }

    public void setExperiencia(int experiencia) {
        this.experiencia = experiencia;
    }

    public int getEdad() 
    {
        return edad;
    }

    public void setEdad(int edad) 
    {
        this.edad = edad;
    }

    @Override
    public String toString() 
    {
     return idDocente+"|"+nombre+"|"+titulo+"|"+edad+"|";
    }
    
  
  
  
  
}
