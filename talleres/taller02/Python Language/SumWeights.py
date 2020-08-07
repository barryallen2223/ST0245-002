class SumWeights():

    def Weight(self, WeightValues, Target):
        return self.Auxiliar(WeightValues, Target, 0)

    def Auxiliar(self, WeightValues, Target, Start):
        if Start >= len(WeightValues):
            return True if Target == 0 else False
        else:
            if self.Auxiliar(WeightValues, Target - WeightValues[Start], Start + 1):
                return True
            Answer = list()
            if self.Auxiliar(self.Rewrite(WeightValues, Answer, 1), Target, Start):
                return True
            return False
    
    def Rewrite(self, Entry, Answer, Index):
        if Index >= len(Entry):
            return Answer
        Answer.append(Entry[Index])
        return self.Rewrite(Entry, Answer, Index + 1)

def main():
    Listt = SumWeights()
    myList = []
    i = int(1)
    myListLength = int(input("Set the total of elements: "))
    
    while i <= myListLength:
        print("Set the element number", i, "of the list")
        myList.append(float(input()))
        i += 1

    Result = Listt.Weight(myList, float(input("Set the Target: ")))
    if Result:
        print("There exists a combination between the elements equal to the target.")
    else:
        print("Doesn't exist a combination between the elements equal to the target.")

if __name__ == "__main__":
    main()