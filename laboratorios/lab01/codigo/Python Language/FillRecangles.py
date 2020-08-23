import time
import sys
sys.setrecursionlimit(10**6)

class FillRectangles():
    
    def FillRectangle(self, total_cases):
        if total_cases > 1:
            return self.FillRectangle(total_cases-2) + self.FillRectangle(total_cases-1)
        return 1

def main():
    
    com = FillRectangles()
    total_cases = int(input())
    print(com.FillRectangle(total_cases))

if __name__ == '__main__':
    main()
