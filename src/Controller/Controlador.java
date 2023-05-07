package Controller;

import java.io.*;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import Model.GestorVintage.*;
import Model.*;
import Model.Artigos.*;
import Model.Mala.*;
import Model.Tshirt.*;
import Model.Sapatilhas.*;

public class Controlador implements Serializable {

    private Input input;
    private Scanner sc;
    private GestorVintage gestor;

    public Controlador(GestorVintage gestor) {
        this.input = new Input(sc);
        this.gestor = gestor;
    }

    public Controlador(Controlador controlador) {
        this.input = controlador.getInput();
        this.gestor = controlador.getGestor();
    }

    private GestorVintage getGestor() {
        return this.gestor;
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
    
    // ============================================================================================ //


    public Utilizador criaUtilizador(String email, String password, String nome, String morada, int nif) {
        List<String> produtosComprados = new ArrayList<>();
        List<String> produtosVendidos = new ArrayList<>();
        List<String> produtosAVenda = new ArrayList<>();
        return new Utilizador(email, password, nome, morada, nif, produtosComprados, produtosVendidos, produtosAVenda);
    }
    
    public void criarSapatilhas(String descricao2, String marca2, String codigo2, float precoBase2, float desconto2, int estado3, EstadoArtigo estado4, int numDonos2, float tamanho, boolean atacadores, String cor, LocalDate data, TipoSapatilhas tipo2) {
        new Sapatilhas(descricao2, marca2, codigo2, precoBase2, desconto2, estado3, estado4, numDonos2, tamanho, atacadores, cor, data, tipo2);
        
    }
    
    public void criarTshirt(String descricao3, String marca3, String codigo3, float precoBase3, float desconto3, int estado5, EstadoArtigo estado6, int numDonos3, Tamanho tamanho2, Padrao padrao) {
        new Tshirt(descricao3, marca3, codigo3, precoBase3, desconto3, estado5, estado6, numDonos3, tamanho2, padrao);
    }
    
	public void criaMala(String descricao, String marca, String codigo, float precoBase, float desconto, int estado2, EstadoArtigo estado, int numDonos, float altura, float largura, float profundidade, String material, int anoColecao, TipoMala tipo) {
        new Mala(descricao, marca, codigo, precoBase, desconto, estado2, estado, numDonos, altura, largura, profundidade, material, anoColecao, tipo);
	}
    
    public void criarTransportadora(String nome, boolean premium, float lucro) {
        new Transportadoras(nome, premium, lucro);
    }

    public void login(String email, String password) throws VintageException{
        if(GestorVintage.existeUtilizador(email, password)) {
            new Login(email, password);
        }
        else {
            throw new VintageException("Utilizador não existe");
        }
    }


    // ========================================= QUERYS  ========================================== //


    // ==========================  GUARDAR E CARREGAR ESTADO DO PROGRAMA ========================== //

    public void guardarEstado (String ficheiro) throws FileNotFoundException, IOException {
        FileOutputStream fos = new FileOutputStream(ficheiro);
        ObjectOutputStream oos = new ObjectOutputStream(fos);
        oos.writeObject(gestor);
        oos.flush();
        oos.close();
    }

    public void carregarEstado (String ficheiro) throws FileNotFoundException, IOException, ClassNotFoundException {
        FileInputStream fis = new FileInputStream(ficheiro);
        ObjectInputStream ois = new ObjectInputStream(fis);
        GestorVintage c = (GestorVintage) ois.readObject();
        ois.close();
        this.gestor = c;
    }

}

    

