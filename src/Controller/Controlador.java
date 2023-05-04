package Controller;

import java.util.ArrayList;
import java.util.List;

import Model.*;

public class Controlador {

    public Controlador() {

    }

    public Controlador(Controlador controlador) {
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
}

