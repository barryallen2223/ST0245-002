public class LinkyList
{
    Node head;
    Node tail;
    private int size = 0;
    
    public LinkyList(){
        size = 0;
    }
    
    public synchronized Node getHead(){
        return head;
    }
    
    public synchronized Node getTail(){
        return tail;
    }
    
    public int size(){
        return size;
    }
    
    public synchronized void insertAtBegin(Node node){
        node.next = head;
        head = node;
        size++;
    }
    
    public synchronized void insertAtEnd(Node node){
        if(head == null)
            head = node;
        else{
            Node auxNode = head;
            while(auxNode.next != null)
                auxNode = auxNode.next;
            auxNode.next = node;
        }
        size++;
    }
    
    public void insert(Object data, int index){
        if(index < 0)
            index = 0;
        else if(index > size)
            index = size;
        if (head == null)
            head = new Node(data);
        else if(index == 0){
            Node insNode = new Node(data);
            insNode.next = head;
            head = insNode;
        } else{
            Node headNode = head;
            for(int i = 1; i < index; i++)
                headNode = headNode.next;
            Node newNode = new Node(data);
            newNode.next = headNode.next;
            headNode.next = newNode;
        }
        size++;
    }
    
    public synchronized Node removeFromBegin(){
        Node node = head;
        if(node != null){
            head = node.next;
            node.next = null;
        }
        size--;
        return node;
    }
    
    public synchronized Node removeFromEnd(){
        if(head == null)
            return null;
        Node headNode = head, remNode = null, next = head.next;
        if(next == null){
            head = null;
            size--;
            return headNode;
        }
        while(headNode.next.next != null)
            headNode = headNode.next;
        headNode.next = null;
        size--;
        return headNode;
    }
    
    public synchronized void removeMatched(Node node){
        if(head == null)
            return;
        if(node.equals(head)){
            head = head.next;
            size--;
            return;
        }
        
        Node insNode = head;
        
        while(insNode.next != null){
            if(node.equals(insNode.next)){
                insNode.next = insNode.next.next;
                size--;
                return;
            }
            
            insNode = insNode.next;
        }
    }
    
    public void remove(int index){
        if(index < 0)
            index = 0;
        if(index >= size)
            index = size - 1;
        if(head == null)
            return;
        if(index == 0)
            head = head.next;
        else{
            Node retNode = head;
            for(int i = 1; i < index; i++){
                retNode = retNode.next;
            }
            retNode.next = retNode.next.next;
        }
        size -= 1;
    }
    
    public int getPosition(Object data){
        Node auxNode = head;
        int pos = 0;
        
        while(auxNode != null){
            if(auxNode.data == data)
                return pos;
            pos += 1;
            auxNode = auxNode.next;
        }
        return Integer.MIN_VALUE;
    }
    
    public void clearList(){
        head = null;
        size = 0;
    }
    
    @Override
    public String toString(){
        String result = "[";
        if(head == null){
            return result+"]";
        }
        result = result + head.data;
        Node temp = head.next;
        while (temp != null) {
            result = result + "," + temp.data;
            temp = temp.next;
        }
        return result + "]";
    }
}