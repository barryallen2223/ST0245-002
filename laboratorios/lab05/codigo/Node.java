import java.util.*;

public class Node
{
    Integer number;
    boolean Car;
    ArrayList<Pair<Node, Double>> time;
    float k;
    
    public Node(){
        this.number = null;
        this.Car = false;
        this.time = null;
        this.k = 1;
    }
    
    public Node(boolean Car){
        this.number = null;
        this.Car = Car;
        this.time = null;
        this.k = 1;
    }
    
    public Node(ArrayList<Pair<Node, Double>> time){
        this.number = null;
        this.Car = false;
        this.time = time;
        this.k = 1;
    }
    
    public Node(float k){
        this.number = null;
        this.Car = true;
        this.time = null;
        this.k = k;
    }
    
    public Node(Integer number){
        this.number = number;
        this.Car = false;
        this.time = null;
        this.k = 1;
    }
    
    public Node(boolean Car, ArrayList<Pair<Node, Double>> time){
        this.number = null;
        this.Car = Car;
        this.time = time;
        this.k = 1;
    }
    
    public Node(boolean Car, float k){
        this.number = null;
        this.Car = Car;
        this.time = null;
        this.k = k;
    }
    
    public Node(ArrayList<Pair<Node, Double>> time, float k){
        this.number = null;
        this.Car = false;
        this.time = time;
        this.k = k;
    }
    
    public Node(Integer number, float k){
        this.number = number;
        this.Car = true;
        this.time = null;
        this.k = k;
    }
    
    public Node(ArrayList<Pair<Node, Double>> time, Integer number){
        this.number = number;
        this.Car = false;
        this.time = time;
        this.k = 1;
    }
    
    public Node(boolean Car, ArrayList<Pair<Node, Double>> time, float k){
        this.number = null;
        this.Car = Car;
        this.time = time;
        this.k = k;
    }
    
    public Node(boolean Car, ArrayList<Pair<Node, Double>> time, Integer number){
        this.number = number;
        this.Car = Car;
        this.time = time;
        this.k = 1;
    }
    
    public Node(boolean Car, float k, Integer number){
        this.number = number;
        this.Car = Car;
        this.time = null;
        this.k = k;
    }
    
    public Node(ArrayList<Pair<Node, Double>> time, float k, Integer number){
        this.number = null;
        this.Car = false;
        this.time = time;
        this.k = k;
    }
    
    public Node(boolean Car, ArrayList<Pair<Node, Double>> time, float k, Integer number){
        this.number = number;
        this.Car = Car;
        this.time = time;
        this.k = k;
    }
    
    public void setNumber(Integer number){
        this.number = number;
    }
    
    public Integer getNumber(){
        return this.number;
    }
    
    public void setCar(boolean Car){
        this.Car = Car;
    }
    
    public boolean getCar(){
        return Car;
    }
    
    public void setK(float k){
        this.k = k;
    }
    
    public float getK(){
        return k;
    }
    
    public void setTime(ArrayList<Pair<Node, Double>> time){
        this.time = time;
    }
    
    public ArrayList<Pair<Node, Double>> getTime(){
        return this.time;
    }
}