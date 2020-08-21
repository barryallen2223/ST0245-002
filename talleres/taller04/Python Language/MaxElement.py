import time
import sys
sys.setrecursionlimit(10**6)

class MaxElement():

    def find_maximum(self, elements):
        return self.maximum_element(elements, elements[0], 0)

    def maximum_element(self, elements, maximum, swivel):

        if swivel < len(elements):
            if elements[swivel] > maximum:
                maximum = elements[swivel]
            return self.maximum_element(elements, maximum, swivel + 1)
        else: return maximum

    def proofs(self, elements):

        elements_list = []

        for i in range(elements):
            elements_list.append(i)
        
        return elements_list


def main(start, loops, amount):

    Mx = MaxElement()

    for loop in range(start,loops+start):

        el = amount*loop
        elements = Mx.proofs(el)
        start_time = time.time()
        Mx.find_maximum(elements)
        print(time.time() - start_time)
        #print(el)


if __name__ == "__main__":
    #limit for amount is 1046 (elements) when loops is equal to 20
    main(20900, 20, 1)