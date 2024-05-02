package main;

public class Pile extends List {
    public Pile(){
        super("stack - pile");
    }

    public void stack(Object object){
        insertNodeEnd(object);
    }

    public Object scatter()throws EmptyListException{
        return removeNodeEnd();
    }

}
