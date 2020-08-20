
public class MaxVolume
{
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
    
    public double[] proofs(int elements){
        double[] weights = new double[elements];
        for(int i = 0 ; i < elements ; i++ ){
            if ( i != elements-1){
                weights[i] = 0;
            } else{
                weights[i] = 1;
            }
        }
        return weights;
    }
    
    public static void main(String args[]){
        MaxVolume Mv = new MaxVolume();
        final int loop = 20;
        final int amount = 225;
        double[] weights = new double[amount*loop];
        for (int i = 1 ; i <= loop ; i++ ){
            weights = Mv.proofs(amount * i);
            double start = System.nanoTime();
            Mv.Weight(weights, 1);
            double end = System.nanoTime();
            System.out.println(((end-start) * (1.0e-9)) + " " + (amount * i));
        }
    }
}