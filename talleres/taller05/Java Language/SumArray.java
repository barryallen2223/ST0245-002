class SumArray{
    
    
    private int sum(int[] array){
        int acum = 0;
        for (int i = 0; i < array.length; i++)
            acum = acum + array[i];
        return acum;
    }
    
    public int recSum(int[] array, int pos){
        if(pos == array.length)
        return 0;
        else return array[pos] + recSum(array, pos+1);
    }
                  
    public static void main(String[] args){
        SumArray yo = new SumArray();
        int Start = 1, Loops = 20;
        int Amount = 1553370000/21;
        for(int Loop = Start; Loop <= Start + Loops; Loop++){ 
            long ti = System.currentTimeMillis();
            yo.sum(new int[Loop*Amount]);
            long tf = System.currentTimeMillis();
            long tik = System.currentTimeMillis();
            yo.recSum(new int[Loop*Amount], 0);
            long tfk = System.currentTimeMillis();
            System.out.println(tf-ti + " " + (tfk-tik) + " " + Loop*Amount);
        }
    }
}