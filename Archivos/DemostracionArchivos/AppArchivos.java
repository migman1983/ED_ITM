
package prejemploarchivos;

public class AppArchivos {


    public static void main(String[] args) 
    {
        Demostracion d = new Demostracion();
        System.out.println("************** BufferedWriter ***************");
        d.escribirConBufferedWriter("Documento.txt");
        d.leerConBufferedReader("Documento.txt");
        System.out.println("************** FileWriter ***************");
        d.escribirArchivoConFileWriter();
        d.leerArchivoConFileReader();
        
        System.out.println("************** printWriter ***************");
        d.escribirPrintWriterSinBuffered(15);
        d.escribirPrintWriterConBuffered();
        
        System.out.println("************** Prueba Eficiencia BufferedWriter ***************");
        d.comparacionEficienciaWriter();
        
        System.out.println("************** Prueba Eficiencia BufferedReader ***************");
        d.comparacionEficienciaReader();
    }
    
}
