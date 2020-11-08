import java.util.*;

/**
 * Write a description of class TwoColors here.
 *
 * @author (your name)
 * @version (a version number or a date)
 */
public class TwoColors
{
    public boolean isColorable(DigraphAL graph){
        Node Start = graph.getHead(0);
        
        ArrayList<Node> blue = new ArrayList<>();
        ArrayList<Node> red = new ArrayList<>();
        
        blue.add(Start);
        
        for(int i = 0; i < graph.size(); i++){
            
            Node act = graph.getHead(i);
            
            for(Node j : graph.getSuccessors(i)){
                if(blue.contains(act)){
                    if(red.contains(j))
                        return false;
                    red.add(j);
                } else if(red.contains(act)){
                    if(blue.contains(j))
                        return false;
                    blue.add(j);
                }
            }
        }
        
        return true;
    }
    
    public static void main(String[] args){
        TwoColors t = new TwoColors();
        DigraphAL graph = new DigraphAL(5);
        
        Node a0 = new Node((Integer) 0);
        Node a1 = new Node((Integer) 1);
        Node a2 = new Node((Integer) 2);
        Node a3 = new Node((Integer) 3);
        Node a4 = new Node((Integer) 4);
        
        graph.setHead(0, a0);
        graph.setHead(1, a1);
        graph.setHead(2, a2);
        graph.setHead(3, a3);
        graph.setHead(4, a4);
        
        graph.addArc(a0, a4, 4.0);
        graph.addArc(a0, a1, 3.0);
        graph.addArc(a1, a2, 2.0);
        graph.addArc(a1, a3, 5.0);
        graph.addArc(a0, a2, 6.0);
        graph.addArc(a2, a1, 2.0);
        graph.addArc(a2, a4, 5.0);
        
        System.out.println(t.isColorable(graph));
    }
}