
/**
 * Write a description of class Point3D here.
 *
 * @author (your name)
 * @version (a version number or a date)
 */
public class Point3D
{
    double x, y, z;
    
    public Point3D (double x, double y, double z){
        this.x = x;
        this.y = y;
        this.z = z;
    }
    
    public double getXCoordinate (){
        return x;
    }
    
    public double getYCoordinate (){
        return y;
    }
    
    public double getZCoordinate (){
        return z;
    }
    
    public double PolarRadius (){
        return Math.sqrt(Math.pow(x,2)+Math.pow(y,2)+Math.pow(z,2));
    }
    
    public double PolarAngle (){
        return Math.atan2(Math.sqrt(Math.pow(x,2)+Math.pow(y,2)),z);
    }
    
    public double AzimuthalAngle(){
        return Math.atan2(y,x);
    }
    
    public double EuclideanDistance(Point3D other){
        return Math.sqrt(Math.pow(other.x-x,2)+Math.pow(other.y-y,2)+Math.pow(other.z-z,2));
    }
}
