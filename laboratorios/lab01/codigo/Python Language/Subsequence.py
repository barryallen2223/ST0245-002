import time
import sys
import resource  

resource.setrlimit(resource.RLIMIT_STACK, [0x10**9, resource.RLIM_INFINITY])
sys.setrecursionlimit(10**9)


class Subsequence():

    def SubseqLength(self, Sequence1, Sequence2):
        return len(self.CompareStrings(Sequence1, Sequence2, "", 0))

    def LongSubseq(self, Sequence1, Sequence2):
        return self.CompareStrings(Sequence1, Sequence2, "", 0)

    def CompareStrings(self, Sqq1, Sqq2, Answer, Swivel):
        if len(Sqq1) == 0 or len(Sqq2) == 0: return Answer
        else:
            if Swivel < len(Sqq2):
                if Sqq1[0] == Sqq2[Swivel]:
                    return self.CompareStrings(Sqq1[1:], self.Rewrite(Sqq2, Swivel), Answer + Sqq1[0], 0)
                else:
                    return self.CompareStrings(Sqq1, Sqq2, Answer, Swivel + 1)
        return self.CompareStrings(Sqq1[1:], Sqq2, Answer, 0)

    def Rewrite(self, Write, Index):
        if Index != 0 and Index < len(Write) - 1: return Write[0:Index] + Write[Index + 1:]
        elif Index == 0: return Write[1:]
        elif Index == len(Write) - 1: return Write[0:Index]
        return Write

def main(Start, Loops, Amount1, Amount2):
    Aux = Subsequence()
    for Loop in range(Start, Start+Loops):
        a = '0'
        b = 'a'
        Val = Amount1*Loop*a
        Val2 = Amount2*Loop*b
        start_time = time.time()
        Aux.SubseqLength(Val, Val2)
        print(time.time()-start_time, Amount1*Loop, Amount2*Loop)


if __name__ == "__main__":
    main(1,20,150,300)