import java.util.*;
public class Permutation{
    
    public void PrintPermutations(String Method){
        ArrayList<String> Permutations = new ArrayList<String>();
        this.Permutate(Method, "", Permutations, 0);
        this.Print(Permutations.toArray(new String[Permutations.size()]), 0);
    }
    
    public String[] Permutations(String Entry){
        ArrayList<String> Permutations = new ArrayList<String>();
        this.Permutate(Entry, "", Permutations, 0);
        return Permutations.toArray(new String[Permutations.size()]);
    }
    
    private void Permutate(String Entry, String Answer, ArrayList<String> Permutations, int i){
        if(Entry.length() > 0){
            Permutate(this.reWrite(Entry, 0), Answer + Entry.charAt(0), Permutations, 0);
            i = 0;
            while(i < Entry.length() - 1){
                i++;
                Permutate(this.reWrite(Entry, i), Answer + Entry.charAt(i), Permutations, i - 1);
            }
        } else
        Permutations.add(Answer);
    }
    
    private String reWrite(String Write, int Elim){
        if(Elim != 0 && Elim < Write.length()-1)
        return Write.substring(0,Elim) + Write.substring(Elim+1);
        else if(Elim == 0)
        return Write.substring(1);
        else if(Elim == Write.length()-1)
        return Write.substring(0,Elim);
        return Write;
    }
    
    private void Print(Object[] Printable, int Index){
        if(Index < Printable.length){
            System.out.println("[" + Printable[Index] + "]");
            Print(Printable, Index + 1);
        }
    }
}
