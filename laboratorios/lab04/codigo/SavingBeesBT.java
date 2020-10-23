
/**
 * Write a description of class SavingBeesBT here.
 *
 * @author (your name)
 * @version (a version number or a date)
 */

import java.util.*;

public class SavingBeesBT
{
    Bee Primal;
    BinaryTreeBees BeeSaving;
    
    public SavingBeesBT(Bee Primal){
        this.Primal = Primal;
        BeeSaving = new BinaryTreeBees(new Node(Primal));
    }
    
    public boolean SavingBees(Bee Dual){
        if(Primal.getDistance(Dual) > 100)
            return false;
        else{
            BeeSaving.add(BeeSaving.getRoot(), Primal.getDistance(Dual), Dual);
            return true;
        }
    }
    
    public static void main(String[] args){
        Bee b1 = new Bee(1,2,1);
        Bee b2 = new Bee(1,3,3);
        Bee b3 = new Bee(5,1,0);
        Bee b6 = new Bee(1,1,1);
        
        SavingBeesBT t = new SavingBeesBT(b1);
        
        t.SavingBees(b2);
        t.SavingBees(b3);
        t.SavingBees(b6);
    }
}
