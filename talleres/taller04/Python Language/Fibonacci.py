import time
import sys
sys.setrecursionlimit(10**6)

class Fibonacci():

    def fibonacci(self, index):

        if(index < 3):
            return 1
        else:
            return self.fibonacci(index-1)+self.fibonacci(index-2)

def main(start, loops, index):

    fib = Fibonacci()

    for loop in range(start,loops+start):
        start_time = time.time()
        fib.fibonacci(index*loop)
        print(time.time()-start_time, index*loop)
        #print(index*loop)


if __name__=="__main__":
    main(22, 20, 1)