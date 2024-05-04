package main;

import java.util.Scanner;

import exceptions.EmptyListException;
import exceptions.InvalidObjectException;
import exceptions.InvalidPositionException;

/**
Faculdade: SENAI FATESG
Trabalho da materia: Estrutura de Dados I
Professor: Luiz Mario Barbosa
Aluno: Danilo Silva da Cunha
Finalizado: 03/05/2024
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

        }
        read.close();
    }
}
