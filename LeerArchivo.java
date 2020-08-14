import java.util.ArrayList;
import java.util.Scanner;
import java.io.File;
import java.io.FileNotFoundException;

public class LeerArchivo
{
    public void readFile(String nombreArchivo) throws FileNotFoundException
    {
        String almacenador, almacenador_semicolon, material;
        int cont = 0;
        File archivo = new File(nombreArchivo);
        Scanner sc = new Scanner(archivo);
        
        while(sc.hasNextLine())
        {
            // Almaceno la línea en un String
            almacenador = sc.nextLine();
            // Uso el String almacenado para reemplazar los ';' por espacios y así hacer más
            // fácil su lectura 
            almacenador_semicolon = almacenador.replace(";"," ");
            // Leo el nuevo string más fácil
            Scanner sc_new = new Scanner(almacenador_semicolon);
            
            /*fecha = sc_new.nextInt();
            hora = sc_new.nextInt();
            // Esto es para quitar lo que no me sirve
            sc_new.next();sc_new.next();sc_new.next();
            
            last = sc_new.nextDouble();
            nTrans = sc_new.nextInt();*/
            cont++;
        }
        System.out.println("Se han cargado exitosamente " + cont + " datos!");
    }
}
