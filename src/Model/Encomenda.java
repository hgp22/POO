package Model;

import java.time.LocalDate;
import java.util.Map;
import java.io.Serializable;

public class Encomenda implements Serializable {
    public enum estadoEncomenda {
        PENDENTE,
        FINALIZADA,
        EXPEDIDA
    }
    public enum dimensaoEncomenda {
        PEQUENA,
        MEDIA,
        GRANDE
    }
    
    private int id;
    private Map<String, Artigos> artigos;
    private dimensaoEncomenda dimensao;
    private float precoFinal;
    private float precoExpedicao;
    private estadoEncomenda estado;
    private LocalDate dataCompra;
    private int numArtigos;

    private LocalDate data;

    public Encomenda() {
        this.id = 0;
        this.artigos = null;
        this.dimensao = null;
        this.precoFinal = 0.0F;
        this.precoExpedicao = 0.0F;
        this.estado = null;
        this.dataCompra = null;
        this.numArtigos = 0;
    }

    public Encomenda(int id, Map<String, Artigos> artigos, dimensaoEncomenda dimensao, float precoFinal, float precoExpedicao, estadoEncomenda estado, LocalDate dataCompra, int numArtigos) {
        this.id = id;
        this.artigos = artigos;
        this.dimensao = dimensao;
        this.precoFinal = precoFinal;
        this.precoExpedicao = precoExpedicao;
        this.estado = estado;
        this.dataCompra = dataCompra;
        this.numArtigos = numArtigos;
    }

    public Encomenda(Encomenda encomenda) {
        this.id = encomenda.getId();
        this.artigos = encomenda.getArtigos();
        this.dimensao = encomenda.getDimensao();
        this.precoFinal = encomenda.getPrecoFinal();
        this.precoExpedicao = encomenda.getPrecoExpedicao();
        this.estado = encomenda.getEstado();
        this.dataCompra = encomenda.getDataCompra();
        this.numArtigos = encomenda.getNumArtigos();
    }

    public int getId() {
        return id;
    }

    public Map<String, Artigos> getArtigos() {
        return artigos;
    }

    public dimensaoEncomenda getDimensao() {
        return dimensao;
    }

    public float getPrecoFinal() {
        return precoFinal;
    }

    public float getPrecoExpedicao() {
        return precoExpedicao;
    }

    public estadoEncomenda getEstado() {
        return estado;
    }

    public LocalDate getDataCompra() {
        return dataCompra;
    }

    public int getNumArtigos() {
        return numArtigos;
    }

    public void setId(int id) {
        this.id = id;
    }

    public void setArtigos(Map<String, Artigos> artigos) {
        this.artigos = artigos;
    }

    public void setDimensao(dimensaoEncomenda dimensao) {
        this.dimensao = dimensao;
    }

    public void setPrecoFinal(float precoFinal) {
        this.precoFinal = precoFinal;
    }

    public void setPrecoExpedicao(float precoExpedicao) {
        this.precoExpedicao = precoExpedicao;
    }

    public void setEstado(estadoEncomenda estado) {
        this.estado = estado;
    }

    public void setDataCompra(LocalDate dataCompra) {
        this.dataCompra = dataCompra;
    }

    public void setNumArtigos(int numArtigos) {
        this.numArtigos = numArtigos;
    }

    public Encomenda clone() {
        return new Encomenda(this);
    }

    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("Encomenda{");
        sb.append("id=").append(id);
        sb.append(", artigos=").append(artigos);
        sb.append(", dimensao=").append(dimensao);
        sb.append(", precoFinal=").append(precoFinal);
        sb.append(", precoExpedicao=").append(precoExpedicao);
        sb.append(", estado=").append(estado);
        sb.append(", dataCompra=").append(dataCompra);
        sb.append(", numArtigos=").append(numArtigos);
        sb.append('}');
        return sb.toString();
    }

    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || this.getClass() != o.getClass()) return false;
        Encomenda encomenda = (Encomenda) o;
        return getId() == encomenda.getId() &&
                Float.compare(encomenda.getPrecoFinal(), getPrecoFinal()) == 0 &&
                Float.compare(encomenda.getPrecoExpedicao(), getPrecoExpedicao()) == 0 &&
                getNumArtigos() == encomenda.getNumArtigos() &&
                getArtigos().equals(encomenda.getArtigos()) &&
                getDimensao() == encomenda.getDimensao() &&
                getEstado() == encomenda.getEstado() &&
                getDataCompra().equals(encomenda.getDataCompra());
    }
}