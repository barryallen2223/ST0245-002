class Combinations():

    def TotalCombinations(self, Objects):
        CombinationsList = []
        VoidList = []
        return self.SumOfLists(CombinationsList, VoidList, self.AllBinomial(Objects, 1), 0)
    
    def AllBinomial(self, Objects, Index):
        if Index < len(Objects):
            SumArrays = []
            return self.SumOfLists(SumArrays, self.Combinational(Objects, Index), self.AllBinomial(Objects, Index + 1), 0)
        else: return self.Combinational(Objects, len(Objects))
    
    def Combinational(self, Objects, Subgroup):
        ListOfLists = []
        Positions = []
        return self.RecursiveCombinational(Objects, Subgroup, ListOfLists, Positions, 0, 0)
    
    def RecursiveCombinational(self, Objects, Subgroup, ObjectPositions, Positions, Index, SubIndex):
        if Index == self.TotalBinomial(len(Objects), Subgroup):
            return ObjectPositions
        if SubIndex < Subgroup:
            ListOfPositions = self.PositionsCombinations(len(Objects), Subgroup)
            Posit = ListOfPositions[Index][SubIndex]
            Positions.append(Objects[Posit])
        if SubIndex == Subgroup:
            ObjectPositions.append(Positions)
            VoidList = []
            return self.RecursiveCombinational(Objects, Subgroup, ObjectPositions, VoidList, Index + 1, 0)
        Val = SubIndex
        return self.RecursiveCombinational(Objects, Subgroup, ObjectPositions, Positions, Index, Val + 1)

    def PositionsCombinations(self, Total, Subgroup):
        PositionsList = []
        Adding = self.RangeList(PositionsList.copy(), Subgroup, 0)
        self.AuxiliarPositions(0, Total - 1, PositionsList, Adding, 0)
        return PositionsList
    
    def AuxiliarPositions(self, Swivel, Total, Positions, Position, LoopIndex):
        if Swivel == len(Position):
            Positions.append(Position.copy())
        else:
            Limit = min(Total + 1, Total + 2 - len(Position) + Swivel)
            for Level in range(LoopIndex, Limit):
                Position[Swivel] = Level
                self.AuxiliarPositions(Swivel + 1, Total, Positions, Position, Level + 1)
        
    def SumOfLists(self, Answer, FirstList, SecondList, Swivel):
        if Swivel < len(FirstList):
            ObjectList = []
            Answer.append(self.SetEqual(ObjectList, FirstList, Swivel, 0))
            return self.SumOfLists(Answer, FirstList, SecondList, Swivel + 1)
        elif len(FirstList) <= Swivel < len(FirstList) + len(SecondList):
            ObjectList = []
            Answer.append(self.SetEqual(ObjectList, SecondList, Swivel - len(FirstList), 0))
            return self.SumOfLists(Answer, FirstList, SecondList, Swivel + 1)
        return Answer
    
    def SetEqual(self, Answer, List, Row, Column):
        if Column < len(List[Row]):
            Answer.append(List[Row][Column])
            return self.SetEqual(Answer, List, Row, Column + 1)
        else: return Answer

    def RangeList(self, Entry, Size, Index):
        if Index == Size: return Entry
        else:
            Entry.append(0)
            return self.RangeList(Entry, Size, Index + 1)

    def Split(self, Objects, Split, Index):
        if len(Objects) < 1: return Split
        Split[Index] = Objects[Index]
        return self.Split(Objects[0:Index], Split, Index - 1)
    
    def Factorial(self, Value):
        if Value == 0 or Value == 1: return 1
        else: return Value*self.Factorial(Value-1)
    
    def TotalBinomial(self, FirstValue, SecondValue):
        Minor = min(FirstValue, SecondValue)
        Mayor = max(FirstValue, SecondValue)
        return self.Factorial(Mayor)/(self.Factorial(Mayor - Minor)*self.Factorial(Minor))

def main():
    CombinationElements = Combinations()
    while True:
        Input = int(input("Choose you input type: \n0. Input type String. \n1. Input type List.\n"))
        if 0 <= Input <= 1: break
        else: print("Error. Try Again\n")
    
    if Input == 0:
        Elements = input("Write the String\n")
        Listt = CombinationElements.RangeList([], len(Elements), 0)
        CharList = CombinationElements.Split(Elements, Listt, len(Elements) - 1).copy()
        print(CombinationElements.TotalCombinations(CharList))
    if Input == 1:
        Dimension = int(input("Set the number of elements of the List: "))
        Listt = []
        for count in range(Dimension):
            Error = count + 1
            Cp = "Set the element number " + str(Error) + " in the List: "
            Listt.append(input(Cp))
        print(CombinationElements.TotalCombinations(Listt))


if __name__ == '__main__':
    main()