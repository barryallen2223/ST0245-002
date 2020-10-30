
import java.util.*;

/**
 * Write a description of class DFS here.
 *
 * @author (your name)
 * @version (a version number or a date)
 */
public class FindPath
{
    public boolean DFS(int Start, int End, DigraphAL totGraph){
        
        boolean[] visited = new boolean[totGraph.size()];
        
        return find_path_DFS(Start, End, totGraph, visited);
    }
    
    public boolean find_path_DFS(int Start, int End, DigraphAL totGraph, boolean[] visited){
        if(Start == End)
            return true;
        if(totGraph.getSuccessors(Start) == null){
            return false;
        }
        else if(!thereIsFalse(visited))
            return false;
            
        if(!visited[Start]){
            visited[Start] = true;
        
            for(int i = 0; i < totGraph.getSuccessors(Start).size(); i++){
                
                
                if(find_path_DFS(totGraph.getSuccessors(Start).get(i), End, totGraph, visited))
                    return true;
                
            }
        }
        
        return false;
    }
    
    public boolean BFS(int Start, int End, DigraphAL totGraph){
        
        boolean[] visited = new boolean[totGraph.size()];
        
        ArrayList<Integer> nodes = new ArrayList<>();
        nodes.add(Start);
        
        return find_path_BFS(Start, End, totGraph, visited, nodes, 0, true);
    }
    
    public boolean find_path_BFS(int Start, int End, DigraphAL totGraph, boolean[] visited, ArrayList<Integer> nodes, int index, boolean val){
        if(Start == End)
            return true;
        if(totGraph.getSuccessors(Start) == null){
            return false;
        }
        else if(!thereIsFalse(visited))
            return false;
            
        if(!visited[Start]){
            visited[Start] = true;
        
            for(int i = 0; i < totGraph.getSuccessors(Start).size(); i++){
                if(totGraph.getSuccessors(Start).get(i) == End)
                    return true;
                
                if(thereItIs(totGraph.getSuccessors(Start).get(i), nodes) == -1){
                    nodes.add(totGraph.getSuccessors(Start).get(i));
                }
            }
            
            index++;
            
            if(index >= nodes.size())
                val = false;
            
            if(val && find_path_BFS(nodes.get(index), End, totGraph, visited, nodes, index, val))
                return true;
        }
        
        return false;
    }
    
    private boolean isThere(int Node, int[] vis){
        for(int i = 0; i < vis.length; i++){
            if(vis[i] == Node)
                return true;
        }
        
        return false;
    }
    
    private int thereItIs(int Node, ArrayList<Integer> List){
        for(int i = 0; i < List.size(); i++){
            if(List.get(i) == Node){
                return i;
            }
        }
        
        return -1;
    }
    
    private boolean thereIsFalse(boolean[] vis){
        for(int i = 0; i < vis.length; i++){
            if(vis[i] == false)
            return true;
        }
        
        return false;
    }
}
