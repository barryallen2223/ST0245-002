public class Queens{
    static int TotalCases = 0;
    
    public int TotalCases(int Queens){
        this.Queen(new int[Queens][Queens], 0, 0, -1);
        int TotCas = TotalCases;
        TotalCases = 0;
        return TotCas;
    }
    
    public void Queens(int Queen, int BoardNumber){
        int[][] Board = new int[Queen][Queen];
        this.Queen(Board, 0, 0, BoardNumber);
        TotalCases = 0;
    }
    
    /**
     * @param Row: set Row = 0
     * @param Column: set Column = 0
     */
    private boolean Queen(int[][] Board, int Row, int Column, int BoardNumber){
        while(Row < Board.length){
            Board[Row][Column] = 1;
            
            //Casos en los cuales hay problemas
            if(this.TANP(Board, Row, Column)){
                if(Queen(Board, Row + 1, 0, BoardNumber))
                return true;
                else{
                    Board[Row][Column] = 0;
                    if(Column == Board.length - 1)
                    return false;
                    else Column++;
                }
            }
            else{
                Board[Row][Column] = 0;
                if(Column < Board.length - 1){
                    if(Queen(Board, Row, Column + 1, BoardNumber))
                    return true;
                    else
                    return false;
                    } else
                    return false;
            }
        }
        
        
        TotalCases++;
        
        if(BoardNumber == -1){
            return false;
        } else if(BoardNumber > 0){
            if(TotalCases == BoardNumber){
                this.Print(Board);
                return true;
            }
            else return false;
        }
        
        return false;
    }
    
    /**
     * TANP : There Are No Problems
     */
    private boolean TANP(int[][] Board, int Row, int Column){
        for(int h = 0; h < Row; h++){
            for(int l = 0; l < Board.length; l++){
                if(Board[h][l] == 1){
                    if(Math.abs(Column - l) == Math.abs(Row - h))
                    return false;
                    else if(Column == l)
                    return false;
                }
            }
        }
        
        return true;
    }
    
    /**
     * @param CP: ColumnPosition
     */
    private int CP(int Max, int ActualValue, int Add){
        if(ActualValue + Add > Max)
        return 0;
        else return ActualValue + Add;
    }
    
    private void Print(int[][] Arr){
        
        for(int z = 0; z < Arr.length; z++){
            for(int i = 0; i < Arr.length; i++){
                if(Arr.length == 1)
                System.out.println("[" + Arr[z][i] + "]");            
                else if(i == Arr.length - 1)
                System.out.println(Arr[z][i] + "]");
                else if(i == 0)
                System.out.print("[" + Arr[z][i] + ", ");
                else
                System.out.print(Arr[z][i] + ", ");
            }
        }
    }
}