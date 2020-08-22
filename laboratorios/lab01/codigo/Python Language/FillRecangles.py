import time
import sys
sys.setrecursionlimit(10**6)

class FillRectangles():

    def FillRectangle(self, forms):
        return self.auxFill(forms, 0)**2 - 1
    
    def auxFill(self, forms, swivel):
        if forms > 1:
            return self.auxFill(forms-2, swivel) + self.auxFill(forms-1, swivel)
        return swivel + 1

def main():
    com = FillRectangles()
    print(com.FillRectangle(3))

if __name__=="__main__":
    main()