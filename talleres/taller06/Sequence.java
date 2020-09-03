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

public class Sequence {
    
    public static void Print(ArrayList<Integer> Arr){
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
    
    public void SequencePrinting(int times){
        
        ArrayList<Integer> Seq = new ArrayList<>();
        
        for(int i = 1; i <= times; i++){
            for(int j = 1; j <= i; j++){
                Seq.add(j);
            }
        }
        
        Print(Seq);
    }
    
    public static void main(String[] args){
        
        Scanner val = new Scanner(System.in);
        Sequence crazy = new Sequence();
        
        int times = val.nextInt();
        
        crazy.SequencePrinting(times);
    }
}