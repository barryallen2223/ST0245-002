import java.util.*;
//import javafx.util.*;

/**
 * Implementacion de un grafo dirigido usando listas de adyacencia
 *
 * @author Mauricio Toro, Mateo Agudelo, Simøn Alvarez, David Madrid
 */
public class DigraphAL extends Digraph {
    LinkedList<Pair<Integer, Integer>>[] normalArray;

    /**
     * Constructor para el grafo dirigido
     * @param vertices el numero de vertices que tendra el grafo dirigido
    *
    */
    public DigraphAL(int size) {
        super(size);
        normalArray = new LinkedList[size];
    }

    /**
    * Metodo para añadir un arco nuevo, donde se representa cada nodo con un entero
    * y se le asigna un peso a la longitud entre un nodo fuente y uno destino   
    * @param source desde donde se hara el arco
    * @param destination hacia donde va el arco
    * @param weight el peso de la longitud entre source y destination
    */
    public void addArc(int source, int destination, int weight) throws NullPointerException{
        if(source >= normalArray.length || destination >= normalArray.length)
            return;
        else if(normalArray.length == 0)
            return;
        else{
            if(normalArray[source] == null)
                normalArray[source] = new LinkedList();
            normalArray[source].add(Pair.makePair(destination, weight));
        }
        
    }

    /**
    * Metodo para obtener una lista de hijos desde un nodo, es decir todos los nodos
    * asociados al nodo pasado como argumento
    * @param vertex nodo al cual se le busca los asociados o hijos
    * @return todos los asociados o hijos del nodo vertex, listados en una ArrayList
    * Para más información de las clases:
    * @see <a href="https://docs.oracle.com/javase/8/docs/api/java/util/ArrayList.html"> Ver documentacion ArrayList </a>
    */
    public ArrayList<Integer> getSuccessors(int vertex) {
        ArrayList<Integer> success = new ArrayList<Integer>();
        
        if(normalArray[vertex] == null)
            return null;
        
        for(int j = 0; j < normalArray[vertex].size(); j++){
            if(normalArray[vertex].get(j).getValue() != 0){
                success.add(0, normalArray[vertex].get(j).getKey());
            }
        }
        return success;
    }

    /**
    * Metodo para obtener el peso o longitud entre dos nodos
    * 
    * @param source desde donde inicia el arco
    * @param destination  donde termina el arco
    * @return un entero con dicho peso
    */  
    public int getWeight(int source, int destination) {
        if(source >= normalArray.length || destination >= normalArray.length || normalArray[source] == null)
        return 0;
        
        for(int i = 0; i < normalArray[source].size(); i++){
            if(normalArray[source].get(i).getKey() == destination)
                return normalArray[source].get(i).getValue();
        }
        
        return 0;
    }

}