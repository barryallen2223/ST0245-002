import time

class SumArray():

  def sumArray(self, array):
    sum = 0
    for i in range(0, len(array)):
      sum += array[i]
    return sum

def main(start, loops, index):

    sa = SumArray()

    
    for loop in range(20, 22):

        arrayn = []

        arrayn = arrayn + [0]*(loop*index)

        start_time = time.time()
        sa.sumArray(arrayn)
        end_time = time.time() - start_time
        print(end_time, len(arrayn))

if __name__ == "__main__":
    main(1, 20, 7397000)