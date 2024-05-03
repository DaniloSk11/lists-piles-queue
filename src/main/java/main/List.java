package main;

public class List {
    private Node firstNode;
    private Node lastNode;
    private String name;
    private int listSize;

    public List() {
        this("List");
        this.listSize = 0;
    }

    public List(String listName) {
        name = listName;
        firstNode = lastNode = null;
        this.listSize = 0;
    }

    // start of the insert methods
    public void insertNodeStart(Object insertObject) {
        if (isEmpty()) {
            firstNode = lastNode = new Node(insertObject);
        } else {
            firstNode = new Node(insertObject, firstNode);
        }

        this.listSize++;
    }

    public void insertNodeEnd(Object insertObject) {
        if (isEmpty()) {
            firstNode = lastNode = new Node(insertObject);
        } else {
            lastNode = lastNode.nodePointer = new Node(insertObject);
        }
    }

    public void insertNodePosition(Object object, int position) throws EmptyListException, InvalidPositionException {
        if (isEmpty()) {
            throw new EmptyListException(name);
        }
        if (isInvalidPosition(position)) {
            throw new InvalidPositionException(name, listSize);
        }

        Node current = firstNode;

        Node previousNode = null;
        Node insertedNode = new Node(object);
        Node nextNode;

        int check = 1;
        if (position == listSize) {
            insertNodeEnd(object);
        } else {
            while (current.nodePointer != null) {

                if (check == position - 1) {
                    previousNode = current;
                    current = current.nodePointer;
                    previousNode.nodePointer = insertedNode;
                    nextNode = current;
                    insertedNode.nodePointer = nextNode;
                    listSize++;
                }
                current = current.nodePointer;
                check++;
            }
        }

    }
    // end of the insert methods

    // start of remove methods
    public Object removeNodeEnd() throws EmptyListException {
        if (isEmpty()) {
            throw new EmptyListException(name);
        }
        Object removedObject = lastNode.data;

        if (firstNode == lastNode) {
            firstNode = lastNode = null;
        } else {
            Node current = firstNode;

            while (current.nodePointer != lastNode) {
                current = current.nodePointer;
            }

            lastNode = current;
            current.nodePointer = null;
        }

        this.listSize--;
        return removedObject;
    }

    public Object removeNodeStart() throws EmptyListException {
        if (isEmpty()) {
            throw new EmptyListException(name);
        }
        Object removedObject = firstNode.data;
        if (firstNode == lastNode) {
            firstNode = lastNode = null;
        } else {
            firstNode = firstNode.nodePointer;
        }
        this.listSize--;
        return removedObject;
    }

    public void removeNodePosition(int position) throws EmptyListException, InvalidPositionException {
        if (isEmpty()) {
            throw new EmptyListException(name);
        }
        if (isInvalidPosition(position)) {
            throw new InvalidPositionException(name, listSize);
        }
        Node current = firstNode;
        Node previousNode = null;
        Node removedNode = null;
        Node nextNode = null;
        int check = 1;
        if (position == listSize) {
            removeNodeEnd();
        }else{
            while (current.nodePointer != null) {
                if (check == position-1) {
                    previousNode = current;
                    current = current.nodePointer;
                    removedNode = current;
                    current = current.nodePointer;
                    removedNode.nodePointer = null;
                    nextNode = current;
                    previousNode.nodePointer = nextNode;
                    listSize--;
                }
                check++;
                current = current.nodePointer;
            }
        }
        
        
    }
    
    public void removeNodeValue(Object object) throws EmptyListException, InvalidObjectException {
        if (isEmpty()) {
            throw new EmptyListException(name);
        }
        if (searchObject(object) == false) {
            throw new InvalidObjectException(name,object);
        }
        Node current = firstNode;
        Node previousNode = null;
        Node nextNode = null;
        
        
            while (current.nodePointer != null) {
                if (current.data == object) {
                    nextNode = current.nodePointer;
                    previousNode.nodePointer = nextNode;
                    
                    listSize--;
                }
                
                previousNode = current;
                current = current.nodePointer;
                nextNode = current.nodePointer;
            }
        
        
        
    }
    

    
    // end of remove methods



    
    // is methods start
    public boolean isEmpty() {
        return firstNode == null;
    }

    public boolean isInvalidPosition(int position) {
        return position <= 0 || position > listSize;
    }
    public String isInList(Object object){
        if (searchObject(object)) {
            return "Object "+object+" is on the list!!";
        }else{
            return "Object "+object+" is not on the list!!";
        }
    }
    // is methods end

    // print methods start
    public void print() {
        if (isEmpty()) {
            System.out.printf("Empty List %s\n", name);
            System.out.printf(printSize());
            return;
        }

        System.out.printf("The list %s:\n", name);
        Node current = firstNode;

        while (current != null) {
            String dataString = current.data.toString();
            System.out.printf("%s -> ", dataString);
            current = current.nodePointer;
        }
        System.out.printf("\n");
        System.out.println(printSize());

    }
    
    public String printSize() {
        return "List Size: " + this.listSize;
    }
    
    // print mehods end

    public boolean searchObject(Object object) {
        Node current = firstNode;
        while (current != null) {
            if (current.data == object) {
                return true;
            }
            current = current.nodePointer;
        }
        return false;
    }

}
