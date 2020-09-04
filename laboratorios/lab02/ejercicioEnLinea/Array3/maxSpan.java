public int maxSpan(int[] nums) {
  return this.saveLast(nums, new int[2]);
}

public int saveLast(int[] nums, int[] cof){
  
  for(int pos = 0; pos < nums.length - cof[0]; pos++){
    
    if(nums[pos] == cof[1])
      continue;
    
    for(int n = nums.length-1; n >= pos; n--){
      if(nums[pos] == nums[n]){
        cof[0] = Math.max(n - pos + 1, cof[0]);
        cof[1] = (cof[0] == n - pos + 1) ? n : cof[1];
      }
    }
    
  }
  return cof[0];
}
