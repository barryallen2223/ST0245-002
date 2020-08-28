import time

class Sort():

    def InsertionSort(self, unsorted):
        for i in range(1, len(unsorted)):
            for j in range(i, 0, -1):
                if unsorted[j-1] > unsorted[j]:
                    temp = unsorted[j]
                    unsorted[j] = unsorted[j-1]
                    unsorted[j-1] = temp
        return unsorted

def main(start, loops, index):

    sa = Sort()

    for loop in range(start, loops + start + 1):

        unsorted = []
        for loope in range(0, loop*index):
            unsorted.append(index - loope)
        
        start_time = time.time()
        sa.InsertionSort(unsorted)
        end_time = time.time() - start_time
        print(index*loop, end_time)
        

if __name__ == "__main__":
    main(1, 20, 2500)