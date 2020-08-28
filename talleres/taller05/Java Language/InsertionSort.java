public class InsertionSort{
    
    public int[] InsertionSort(int[] elements){
        for(int pos = 0; pos < elements.length-1; pos++){
            if(elements[pos] > elements[pos+1]){
                for(int min = 0; min <= pos; min++){
                    if(elements[pos+1] < elements[min]){
                        this.Swap(elements, pos+1, min);
                    }
                }
            }
        }
        
        return elements;
    }
    
    private void Swap(int[] Arr, int el1, int el2){
        int elS = Arr[el1];
        Arr[el1] = Arr[el2];
        Arr[el2] = elS;
    }
    
    private int[] Create(int End){
        int[] ret = new int[End];
        ret[0] = End;
        for(int i = 1; i < End; i++){
            ret[i] = i;
        }
        return ret;
    }
    
    public static void main(String[] args){
        InsertionSort create = new InsertionSort();
        
        create.InsertionSort(create.Create(24000));
        create.InsertionSort(create.Create(12000));
        
        int Start = 1, Loops = 20, Amount = 25000;
        
        for(int Loop = Start; Loop <= Loops + Start; Loop++){
            int[] a = create.Create(Loop*Amount);
            long ti = System.currentTimeMillis();
            create.InsertionSort(a);
            long tf = System.currentTimeMillis();
            System.out.println(tf-ti + " " + Loop*Amount);
        }
    }
}