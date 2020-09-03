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

public class BionicBee {
    
    public ArrayList<Object[]> Insert(ArrayList<Object[]> beeGroup, Object[] bee, int index){
        if(beeGroup.isEmpty())
            beeGroup.add(bee);
        else beeGroup.add(index, bee);
        return beeGroup;
    }
    
    public static void Print(ArrayList<double[]> which){
        which.forEach(t -> {
            for(int ind = 0; ind < t.length; ind++){
                if(t.length == 1)
                    System.out.println("[" + t[ind] + "]");            
                else if(ind == t.length - 1)
                    System.out.println(t[ind] + "]");
                else if(ind == 0)
                    System.out.print("[" + t[ind] + ", ");
                else
                    System.out.print(t[ind] + ", ");
            }
        });
    }
    
    public static void main(String[] args){
        
        ArrayList<double[]> Bionic = new ArrayList<>();
        Scanner read = new Scanner(System.in);
        int decision = 0;
        double x, y, z;
        
        
            
        System.out.println("Do you want to insert or eliminate a bee?\n" +
                            "1. Yes, 2. No");
        int dd = read.nextInt();
        
        while(dd == 1){
            
            if(dd == 1){
                System.out.println("Choose an option:\n" +
                                    "0. Insert a Bee in the last position\n" + 
                                    "1. Insert Bee Position\n" +
                                    "2. Delete Bee In a Position\n" +
                                    "3. Show Bees' position\n" +
                                    "-1. Break");
                decision = read.nextInt();
                
                if(decision == -1) break;
                else if(decision != 0 && decision != 1 && decision != 2 && decision != 3)
                    continue;
                
                if(Bionic.isEmpty() || decision == 0){
                    
                    if(decision == 0 || decision == 1){
                        System.out.println("Insert a bee x, y and z coordinates separately:");
                        x = read.nextDouble();
                        y = read.nextDouble();
                        z = read.nextDouble();
                        double[] tuple = {x,y,z};
                        Bionic.add(tuple);
                    } else if(decision == 2)
                        System.out.println("You cannot delete any element");
                }
                
                else if(Bionic.size() > 0 && decision != 3){
                    System.out.println("Write your index:");
                    int index = read.nextInt();
                    
                    if((decision == 1 || decision == 2) && index >= Bionic.size())
                        System.out.println("Error in the index value. This can go from 0 to " + Bionic.size());
                    
                    else if(decision == 1){
                        System.out.println("Insert a bee x and y coordinates separately:");
                        x = read.nextDouble();
                        y = read.nextDouble();
                        z = read.nextDouble();
                        double[] tuple = {x,y,z};
                        Bionic.add(index, tuple);
                    } else if(decision == 2)
                        Bionic.remove(index);
                } else if(decision == 3)
                    Print(Bionic);
                
                System.out.println();

            }
        }
        
        //Complejidad: O(n^2). No es tan buena para agregar millones de abejas.
    }
}