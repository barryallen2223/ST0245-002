import java.util.ArrayList;
import java.util.Scanner;
import java.io.File;
import java.util.ArrayList;
import java.util.Scanner;
import java.io.File;
import java.io.FileNotFoundException;
import java.util.LinkedList;

public class Coords
{
    LinkedList<String> lista = new LinkedList();
    public LinkedList readFile(String nombreArchivo) throws FileNotFoundException
    {
        String almacenador, almacenador_semicolon, s_util;
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
            
            lista.add(almacenador_semicolon);
            
            cont++;
        }
        System.out.println("Se han cargado exitosamente " + cont + " datos!");
        return lista;
    }
    public static void main(String args[]) throws FileNotFoundException{
        Coords c = new Coords();
        LinkedList<String> lista = 
        c.readFile("C:/Users/user/Documents/EAFIT/Semestre 2/Estructuras Datos y Algoritmos 1/medellin_colombia-grande.txt");
        for(int i = 0 ; i < 10 ; i++){
            System.out.println(lista.get(i));
        }
    }
}
