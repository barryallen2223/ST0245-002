
/**
 * Write a description of class MaxWeight here.
 *
 * @author (your name)
 * @version (a version number or a date)
 */
public class MaxWeight
{
    public boolean Equals(Object[] Weights, int Target){
        Binomial Set = new Binomial();
        Object[][] Combin = Set.AllBinomial(Weights, 1).clone();
        int Sum = 0;
        
        
            for(int t = 0; t < Combin.length; t++){
                for(int k = 0; k < Combin[t].length; k++){
                    Sum += (int) Combin[t][k];
                }
                
                if(Sum == Target)
                return true;
                
                Sum = 0;
            }
            
            return false;
    }
    
    public Object[] Rewrite(Object[] Entry, int n){
        
        Object[] rewrite = new Object[Entry.length - (int) n];
        
        if(n >= Entry.length)
        return rewrite;
        
        for(int i = n; i < Entry.length; i++)
        rewrite[i-n] = Entry[i];
        
        return rewrite;
    }
}
