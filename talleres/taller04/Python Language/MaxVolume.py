import time
import sys
sys.setrecursionlimit(10**6)

class MaxVolume():

    def Volume(self, VolumeValues, Target):
        return self.Auxiliar(VolumeValues, Target, 0)

    def Auxiliar(self, VolumeValues, Target, Start):
        if Start >= len(VolumeValues):
            return True if Target == 0 else False
        else:
            if self.Auxiliar(VolumeValues, Target - VolumeValues[Start], Start + 1):
                return True
            if self.Auxiliar(self.Rewrite(VolumeValues, [], 1), Target, Start):
                return True
            return False

    def Rewrite(self, Entry, Answer, Index):
        if Index >= len(Entry):
            return Answer
        Answer.append(Entry[Index])
        return self.Rewrite(Entry, Answer, Index + 1)

    def Proofs(self, Elements):
        Volumes = []
        for Element in range(1, Elements+1):
            if Element < Elements:
                Volumes.append(0)
            else: Volumes.append(1)
        return Volumes


def main(loops, amount):

    for loop in range(1,loops+1):

        Mv = MaxVolume()

        elements = Mv.Proofs(round(loop*amount))
        start_time = time.time()
        Mv.Volume(elements, 2)
        print(time.time() - start_time)
        #print(round(loop*amount))


if __name__ == "__main__":
    main(20, 23/20)