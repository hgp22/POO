package Model;

import java.io.Serializable;
import java.time.LocalDate;
import java.util.*;
import static java.time.temporal.ChronoUnit.DAYS;

import Model.Encomenda.dimensaoEncomenda;
import Model.Encomenda.estadoEncomenda;

public class GestorVintage implements Serializable {
    private Map<String, Utilizador> utilizadores;
    private Map<String, Transportadoras> transportadoras;
    private List<Artigos> artigosVenda; 
    private Map<Integer, Encomenda> encomendas;
    private LocalDate data;

    public GestorVintage() {
        this.utilizadores = new HashMap<>();
        this.transportadoras = new HashMap<>();
        this.artigosVenda = new ArrayList<>();
        this.encomendas = new HashMap<>(); 
        this.data = LocalDate.now();   
    }

    public GestorVintage(Map<String, Utilizador> utilizadores, Map<String, Transportadoras> transportadoras, List<Artigos> artigosVenda, Map<Integer, Encomenda> encomendas) {
        this.utilizadores = utilizadores;
        this.transportadoras = transportadoras;
        this.artigosVenda = artigosVenda;
        this.encomendas = encomendas;
        this.data = LocalDate.now();
    }

    public GestorVintage(GestorVintage gestor) {
        this.utilizadores = gestor.getUtilizadores();
        this.transportadoras = gestor.getTransportadoras();
        this.artigosVenda = gestor.getArtigosVenda();
        this.encomendas = gestor.getEncomendas();
        this.data = gestor.getData();
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
        for (Artigos artigo : this.artigosVenda) {
                aux.add(artigo.clone());
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

    public LocalDate getData() {
        return this.data;
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
        artigosVenda.add(artigo);
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

    public boolean existeTransportadora(String nome) {
        return transportadoras.containsKey(nome);
    }

    public List<Artigos> getArtigosDisponiveis(Login login) {
        List<Artigos> aux = new ArrayList<>();
        for (Artigos artigo : this.artigosVenda) {
            if (artigo.getVendedor().getEmail() != login.getEmail()) {
                aux.add(artigo.clone());
            }
        }
        return aux;
    }

    // verificar se existe o utilizador
    public boolean existeUtilizador(String email, String password) {
        Utilizador us = utilizadores.get(email);
        if(us != null){
            return us.getPassword().equals(password);
        }    
        return false;
    }

    public Transportadoras getTransportadora(String nome) {
        return transportadoras.get(nome);
    }

    public Utilizador getUtilizador(String email) {
        return utilizadores.get(email);
    }

    public dimensaoEncomenda dimensaoEncomenda(int tamanho){
        if(tamanho < 2) return dimensaoEncomenda.PEQUENA;
        else if(tamanho < 5) return dimensaoEncomenda.MEDIA;
        else return dimensaoEncomenda.GRANDE;
    }

    public float precoArtigos (List<Artigos> artigosFinal){
        float preco = 0;
        for (Artigos artigo : artigosFinal) {
            if (artigo instanceof Mala){
                Mala mala = (Mala) artigo;
                preco += mala.precoMala();
            }
            else if (artigo instanceof Sapatilhas){
                Sapatilhas sapatilhas = (Sapatilhas) artigo;
                preco += sapatilhas.precoSapatilhas();
            }
            else if (artigo instanceof Tshirt){
                Tshirt Tshirt = (Tshirt) artigo;
                preco += Tshirt.precoTshirt();
            }
        }
        
        return preco;
    }

    public float precoArtigo (Artigos artigo){
        float preco = 0;
        if (artigo instanceof Mala){
            Mala mala = (Mala) artigo;
            preco += mala.precoMala();
        }
        else if (artigo instanceof Sapatilhas){
            Sapatilhas sapatilhas = (Sapatilhas) artigo;
            preco += sapatilhas.precoSapatilhas();
        }
        else if (artigo instanceof Tshirt){
            Tshirt Tshirt = (Tshirt) artigo;
            preco += Tshirt.precoTshirt();
        }
        return preco;
    }

    public float precoExpedicao(dimensaoEncomenda dimensao, Transportadoras transportadora) {
        float precoBase = 0;
        if(dimensao == dimensaoEncomenda.PEQUENA) precoBase = 2;
        else if(dimensao == dimensaoEncomenda.MEDIA) precoBase = 5;
        else if(dimensao == dimensaoEncomenda.GRANDE) precoBase = 10;
        float precoExpedicao = precoBase * transportadora.getLucro() * (1+transportadora.getImposto());
        return precoExpedicao;
    }

    public float precoTotal(float precoArtigos, float precoExpedicao) {
        return precoArtigos + precoExpedicao;
    }

    public Encomenda criarEncomenda(List<Artigos> artigosFinal, Login login, Transportadoras transportadora) {
        int tamanho = artigosFinal.size();
        dimensaoEncomenda dimensao = dimensaoEncomenda(tamanho);
        float precoArtigos = precoArtigos(artigosFinal);
        float precoExpedicao = precoExpedicao(dimensao, transportadora);
        estadoEncomenda estado = estadoEncomenda.PENDENTE;
        LocalDate dataCompra = LocalDate.now();
        float precoFinal = precoTotal(precoArtigos, precoExpedicao);
        Utilizador comprador = getUtilizador(login.getEmail());

        return new Encomenda(artigosFinal, dimensao, precoFinal, estado, dataCompra, comprador);
    }

    public void cancelarEncomenda(Encomenda encomenda, Login login) {
        for (Map.Entry<Integer, Encomenda> entry : encomendas.entrySet()) {
            if(entry.getValue().equals(encomenda)){
                encomendas.remove(entry.getKey());
            }
        }
    }

    public Map<Integer, Encomenda> getEncomendasComprador(Login login) {
        Map<Integer, Encomenda> aux = new HashMap<>();
        for (Map.Entry<Integer, Encomenda> entry : this.encomendas.entrySet()) {
            if (entry.getValue().getComprador().getEmail() == login.getEmail()) {
                aux.put(entry.getKey(), entry.getValue().clone());
            }
        }
        return aux;
    }

    public void atualizaEstadoEncomenda(Map<Integer, Encomenda> encomendas, LocalDate data){
        for (Map.Entry<Integer, Encomenda> entry : encomendas.entrySet()) {
            if(DAYS.between(entry.getValue().getDataCompra(), data) > 3){
                Encomenda encomenda = entry.getValue();
                encomenda.setEstado(estadoEncomenda.FINALIZADA);
                Transportadoras transportadora = encomenda.getArtigos().get(0).getTransportadora();
                encomendaFinalizada(encomenda, encomenda.getArtigos(), transportadora);
            }
            else if (DAYS.between(entry.getValue().getDataCompra(), data) > 1){
                entry.getValue().setEstado(estadoEncomenda.EXPEDIDA);
            }
            else{
                entry.getValue().setEstado(estadoEncomenda.PENDENTE);
            }
        }
    }

    public void encomendaFinalizada(Encomenda encomenda, List<Artigos> artigosFinal, Transportadoras transportadora){
        dimensaoEncomenda dimensao = encomenda.getDimensao();
        float precoExpedicao = precoExpedicao(dimensao, transportadora);
        for (Artigos artigo : artigosFinal) {
            float extra = 0.0F;
            if (artigo.getNovoUsado() == 0) extra = 0.5F;
            else if (artigo.getNovoUsado() == 1) extra = 0.25F;
            artigo.getVendedor().setFaturado(artigo.getVendedor().getFaturado() + precoArtigo(artigo));
            artigo.getTransportadora().setFaturado(artigo.getTransportadora().getFaturado() + precoExpedicao + extra);
            artigo.getTransportadora().setVolumeFaturado(artigo.getTransportadora().getVolumeFaturado() + 1);
            getArtigosVenda().remove(artigo);
        }
    }

    public GestorVintage avancarTempo (int dias){
        this.data = data.plusDays(dias);
        atualizaEstadoEncomenda(this.encomendas, this.data);
        return this;
    }

    public Utilizador utilizadorMaisFaturado (LocalDate inicio, LocalDate fim){
        float maior = 0;
        float faturado = 0;
        for(Utilizador utilizador : utilizadores.values()){
            for (Encomenda encomenda : this.getEncomendas().values()) {
                if(encomenda.getDataCompra().isAfter(inicio) && encomenda.getDataCompra().isBefore(fim)){
                    for(Artigos artigo : encomenda.getArtigos()){
                        if(artigo.getVendedor().equals(utilizador)){
                            faturado += precoArtigo(artigo);
                        }
                    }
                }
            }
            if(faturado > maior){
                maior = faturado;
            }
        }
        for(Utilizador utilizador : utilizadores.values()){
            for (Encomenda encomenda : this.getEncomendas().values()) {
                if(encomenda.getDataCompra().isAfter(inicio) && encomenda.getDataCompra().isBefore(fim)){
                    for(Artigos artigo : encomenda.getArtigos()){
                        if(artigo.getVendedor().equals(utilizador)){
                            faturado += precoArtigo(artigo);
                        }
                    }
                }
            }
            if(faturado == maior){
                return utilizador;
            }
        }
        return null;
    }

    public List<Artigos> artigosVendidosUtilizador (Utilizador utilizador){
        List<Artigos> artigos = new ArrayList<>();
        for (Encomenda encomenda : this.getEncomendas().values()) {
            for(Artigos artigo : encomenda.getArtigos()){
                if(artigo.getVendedor().equals(utilizador)){
                    artigos.add(artigo);
                }
            }
        }
        return artigos;
    }
}

