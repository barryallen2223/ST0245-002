
/**
 * Write a description of class Stack here.
 *
 * @author (your name)
 * @version (a version number or a date)
 */

import java.util.*;
public class PolishCrazy
{
    public int Notation(String entry){
        String[] splitting = entry.split(" ");
        
        Stack p = new Stack();
        
        for(int i = 0; i < splitting.length; i++){
            if(this.isInteger(splitting[i])){
                p.push(Integer.parseInt(splitting[i]));
            } else{
                if(splitting[i].equals("+")){
                    
                    int temp = (int)p.pop();
                    
                    p.push(temp + (int)p.pop());
                } else if(splitting[i].equals("*")){
                    
                    int temp = (int)p.pop();
                    
                    p.push(temp * (int)p.pop());
                } else if(splitting[i].equals("-")){
                    
                    int temp = (int)p.pop();
                    
                    p.push((int)p.pop() - temp);
                } else if(splitting[i].equals("/")){
                    
                    int temp = (int)p.pop();
                    
                    p.push((int)p.pop() / temp);
                }
            }
        }
        
        return (int)p.peek();
    }
    
    public boolean isInteger(String numero){
        try{
            Integer.parseInt(numero);
            return true;
        }catch(NumberFormatException e){
            return false;
        }
    }
    
    public static void main(String[] args){
        PolishCrazy p = new PolishCrazy();
        
        String s = "3 8 + 5 - 8 9 12 * + -";
        
        System.out.println(p.Notation(s));
    }
}
