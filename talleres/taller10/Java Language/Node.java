public class Node
{
    Object data;
    Node next;
    
    public Node(){
        this.data = null;
        this.next = null;
    }
    
    public Node(Object data){
        this.data = data;
        this.next = null;
    }
    
    public Node(Object data, Node next){
        this.data = data;
        this.next = next;
    }
    
    public void setData(Object data){
        this.data = data;
    }
    
    public Object getData(){
        return data;
    }
    
    public void setNext(Node next){
        this.next = next;
    }
    
    public Node getNext(){
        return next;
    }
    
    public int size(Node headNode){
        int size = 0;
        Node currentNode = headNode;
        while(currentNode != null){
            size++;
            currentNode = currentNode.next;
        }
        return size;
    }
}