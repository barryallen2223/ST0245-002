import java.util.*;
//import javafx.util.*;

/**
 * Implementacion de un grafo dirigido usando listas de adyacencia
 *
 * @author Mauricio Toro, Mateo Agudelo, Simøn Alvarez, David Madrid
 */
public class DigraphAL extends Digraph {
    Pair<Node, LinkedList<Pair<Node, Double>>>[] normalArray;

    /**
     * Constructor para el grafo dirigido
     * @param vertices el numero de vertices que tendra el grafo dirigido
    *
    */
    public DigraphAL(int size) {
        super(size);
        normalArray = new Pair[size];
    }
    
    public void setHead(int position, Node newHead){
        if(normalArray[position] == null)
            normalArray[position] = new Pair(newHead, new LinkedList<>());
        else
            normalArray[position].setKey(newHead);
    }
    
    public Node getHead(int position){
        return normalArray[position].getKey();
    }

    /**
    * Metodo para añadir un arco nuevo, donde se representa cada nodo con un entero
    * y se le asigna un peso a la longitud entre un nodo fuente y uno destino   
    * @param source desde donde se hara el arco
    * @param destination hacia donde va el arco
    * @param weight el peso de la longitud entre source y destination
    */
    public void addArc(Node source, Node destination, Double weight) throws NullPointerException{
        
        if(source.getNumber() == null || destination.getNumber() == null || source.getNumber() >= normalArray.length || destination.getNumber() >= normalArray.length)
            return;
        else if(normalArray.length == 0)
            return;
        else{
            if(normalArray[source.getNumber()] == null){
                Node Void = new Node();
                LinkedList<Pair<Node, Double>> linky = new LinkedList<>();
                normalArray[source.getNumber()] = new Pair(Void, linky);
            }
            normalArray[source.getNumber()].getValue().add(Pair.makePair(destination, weight));
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
    public ArrayList<Node> getSuccessors(Node vertex) {
        ArrayList<Node> success = new ArrayList<>();
        
        if(normalArray[vertex.getNumber()] == null)
            return null;
        
        for(int j = 0; j < normalArray[vertex.getNumber()].getValue().size(); j++){
            if(normalArray[vertex.getNumber()].getValue().get(j).getValue() != 0){
                success.add(0, normalArray[vertex.getNumber()].getValue().get(j).getKey());
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
    public Double getTime(Node source, Node destination) {
        if(source.getNumber() >= normalArray.length || destination.getNumber() >= normalArray.length || normalArray[source.getNumber()] == null)
        return 0.0;
        return normalArray[source.getNumber()].getValue().get(destination.getNumber()).getValue();
    }

}