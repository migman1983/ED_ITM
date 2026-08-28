package estudiante;
import java.util.Scanner;
import static estudiante.Validacion.*;


public class Boletin 
{
  private int idCurso, idEstudiante, idDocente;
  private double notaFinal; 

    public Boletin() 
    {
    }

    public Boletin(int idCurso, int idEstudiante, int idDocente, double notaFinal)
    {
      this.idCurso = idCurso;
      this.idEstudiante = idEstudiante;
      this.idDocente = idDocente;
      this.notaFinal = notaFinal;
    }
    public Boletin ingresarDatos(int idEstudiante, int idDocente, int idCurso)
    {
      notaFinal = leerNota("Ingrese la nota final del estudiante: ");  
      return new Boletin(idCurso, idEstudiante,idDocente,notaFinal);
    }
    
    public int getIdCurso() 
    {
        return idCurso;
    }

    public void setIdCurso(int idCurso) 
    {
        this.idCurso = idCurso;
    }

    public int getIdEstudiante() 
    {
        return idEstudiante;
    }

    public void setIdEstudiante(int idEstudiante) 
    {
        this.idEstudiante = idEstudiante;
    }

    public int getIdDocente() 
    {
        return idDocente;
    }

    public void setIdDocente(int idDocente) 
    {
        this.idDocente = idDocente;
    }

    public double getNotaFinal() 
    {
        return notaFinal;
    }

    public void setNotaFinal(double notaFinal) 
    {
        this.notaFinal = notaFinal;
    }
    
  
    public String estructuraRegistro() 
    {
     return idCurso+"|"+idEstudiante+"|"+idDocente+"|"+"|"+notaFinal;
    }
}
