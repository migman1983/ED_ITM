
package rutaexpressvf;

import java.util.Scanner;


public class AppRutaExpress 
{

    public static void main(String[] args) 
    {
       Archivo arch = new Archivo();
       CRUDCliente crudC =  new CRUDCliente();
       Scanner sc = new Scanner(System.in);
       String cedula;
        System.out.println("ingrese la cedula del cliente: ");
        cedula = sc.next();
        crudC.ingresarRegistro(arch, cedula);
    }
    
}
