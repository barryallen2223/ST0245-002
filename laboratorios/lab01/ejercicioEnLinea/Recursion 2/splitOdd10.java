public class splitOdd10{
    public boolean splitOdd10(int[] nums) {
       return this.split(nums, 0, 0, 0);
    }
    
    public boolean split(int[] nums, int fgroup, int sgroup, int level){
       if(level < nums.length){
          if(split(nums, fgroup + nums[level], sgroup, level+1) || 
            split(nums, fgroup, sgroup + nums[level], level+1))
          return true;
       }
      
       if(sgroup + fgroup == this.sumArr(nums)){
         if((sgroup%10 == 0 && fgroup%2 == 1) || (fgroup%10 == 0 && sgroup%2 == 1))
         return true;
         return false;
       }
       return false;
    }
        
    public int sumArr(int[] arr){
       int k = 0;
        for(int i = 0; i < arr.length; i++){
          k+=arr[i];
       }
       return k;
    }
}