package View;

import java.util.List;
import java.util.Map;

import Model.Artigos;
import Model.Login;
import Model.Transportadoras;

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

    public void printArtigosDisponiveis(List<Artigos> artigosDisponiveis, Login login) {
        System.out.println("Artigos disponiveis:");
        int indice = 0;
        int flag = 0; // 0 mostra todos os artigos, 1 mostra apenas artigos da mesma transportadora
        for (int i = 0; i < artigosDisponiveis.size(); i++) {
            if (!(artigosDisponiveis.get(i).getVendedor().getEmail().equals(login.getEmail())) && flag == 0){
                System.out.println(indice + " - " + artigosDisponiveis.get(indice));
                indice++;
            }
            else if (!(artigosDisponiveis.get(i).getVendedor().getEmail().equals(login.getEmail())) && flag == 1){
                if (artigosDisponiveis.get(i).getTransportadora().equals(artigosDisponiveis.get(0).getTransportadora())){
                    System.out.println(indice + " - " + artigosDisponiveis.get(indice));
                    indice++;
                }
            }
        }
    }

    public void printMenuEstatisticas(){
        this.prints.printMenu(new String[]{"Top Vendedor", "Top Transportadora", "Artigos vendidos por um utilizador", "Top Compradores/Vendedores", "Todo o dinheiro feito pela Vintage"}, "          MENU ESTATISTICAS", 0);
    }

    public void printTransportadoras(Map <String, Transportadoras> transportadoras) {
        System.out.println("Transportadoras disponiveis:");
        for (Transportadoras t : transportadoras.values()) {
            System.out.println(t.getNome() + " -> Lucro: " + t.getLucro());
        }
    }
    
}

