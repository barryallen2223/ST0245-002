
public class CompararListas
{
    public Object maxElement(Node node ,Object maxValue){
        if(node == null){
            return maxValue;
        }
        else{
            if((int)maxValue < (int)node.data){
                return maxElement(node.next,node.data);
            }
            return maxElement(node.next, maxValue);
        }
    }
    
    public Object dialer(LinkyList l){
        Node node = l.getHead();
        return this.maxElement(node, Integer.MIN_VALUE);
    }
    
    public boolean isEquals(LinkyList l1, LinkyList l2){
        if(l1.size() != l2.size()){
            return false;
        }
        return equals(l1.getHead(), l2.getHead());
    }
    
    public boolean equals(Node n1, Node n2){
        if(n1 == null && n2 == null){
            return true;
        }
        if(n1.data == n2.data){
            return equals(n1.next, n2.next);
        }
        else{
            return false;
        }
    }
}

