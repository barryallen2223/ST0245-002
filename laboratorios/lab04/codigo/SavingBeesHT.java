/**
 * Write a description of class ShittyBees here.
 *
 * @author (your name)
 * @version (a version number or a date)
 */
import java.util.*;

public class SavingBeesHT
{
    Hashtable<Double, Bee> Thing;
    Bee Primal;
    
    public SavingBeesHT(Bee Primal){
        this.Primal = Primal;
        Thing = new Hashtable<>();
    }
    
    public Hashtable getThing(){
        return Thing;
    }
    
    public boolean SavingBees(Bee Dual){
        if(Primal.getDistance(Dual) > 100)
            return false;
        else{
            Thing.put(Primal.getDistance(Dual), Dual);
            return true;
        }
    }
    
    public Bee get(Double element){
        return Thing.get(element);
    }
}