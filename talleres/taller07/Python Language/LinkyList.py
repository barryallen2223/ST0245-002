import sys

def synchronized(wrapped):
        @functools.wraps(wrapped)
        def wrapper(*args, **kwargs):
            return wrapped(*args, **kwargs)
        return wrapper

class LinkyList:
    size = 0
    def __init__(self):
        size = 0

    @synchronized
    def getHead(self):
        return self.head

    @synchronized
    def getTail(self):
        return self.tail

    def size(self):
        return self.size

    @synchronized
    def insertAtBegin(self, node):
        node.next = self.head
        head = node
        self.size = self.size + 1

    @synchronized
    def insertAtEnd(self, node):
        if head == None: 
            head = node
        else:
            auxNode = head
            while auxNode != None:
                auxNode = auxNode.next
            auxNode.next = node
        self.size = self.size + 1
    
    def insert(self, data, index):
        if index <  0:
            index = 0
        elif index > self.size:
            index = self.size
        if head == None:
            return Node(data)
        elif index == 0:
            insNode = Node(data)
            insNode.next = head
            head = insNode
        else:
            headNode = head
            for i in range(index):
                headNode = headNode.next
            newNode = Node(data)
            newNode.next = headNode.next
            headNode.next = newNode
        self.size = self.size + 1
    
    @synchronized
    def removeFromBegin(self):
        node = self.head
        if node != None:
            head = node.next
            node.next = None
        self.size = self.size - 1
        return node

    @synchronized
    def removeFromEnd(self):
        if self.head == None:
            return None
        headNode = self.head
        remNode = None
        next = self.head.next
        if next == None:
            head = None
            size = size - 1
            return headNode
        while headNode.next.next != None:
            headNode = headNode.next
        headNode.next = None
        size = size - 1
        return headNode
    
    @synchronized
    def removeMatched(self, node):
        if self.head == None:
            return None
        if node.equals(head):
            head = head.next
            size = size - 1
            return
        
        insNode = head
        
        while insNode.next != None:
            if node.equals(insNode.next):
                insNode.next = insNode.next.next
                size = size - 1
                return
            insNode = insNode.next
    
    def remove(self, index):
        if index <  0:
            index = 0
        if index >= self.size:
            index = self.size - 1
        if self.head == None:
            return
        if index == 0:
            head = head.next
        else:
            retNode = head
            for i in range(index):
                retNode = retNode.next
            retNode.next = retNode.next.next
        self.size = self.size - 1
    
    def getPosition(self, data):
        auxNode = self.head
        pos = 0
        while auxNode != None:
            if auxNode.data == data:
                return pos
            pos = pos + 1
            auxNode = auxNode.next
        return -1 * sys.maxsize
    
    def clearList(self):
        self.head = None
        self.size = 0
    
    def toString(self):
        result = "["
        if self.head == None:
            return result + "]"
        result = result + self.head.data
        temp = self.head.next
        while temp != None:
            result = result + "," + temp.data
            temp = temp.next
        return result + "]"
