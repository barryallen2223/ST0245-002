public boolean more14(int[] nums) {
  int cont1 = 0, cont2 = 0;
  for(int i = 0 ; i < nums.length ; i++){
    if(nums[i] == 1){
      cont1++;
    }
    if(nums[i] == 4){
      cont2++;
    }
  }
  if(cont1 > cont2){
    return true;
  }
  return false;
}

