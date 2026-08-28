
package estudiante;

import static estudiante.Validacion.*;

public class Curso 
{
  private String nombre, programa;
  private int idCurso,creditos;
  private String tipo;
  public Curso()
  {
      
  }

  public Curso(int idCurso, String nombre, String programa, String tipo, int creditos) 
  {
    this.idCurso = idCurso;
    this.nombre = nombre;
    this.programa = programa;
    this.tipo = tipo;
    this.creditos = creditos;
  }
  
  public Curso ingresarDatos(int idCurso)
  {
    nombre = leerString("Ingrese el nombre del curso: ");
    programa = leerString("Ingrese el nombre del programa");
    creditos = leerCreditos("Ingrese el numero de créditos: ");
    tipo = leerTipoPrograma("Seleccione el Tipo de Porgrama: 1. remoto / 2. virtual / 3. presencial");
    return new Curso(idCurso, nombre, programa,tipo,creditos);
  }

    public int getIdCurso() {
        return idCurso;
    }

    public void setIdCurso(int idCurso) {
        this.idCurso = idCurso;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getPrograma() {
        return programa;
    }

    public void setPrograma(String programa) {
        this.programa = programa;
    }

    public String getTipo() {
        return tipo;
    }

    public void setTipo(String tipo) {
        this.tipo = tipo;
    }

    public int getCreditos() {
        return creditos;
    }

    public void setCreditos(int creditos) {
        this.creditos = creditos;
    }
  
  
   @Override
    public String toString() 
    {
     return idCurso+"|"+nombre+"|"+creditos;
    }
    
  
}
