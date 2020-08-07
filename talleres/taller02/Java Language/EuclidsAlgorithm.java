public class EuclidsAlgorithm{
    
    public int FindGCD(int fValue, int sValue){
        int Min = Math.min(fValue, sValue);
        int Max = Math.max(fValue, sValue);
        
        if(Max%Min != 0)
        return FindGCD(Min, Max%Min);
        return Min;
    }
}