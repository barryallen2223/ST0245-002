
import java.util.List;
import java.util.LinkedList;
import java.util.Scanner;

public class Neveras
{
    static int longitud = 0;
    public LinkedList add(LinkedList pos, String codesc, int opc){
        if(opc == 0){
            pos.add(codesc);
            longitud++;
        } else{
            pos.add(codesc);
        }
        
        return pos;
    }
    public LinkedList delete(LinkedList pos){
        pos.remove(0);
        return pos;
    }
    public static void main(String args[]){
        LinkedList<String> almacen = new LinkedList();
        LinkedList<String> solicitudes = new LinkedList();
        Neveras nv = new Neveras();
        Scanner sc = new Scanner(System.in);
        String codesc = "";
        int ans;
        boolean gtfo = false;
        while(!gtfo){
            System.out.print("1. Ingresar nevera\n");
            System.out.print("2. Ingresar solicitudes\n");
            System.out.print("3. Mostrar Bodega\n");
            System.out.print("4. Mostrar pedido\n");
            System.out.print("0. Salir\n");
            ans = sc.nextInt();
            switch(ans){
                case 1: 
                    System.out.print("Ingrese el codigo \n");
                    int code = sc.nextInt();
                    System.out.print("Ingrese la descripcion \n");
                    String desc = sc.next();
                    codesc = code + ",\"" + desc + "\"";
                    if(almacen.size() == 0){
                       nv.add(almacen, codesc, 0);
                       continue;
                    }
                    nv.add(almacen, codesc, 0);
                    break;
                case 2:
                    if(almacen.size() != 0 && longitud != 0){
                        System.out.print("Ingrese el nombre de la tienda \n");
                        String name = sc.next();
                        System.out.print("Ingrese la cantidad \n");
                        int cant = sc.nextInt();
                        if(cant <= longitud){
                            codesc = "\"" + name + "\"," + cant;
                            nv.add(solicitudes, codesc, 1);
                            longitud -= cant;
                        } else{
                            System.out.println("No hay cantidades disponibles. Cantidad actual: " + longitud);
                        }
                        
                    }
                    else{System.out.println("Bodega vacía");}
                    break;
                case 3:
                    if(almacen.size()==0){System.out.println("Bodega vacía");}
                    for(int i = 0 ; i < almacen.size() ; i++){
                        System.out.print("["+almacen.get(i)+"]→");
                    }
                    System.out.print("\n");
                    break;
                case 4:
                    if(solicitudes.size()==0){System.out.println("No hay pedidos pendientes");}
                    for(int i = 0 ; i < solicitudes.size() ; i++){
                        String soli = solicitudes.get(i);
                        int a = soli.indexOf(",");
                        String name = soli.substring(0, a);
                        int cant = Integer.parseInt(soli.substring(a+1));
                        System.out.print("["+name+"]→");
                        for(int j = 0 ; j < cant ; j++){
                            System.out.print("[("+almacen.get(0)+")]→");
                            nv.delete(almacen);
                        }
                        System.out.print("\n");
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
