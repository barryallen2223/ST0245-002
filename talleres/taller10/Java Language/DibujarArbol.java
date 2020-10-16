import java.util.Arrays;
import java.util.SortedSet;
import java.util.TreeSet;

public class DibujarArbol
{
    public static void main(String args[]){
        Integer[] nums = {1,2,3,4,5,6,7,8,9};
        SortedSet<Integer> arbolito = new TreeSet<>(Arrays.asList(nums));

        generarViz(arbolito);
    }

    public static void imprimirArbolito(SortedSet<Integer> arbolito){
        for (int i: arbolito){
            System.out.println(i);
        }
        System.out.println();
    }

    public static void generarViz(SortedSet<Integer> arbolito){
        System.out.println("digraph \"Arbolito\" {");
        for (int i: arbolito){
            System.out.print("\t \"" + i + "\"");
            System.out.println(" -> " + "\"" + (i+1) + "\"");
        }
        System.out.print("}");
    }
}