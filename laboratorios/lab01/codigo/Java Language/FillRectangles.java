public class FillRectangles{
    
    public double fillRectangle(int n){
        return Math.pow(auxFill(n, 0),2)-1;
    }
    
    public int auxFill(int n, int cont){
        if(n > 1)
        return auxFill(n-2, cont) + auxFill(n-1, cont);
        return ++cont;
    }
}