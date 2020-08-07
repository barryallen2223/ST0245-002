import java.util.*;
public class Binomial
{
    public static void main(String[] args){
        Scanner Comb = new Scanner(System.in);
        
        int C = -1;
        
        while(C == -1 || C == 0 || C == 1){
            System.out.println("Choose your input type: \n" +
                           "0. Input type Array \n" +
                           "1. Input type String");
            C = Comb.nextInt();
            if(C == 0){
                System.out.println("Set the array dimension");
                int dimension = Comb.nextInt();
                Object[] T = new Object[dimension];
                for(int x = 0; x < dimension; x++){
                    int y = x + 1;
                    System.out.println("Set the element number " + y + " of the array");
                    T[x] = Comb.nextDouble();
                }
                Binomial AlMeth = new Binomial();
        
                System.out.println("[]");
                for(int t = 1; t < AlMeth.Combinations(T).length; t++)
                AlMeth.Print(AlMeth.Combinations(T)[t]);
                C = 2;
            } else if(C == 1){
                System.out.println("Write the String");
                String Elements;
                Elements = Comb.next();
                
                Binomial AlMeth = new Binomial();
                Object[] CharArray = AlMeth.Split(Elements, new Object[Elements.length()], Elements.length()-1).clone();
                System.out.println("[]");
                for(int t = 1; t < AlMeth.Combinations(CharArray).length; t++)
                AlMeth.Print(AlMeth.Combinations(CharArray)[t]);
                C = 2;
            } else{
                System.out.println("The entry value is incorrect.");
                System.out.println();
                C = -1;
            }
        }
    }
    
    public Object[][] Combinations(Object[] Objects){
        return this.SumArrays(new ArrayList<Object[]>(), new Object[1][1], this.AllBinomial(Objects, 1), 0);
    }
    
    /**
     * @param index: Set index = 1
     */
    private Object[][] AllBinomial(Object[] Objects, int index) throws NullPointerException{
        if(index < Objects.length){
            return this.SumArrays(new ArrayList<Object[]>(), Combinational(Objects, index), AllBinomial(Objects, index + 1), 0);
        } else if(index == Objects.length){
            return Combinational(Objects, Objects.length);
        }
        return new Object[0][0];
    }
    
    private Object[][] Combinational(Object[] Objects, int Subgroup){
        return this.RecursiveCombin(Objects, Subgroup, new ArrayList<Object[]>(), new ArrayList<Object>(), 0, 0);
    }
    
    private Object[][] RecursiveCombin(Object[] Objects, int Subgroup, ArrayList<Object[]> WithPositions, ArrayList<Object> ElemInPos, int Index, int Cycle){
        if(Index == (int) this.TotBinomial(Objects.length, Subgroup))
        return WithPositions.toArray(new Object[WithPositions.size()][Subgroup]);
        if(Cycle < Subgroup)
        ElemInPos.add(Objects[this.ACombinational(Objects.length, Subgroup)[Index][Cycle]]);
        if(Cycle == Subgroup){
            WithPositions.add(ElemInPos.toArray(new Object[ElemInPos.size()]));
            return this.RecursiveCombin(Objects, Subgroup, WithPositions, new ArrayList<>(), Index + 1, 0);
        }
        return this.RecursiveCombin(Objects, Subgroup, WithPositions, ElemInPos, Index, Cycle + 1);
    }
    
    private int[][] ACombinational(int Total, int Sub){
        ArrayList<int[]> Combinations = new ArrayList<int[]>();
        CreateValues(0, Total - 1, Combinations, new int[Sub],0);
        return Combinations.toArray(new int[Combinations.size()][Sub]);
    }
    
    private void CreateValues(int level, int Total, ArrayList<int[]> Combinations, int[] Comb, int DependenceFor){
        if(level == Comb.length){
            int[] Index = Comb.clone();
            Combinations.add(Index);
        } else{
            int lim = Math.min(Total + 1, Total + 2 - Comb.length + level);
            for(int z = DependenceFor; z < lim; z++){
                Comb[level] = z;
                CreateValues(level+1, Total, Combinations, Comb, z+1);
            }
        }
    }
    
    private Object[][] SumArrays(ArrayList<Object[]> Sum, Object[][] Arr1, Object[][] Arr2, int Count){
        //ArrayList<Object[]> Possib = new ArrayList<Object[]>();
        if(Count < Arr1.length){
            Object[] Go = this.SetEq(new Object[Arr1[Count].length], Arr1, Count, 0);
            Sum.add(Go.clone());
            return SumArrays(Sum, Arr1, Arr2, Count + 1);
        } else if(Arr1.length <= Count && Count < Arr2.length + Arr1.length){
            Object[] Go = this.SetEq(new Object[Arr2[Count - Arr1.length].length], Arr2, Count - Arr1.length, 0);
            Sum.add(Go.clone());
            return SumArrays(Sum, Arr1, Arr2, Count + 1);
        }
        
        return Sum.toArray(new Object[Sum.size()][(Arr1[0].length > Arr2[0].length) ? Arr1[0].length : Arr2[0].length]);
    }
    
    private Object[] SetEq(Object[] Set, Object[][] Setter, int Row, int Col){
        if(Col < Setter[Row].length){
             Set[Col] = Setter[Row][Col];
             return SetEq(Set, Setter, Row, Col + 1);
        } else return Set;
    }
    
    /**
     * @param index: set index = Object.length() - 1
     */
    private Object[] Split(String Object, Object[] Split, int index){
        if(Object.length() < 1)
        return Split;
        Split[index] = Object.charAt(index);
        return Split(Object.substring(0,index), Split, index - 1);
    }
    
    public double Factorial(double a){
        double result;
        
        if(a == 1 || a == 0)
        return 1;
        
        result = a*Factorial(a-1);
        return result;
    }
    
    public double TotBinomial(double i, double n){
        
        double m = (i > n) ? n : i;
        double M = (i > n) ? i : n;
        
        return this.Factorial(M)/(this.Factorial(M-m)*this.Factorial(m));
    }
    
    public double SumTotBin(double Start, double End){
        if(Start <= End)
        return this.TotBinomial(Start, End) + SumTotBin(Start + 1, End);
        
        return 0;
    }
    
    public void Print(Object[] Arr){
        for(int i = 0; i < Arr.length; i++){
            if(Arr.length == 1)
            System.out.println("[" + Arr[i] + "]");            
            else if(i == Arr.length - 1)
            System.out.println(Arr[i] + "]");
            else if(i == 0)
            System.out.print("[" + Arr[i] + ", ");
            else
            System.out.print(Arr[i] + ", ");
        }
    }
}