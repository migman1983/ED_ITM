
package prejemploarchivos;

import java.io.FileWriter;
import java.io.FileReader;
import java.io.PrintWriter;
import java.io.BufferedWriter;
import java.io.BufferedReader;
import java.io.IOException;


public class Demostracion 
{
    
    /*
    El printWriter se utiliza para proporcionar una forma conveniente de escribir caracteres, cadenas de texto 
    y otros tipos de datos en un archivo.
    Adecuado para escrituras frecuentes y grandes volúmenes de datos, así como para escribir diferentes 
    tipos de datos (enteros, booleanos, etc.).
    */
   public void escribirPrintWriterSinBuffered(int numRegistros) 
    {
      try (PrintWriter pw = new PrintWriter(new FileWriter("print_sin_buffered.txt"))) 
        {
           for (int i = 0; i < numRegistros; i++) 
            {
                pw.println("Registro " + i + ": Datos del registro");
            }
        } catch (IOException e) 
           {
            e.printStackTrace();
           }
    }

    public void escribirPrintWriterConBuffered() 
     {
       try 
        {
          // Crear FileWriter y BufferedWriter
          FileWriter fileWriter = new FileWriter("archivo.txt");
          BufferedWriter bufferedWriter = new BufferedWriter(fileWriter);

          // Crear PrintWriter utilizando BufferedWriter
          PrintWriter printWriter = new PrintWriter(bufferedWriter);

          // Escribir en el archivo usando PrintWriter
          printWriter.println("Hola, mundo!");
          printWriter.println("Esto es un ejemplo de PrintWriter utilizando BufferedWriter.");

         // Cerrar PrintWriter (esto también cierra BufferedWriter y FileWriter)
          printWriter.close();
        }catch (IOException e) 
          {
            e.printStackTrace();
          }
     }

    public void usarMetodosPrintWriter(String archivo) 
    {
      try (PrintWriter pw = new PrintWriter(archivo)) 
       {
          // Método print(boolean b)
          pw.print(true);
          pw.print(" "); // Espacio para separar los valores

          // Método print(char c)
          pw.print('A');
          pw.print(" "); // Espacio para separar los valores

          // Método print(int i)
          pw.print(123);
          pw.print(" "); // Espacio para separar los valores

          // Método print(String s)
          pw.print("Hola");
          pw.print(" "); // Espacio para separar los valores

          // Método println(String s)
          pw.println("Mundo!");

          // Método printf(String format, Object... args)
          pw.printf("Formato: %s, Número: %d, Decimal: %.2f\n", "Texto", 42, 3.14159);

          // Método flush()
          pw.flush(); // Forzar la escritura de los datos en el archivo

          // Método close() - Se llama automáticamente al final del bloque try-with-resources
        }catch (IOException e) 
          {
            e.printStackTrace();
          }
      }
	
     public void escribirConBufferedWriter(String archivo) 
        {
        /* No es posible utilizar un BufferedWriter sin un Writer como parámetro.
           El BufferedWriter recibe un FileWriter como parámetro para combinar las capacidades de 
           ambos y mejorar la eficiencia de escritura en archivos. */
         try(BufferedWriter bw = new BufferedWriter(new FileWriter(archivo))) 
          {
            // Escribir una cadena completa
            bw.write("Hola, mundo!");
            bw.newLine();
              
            // Escribir una parte de un arreglo de caracteres
            char[] cbuf = "Esta es una nueva línea.".toCharArray();
            bw.write(cbuf, 0, cbuf.length);
            bw.newLine();

            // Escribir otra cadena y forzar la escritura
            bw.write("Forzando la escritura en el archivo.");
            bw.flush();
           }catch (IOException e) 
            {
             e.printStackTrace();
            }
        }
	
     public void leerConBufferedReader(String archivo) 
      {
        /*No es posible utilizar un BufferedReader sin un Reader como parámetro.   
        El BufferedReader recibe un FileReader como parámetro para aprovechar las capacidades de ambos 
        y mejorar la eficiencia de lectura de archivos.  */
        try (BufferedReader br = new BufferedReader(new FileReader(archivo)))
         {
            // Leer un solo carácter
            int c = br.read();
            System.out.println("Primer carácter: " + (char) c);

            // Leer una parte de un arreglo de caracteres
            char[] cbuf = new char[20];
            int numCharsRead = br.read(cbuf, 0, cbuf.length);
            System.out.println("Caracteres leídos: " + new String(cbuf, 0, numCharsRead));

            // Leer una línea completa
            String linea = br.readLine();
            System.out.println("Línea leída: " + linea);

            // Verificar si el flujo está listo para ser leído
            if (br.ready()) {
                System.out.println("El flujo está listo para ser leído.");
            }

            // Omitir caracteres
            br.skip(5);
            linea = br.readLine();
            System.out.println("Después de omitir 5 caracteres: " + linea);
         }catch (IOException e) 
           {
            e.printStackTrace();
           }
       }
    /* el bufferedWriter se utiliza para escribir caracteres en un buffer antes de escribirlos en un archivo.
       mientras que el fileWriter se utiliza para escribir caracteres directamente en un archivo.
     */
    public void escribirArchivoConFileWriter() 
    {
      try 
       {
          FileWriter writer = new FileWriter("archivo.txt");

          // Escribir un solo carácter
          writer.write('H');

          // Escribir un arreglo de caracteres
          char[] chars = {'o', 'l', 'a'};
          writer.write(chars);

          // Escribir una parte de un arreglo de caracteres
          writer.write(chars, 1, 2); // escribe "la"

          // Escribir una cadena de texto
          writer.write(" Mundo");

          // Escribir una parte de una cadena de texto
            writer.write(" Bienvenido", 1, 8); // escribe "ienvenid"

            // Limpiar el flujo de salida
            writer.flush();

            // Cerrar el FileWriter
            writer.close();
        }catch (IOException e)
          {
           e.printStackTrace();
          }
      }
	
