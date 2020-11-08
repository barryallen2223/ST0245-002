
/**
 * Write a description of class FewCars here.
 *
 * @author (your name)
 * @version (a version number or a date)
 */
public class FewCars
{
    DigraphAL graph;
    
    
    public FewCars(DigraphAL graph){
        this.graph = graph;
    }
    
    public void setTimes(){
        
        for(int i = 0; i < graph.size(); i++){
            graph.getHead(i).setTime()
        }
    }
}
