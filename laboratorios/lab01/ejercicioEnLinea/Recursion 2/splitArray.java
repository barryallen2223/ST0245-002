public class splitArray{
    public boolean splitArray(int[] nums) {
       return this.split(nums, 0, 0, 0);
    }
    
    public boolean split(int[] nums, int fgroup, int sgroup, int level){
       if(level < nums.length){
          if(split(nums, fgroup + nums[level], sgroup, level+1) || 
          split(nums, fgroup, sgroup + nums[level], level+1))
          return true;
       }
       
       if(sgroup + fgroup == this.sumArr(nums)){
           if(sgroup == fgroup) return true;
           return false;
       }
       return false;
    }
    
    public int sumArr(int[] arr){
        int allElem = 0;
        for(int i = 0; i < arr.length; i++){
            allElem+=arr[i];
        }
        return allElem;
    }
}