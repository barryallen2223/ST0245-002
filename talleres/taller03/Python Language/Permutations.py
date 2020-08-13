class Permutations():

    def PrintPermutations(self, Entry):
        VoidList = []
        self.Permutate(Entry, "", VoidList, 0)
        print(VoidList)

    def Permutations(self, Entry):
        VoidList = []
        self.Permutate(Entry, "", VoidList, 0)
        return VoidList

    def Permutate(self, Entry, Answer, Permutations, Swivel):
        if len(Entry) > 0:
            self.Permutate(self.reWrite(Entry, 0), Answer + Entry[0], Permutations, 0)
            Swivel = 0
            while Swivel < len(Entry) - 1:
                Swivel+=1
                self.Permutate(self.reWrite(Entry, Swivel), Answer + Entry[Swivel], Permutations, Swivel - 1)
        else: Permutations.append(Answer)
    
    def reWrite(self, Write, QuitIndex):
        if QuitIndex != 0 and QuitIndex < len(Write) - 1:
            return Write[0:QuitIndex] + Write[QuitIndex+1:]
        elif QuitIndex == 0: return Write[1:]
        elif QuitIndex == len(Write) - 1: return Write[0:QuitIndex]
        return Write

def main():
    Permut = Permutations()
    OriginalString = input("Permutate the next string: ")
    Permut.PrintPermutations(OriginalString)

if __name__ == "__main__":
    main()