class FloodFill():

    def PrintFill(self, Figure, Row, Column, Color):
        self.Print(self.Fill(Figure, Row, Column, Color), 0)
    
    def Fill(self, Figure, Row, Column, Color):
        return self.Floodfill(Figure, Row, Column, Color)
    
    def Floodfill(self, Figure, Row, Column, Color):

        if Row < len(Figure) and Column < len(Figure):
            if Color == Figure[Row][Column]: return Figure
        else: return Figure

        OldColor = Figure[Row][Column]
        Figure[Row][Column] = Color
        
        if Row < len(Figure) - 1:
            if OldColor == Figure[Row+1][Column]:
                self.Floodfill(Figure, Row + 1, Column, Color)
        if Row > 0:
            if OldColor == Figure[Row-1][Column]:
                self.Floodfill(Figure, Row - 1, Column, Color)
        if Column < len(Figure[Row]) - 1:
            if OldColor == Figure[Row][Column+1]:
                self.Floodfill(Figure, Row, Column + 1, Color)
        if Column > 0:
            if OldColor == Figure[Row][Column-1]:
                self.Floodfill(Figure, Row, Column - 1, Color)

        return Figure

    def Print(self, Entry, Swivel):
        if(Swivel < len(Entry)):
            print(Entry[Swivel])
            self.Print(Entry, Swivel + 1)

def main():
    Ff = FloodFill()
    ListMain = []
    print("Write each row of the matrix separated by spaces")
    print("Write False when you've finished of set the values of the matrix")

    while True:
        Lst = input()

        if Lst == "False": break

        ListMain.append(Lst.split())

    for i in range(len(ListMain)):
        for j in range(len(ListMain[i])):
            ListMain[i][j] = int(ListMain[i][j])
    
    Row = int(input("Set the Row you want to change (Starts in 0): "))
    Column = int(input("Set the Column you want to change (Starts in 0): "))
    Color = int(input("Set the color you want to use: "))
    
    Ff.PrintFill(ListMain, Row, Column, Color)

if __name__ == "__main__":
    main()