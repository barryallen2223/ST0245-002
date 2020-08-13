public class FloodFill
{
    public void PrintFill(int[][] Figure, int Row, int Column, int Columnor){
        this.Print(this.FloodFill(Figure, Row, Column, Columnor));
    }
    
    private int[][] FloodFill(int[][] Figure, int Row, int Column, int Color){
        if( Color == Figure[Row][Column])
        return Figure;
        
        int T = Figure[Row][Column];
        if(Row < Figure.length-1){
            if(Figure[Row][Column] == Figure[Row+1][Column]){
                Figure[Row][Column] = Color;
                FloodFill(Figure, Row + 1, Column, Color);
                Figure[Row][Column] = T;
            }
        }
        if(Column < Figure[Row].length-1){
            if(Figure[Row][Column] == Figure[Row][Column+1]){
                Figure[Row][Column] = Color;
                FloodFill(Figure, Row, Column + 1, Color);
                Figure[Row][Column] = T;
            }
        }
        if(Row > 0){
            if(Figure[Row][Column] == Figure[Row-1][Column]){
                Figure[Row][Column] = Color;
                FloodFill(Figure, Row - 1, Column, Color);
                Figure[Row][Column] = T;
            }
        }
        if(Column > 0){
            if(Figure[Row][Column] == Figure[Row][Column-1]){
                Figure[Row][Column] = Color;
                FloodFill(Figure, Row, Column - 1, Color);
                Figure[Row][Column] = T;
            }
        }
        
        Figure[Row][Column] = Color;
        return Figure;
    }
    
    private void Print(int[][] Arr){
        
        for(int z = 0; z < Arr.length; z++){
            for(int i = 0; i < Arr[z].length; i++){
                if(Arr.length == 1)
                System.out.println("[" + Arr[z][i] + "]");            
                else if(i == Arr[z].length - 1)
                System.out.println(Arr[z][i] + "]");
                else if(i == 0)
                System.out.print("[" + Arr[z][i] + ", ");
                else
                System.out.print(Arr[z][i] + ", ");
            }
        }
    }
}
