/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author salvarezo1
 */
import java.util.*;

public class ScanInversion {
    
    public static void Print(ArrayList<Double> Arr){
        for(int t = 0; t < Arr.size(); t++){
            if(Arr.size() == 1)
            System.out.println("[" + Arr.get(t) + "]");            
            else if(t == Arr.size() - 1)
            System.out.println(Arr.get(t) + "]");
            else if(t == 0)
            System.out.print("[" + Arr.get(t) + ", ");
            else
            System.out.print(Arr.get(t) + ", ");
        }
    }
    
    public static void main(String[] args){
        
        ArrayList<Double> Invert = new ArrayList<>();
        Scanner read = new Scanner(System.in);
        
        while(true){
            System.out.println("1. Add another number\n" +
                               "-1. Break");
            int decision = read.nextInt();
            
            if(decision == -1) break;
            
            System.out.println("How many numbers do you want to add?");
            double inLoop = read.nextDouble();
            
            System.out.println("You can start writing");
            double next;
            
            for(int loop = 0; loop < inLoop; loop++){
                next = read.nextDouble();
                Invert.add(0, next);
            }
        }
        
        Print(Invert);
    }
    
}
