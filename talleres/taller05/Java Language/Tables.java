
/**
 * Write a description of class Tables here.
 *
 * @author (your name)
 * @version (a version number or a date)
 */
public class Tables
{
    
    public String[] MatrMult(int last){
        
        String[] asd = new String[last];
        
        for(int row = 0; row < last; row++){
            
            String jk = "";
            for(int i = 0; i < last; i++){
                jk += (row+1)*(1+i);
            }
            
            asd[row] = jk;
        }
        
        return asd;
    }
    
    public int[][] Multiplication(int last){
        int[][] tables = new int[last][last];
        
        for(int row = 0; row < tables.length; row++){
            for(int col = 0; col < tables[row].length; col++){
                tables[row][col] = (row+1)*(col+1);
            }
        }
        
        return tables;
    }
    
    public static void main(String[] args){
        Tables tab = new Tables();
        
        int Start = 1, Loops = 20, Amount = 3000;
        
        for(int Loop = Start; Loop <= Start + Loops; Loop++){
            double st = System.currentTimeMillis();
            tab.Multiplication(Loop*Amount);
            //tab.MatrMult(Loop*Amount);
            double fn = System.currentTimeMillis() - st;
            System.out.println(fn);
        }
    }
}
