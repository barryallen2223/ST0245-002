import java.util.*;
/**
 * Write a description of class AllPos here.
 *
 * @author (your name)
 * @version (a version number or a date)
 */
public class AllPos
{
    public int[][] All(){
        int[][] S = new int[80][5];
        int t = 0;
        int D = 6; //Total
        
        for(int i = 0; i < D - 4; i++){
            for(int j = i+1; j < D - 3; j++){
                for(int k = j+1; k < D - 2; k++){
                    for(int l = k+1; l < D - 1; l++){
                        for(int m = l+1; m < D - 0; m++){
                            S[t][0] = i;
                            S[t][1] = j;
                            S[t][2] = k;
                            S[t][3] = l;
                            S[t][4] = m;
                            t++;
                        }
                    }
                }
            }
        }
        
        return S;
    }
    
    private void CreateVal(int level, int Total, ArrayList<int[]> Combinations, int[] Comb, int DependenceFor){
        if(level == Comb.length){
            int[] Index = Comb.clone();
            Combinations.add(Index);
        } else{
            int lim = Math.min(Total, Total + 1 - Comb.length + level);
            for(int z = DependenceFor; z <= lim; z++){
                Comb[level] = z;
                CreateVal(level+1, Total, Combinations, Comb, z+1);
            }
        }
    }
    
    public int[][] Save(int Total, int Sub){
        ArrayList<int[]> C = new ArrayList<int[]>();
        CreateVal(0, Total - 1, C, new int[Sub],0);
        return C.toArray(new int[C.size()][Sub]);
    }
    
    public void AllRecursion(int level, int n, int[] lattice){
        if(level >= n){
            this.Print(lattice);
        }else{
            for(int i = -1; i <= 1; i += 2){
                lattice[level] = i;
                AllRecursion(level + 1,n,lattice);
            }
        }
    }
    
    public void Print(int[] Arr){
        for(int i = 0; i < Arr.length; i++){
            if(i == Arr.length - 1)
            System.out.println(Arr[i] + "]");
            else if(i == 0)
            System.out.print("[" + Arr[i] + ", ");
            else
            System.out.print(Arr[i] + ", ");
        }
    }
}
