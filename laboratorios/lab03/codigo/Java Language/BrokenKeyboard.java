import java.util.LinkedList;
import java.util.Scanner;
public class BrokenKeyboard
{
    public LinkedList beijuText(String s1, String s2){
        LinkedList<String> ll = new LinkedList();
        if(s1.length() == s2.length()){
            for(int i = 0 ; i < s1.length() ; i++){
                if(s1.charAt(i) != s2.charAt(i)){
                    ll.add(Character.toString(s1.charAt(i)));
                }
            }
        }
        return s1.length() == s2.length() ? ll : null;
    }

    public static void main(String args[]){
        BrokenKeyboard bk = new BrokenKeyboard();
        Scanner sc = new Scanner(System.in);
        System.out.print("Ingrese el string 1: ");
        String s1 = sc.next();
        System.out.print("Ingrese el string 2: ");
        String s2 = sc.next();
        LinkedList<String> ll = bk.beijuText(s1, s2);
        if(ll != null){
            System.out.print("Missing keys: ");
            for(int i = 0 ; i < ll.size() ; i++){
                System.out.print("[" + ll.get(i) + "] ");
            }
        } else{
            System.out.println("Los strings son de diferente longitud");
        }
        
    }
}
