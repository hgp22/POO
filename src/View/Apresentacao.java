package View;

import java.util.List;

public class Apresentacao {
    private ApresentacaoMenu ap;
    private Prints prints;

    public Apresentacao() {
        this.ap = new ApresentacaoMenu();
        this.prints = new Prints();
    }

    public void printInicio(){
        this.ap.printInicio();
    }

    public void printMenu(){
        this.ap.printMenu();
    }

    public void printLogin(){
        this.ap.printLogin();
    }

    public void printMenuInicial(){
        this.ap.printMenuInicial();
    }

    public void printMenuVender(){
        this.ap.printMenuVender();
    }

    public void printMenuComprar(){
        this.ap.printMenuComprar();
    }

    public void printMenuTransportadora(){
        this.ap.printMenuTransportadora();
    }

    public void printMessage(String message){
        this.prints.printMessage(message);
    }

    public void printArtigosDisponiveis(List<Integer> artigosDisponiveis) {
        this.ap.printArtigosDisponiveis(artigosDisponiveis);
    }
}
