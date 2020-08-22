public class FillRectangles{
    
    public double fillRectangle(int n){
        if(n > 1)
        {
            return fillRectangle(n-2) + fillRectangle(n-1);
        }
        return 1;
    }
    
}
