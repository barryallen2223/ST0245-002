
public class count8
{
    public int count8(int n) {
      int m = n/10;
      if(n<1) {
        return 0;
      }
      if (n%100 == 88) {
        return 2+count8(n/10);
      }
      else if(n%10 == 8){
        return 1+count8(n/10);
      }
      else{
        return count8(n/10);
      }
    }
}
