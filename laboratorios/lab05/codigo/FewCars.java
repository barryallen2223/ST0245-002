import java.util.*;
/**
 * Write a description of class FewCars here.
 *
 * @author (your name)
 * @version (a version number or a date)
 */
public class FewCars
{
    DigraphAL graph;

    public FewCars(DigraphAL graph){
        this.graph = graph;
    }

    public ArrayList<Pair<Node, LinkedList>> toTake(){
        pathAlt idk = new pathAlt();
        
        idk.sumIDK(graph);
        
        ArrayList<Pair<Node, LinkedList>> carsNpick = new ArrayList<>();

        ArrayList<Node> wCar = new ArrayList<>();
        ArrayList<Node> pickUp = new ArrayList<>();

        ArrayList<Node> unavailable = new ArrayList<>();

        for(int i = 0; i < graph.size(); i++){
            if(graph.getHead(i).getTime() == null || graph.getHead(i).getTime().get(0).getValue() == null)
                continue;
            if(graph.getHead(i).getCar())
                wCar.add(graph.getHead(i));
            else pickUp.add(graph.getHead(i));
        }

        //Metodo para encontrar el tiempo maximo que desea un carro para llegar al destino
        ArrayList<Pair<Node, Double>> maxTime = new ArrayList<>();

        for(int j = 0; j < wCar.size(); j++){
            maxTime.add(Pair.makePair(wCar.get(j), wCar.get(j).getTime().get(wCar.get(j).getNumber()).getValue()*wCar.get(j).getK()));
        }

        //Ordenamiento te los tiempos para utilizar el menos con el fin de recoger a los mas cercanos.
        maxTime = InsertionSort(maxTime);

        for(int n = 0; n < maxTime.size(); n++){

            //Valor por el cual se cambiara al final del codigo los tiempos que existian en la posicion n y no cambiar el nodo final.
            ArrayList<Pair<Node, Double>> oldTime = maxTime.get(n).getKey().getTime();

            //Ordenamiento de los nodos para saber cuales son los mas cercanos al carro n.
            maxTime.get(n).getKey().setTime(InsertionSort(maxTime.get(n).getKey().getTime()));

            //1. Metodo para hallar los 4 nodos sin carro mas cercanos a recoger
            Node[] fourElem = new Node[4];
            int cont = 0;

            for(int t = 0; t < maxTime.size(); t++){
                if(cont == 4)
                    break;
                if(!maxTime.get(n).getKey().getTime().get(t).getKey().getCar() && !unavailable.contains(maxTime.get(n).getKey().getTime().get(t).getKey())){
                    fourElem[cont] = maxTime.get(n).getKey().getTime().get(t).getKey();
                    cont++;
                }
            }

            //Fin 1

            //2. Metodo para hallar el objeto con la menor distancia hasta la universidad

            Double minorDistanceToU = Integer.MAX_VALUE - 0.0;
            Node mDTU = fourElem[0];

            for(int k = 0; k < fourElem.length; k++){
                if(minorDistanceToU > fourElem[k].getTime().get(0).getValue()){
                    minorDistanceToU = fourElem[k].getTime().get(0).getValue();
                    mDTU = fourElem[k];
                }
            }

            if(mDTU.getTime().get(0).getValue() >= maxTime.get(n).getValue() - oldTime.get(n).getKey().getTime().get(mDTU.getNumber()).getValue())
                continue;
            else if(mDTU.getTime().get(0).getValue() == maxTime.get(n).getValue() - oldTime.get(n).getKey().getTime().get(mDTU.getNumber()).getValue()){
                LinkedList<Node> Linky = new LinkedList<>();
                Linky.add(mDTU);
                carsNpick.add(Pair.makePair(maxTime.get(n).getKey(), Linky));
            }

            //Fin 2

            //3. Metodo para hallar la distancia mas corta para recoger a los 2 pasajeros restantes.

            int one = 0;
            int two = 0;

            Double minTime;

            for(int h = 1; h < 4; h++){
                if(fourElem[h] == mDTU)
                    one = h;
            }

            if(one == 1){
                one = 2;
                two = 3;
            } else if(one == 2){
                one = 1;
                two = 3;
            } else{
                one = 1;
                two = 2;
            }

            LinkedList<Node> bestRoute = bestRoute(oldTime.get(n).getKey(), fourElem[one], fourElem[two], mDTU, oldTime.get(n).getValue());

            //Ruta completa en el mejor de los casos
            // minTime = (oldTime.get(n).getKey().getTime().get(fourElem[0].getNumber()).getValue() + fourElem[0].getTime().get(fourElem[one].getNumber()).getValue() + 
            // fourElem[one].getTime().get(fourElem[two].getNumber()).getValue() + fourElem[two].getTime().get(mDTU.getNumber()).getValue() >
            // oldTime.get(n).getKey().getTime().get(fourElem[0].getNumber()).getValue() + fourElem[0].getTime().get(fourElem[two].getNumber()).getValue() +
            // fourElem[two].getTime().get(fourElem[one].getNumber()).getValue() + fourElem[one].getTime().get(mDTU.getNumber()).getValue()) ? 
            // oldTime.get(n).getKey().getTime().get(fourElem[0].getNumber()).getValue() + fourElem[0].getTime().get(fourElem[two].getNumber()).getValue() +
            // fourElem[two].getTime().get(fourElem[one].getNumber()).getValue() + fourElem[one].getTime().get(mDTU.getNumber()).getValue() : 
            // oldTime.get(n).getKey().getTime().get(fourElem[0].getNumber()).getValue() + fourElem[0].getTime().get(fourElem[one].getNumber()).getValue() + 
            // fourElem[one].getTime().get(fourElem[two].getNumber()).getValue() + fourElem[two].getTime().get(mDTU.getNumber()).getValue();

            // if(minTime >= maxTime.get(0).getValue())
            // continue;

            //Fin 3

            maxTime.get(n).getKey().setTime(oldTime.get(n).getKey().getTime());
            carsNpick.add(Pair.makePair(maxTime.get(n).getKey(), bestRoute));

            for(int h = 0; h < bestRoute.size(); h++){
                unavailable.add(bestRoute.get(h));
            }
        }

        return carsNpick;
    }

