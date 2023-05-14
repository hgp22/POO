package View;

import java.util.List;
import java.util.Map;

import Model.Artigos;
import Model.Login;
import Model.Transportadoras;

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

    public void printArtigosDisponiveis(List<Artigos> artigosDisponiveis, Login login) {
        this.ap.printArtigosDisponiveis(artigosDisponiveis, login);
    }

    public void printTransportadoras(Map <String, Transportadoras> transportadoras) {
        this.ap.printTransportadoras(transportadoras);
    }

    public void printMenuEstatisticas() {
        this.ap.printMenuEstatisticas();
    }
}
