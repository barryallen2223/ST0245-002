
import java.util.*;

public class pathAlt
{
    static Double times = 0.0;
    public static void main(String args[])
    {
        // V número de vertices
        int v = 5;
        DigraphAL graph = new DigraphAL(v);

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

        Node source = a0, dest = a3;        
        
        printShortestDistance(graph, source, dest, v);
    }
        
    public static Double sumTime(LinkedList<Integer> path, DigraphAL adj){
        
        for (int i = path.size() -1 ; i > 0 ; i--){
            Node src = adj.getHead(path.get(i)), dest = adj.getHead(path.get(i-1));
            times += adj.getTime(src, dest);
        }
        return times;
    }   
    
    public static ArrayList sumIDK(DigraphAL adj){
        ArrayList<Pair<Node, Double>> doub = new ArrayList<Pair<Node, Double>>();
        ArrayList<Node> all = adj.getAllHeads();
        for (int i = 0 ; i < adj.size() ; i++){
            Node src = adj.getHead(i);
            for (int j = 0 ; j < adj.size() ; j++){
                Node dest = adj.getHead(j);
                doub.add(Pair.makePair(dest, adj.getTime(src, dest)));
            }
            all.get(i).setTime(doub);
        }
        return doub;
    }
    
    public static void printShortestDistance(DigraphAL adj, Node src, Node dest, int v){
        int pred[] = new int[v];
        int dist[] = new int[v];
        
        // BFS if
        if (BFS(adj, src, dest, pred, dist) == false){
            System.out.println("Given source and destination are not connected");
            return;
        }
        
        // LinkedList to store path
        LinkedList<Integer> path = new LinkedList<Integer>();
        int crawl = dest.getNumber();
        path.add(crawl);
        
        while(pred[crawl] != -1){
            path.add(pred[crawl]);
            crawl = pred[crawl];
        }
        
        System.out.println("Shortest path length is: " + dist[dest.getNumber()]);
        
        System.out.print("Path: ");
        for (int i = path.size() - 1 ; i >= 0 ; i--){
            System.out.print(path.get(i) + " ");
        }
        
        System.out.print("\nTiempo: " + sumTime(path, adj));
        ArrayList<Double> doub = sumIDK(adj);
        /*System.out.println("\nTiempo de todos con todos: ");
        for (int i = 0 ; i < doub.size() ; i++){
            for (int j = 0 ; j < doub.size() ; j++){
                System.out.print(doub.get(i) + " ");
            }
            System.out.print("\n");
        }*/
    }
    
    private static boolean thereIsFalse(boolean[] vis){
        for(int i = 0; i < vis.length; i++){
            if(vis[i] == false)
                return true;
        }

        return false;
    }

    public static boolean BFS(DigraphAL adj, Node src, Node dest, int pred[], 
    int dist[]){
        LinkedList<Integer> queue = new LinkedList<Integer>();
        
        FindNodes t = new FindNodes();
                    
        boolean visited[] = new boolean[adj.size()];
        
        for (int i = 0 ; i < adj.size() ; i++){
            visited[i] = false;
            dist[i] = Integer.MAX_VALUE;
            pred[i] = -1;
        }
        
        visited[src.getNumber()] = true;
        dist[src.getNumber()] = 0;
        queue.add(src.getNumber());
        
        while(!queue.isEmpty()){
            int u = queue.remove();
            for (int i = 0 ; i < adj.getSuccessors(u).size() ; i++){
                if (visited[adj.getSuccessors(u).get(i).getNumber()] == false){
                    visited[adj.getSuccessors(u).get(i).getNumber()] = true;
                    dist[adj.getSuccessors(u).get(i).getNumber()] = dist[u] + 1;
                    pred[adj.getSuccessors(u).get(i).getNumber()] = u;
                    queue.add(adj.getSuccessors(u).get(i).getNumber());
                    
                    if (adj.getSuccessors(u).get(i) == dest){
                        return true;
                    }
                }
            }
        }
        
        return false;
    }
}