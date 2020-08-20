import java.util.Random;

public class MaxElement
{
    public void time(){
        double start = System.nanoTime();
        double end = System.nanoTime();
        System.out.println("Tiempo: " + ((end-start) * (1.0e-9)));
    }

    public int find_maximum(int[] elements){
        return maximum_element(elements, elements[0], 0);
    }

    public int maximum_element(int[] elements, int maximum, int swivel){
        if (swivel < elements.length ){
            if (elements[swivel] > maximum){
                maximum = elements[swivel];
            }
            return maximum_element(elements, maximum, swivel + 1);
        }
        else{
            return maximum;
        }
    }

    public int[] proofs(int elements){
        int[] elements_list = new int[elements];
        for(int i = 0 ; i < elements ; i++ ){
            elements_list[i] = i;
        }
        return elements_list;
    }

    public static void main(String args[]){
        MaxElement Mx = new MaxElement();
        final int loop = 20;
        final int amount = 800;
        int[] elements = new int[amount*loop];
        for (int i = 1 ; i <= loop ; i++ ){
            elements = Mx.proofs(amount * i);
            double start = System.nanoTime();
            Mx.find_maximum(elements);
            double end = System.nanoTime();
            System.out.println(((end-start) * (1.0e-9)) + " " + (amount * i));
        }
    }
}
