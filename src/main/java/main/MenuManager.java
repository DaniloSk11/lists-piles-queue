package main;

public class MenuManager {
    private Object currentMenu;
    
    public void printMenu(Object option){
        System.out.println(manageOption(option));
    }
    public String manageOption(Object option){
        if (currentMenu == "insertMenu") {
            
        }if(currentMenu == "removeMenu"){

        }
        
        return option1(option);
        
    }   

    ////(1) Inserir Novo Elemento; (2) Remover Elemento; (3) Buscar Elemento; (4) Imprimir elementos (0) Sair.
    //1- (1) – Inserir no Inicio; (2) – Inserir no Fim; (3) – Inserir Por posição
    //2- (1) – Remover no Inicio; (2) – Remover no Fim; (3) – Remover por Valor (leia o object a ser removido); (4) – Remover por Posição.
    
    public String option1(Object option){
        if (option == "1") {
            currentMenu = "insertMenu";
            return "Menu1";     
        }
        else{
            return option2(option);
        }
    }

    public String option2(Object option){
        if (option == "2") {
            currentMenu = "removeMenu";
            return "Menu2";     
        }
        else{
            return option3(option);
        }
    }

    public String option3(Object option){
        if (option == "3") {
            return "Menu3";     
        }
        else{
            return option4(option);
        }
    }

    public String option4(Object option){
        if (option == "4") {
            return "Menu4";     
        }
        else{
            return option0(option);
        }
    }

    public String option0(Object option){
        if (option == "0") {
            return "Menu0";     
        }
        else{
            return invalidOption(option);
        }
    }

    public String invalidOption(Object option){
        return "Invalid Option!!";
    }
}
