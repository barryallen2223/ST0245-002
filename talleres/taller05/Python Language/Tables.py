import time

class Tables():

    def Multiplication(self, last_element = int()):

        tables = []
        row_n = []

        for row in range(0, last_element + 1):
            for col in range(0, last_element + 1):
                row_n.append((row+1)*(col+1))
            tables.append(row_n)
    
def main(start = int(), loops = int(), amount = int()):

    tab = Tables()

    for loop in range(loops+1, loops+2):
        start_time = time.time()
        tab.Multiplication(start + loop*amount)
        end_time = time.time() - start_time
        print(end_time, start + loop*amount)


if __name__== "__main__":
    main(3000, 20, 600)
