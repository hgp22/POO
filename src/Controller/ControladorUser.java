package Controller;

import java.util.*;
import Model.*;
import View.*;

public class ControladorUser {
    private Input input;
    private boolean login;

    public ControladorUser() {
        this.input = new Input();
        this.login = false;
    }

    public Login login(GestorVintage gestor, Apresentacao a) {
        a.printMessage("---------------  LOGIN  ---------------");
        String email = this.input.lerString(a, "Insira o seu email: ");
        String password = this.input.lerString(a, "Insira a sua password: ");
        if(gestor.existeUtilizador(email, password)) {
            a.printMessage("Login efetuado com sucesso!");
            this.login = true;
            return new Login(email, password);
        } else {
            a.printMessage("Email ou password incorretos!");
            return null;
        }
    }

    public Utilizador registarUtilizador(GestorVintage gestor, Apresentacao a){
        List<String> produtosComprados = new ArrayList<>();
        List<String> produtosVendidos = new ArrayList<>();
        List<String> produtosAVenda = new ArrayList<>();
        a.printMessage("---------------  REGISTAR  ---------------");
        String email = this.input.lerString(a, "Insira o seu email: ");
        String password = this.input.lerString(a, "Insira a sua password: ");
        String nome = this.input.lerString(a, "Insira o seu nome: ");
        int nif = this.input.lerInteiro(a, "Insira o seu NIF: ", 0, 999999999);
        String morada = this.input.lerString(a, "Insira a sua morada: ");
        
        if(gestor.existeUtilizador(email, password)) {
            a.printMessage("Já existe um utilizador com esse email!");
            return null;
        } else {
            a.printMessage("Utilizador registado com sucesso!");
            return new Utilizador(email, password, nome, morada, nif, produtosComprados, produtosVendidos, produtosAVenda);
        }
    }
    
    public void logout(){
        this.login = false;
    }
    
}