    public void leerArchivoConFileReader() 
     {
       try
        {
          FileReader reader = new FileReader("archivo.txt");

          // Leer un solo carácter
           int charValue = reader.read();
            System.out.println("Carácter leído: " + (char) charValue);

            // Leer caracteres en un arreglo
            char[] chars = new char[5];
            int numCharsRead = reader.read(chars);
            System.out.println("Caracteres leídos: " + new String(chars, 0, numCharsRead));

            // Leer una parte de un arreglo de caracteres
            char[] partialChars = new char[10];
            int numPartialCharsRead = reader.read(partialChars, 2, 5);
            System.out.println("Caracteres parcialmente leídos: " + new String(partialChars, 2, numPartialCharsRead));

            // Cerrar el FileReader
            reader.close();
        }catch (IOException e) 
          {
            e.printStackTrace();  
          }
      }
    
 

    public void crearArchivoGrande(String fileName) 
     {
        try 
         {
          PrintWriter writer = new PrintWriter(new BufferedWriter(new FileWriter(fileName)));
          for (int i = 0; i < 1000000; i++) 
            {
             writer.println("Esta es una línea de texto número " + i);
            }
            writer.close();
            System.out.println("Archivo grande creado exitosamente.");
          }catch (IOException e) 
           {
            e.printStackTrace();
           }
      }

    public void medirTiempoFileReader(String fileName) 
     {
        try 
         {
           long startTime = System.nanoTime();
           FileReader fileReader = new FileReader(fileName);
           while (fileReader.read() != -1) {}
           fileReader.close();
           long endTime = System.nanoTime();
           long duration = endTime - startTime;
           System.out.println("Tiempo de lectura con FileReader: " + duration + " nanosegundos");
         } catch (IOException e) 
            {
             e.printStackTrace();
            }
       }

    public void medirTiempoBufferedReader(String fileName) 
     {
        try 
         {
            long startTime = System.nanoTime();
            BufferedReader bufferedReader = new BufferedReader(new FileReader(fileName));
            while (bufferedReader.read() != -1) {}
            bufferedReader.close();
            long endTime = System.nanoTime();
            long duration = endTime - startTime;
            System.out.println("Tiempo de lectura con BufferedReader: " + duration + " nanosegundos");
         }catch (IOException e) 
           {
             e.printStackTrace();
           }
      }
    
        public void comparacionEficienciaReader() 
    {
        // Crear un archivo grande de texto
        crearArchivoGrande("archivo_grande.txt");

        // Medir el tiempo de lectura con FileReader
        medirTiempoFileReader("archivo_grande.txt");

        // Medir el tiempo de lectura con BufferedReader
        medirTiempoBufferedReader("archivo_grande.txt");
    }


    public void medirTiempoFileWriter(String fileName) 
    {
        try 
        {
          long startTime = System.nanoTime();
          FileWriter fileWriter = new FileWriter("filewriter_output.txt");
          for (int i = 0; i < 1000000; i++)
           {
            fileWriter.write("Esta es una línea de texto número " + i + "\n");
           }
           fileWriter.close();
           long endTime = System.nanoTime();
           long duration = endTime - startTime;
           System.out.println("Tiempo de escritura con FileWriter: " + duration + " nanosegundos");
         }catch (IOException e) 
           {
            e.printStackTrace();
           }
    }

    public void medirTiempoBufferedWriter(String fileName)
     {
        try 
        {
            long startTime = System.nanoTime();
            BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter("bufferedwriter_output.txt"));
            for (int i = 0; i < 1000000; i++) 
            {
              bufferedWriter.write("Esta es una línea de texto número " + i + "\n");
            }
            bufferedWriter.close();
            long endTime = System.nanoTime();
            long duration = endTime - startTime;
            System.out.println("Tiempo de escritura con BufferedWriter: " + duration + " nanosegundos");
        } catch (IOException e) 
           {
            e.printStackTrace();
           }
    }

    public void medirTiempoPrintWriter(String fileName) 
    {
        try 
        {
            long startTime = System.nanoTime();
            PrintWriter printWriter = new PrintWriter(/*new BufferedWriter(new FileWriter(*/"printwriter_output.txt")/*))*/;
            for (int i = 0; i < 1000000; i++) 
              {
                printWriter.println("Esta es una línea de texto número " + i);
              }
            printWriter.close();
            long endTime = System.nanoTime();
            long duration = endTime - startTime;
            System.out.println("Tiempo de escritura con PrintWriter: " + duration + " nanosegundos");
         } catch (IOException e) 
            {
             e.printStackTrace();
            }
    }
    
    public void comparacionEficienciaWriter()
    {
        // Crear un archivo grande de texto
        crearArchivoGrande("archivo_grande.txt");

        // Medir el tiempo de escritura con FileWriter
        medirTiempoFileWriter("archivo_grande.txt");

        // Medir el tiempo de escritura con BufferedWriter
        medirTiempoBufferedWriter("archivo_grande.txt");

        // Medir el tiempo de escritura con PrintWriter
        medirTiempoPrintWriter("archivo_grande.txt");
    }

}  


   


   
	

