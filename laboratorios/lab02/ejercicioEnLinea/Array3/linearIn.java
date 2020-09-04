public boolean linearIn(int[] outer, int[] inner) {
  int cont = 0;
  for(int i = 0 ; i < inner.length ; i++){
    for(int j = 0 ; j < outer.length ; j++){
      if(inner[i] == outer[j]){
        cont++;
        break;
      }
    }
  }
  if(cont == inner.length) return true;
  return false;
}
