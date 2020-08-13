class nQueens():

    TotalCases = int(0)

    def TotalOfCases(self, Queens):
        VoidList = []
        Board = self.Fulfill(VoidList.copy(), VoidList.copy(), Queens, Queens, 0, 0)
        self.Queen(Board, 0, 0, -1)
        TotCases = self.TotalCases
        self.TotalCases = 0
        return TotCases
    
    def Queens(self, Queen, BoardNumber):
        VoidList = []
        Board = self.Fulfill(VoidList.copy(), VoidList.copy(), Queen, Queen, 0, 0)
        self.Queen(Board, 0, 0, BoardNumber)
        self.TotalCases = 0
    
    def Queen(self, Board, Row, Column, BoardNumber):
        while Row < len(Board):
            Board[Row][Column] = 1

            if self.TANP(Board, Row, Column):
                if self.Queen(Board, Row + 1, 0, BoardNumber): return True
                else:
                    Board[Row][Column] = 0
                    if Column == len(Board) - 1: return False
                    else: Column += 1
            
            else:
                Board[Row][Column] = 0
                if Column < len(Board) - 1:
                    if self.Queen(Board, Row, Column + 1, BoardNumber): return True
                    return False
                else: return False

        self.TotalCases += 1

        if BoardNumber == -1: return False
        elif BoardNumber > 0:
            if self.TotalCases == BoardNumber:
                self.Print(Board, 0)
                return True
            else: return False

        return False

    def TANP(self, Board, Row, Column):
        for Rw in range(Row):
            for Bd in range(len(Board)):
                if Board[Rw][Bd] == 1:
                    if abs(Column - Bd) == abs(Row - Rw): return False
                    elif Column == Bd: return False
    
        return True

    def Fulfill(self, List, SwivelList, Rows, Columns, SwivelRows, SwivelColumns):
        if SwivelColumns < Columns:
            SwivelList.append(0)
            return self.Fulfill(List, SwivelList, Rows, Columns, SwivelRows, SwivelColumns + 1)
        else:
            if SwivelRows < Rows:
                List.append(SwivelList.copy())
                return self.Fulfill(List, SwivelList, Rows, Columns, SwivelRows + 1, SwivelColumns)
            else: return List
        
    def Print(self, Entry, Swivel):
        if(Swivel < len(Entry)):
            print(Entry[Swivel])
            self.Print(Entry, Swivel + 1)

def main():
    Void = int(input("Set the number of queens: "))
    nQ = nQueens()
    Method = int(input("Do you want to get a board or the total of posibilities?: \n"
                        "1. Total Posibilities.\n"
                        "2. A Board\n"))
    if Method == 1: print(nQ.TotalOfCases(Void))
    elif Method == 2:
        BoardNumber = int(input("Set the board number: "))
        nQ.Queens(Void, BoardNumber)

if __name__ == "__main__":
    main()