    private LinkedList<Node> bestRoute(Node start, Node int1, Node int2, Node end, Double maxTime){
        LinkedList<Node> ll = new LinkedList<>();
        Integer Istart = start.getNumber(), Int1 = int1.getNumber(), Int2 = int2.getNumber(), Iend = end.getNumber();

        if ((start.getTime().get(Iend).getValue()) <= maxTime){
            ll.add(end);
            if ((start.getTime().get(Int1).getValue() + int1.getTime().get(Iend).getValue()) <= maxTime){
                ll.add(int1);
                if ((start.getTime().get(Int1).getValue() + int1.getTime().get(Int2).getValue()) + int2.getTime().get(Iend).getValue() <= maxTime){
                    ll.add(int2);
                }
            }
            if (start.getTime().get(Int2).getValue() + int2.getTime().get(Iend).getValue() <= maxTime){
                ll.add(int2);        
                if ((start.getTime().get(Int2).getValue() + int2.getTime().get(Int1).getValue()) + int1.getTime().get(Iend).getValue() <= maxTime){
                    ll.add(int1);
                }
            }
        }

        return ll;        
    }

    public ArrayList<Pair<Node, Double>> InsertionSort(ArrayList<Pair<Node, Double>> elements){
        for(int pos = 0; pos < elements.size()-1; pos++){
            if(elements.get(pos).getValue() > elements.get(pos+1).getValue()){
                for(int min = 0; min <= pos; min++){
                    if(elements.get(pos+1).getValue() < elements.get(min).getValue()){
                        this.Swap(elements, pos+1, min);
                    }
                }
            }
        }

        return elements;
    }

    private ArrayList<Pair<Node, Double>> commonElements(ArrayList<Pair<Node, Double>> maxTime, ArrayList<Node> pickUp){

        ArrayList<Pair<Node, Double>> commonNodes = new ArrayList<>();

        Hashtable<Node, Node> t = new Hashtable<>();

        for(int i = 0; i < maxTime.size(); i++){
            t.put(maxTime.get(i).getKey(), maxTime.get(i).getKey());
        }

        for(int i = 0; i < pickUp.size(); i++){
            t.put(pickUp.get(i), pickUp.get(i));
        }

        for(int j = 0; j < t.size(); j++){
            t.get(pickUp.get(j));
        }

        return commonNodes;
    }

    private void Swap(ArrayList<Pair<Node, Double>> Arr, int el1, int el2){
        Double elS = Arr.get(el1).getValue();
        Arr.get(el1).setValue(Arr.get(el2).getValue());
        Arr.get(el2).setValue(elS);
    }

    public static void main(String[] args){
        int v = 5;
        DigraphAL graph = new DigraphAL(v);

        Node a0 = new Node((Integer) 0, (float) 2);
        Node a1 = new Node((Integer) 1);
        Node a2 = new Node((Integer) 2);
        Node a3 = new Node((Integer) 3, (float) 2);
        Node a4 = new Node((Integer) 4);

        graph.setHead(0, a0);
        graph.setHead(1, a1);
        graph.setHead(2, a2);
        graph.setHead(3, a3);
        graph.setHead(4, a4);

        graph.addArc(a0, a4, 4.0);
        graph.addArc(a0, a1, 3.0);
        graph.addArc(a1, a2, 2.0);
        graph.addArc(a1, a3, 5.0);
        graph.addArc(a0, a2, 6.0);
        graph.addArc(a2, a1, 2.0);
        graph.addArc(a2, a4, 5.0);

        FewCars cacaprofe = new FewCars(graph);

        ArrayList<Pair<Node, LinkedList>> t = cacaprofe.toTake();
    }
}
