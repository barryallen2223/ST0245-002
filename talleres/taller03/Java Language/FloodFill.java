public class FloodFill
{
    
    /**
     * Print the matrix
     */
    public void PrintFill(int[][] Figure, int Row, int Column, int Color){
        this.Print(this.Floodfill(Figure, Row, Column, Color));
    }
    
    public int[][] Fill(int[][] Figure, int Row, int Column, int Color){
        return this.Floodfill(Figure, Row, Column, Color);
    }
    
    private int[][] Floodfill(int[][] Figure, int Row, int Column, int Color){
        if(Row < Figure.length && Column < Figure[Row].length){ 
            if( Color == Figure[Row][Column])
            return Figure;
        } else return Figure;
        
        int oldColor = Figure[Row][Column];
        Figure[Row][Column] = Color;
        
        if(Row < Figure.length-1){
            if(oldColor == Figure[Row+1][Column])
            Floodfill(Figure, Row + 1, Column, Color);
        }
        if(Column < Figure[Row].length-1){
            if(oldColor == Figure[Row][Column+1])
            Floodfill(Figure, Row, Column + 1, Color);
        }
        if(Row > 0){
            if(oldColor == Figure[Row-1][Column])
            Floodfill(Figure, Row - 1, Column, Color);
        }
        if(Column > 0){
            if(oldColor == Figure[Row][Column-1])
            Floodfill(Figure, Row, Column - 1, Color);
        }
        
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
