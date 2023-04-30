package Model;

import java.io.Serializable;
import java.util.*;

public class GestorVintage implements Serializable {
    private Map<Utilizador, Login> credenciais;
    private Map<String, Transportadoras> transportadoras;
    private Map<String, Artigos> artigos;
    private Map<String, Encomenda> encomendas;

    public GestorVintage() {
        this.credenciais = new HashMap<>();
        this.transportadoras = new HashMap<>();
        this.artigos = new HashMap<>();
        this.encomendas = new HashMap<>();
    }

    public Map<Utilizador, Login> getCredenciais() {
        return credenciais;
    }

    public void setCredenciais(Map<Utilizador, Login> credenciais) {
        this.credenciais = credenciais;
    }

    public Map<String, Transportadoras> getTransportadoras() {
        return transportadoras;
    }

    public void setTransportadoras(Map<String, Transportadoras> transportadoras) {
        this.transportadoras = transportadoras;
    }

    public Map<String, Artigos> getArtigos() {
        return artigos;
    }

    public void setArtigos(Map<String, Artigos> artigos) {
        this.artigos = artigos;
    }

    public Map<String, Encomenda> getEncomendas() {
        return encomendas;
    }

    public void setEncomendas(Map<String, Encomenda> encomendas) {
        this.encomendas = encomendas;
    }


    public void addCredencial(Utilizador utilizador, Login login) {
        credenciais.put(utilizador, login);
    }

    public void removeCredencial(Utilizador utilizador) {
        credenciais.remove(utilizador);
    }

    public void addTransportadora(String codigo, Transportadoras transportadora) {
        transportadoras.put(codigo, transportadora);
    }

    public void removeTransportadora(String codigo) {
        transportadoras.remove(codigo);
    }

    public void addArtigo(String codigo, Artigos artigo) {
        artigos.put(codigo, artigo);
    }

    public void removeArtigo(String codigo) {
        artigos.remove(codigo);
    }

    public void addEncomenda(String codigo, Encomenda encomenda) {
        encomendas.put(codigo, encomenda);
    }

    public void removeEncomenda(String codigo) {
        encomendas.remove(codigo);
    }
    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("Gestor_Unidades============")
                .append("Utilizadores{").append(credenciais).append("}\n")
                .append("Transportadoras{").append(transportadoras).append("}\n")
                .append("Artigos{").append(artigos).append("}\n")
                .append("Encomendas{").append(encomendas).append("}\n")
                .append("==========================");
        return sb.toString();
    }
}
