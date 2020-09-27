import java.util.ArrayList;
import java.util.Scanner;
import java.io.File;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Scanner;
import java.io.File;
import java.io.FileNotFoundException;
import java.util.LinkedList;

public class Coords
{
    LinkedList<String[]> lista = new LinkedList();
    public LinkedList readFile(String nombreArchivo) throws FileNotFoundException
    {
        String almacenador, almacenador_semicolon;
        String[] s_util;
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
            
            s_util = almacenador_semicolon.split(" ");
            
            // Leo el nuevo string más fácil
            Scanner sc_new = new Scanner(almacenador_semicolon);
            
            lista.add(s_util);
            
            cont++;
        }
        System.out.println("Se han cargado exitosamente " + cont + " datos!");
        return lista;
    }
    public static void main(String args[]) throws FileNotFoundException{
        Scanner sc = new Scanner(System.in);
        System.out.print("Ingrese la ruta del archivo seguido de su extension");
        String ruta = sc.next();
        Coords c = new Coords();
        LinkedList<String[]> lista = c.readFile(ruta);
        for(int i = 0 ; i < lista.size() ; i++){
            for(int j = 0 ; j < lista.get(i).length ; j++ ){
                System.out.print(lista.get(i)[j]);
            }
            System.out.print("\n");
        }
    }
    
}
