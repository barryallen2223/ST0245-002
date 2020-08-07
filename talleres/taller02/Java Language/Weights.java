public class Weights{
    
    public boolean Weight(double[] Weights, double Target){
        return auxWeight(Weights, Target, 0);
    }
    
    private boolean auxWeight(double[] WeightsValues, double Target, int Start){
        if(Start >= WeightsValues.length)
        return (Target == 0) ? true : false;
        else{
            if(auxWeight(WeightsValues, Target - WeightsValues[Start], Start + 1))
            return true;
            if(auxWeight(this.Rewrite(WeightsValues, new double[WeightsValues.length - 1], 1, 0), Target, Start))
            return true;
            return false;
        }
    }
    
    private double[] Rewrite(double[] Entry, double[] Answer, int n, int index){
        if(n >= Entry.length)
        return Answer;
        Answer[index] = Entry[n];
        return Rewrite(Entry, Answer, n+1, index+1);
    }
}