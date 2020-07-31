/**
 * Write a description of class EuclidesAlgorithm here.
 *
 * @author (your name)
 * @version (a version number or a date)
 */
public class EuclidesAlgorithm
{
    int m;
    
    public int FindMCD(int a, int b){
        m = (a > b) ? b : a;
        
        if(a%b != 0)
        return FindMCD(b, a%b);
        else return m;
    }
}
