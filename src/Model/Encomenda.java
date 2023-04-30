package Model;

import java.time.LocalDate;
import java.util.Map;
import java.io.Serializable;

public class Encomenda implements Serializable {
    private Map<String, Artigos> artigos;
    public enum estadoEncomenda {
        PENDENTE,
        FINALIZADA,
        EXPEDIDA
    }
    private estadoEncomenda estado;
    public enum dimensaoEncomenda {
        PEQUENA,
        MEDIA,
        GRANDE
    }
    private dimensaoEncomenda dimensao;
    private float preco;
    private LocalDate data;

    public Encomenda(){
        this.artigos = null;
        this.estado = estadoEncomenda.PENDENTE;
        this.dimensao = dimensaoEncomenda.PEQUENA;
        this.preco = 0.0F;
        this.data = LocalDate.now();
    }

    public Encomenda(Map<String, Artigos> artigos, estadoEncomenda estado, dimensaoEncomenda dimensao, float preco, LocalDate data) {
        this.artigos = artigos;
        this.estado = estado;
        this.dimensao = dimensao;
        this.preco = preco;
        this.data = data;
    }

    public Encomenda(Encomenda encomenda){
        this.artigos = encomenda.getArtigos();
        this.estado = encomenda.getEstado();
        this.dimensao = encomenda.getDimensao();
        this.preco = encomenda.getPreco();
        this.data = encomenda.getData();
    }

    public Map<String, Artigos> getArtigos() {
        return artigos;
    }

    public void setArtigos(Map<String, Artigos> artigos) {
        this.artigos = artigos;
    }

    public estadoEncomenda getEstado() {
        return estado;
    }

    public void setEstado(estadoEncomenda estado) {
        this.estado = estado;
    }

    public dimensaoEncomenda getDimensao() {
        return dimensao;
    }

    public void setDimensao(dimensaoEncomenda dimensao) {
        this.dimensao = dimensao;
    }

    public float getPreco() {
        return preco;
    }

    public void setPreco(float preco) {
        if(preco >= 0.0F)
            this.preco = preco;
    }

    public LocalDate getData() {
        return data;
    }

    public void setData(LocalDate data) {
        this.data = data;
    }

    public Encomenda clone(){
        return new Encomenda(this);
    }

    public String toString(){
        StringBuilder sb = new StringBuilder();
        sb.append("Artigos: ").append(this.artigos).append("\n");
        sb.append("Estado: ").append(this.estado).append("\n");
        sb.append("Dimensao: ").append(this.dimensao).append("\n");
        sb.append("Preco: ").append(this.preco).append("\n");
        sb.append("Data: ").append(this.data).append("\n");
        return sb.toString();
    }

    public boolean equals(Object o){
        if(this == o) return true;
        if(o == null || this.getClass() != o.getClass()) return false;
        Encomenda encomenda = (Encomenda) o;
        return this.artigos.equals(encomenda.getArtigos()) &&
                this.estado.equals(encomenda.getEstado()) &&
                this.dimensao.equals(encomenda.getDimensao()) &&
                this.preco == encomenda.getPreco() &&
                this.data.equals(encomenda.getData());
    }
}
