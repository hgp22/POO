package View;

import java.util.List;

public class ApresentacaoMenu {
    private Prints prints;

    public ApresentacaoMenu() {
        this.prints = new Prints();
    }

    public void printInicio(){
        System.out.println("                                 _________ _       _________ _______  _______  _______          ");
        System.out.println("                        |\\     /|\\__   __/( (    /|\\__   __/(  ___  )(  ____ \\(  ____ \\    ");
        System.out.println("                        | )   ( |   ) (   |  \\  ( |   ) (   | (   ) || (    \\/| (    \\/      ");
        System.out.println("                        | |   | |   | |   |   \\ | |   | |   | (___) || |      | (__            ");
        System.out.println("                        ( (   ) )   | |   | (\\ \\) |   | |   |  ___  || | ____ |  __)          ");
        System.out.println("                         \\ \\_/ /    | |   | | \\   |   | |   | (   ) || | \\_  )| (           ");
        System.out.println("                          \\   /  ___) (___| )  \\  |   | |   | )   ( || (___) || (____/\\      ");
        System.out.println("                           \\_/   \\_______/|/    )_)   )_(   |/     \\|(_______)(_______/      ");
        System.out.println("                                                                                                ");
        System.out.println("                                                                                                ");
        System.out.println("                                                Bem-vindo à Vintage!                            ");
    }
    
    public void printMenu(){
        this.prints.printMenu(new String[]{"Login/Registar", "Criar Transportadora", "Avançar tempo", "Carregar estado", "Gravar estado"}, "          MENU", 0);
    }

    public void printLogin(){
        this.prints.printMenu(new String[]{"Login", "Registar"}, "      MENU LOGIN", 0);
    }

    public void printMenuInicial(){
        this.prints.printMenu(new String[]{"Comprar Artigo", "Vender Artigo", "Criar Transportadora", "Devolver Encomenda", "Estatisiticas", "Logout"}, "        MENU INICIAL", 0);
    }

    public void printMenuVender(){
        this.prints.printMenu(new String[]{"Vender Mala", "Vender Sapatilha", "Vender Tshirt"}, "      MENU VENDER ARTIGOS", 0);
    }

    public void printMenuComprar(){
        this.prints.printMenu(new String[]{"Comprar Produto", "Remover Produto", "Terminar Encomenda"}, "          MENU COMPRAR ARTIGOS", 0);
    }

    public void printMenuTransportadora(){
        this.prints.printMenu(new String[]{"Criar Nova Transportadora", "Ver Transportadoras"}, "         MENU TRANSPORTADORA", 0);
    }

    public void printArtigosDisponiveis(List<Integer> artigosDisponiveis) {
        System.out.println("Artigos disponiveis:");
        for (int i = 0; i < artigosDisponiveis.size(); i++) {
            System.out.println((i + 1) + " - " + artigosDisponiveis.get(i));
        }
    }
}

