class HanoiTowers():

    def HanoiTowers(self, Towers):
        self.Auxiliar(Towers, 1, 2, 3)
    
    def Auxiliar(self, Towers, Start, Intermediate, End):
        if Towers > 1:
            self.Auxiliar(Towers - 1, Start, End, Intermediate)
            print("Tower from", Start, "to", End)
            self.Auxiliar(Towers - 1, Intermediate, Start, End)
        else: print("Tower from", Start, "to", End)

def main():
    Hanoi = HanoiTowers()
    Towers = int(input("Set number of towers: "))
    Hanoi.HanoiTowers(Towers)

if __name__ == "__main__":
    main()