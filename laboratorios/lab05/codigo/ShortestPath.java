import java.util.*;

public class ShortestPath
{
    private boolean thereIsFalse(boolean[] vis){
        for(int i = 0; i < vis.length; i++){
            if(vis[i] == false)
            return true;
        }
        
        return false;
    }
    
    public void BFS(Node Start, DigraphAL totGraph){
        
        boolean[] visited = new boolean[totGraph.size()];
        
        ArrayList<Node> nodes = new ArrayList<>();
        nodes.add(Start);
        
        nodes = find_path_BFS(Start, totGraph, visited, nodes, 0, true);
        
        for(int i = 0; i < nodes.size(); i++){
            nodes.get(i).setNumber(i);
        }
    }
    
    private ArrayList<Node> find_path_BFS(Node Start, DigraphAL totGraph, boolean[] visited, ArrayList<Node> nodes, int index, boolean val){
        if(totGraph.getSuccessors(Start) == null || !thereIsFalse(visited)){
            return nodes;
        }
            
        if(!visited[Start.getNumber()]){
            visited[Start.getNumber()] = true;
        
            for(int i = 0; i < totGraph.getSuccessors(Start).size(); i++){
                if(thereItIs(totGraph.getSuccessors(Start).get(i), nodes) == -1){
                    nodes.add(totGraph.getSuccessors(Start).get(i));
                }
            }
            
            index++;
            
            if(index >= nodes.size())
                val = false;
            
            if(val)
                return find_path_BFS(nodes.get(index), totGraph, visited, nodes, index, val);
        }
        
        return nodes;
    }
    
    private int thereItIs(Node node, ArrayList<Node> List){
        for(int i = 0; i < List.size(); i++){
            if(List.get(i) == node){
                return i;
            }
        }
        
        return -1;
    }
    
    public static void main(String[] args){
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
    }
}