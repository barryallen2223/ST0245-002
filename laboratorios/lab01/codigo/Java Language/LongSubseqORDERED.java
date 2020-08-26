import java.util.*;
import java.lang.Math;

public class LongSubseqORDERED{
    
    public int CallSub(String str1, String str2){
        Subsequence(str1, str2, str1, str2, 0, 0);
        return 0;
    }
    
    public int Subsequence(String str1, String str2, String subO, String subT, int relMax, int absMax){
        
        if(str1.length() > absMax - relMax){
            
            String sub1 = str1.substring(1);
            String sub2 = str2.substring(str2.indexOf(str1.charAt(0)));
            return Subsequence(str1, str2, sub1, sub2, relMax+1, absMax);
            
        } else{
            return absMax;
        }
    }
    
    private String filter(String str1, String str2, String answer, int swivel) {
        if(str1.length() == 0 || str2.length() == 0)
            return answer;
        if(swivel < str2.length()){
            if(str1.charAt(0) == str2.charAt(swivel))
                return filter(str1.substring(1), this.reWrite(str2, swivel), answer + str1.charAt(0), 0);
            return filter(str1, str2, answer, swivel + 1);
        }
        return filter(str1.substring(1), str2, answer, 0);
    }
    
    public String longSubseq(String str1, String str2){
        return auxSubseq(str1, str2, "");
    }
    
    private String auxSubseq(String str1, String str2, String answer) {
        if(str1.length() == 0 || str2.length() == 0){
            return answer;
        }
        if(str1.charAt(0) == str2.charAt(0))
        return auxSubseq(str1.substring(1), str2.substring(1), answer + str1.charAt(0));
        
        String str11 = auxSubseq(str1.substring(1), str2, answer);
        String str22 = auxSubseq(str1, str2.substring(1), answer);
        return (str11.length() > str22.length()) ? str11 : str22;
    }
    
    private String reWrite(String write, int Elim){
        if(Elim != 0 && Elim < write.length()-1)
        return write.substring(0,Elim) + write.substring(Elim+1);
        else if(Elim == 0)
        return write.substring(1);
        else if(Elim == write.length()-1)
        return write.substring(0,Elim);
        return write;
    }
    
    private String proofs(int f, String chars){
        String fhelp = chars;
        for(int i = 0; i < f; i++)
        chars += fhelp;
        return chars;
    }
    
    public static void main(String[] args){
        
        LongSubseq Prof = new LongSubseq();
        
        String first = "abg", second = "dsareisahgba";
        int Start = 1, Loops= 1, Amount = 3;
        
        for (int Loop = Start; Loop <= Start+Loops; Loop++){
            first = Prof.proofs(Loop*Amount, first);
            long start = System.currentTimeMillis();
            //second = Prof.proofs(Loop*Amount, second);
            //first = Prof.filter(first, second, "", 0);
            second = Prof.filter(second, first, "", 0);
            System.out.println(Prof.longSubseq(first, second));
            long end = System.currentTimeMillis();
            long elapsedTime = end - start;
            System.out.println(elapsedTime);
            first = "abghasierasd";
            second = "dsareisahgba";
            //Xss in 2000: hasta 7000 chars de cada string.
        }

//        LongSubseq Prof = new LongSubseq();
//        
//        String a = "ayjktq", b = "jtkayq";
//        Prof.CallSub(a, b);
    }
}
