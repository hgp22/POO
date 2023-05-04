package Controller;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import Model.*;

public class Controlador {

    private Input input;
    private Scanner sc;


    public Controlador() {
        this.input = new Input(sc);
    }

    public Controlador(Controlador controlador) {
        this.input = controlador.getInput();
    }

    public Input getInput() {
        return this.input;
    }

    public void setInput(Input input) {
        this.input = input;
    }
    
    public Controlador clone() {
        return new Controlador(this);
    }

    public Utilizador criaUtilizador(String email, String password, String nome, String morada, int nif) {
        List<String> produtosComprados = new ArrayList<>();
        List<String> produtosVendidos = new ArrayList<>();
        List<String> produtosAVenda = new ArrayList<>();
        return new Utilizador(email, password, nome, morada, nif, produtosComprados, produtosVendidos, produtosAVenda);
        
    }

    public Login login(String email, String password) {
        return new Login(email, password);
    }

    //public Tshirt criaTshirt(String descricao, String marca, String cod, float precoBase, float desconto, int novoUsado, Estado estado,
    //int numDonos,Tamanho tamanho, Padrao padrao) {
    //    return new Tshirt(id, descricao, cor, tamanho, genero, preco, quantidade);
    //}
}



