package main;

import java.util.Scanner;

import exceptions.EmptyListException;
import exceptions.InvalidObjectException;
import exceptions.InvalidPositionException;

public class MenuManager {
    private Object currentMenu;
    Scanner read = new Scanner(System.in);
    
    public void printMenu(Integer option, List list) throws EmptyListException, InvalidPositionException, InvalidObjectException{
        System.out.println(manageOption(option, list));
    }
    public String manageOption(Integer option, List list) throws EmptyListException, InvalidPositionException, InvalidObjectException{
        if (currentMenu == "insertMenu") { 
            return insertOptions(option, list);
        }
        if (currentMenu == "removeMenu") {
            return removeOptions(option, list);
        }
        return optionNull(option,list);    
    }   

    ////(1) Inserir Novo Elemento; (2) Remover Elemento; (3) Buscar Elemento; (4) Imprimir elementos (0) Sair.
    //1- (1) – Inserir no Inicio; (2) – Inserir no Fim; (3) – Inserir Por posição
    //2- (1) -> Remover no Inicio; (2) -> Remover no Fim; (3) -> Remover por Valor; (4) -> Remover por Posição.
    
    public String optionNull(Integer option, List list){
        if (option == null) {
            currentMenu = "mainMenu";
            return "(1) Inserir Novo Elemento; (2) Remover Elemento; (3) Buscar Elemento; (4) Imprimir elementos (0) Sair.";
        }
        
        return option1(option,list);
    }

    public String option1(Integer option, List list){
        if (option == 1) {
            currentMenu = "insertMenu";
            return "(1) -> Inserir no Inicio; (2) -> Inserir no Fim; (3) -> Inserir Por posição.";     
        }
        else{
            return option2(option,list);
        }
    }

    public String option2(Integer option, List list){
        if (option == 2) {
            currentMenu = "removeMenu";
            return "(1) -> Remover no Inicio; (2) -> Remover no Fim; (3) -> Remover por Valor; (4) -> Remover por Posição.";     
        }
        else{
            return option3(option,list);
        }
    }

    public String option3(Integer option, List list){
        if (option == 3) {
            System.out.println("Qual o valor a ser pesquisado: ");
            Object data = read.nextLine();
            list.isInList(data);
            option = null;
            return optionNull(option, list);     
        }
        else{
            return option4(option,list);
        }
    }

    public String option4(Integer option, List list){
        if (option == 4) {
            list.print();
            option = null;
            return optionNull(option, list);     
        }
        else{
            return option0(option,list);
        }
    }

    public String option0(Integer option, List list){
        if (option == 0) {
            return "Menu0";     
        }
        else{
            return invalidOption(option,list);
        }
    }

    public String insertOptions(Integer option, List list) throws EmptyListException, InvalidPositionException{
        if (option == 1) {    
            currentMenu = "mainMenu";
            option = null;
            return insertOp1(option, list);
        }
        if (option == 2) {    
            currentMenu = "mainMenu";
            option = null;
            return insertOp2(option, list);
        }
        if (option == 3) {    
            currentMenu = "mainMenu";
            option = null;
            return insertOp3(option, list);
        }else{
            return invalidOption(option,list);
        }
    }

    public String insertOp1(Integer option, List list){
        System.out.println("Insert data: ");
        Object data = read.nextLine();
        list.insertNodeStart(data);
        return "Data Inserted on the first position!\n" + optionNull(option,list);
    }

    public String insertOp2(Integer option, List list){
        System.out.println("Insert data: ");
        Object data = read.nextLine();
        list.insertNodeEnd(data);
        return "Data Inserted on the last position!\n" + optionNull(option,list);
    }
    public String insertOp3(Integer option, List list) throws EmptyListException, InvalidPositionException{
        System.out.println("Insert data: ");
        Object data = read.nextLine();
        System.out.println("Insert position: ");
        int position = read.nextInt();
        list.insertNodePosition(data,position);
        return "Data Inserted on the "+ position +" position!\n" + optionNull(option,list);
    }



    
    public String removeOptions(Integer option, List list) throws EmptyListException, InvalidObjectException, InvalidPositionException{
        if (option == 1) {    
            currentMenu = "mainMenu";
            option = null;
            return removeOp1(option, list);
        }
        if (option == 2) {    
            currentMenu = "mainMenu";
            option = null;
            return removeOp2(option, list);
        }
        if (option == 3) {    
            currentMenu = "mainMenu";
            option = null;
            return removeOp3(option, list);
        }
        if (option == 4) {    
            currentMenu = "mainMenu";
            option = null;
            return removeOp4(option, list);
        }else{
            return invalidOption(option, list);
        }
    }

    //2- (1) -> Remover no Inicio; (2) -> Remover no Fim; (3) -> Remover por Valor; (4) -> Remover por Posição.

    public String removeOp1(Object option, List list) throws EmptyListException{
        list.removeNodeStart();
        return "First object removed!\n" + optionNull(null, list);
    }
    public String removeOp2(Object option, List list) throws EmptyListException{
        list.removeNodeEnd();
        return "Last object removed!\n"+optionNull(null, list);
    }
    public String removeOp3(Object option, List list) throws EmptyListException, InvalidObjectException{
        System.out.println("Insert value to be removed: ");
        Object object = read.nextLine();
        list.removeNodeValue(object);
        return "Object "+ object + " removed!\n" +optionNull(null, list);
    }
    public String removeOp4(Object option, List list) throws EmptyListException, InvalidPositionException{
        System.out.println("Insert position to be remoed: ");
        int position = read.nextInt();
        list.removeNodePosition(position);
        return "Object on the position "+position+" removed!\n" + optionNull(null, list);
    }



    public String invalidOption(Integer option,List list){
        return "Invalid Option!!\n"+ optionNull(option, null);
    }
}
