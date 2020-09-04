public boolean only14(int[] nums) {
  int cont=0;
  for(int i = 0 ; i < nums.length ; i++){
    if(nums[i]== 1){
      cont++;
    }
    if(nums[i]== 4){
      cont++;
    }
  }
  if(cont == nums.length){
    return true;
  }
  return false;
}
