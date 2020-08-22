public class nestParen{
    
    public boolean nestParen(String str) {
  
        if(str.length() <= 1) return true;
  
        if(str.length()%2 == 0){
            if(str.charAt(0) == '(' && str.charAt(str.length() - 1) == ')')
            return nestParen(str.substring(1,str.length()-1));
            return false;
        }
        return false;
    } 
    //T(n) = c_1\cdot n + c_2, n the length of the string
}