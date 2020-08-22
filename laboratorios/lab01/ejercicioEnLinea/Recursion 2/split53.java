public class split53{
    
    public boolean split53(int[] nums) {
        return this.split(nums, 0, 0, 0);
    }
    
    public boolean split(int[] nums, int fgroup, int sgroup, int level){
        if(level < nums.length){
        
            int div5 = (nums[level]%5 == 0) ? nums[level] : 0;
            int div3 = (nums[level]%3 == 0 && nums[level]%5 != 0) ? nums[level] : 0;
            int sum = (div5 == 0 && div3 == 0) ? nums[level] : 0;
        
            if(split(nums, fgroup + sum + div5, sgroup, level+1) || 
            split(nums, fgroup, sgroup + sum + div3, level+1))
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
