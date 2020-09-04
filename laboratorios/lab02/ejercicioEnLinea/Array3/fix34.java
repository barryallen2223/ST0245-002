public int[] fix34(int[] nums) {
  return this.fixPos(nums, 0);
}

public int[] fixPos(int[] nums, int pos){
  
  for(int i = 0; i < nums.length; i++){
    if(nums[i] == 3){
      for(int j = pos; j < nums.length; j++){
        if(nums[j] == 4){
          int ret = nums[i+1];
          nums[i+1] = nums[j];
          nums[j] = ret;
          pos = j+1;
          break;
        }
      }
    }
  }
  
  return nums;
}
