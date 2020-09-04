public class MergeSort
{
    void merge(int arr[], int left, int m, int right){
        int n1 = (m - left) + 1, n2 = right - m;
        int[] l = new int[n1], r = new int[n2];
        for(int i = 0 ; i < n1 ; i++){
            l[i] = arr[left + i];
        }
        for(int j = 0 ; j < n2 ; j++){
            r[j] = arr[m + 1 + j];
        }
        int i = 0, j = 0, k = left;
        while(i < n1 && j < n2 ){
            // Compara los elementos de los sub-arreglos y los une
            if(l[i] <= r[j]){
                arr[k] = l[i];
                i++;
            }
            else{
                arr[k] = r[j];
                j++;
            }
            k++;
        }
        while(i < n1){
            arr[k] = l[i];
            i++;
            k++;
        }
        while(j < n2){
            arr[k] = r[j];
            j++;
            k++;
        }
    }
    void mergeSort(int arr[], int left, int right){
        if(left < right){
            int m = left + (right - left)/2;
            mergeSort(arr, left, m);
            mergeSort(arr, m+1, right);
            
            merge(arr, left, m, right);
        }
    }
    
    public int[] filler(int length){
        int[] fArray = new int[length];
        for(int i = 0 ; i < length ; i++){
            fArray[i] = (int)(Math.random() * 10 + 1);
        }
        return fArray;
    } 
  
    public static void main(String args[]){
        MergeSort mSort = new MergeSort();
        final int loop = 20;
        final int amount = 10000;
        for (int i = 1 ; i <= loop ; i++ ){
            int k = amount * i;
            double start = System.nanoTime();
            mSort.mergeSort(mSort.filler(k), 0, k-1);
            double end = System.nanoTime();
            System.out.println(((end-start) * (1.0e-9)) + " " + Math.round(k));
        }
    } 
}
