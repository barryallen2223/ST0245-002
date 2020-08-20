
public class Fibonacci
{
    public int fibonacci(int n) {
        if ( n == 0 ) return 0;
        if ( n == 1 ) return 1;
        return fibonacci(n-1) + fibonacci(n-2);
    }
        
    public static void main(String args[]){
        Fibonacci F = new Fibonacci();
        final int loop = 20;
        final float amount = 2.55f;
        for (float i = 1 ; i <= loop ; i++ ){
            float k = amount * i;
            double start = System.nanoTime();
            F.fibonacci(Math.round(k));
            double end = System.nanoTime();
            System.out.println(((end-start) * (1.0e-9)) + " " + Math.round(k));
        }
    }
}
