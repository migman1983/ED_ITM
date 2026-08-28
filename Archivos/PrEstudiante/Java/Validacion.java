
package estudiante;

import java.util.Scanner;

public class Validacion 
{
     public static int leerEntero(String mensaje) // me permite validar el idCliente 
	{
             Scanner sc = new Scanner (System.in);
		int num = 0;
                do{
		try
		{
	      	   System.out.println(mensaje);
                   num = sc.nextInt();
                   if(num<=0)
                     System.out.println("ERROR, el Numero debe ser mayor que cero");
                 }
		catch (Exception e)
		{
		  System.out.println("ERROR:"+ e);
		}
                 }while(num<=0);
		return num;
	}
       
        public static String leerTitulo(String mensaje)
        {
          Scanner sc = new Scanner (System.in);
		int p  = 0;
                String programa ="";
                do{
	         try
		  {
	      	   System.out.println(mensaje);
                   p = sc.nextInt();
                   switch(p)
                    {
                      case 1:
                       programa = "especialista";
                       break;
                      case 2:
                       programa = "magister";
                       break;
                      case 3:
                       programa = "doctor";
                       break;
                   }  
                   if((p<1)||(p>3))
                     System.out.println("ERROR, opción no valida");
                 }
		catch (Exception e)
		{
		  System.out.println("ERROR:"+ e);
		}
                 }while((p<1)||(p>3));
		return programa;  
        }      
        
        public static String leerTipoPrograma(String mensaje)
        {
          Scanner sc = new Scanner (System.in);
		int t  = 0;
                String titulo ="";
                do{
	         try
		  {
	      	   System.out.println(mensaje);
                   t = sc.nextInt();
                   switch(t)
                    {
                      case 1:
                       titulo = "remoto";
                       break;
                      case 2:
                       titulo = "virtual";
                       break;
                      case 3:
                       titulo = "presencial";
                       break;
                   }  
                   if((t<1)||(t>3))
                     System.out.println("ERROR, opción no valida");
                 }
		catch (Exception e)
		{
		  System.out.println("ERROR:"+ e);
		}
                 }while((t<1)||(t>3));
		return titulo;  
        }   
        public static int leerCreditos(String mensaje)
        {
          Scanner sc = new Scanner (System.in);
		int num = 0;
                do{
		try
		{
	      	   System.out.println(mensaje);
                   num = sc.nextInt();
                   if((num<2)||(num>5))
                     System.out.println("ERROR, los creditos deben estar entre 2 y 5");
                 }
		catch (Exception e)
		{
		  System.out.println("ERROR:"+ e);
		}
                 }while((num<2)||(num>5));
		return num;  
        }      
        
        
        public static int leerExperienciaDocente(String mensaje)
        {
          Scanner sc = new Scanner (System.in);
		int num = 0;
                do{
		try
		{
	      	   System.out.println(mensaje);
                   num = sc.nextInt();
                   if((num<20)||(num>5))
                     System.out.println("ERROR, la edad debe estar entre 18 y 100");
                 }
		catch (Exception e)
		{
		  System.out.println("ERROR:"+ e);
		}
                 }while((num<20)||(num>5));
		return num;  
        }      
        
        public static int leerEdadDocente(String mensaje)
        {
          Scanner sc = new Scanner (System.in);
		int num = 0;
                do{
		try
		{
	      	   System.out.println(mensaje);
                   num = sc.nextInt();
                   if(num<38)
                     System.out.println("ERROR, la edad debe ser mayor a 30");
                 }
		catch (Exception e)
		{
		  System.out.println("ERROR:"+ e);
		}
                 }while(num<30);
		return num;  
        }      
        
        public static String leerString(String mensaje)
	{
	  String cadena= "";
          Scanner sc = new Scanner (System.in);
          do
          {
	   try
	    {
              System.out.println(mensaje);
              cadena = sc.nextLine();
	       if(cadena.equals(""))
                  System.out.println("ERROR: debe ingresar informacion");
            }
	    catch (Exception e)
	      {
		System.out.println("ERROR: " + e);
	      }
           }while(cadena.equals(""));
	 return cadena;
	}
    
        public static int leerEstrato(String mensaje)
	{
          Scanner sc = new Scanner(System.in);
	  int num = 0;
           do
           {
	    try
	     {
              System.out.println(mensaje);
              num = sc.nextInt();
	      if(num<=0||num>=7)
                System.out.println("ERROR, el Numero ingresado no pertenece a un estrato");
             }
	     catch (Exception e)
	      {
               System.out.println("ERROR - OJO  " );
	      }
           }while(num<=0||num>=7);
	 return num;
        }
       public static double leerNota(String mensaje)
	{ 
          Scanner sc = new Scanner(System.in);
	  double num = 0;
           do
           {
	    try
	     {
              System.out.println(mensaje);
              num = sc.nextInt();
	      if(num<0||num>5)
                System.out.println("ERROR, el valor ingresado esta fuera del rango de una nota");
             }
	     catch (Exception e)
	      {
               System.out.println("ERROR - OJO  " );
	      }
           }while(num<0||num>5);
	 return num;
        }  
}
        
