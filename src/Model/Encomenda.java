package Model;

import java.time.LocalDate;
import java.util.List;
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
    
    private static int idEncomenda = 0;
    private int id;
    private List<Artigos> artigos;
    private dimensaoEncomenda dimensao;
    private float precoFinal;
    private estadoEncomenda estado;
    private LocalDate dataCompra;

    public Encomenda() {
        this.id = idEncomenda++;
        this.artigos = null;
        this.dimensao = null;
        this.precoFinal = 0.0F;
        this.estado = null;
        this.dataCompra = LocalDate.now();
    }

    public Encomenda(List<Artigos> artigos, dimensaoEncomenda dimensao, float precoFinal, estadoEncomenda estado, LocalDate dataCompra) {
        this.id = idEncomenda++;
        this.artigos = artigos;
        this.dimensao = dimensao;
        this.precoFinal = precoFinal;
        this.estado = estado;
        this.dataCompra = dataCompra;
        
    }

    public Encomenda(Encomenda encomenda) {
        this.id = encomenda.getId();
        this.artigos = encomenda.getArtigos();
        this.dimensao = encomenda.getDimensao();
        this.precoFinal = encomenda.getPrecoFinal();
        this.estado = encomenda.getEstado();
        this.dataCompra = encomenda.getDataCompra();
    }

    public int getId() {
        return id;
    }

    public List<Artigos> getArtigos() {
        return artigos;
    }

    public dimensaoEncomenda getDimensao() {
        return dimensao;
    }

    public float getPrecoFinal() {
        return precoFinal;
    }

    public estadoEncomenda getEstado() {
        return estado;
    }

    public LocalDate getDataCompra() {
        return dataCompra;
    }

    public void setId(int id) {
        this.id = id;
    }

    public void setArtigos(List<Artigos> artigos) {
        this.artigos = artigos;
    }

    public void setDimensao(dimensaoEncomenda dimensao) {
        this.dimensao = dimensao;
    }

    public void setPrecoFinal(float precoFinal) {
        this.precoFinal = precoFinal;
    }

    public void setEstado(estadoEncomenda estado) {
        this.estado = estado;
    }

    public void setDataCompra(LocalDate dataCompra) {
        this.dataCompra = dataCompra;
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
        sb.append(", estado=").append(estado);
        sb.append(", dataCompra=").append(dataCompra);
        sb.append('}');
        return sb.toString();
    }

    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || this.getClass() != o.getClass()) return false;
        Encomenda encomenda = (Encomenda) o;
        return getId() == encomenda.getId() &&
                Float.compare(encomenda.getPrecoFinal(), getPrecoFinal()) == 0 &&
                getArtigos().equals(encomenda.getArtigos()) &&
                getDimensao() == encomenda.getDimensao() &&
                getEstado() == encomenda.getEstado() &&
                getDataCompra().equals(encomenda.getDataCompra());
    }
}