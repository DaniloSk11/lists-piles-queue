package main;
public class InvalidPositionException extends Exception {
    private static final long serialVersionUID = 2L;

    public InvalidPositionException(){
        this("List", 1);
    }
    public InvalidPositionException(String name, int listSize){
        super("Insert position invalid!! The list: "+name+" has a size of: " + listSize);
    }
}
