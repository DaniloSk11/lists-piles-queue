package main;

public class Node {
    Object data;
    Node nodePointer;

    Node(Object object){
        this(object, null);
    }

    Node(Object object, Node node){
        data = object;
        nodePointer = node;
    }


    //get and set data
    public void setData(Object data){
        this.data = data;
    }
    Object getData(){
        return data;
    }


    //get and set nodePoiters    
    public void setNodePointer(Node novo){
        this.nodePointer = novo;
    }
    Node getNodePointer(){
        return nodePointer;
    }

}
