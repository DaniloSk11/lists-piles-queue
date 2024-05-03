package main;

import java.util.Scanner;

import exceptions.EmptyListException;
import exceptions.InvalidObjectException;
import exceptions.InvalidPositionException;

/**
 * Hello world!
 *
 */
public class App {
    public static void main(String[] args) throws EmptyListException, InvalidPositionException, InvalidObjectException {
        Scanner read = new Scanner(System.in);
        MenuManager menu = new MenuManager();
        Integer option = null;
        Integer sair = 0;
        List list = new List();
        
        while (option != sair) {
            menu.printMenu(option, list);
            option = read.nextInt();
            //enviar a resposta pra o menu
        }
        read.close();
    }
}
// teste de commit