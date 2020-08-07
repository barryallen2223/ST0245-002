class EuclidesAlgorithm():

    def FindGreatestCommonDivisor(self, FirstValue, SecondValue):
        Minor = min(FirstValue, SecondValue)
        Mayor = max(FirstValue, SecondValue)

        return self.FindGreatestCommonDivisor(Mayor, Mayor % Minor) if Mayor % Minor != 0 else Minor

def main():
    EucAlg = EuclidesAlgorithm()
    FirstValue = int(input("Set the first value: "))
    SecondValue = int(input("Set the second value: "))
    print("The Greatest Common Divisor between", FirstValue, "and", SecondValue, "is:", EucAlg.FindGreatestCommonDivisor(FirstValue, SecondValue))

if __name__ == "__main__":
    main()