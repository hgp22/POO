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
            this.login = true;
            return new Utilizador(email, password, nome, morada, nif);
        }
    }
    
    public void logout(){
        this.login = false;
    }

    public void utilizadorVendas(GestorVintage gestor, Apresentacao a){    
        String email = input.lerString(a, "Introduza o email do utilizador");
        Utilizador u = gestor.getUtilizador(email);
        if (u != null){
            a.printMessage(email + " vendeu os seguintes artigos:");
            List<Artigos> artigos = gestor.artigosVendidosUtilizador(u);
            for(Artigos artigo : artigos){
                artigo.toString();
            }
        }
        else{
                a.printMessage("Utilizador não existe");
        }
    }
    

    
}
