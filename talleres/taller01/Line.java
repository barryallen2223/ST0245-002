import java.util.*;

/**
 * Write a description of class Line here.
 *
 * @author (your name)
 * @version (a version number or a date)
 */
public class Line
{
    private double x0, x1, y0, y1;
    
    public Line(double x0, double x1, double y0, double y1){
        this.x0 = x0;
        this.x1 = x1;
        this.y0 = y0;
        this.y1 = y1;
    }
    
    private Double Slope(){
        if(x0 == x1)
        return null;
        
        return (y1-y0)/(x1-x0);
    }
    
    private double Constant(){
        return y1 - this.Slope()*x1;
    }
    
    private double ImageX(double x){
        return this.Slope()*x + this.Constant();
    }
    
    private double ImageY(double y){
        return (y - this.Constant())/this.Slope();
    }
    
    public double[][] SetMatrix(double[][] Array){
        
        ArrayList<double[]> Change = new ArrayList<double[]>();
        int k = 0;
        
        for(int i = 0; i < Array.length - 1; i++){
            
            while(Array[i][0] == Array[i+1][0] && Array[i][1] == Array[i+1][1] && i != Array.length - 2)
                i++;
                
            if(i == Array.length - 2 && !(Array[i][0] == Array[i+1][0] && Array[i][1] == Array[i+1][1])){
                Change.add(Array[i]);
                i++;
            }
            
            Change.add(Array[i]);
        }
        
        double[][] retVal = Change.toArray(new double[Change.size()][2]);
        
        return retVal;
    }
    
    /**
     * @param n: amount of intermediate points the user want to exist between the two points (exclusive).
     * @param n: set n = -1 if you want to exist all the possible intermediate points.
     */
    public double[][] IntermediatePoints (double n){
        
        if(this.Aproximation(x0) == this.Aproximation(x1) && this.Aproximation(y0) == this.Aproximation(y1)){
            double[][] aPoint = new double[1][2];
            aPoint[0][0] = this.Aproximation(x0);
            aPoint[0][1] = this.Aproximation(y0);
            
            return aPoint;
        }
        
        double MaxVal, MinVal, Image;
        boolean Tx = true;
        
        if(this.Slope() == null){
            MaxVal = (this.Aproximation(y0) > this.Aproximation(y1)) ? this.Aproximation(y0) : this.Aproximation(y1);
            MinVal = (MaxVal == this.Aproximation(y0)) ? this.Aproximation(y1) : this.Aproximation(y0);
            n = (n == -1) ? MaxVal - MinVal : n;
            double[][] IntermediatePoints = new double[(int) n + 2][2];
            double Delta = (MaxVal - MinVal)/(n+1);
            for(int i = (int) n + 1; i >= 0; i--){
                IntermediatePoints[i][0] = this.Aproximation(x0);
                IntermediatePoints[i][1] = this.Aproximation(MinVal + Delta*i);
            }
            return this.SetMatrix(IntermediatePoints);
        } else if(Math.abs(this.Slope()) > 1){
            MaxVal = (this.Aproximation(y0) > this.Aproximation(y1)) ? this.Aproximation(y0) : this.Aproximation(y1);
            MinVal = (MaxVal == this.Aproximation(y0)) ? this.Aproximation(y1) : this.Aproximation(y0);
            Tx = false;
        } else{
            MaxVal = (this.Aproximation(x0) > this.Aproximation(x1)) ? this.Aproximation(x0) : this.Aproximation(x1);
            MinVal = (MaxVal == this.Aproximation(x0)) ? this.Aproximation(x1) : this.Aproximation(x0);
        }
        
        n = (n == -1) ? MaxVal - MinVal : n;
        int IntN = (int) n;
        double[][] IntermediatePoints = new double[IntN+2][2];
        double DVal = (MaxVal - MinVal)/(n+1);
        
        for(int i = IntN + 1; i >= 0; i--){
            
            double value = MinVal + DVal*i;
            
            if(!Tx){
                Image = this.ImageY(value);
                IntermediatePoints[i][1] = this.Aproximation(value);
                IntermediatePoints[i][0] = this.Aproximation(Image);
            }else{
                Image = this.ImageX(value);
                IntermediatePoints[i][0] = this.Aproximation(value);
                IntermediatePoints[i][1] = this.Aproximation(Image);
            }
        }
        
        return this.SetMatrix(IntermediatePoints);
    }
    
    double Aproximation(double value){
        return (value - Math.floor(value) >= 0.5) ? Math.ceil(value) : Math.floor(value);
    }
}
