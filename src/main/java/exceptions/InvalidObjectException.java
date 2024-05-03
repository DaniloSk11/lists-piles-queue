package exceptions;

public class InvalidObjectException extends Exception {
    private static final long serialVersionUID = 3L;

    public InvalidObjectException(){
        this("List", null);
    }
    public InvalidObjectException(String name, Object object){
        super("Invalid object!! The list: "+name+" doesn't have the object: " + object);
    }
}
