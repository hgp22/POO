package Model;

import java.io.Serializable;
import java.util.*;

public class GestorVintage implements Serializable {
    private Map<String, Utilizador> utilizadores;
    private Map<String, Transportadoras> transportadoras;
    private List<Artigos> artigosVenda; 
    private Map<Integer, Encomenda> encomendas;

    public GestorVintage() {
        this.utilizadores = new HashMap<>();
        this.transportadoras = new HashMap<>();
        this.artigosVenda = new ArrayList<>();
        this.encomendas = new HashMap<>();    
    }

    public GestorVintage(Map<String, Utilizador> utilizadores, Map<String, Transportadoras> transportadoras, List<Artigos> artigosVenda, Map<Integer, Encomenda> encomendas) {
        this.utilizadores = utilizadores;
        this.transportadoras = transportadoras;
        this.artigosVenda = artigosVenda;
        this.encomendas = encomendas;
    }

    public GestorVintage(GestorVintage gestor) {
        this.utilizadores = gestor.getUtilizadores();
        this.transportadoras = gestor.getTransportadoras();
        this.artigosVenda = gestor.getArtigosVenda();
        this.encomendas = gestor.getEncomendas();
    }

    public Map<String, Utilizador> getUtilizadores() {
        Map<String, Utilizador> aux = new HashMap<>();
        for (Map.Entry<String, Utilizador> entry : this.utilizadores.entrySet()) {
            aux.put(entry.getKey(), entry.getValue().clone());
        }
        return aux;
    }

    public Map<String, Transportadoras> getTransportadoras() {
        Map<String, Transportadoras> aux = new HashMap<>();
        for (Map.Entry<String, Transportadoras> entry : this.transportadoras.entrySet()) {
            aux.put(entry.getKey(), entry.getValue().clone());
        }
        return aux;
    }

    public List<Artigos> getArtigosVenda() {
        List<Artigos> aux = new ArrayList<>();
        for (Artigos a : this.artigosVenda) {
            aux.add(a.clone());
        }
        return aux;
    }

    public Map<Integer, Encomenda> getEncomendas() {
        Map<Integer, Encomenda> aux = new HashMap<>();
        for (Map.Entry<Integer, Encomenda> entry : this.encomendas.entrySet()) {
            aux.put(entry.getKey(), entry.getValue().clone());
        }
        return aux;
    }

    /* nao sei se isto e preciso
    public void setUtilizadores(Map<String, Utilizador> utilizadores) {
        this.utilizadores = new HashMap<>();
        for (Map.Entry<String, Utilizador> entry : utilizadores.entrySet()) {
            this.utilizadores.put(entry.getKey(), entry.getValue().clone());
        }
    }

    public void setTransportadoras(Map<String, Transportadoras> transportadoras) {
        this.transportadoras = new HashMap<>();
        for (Map.Entry<String, Transportadoras> entry : transportadoras.entrySet()) {
            this.transportadoras.put(entry.getKey(), entry.getValue().clone());
        }
    }

    public void setArtigos(List<Artigos> artigos) {
        this.artigos = new ArrayList<>();
        for (Artigos a : artigos) {
            this.artigos.add(a.clone());
        }
    }

    public void setEncomendas(Map<String, Encomenda> encomendas) {
        this.encomendas = new HashMap<>();
        for (Map.Entry<String, Encomenda> entry : encomendas.entrySet()) {
            this.encomendas.put(entry.getKey(), entry.getValue().clone());
        }
    }
    */
    







    public void addUtilizador(Utilizador utilizador) {
        utilizadores.put(utilizador.getEmail(), utilizador);
    }
    
    public void addTransportadora(Transportadoras transportadora) {
        transportadoras.put(transportadora.getNome(), transportadora);
    }
    
    public void addArtigoPorVender(Artigos artigo, Login login) {
        this.utilizadores.get(login.getEmail()).addVender(artigo);
    }

    public void addArtigoVenda(String cod, Login login, Encomenda e) {
        for(Artigos a : artigosVenda){
            if(a.getCod() == cod){
                for(String s : this.utilizadores.keySet()){
                    if(this.utilizadores.get(s).getEmail() == login.getEmail()){
                        addArtigoPorVender(a, login);
                    }
                }
            }
        }

    }
    
    public void addEncomenda(Encomenda encomenda) {
        encomendas.put(encomenda.getId(), encomenda);
    }

    // verificar se existe o utilizador
    public boolean existeUtilizador(String email, String password) {
        Utilizador us = utilizadores.get(email);
        if(us != null){
            return us.getPassword().equals(password);
        }    
        return false;
    }
    
    // funcao para calcular o preco de expedicao


    // funcao que percorre cada user e lista as malas que estao por vender
    public List<Integer> listaMalasPorVender(Login login) {

        return null;
    }
}