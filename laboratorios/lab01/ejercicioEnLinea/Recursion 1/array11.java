public class array11{
    public int array11(int[] nums, int index) {
        if(index<nums.length){
            if(nums[index] == 11) return 1 + array11(nums,index+1);
            return array11(nums,index+1);
        }
        return 0;
    }
}