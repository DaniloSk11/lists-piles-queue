package main;

public class List {
    private Node firstNode;
    private Node lastNode;
    private String name;
    private int listSize;


    public List(){
        this("List");
        this.listSize = 0;
    }
    public List(String listName){
        name = listName;
        firstNode = lastNode = null;
        this.listSize = 0;
    }

    //start of the insert methods
    public void insertNodeStart(Object insertObject){
        if (isEmpty()) {
            firstNode = lastNode = new Node(insertObject);
        }else{
            firstNode = new Node(insertObject, firstNode);
        }

        this.listSize++;
    }
    public void insertNodeEnd(Object insertObject){
        if (isEmpty()) {
            firstNode = lastNode = new Node(insertObject);
        }else{
            lastNode = lastNode.nodePointer = new Node(insertObject);
        }
    }
    public void insertNodePosition(Object object, int position) throws EmptyListException{
        if (isEmpty()) {
            throw new EmptyListException(name);            
        }
        if (position > listSize) {
            //criar uma nova exception pra tamanho a lista
        }

        Node current = firstNode;
        int loop = 0;
        while (loop != position) {
            current = current.nodePointer;
        }

        
    }
    //end of the insert methods

    //start of remove methods
    public Object removeNodeEnd() throws EmptyListException{
        if (isEmpty()) {
            throw new EmptyListException(name);
        }
        Object removedObject = lastNode.data;

        if (firstNode == lastNode) {
            firstNode = lastNode = null;
        }else{
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
    public Object removeNodeStart() throws EmptyListException{
        if (isEmpty()) {
            throw new EmptyListException(name);
        }
        Object removedObject = firstNode.data;
        if (firstNode == lastNode) {
            firstNode = lastNode = null;
        }else{
            firstNode = firstNode.nodePointer;
        }
        this.listSize--;
        return removedObject;
    }
    //end of remove methods

    //determines if a list is empty
    public boolean isEmpty(){
        return firstNode == null;
    }

    public void print(){
        if (isEmpty()) {
            System.out.printf("Empty List %s\n", name);
            System.out.printf(printSize());
            return;
        }

        System.out.printf("The list %s:\n",name);
        Node current = firstNode;

        while (current != null) {
            System.out.printf("%s -> ", current.data);
            current = current.nodePointer;
        }
        System.out.printf("\n");
        System.out.println(printSize());

    }

    public String printSize(){
        return "List Size: "+this.listSize;
    }

    public boolean searchObject(Object object){
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
