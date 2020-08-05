public class Genoma
{   
    public int main(String sub1, String sub2){
        return this.subsecuencia(sub1, sub2, 0, 0);
    }
    
    private int subsecuencia(String sub1, String sub2, int cont, int index){
        if (sub1.length() == 0 || sub2.length() == 0){
            return cont;
        }
        else {
            if (index <= sub2.length()-1){
                if (sub1.charAt(0) != sub2.charAt(index)){
                    return subsecuencia(sub1, sub2, cont, index+1);
                }
                else {
                    return subsecuencia(sub1.substring(1), this.idk(sub2, index), cont+1, 0);
                }
            }
            else{
                return subsecuencia(sub1.substring(1), sub2, cont, 0);
            }
        }
    }
    
    private String idk (String s, int indez){
        if (indez != 0 && indez < s.length() -1){
            return s.substring(0,indez) + s.substring(indez + 1);
        }
        else if (indez == 0){
            return s.substring(1);
        }
        else if (indez == s.length() -1){
            return s.substring(0, indez);
        }
        return s;
    }
}
