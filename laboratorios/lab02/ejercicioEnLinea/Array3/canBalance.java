public boolean canBalance(int[] nums) {
  int sum1=0, sum2=0;
  if(nums.length==1){
    return false;
  }
  for(int i = 0 ; i < nums.length ; i++){
    sum1+= nums[i];
    sum2=0;
    for(int j = nums.length-1 ; j > i ; j--){
      sum2+= nums[j];
    }
    if(sum1==sum2)return true;
  }
  return false;
}

