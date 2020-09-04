
public class seriesUp
{
    public int[] seriesUp(int n) {
        int length = (n*(n+1))/2, cont=0;
        int[] arr = new int[length];
        for(int i=1 ; i <= n ; i++){
            for(int j=1 ; j <= i ; j++){
                arr[cont++] = j;
            }
        }
        return arr;
    }

}
