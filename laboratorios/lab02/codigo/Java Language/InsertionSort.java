public class InsertionSort
{
    public int[] insertionSort(int[] unsorted){
        for (int i = 1 ; i < unsorted.length ; i++){ // c1*n + c2
            for (int j = i ; j > 0 ; j--){ // c3 + c4*0
                if(unsorted[j-1] > unsorted[j]){
                   int temp = unsorted[j]; // c5
                   unsorted[j] = unsorted[j-1]; // c6
                   unsorted[j-1] = temp; // c7
                }
            }
        }
        return unsorted; // c8
        // T(n) = c1*n + c2 + c3 + c4*0 + c5 + c6 + c7
        // T(n) es O(n) 
    }
    
    public int[] filler(int length){
        int[] fArray = new int[length];
        for(int i = 0 ; i < length ; i++){
            fArray[i] = (int)(Math.random() * 10 + 1);
        }
        return fArray;
    }
    
    public static void main(String args[]){
        InsertionSort iSort = new InsertionSort();
        final int loop = 20;
        final int amount = 10000;
        for (int i = 1 ; i <= loop ; i++ ){
            int k = amount * i;
            double start = System.nanoTime();
            iSort.insertionSort(iSort.filler(k));
            double end = System.nanoTime();
            System.out.println(((end-start) * (1.0e-9)) + " " + Math.round(k));
        }
    }
    
}