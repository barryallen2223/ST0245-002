public int maxSpan(int[] nums) {
  int cont=0;
  if(nums.length==0)return 0;
  if(nums[0]!=nums[nums.length-1]){
    for(int i = 1 ; i < nums.length ; i++){
      cont++;
    }
  }
  else if(nums[0]==nums[nums.length-1]){
    for(int i = 0 ; i < nums.length ; i++){
      cont++;
    }
  }
  return cont;
}
