import java.util.List;
import java.util.LinkedList;
import java.util.Scanner;

public class ListaEnlazada
{
    public LinkedList add(LinkedList pos, int index, int val){
        pos.add(index, val);
        return pos;
    }
    public LinkedList delete(LinkedList pos, int index){
        pos.remove(index);
        return pos;
    }
    public int search(LinkedList pos, int elem){
        int ans = -1;
        for(int i = 0 ; i < pos.size() ; i++){
            if((int)pos.get(i) == elem){
                ans = i;
            }
        }
        return ans;
    }
    public static void main(String args[]){
        ListaEnlazada le = new ListaEnlazada();
        LinkedList<Double> pos = new LinkedList();
        Scanner sc = new Scanner(System.in);
        int ans;
        boolean gtfo = false;
        while(!gtfo){
            System.out.print("1. Agregar posicion\n");
            System.out.print("2. Eliminar posicion\n");
            System.out.print("3. Buscar elemento\n");
            System.out.print("4. Mostrar Lista Enlazada\n");
            System.out.print("0. Salir\n");
            ans = sc.nextInt();
            switch(ans){
                case 1: 
                    System.out.print("Ingrese el valor \n");
                    int val = sc.nextInt();
                    if(pos.size() == 0){
                       le.add(pos, 0, val);
                       continue;
                    }
                    System.out.print("Ingrese la posicion \n");
                    int ind = sc.nextInt();
                    
                    while(ind>pos.size()){
                        System.out.print("Posicion incorrecta \n");
                        System.out.print("Ingrese la posicion \n");
                        ind = sc.nextInt(); 
                    }
                    le.add(pos, ind, val);
                    break;
                case 2:
                    if(pos.size() != 0){
                        System.out.print("Ingrese la posicion \n");
                        ind = sc.nextInt();
                        while(ind>pos.size()){
                            System.out.print("Posicion incorrecta \n");
                            System.out.print("Ingrese la posicion \n");
                            ind = sc.nextInt(); 
                        }
                    
                        le.delete(pos, ind);
                    }
                    else{System.out.println("Lista vacía");}
                    break;
                case 3:
                    if(pos.size() != 0){
                        System.out.print("Ingrese el elemento a buscar \n");
                        int elem = sc.nextInt();                    
                        int answ = le.search(pos, elem);
                        if(answ == -1){
                            System.out.print("El elemento no esta \n");
                        }
                        else{
                            System.out.print(elem + " esta en la posicion " + answ + "\n");
                        }
                    }
                    else{System.out.println("Lista vacía");}
                case 4:
                    if(pos.size()==0){System.out.println("Lista vacía");}
                    for(int i = 0 ; i < pos.size() ; i++){
                        System.out.print("["+pos.get(i)+"]→");
                    }
                    System.out.print("\n");
                    break;
                case 0:
                    gtfo = true;
                    break;
            }
        }
    }
}
