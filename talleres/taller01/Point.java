
/**
 * Write a description of interface Points here.
 *
 * @author (your name)
 * @version (a version number or a date)
 */
public class Point
{
    double x, y;
    
    public Point(double x, double y){
        this.x = x;
        this.y = y;
    }
    
    public double getXCoordinate (){
        return x;
    }
    
    public double getYCoordinate (){
        return y;
    }
    
    public double PolarRadius(){
        return Math.sqrt(Math.pow(x,2)+Math.pow(y,2));
    }
    
    public double PolarAngle(){
        return Math.atan2(y, x);
    }
    
    public double EuclideanDistance(Point other){
        return Math.sqrt(Math.pow(other.x-x,2)+Math.pow(other.y-y,2));
    }
}
