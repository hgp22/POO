package Model;

import java.io.Serializable;

public class Transportadoras implements Serializable {
    private String nome;
    private boolean transportaPremium; //nao sei se isto é preciso
    private float imposto;
    private float lucro;
    private float faturado;
    private int volumeFaturado;
    
    public Transportadoras(){
        this.nome = "";
        this.transportaPremium = false;
        this.imposto = 0.3F;
        this.lucro = 0.0F;
        this.faturado = 0.0F;
        this.volumeFaturado = 0;
    }

    public Transportadoras(String nome, boolean transportaPremium, float lucro) {
        this.nome = nome;
        this.transportaPremium = transportaPremium;
        this.imposto = 0.3F;
        this.lucro = lucro;
        this.faturado = 0.0F;
        this.volumeFaturado = 0;
    }

    public Transportadoras(Transportadoras transportadora) {
        this.nome = transportadora.getNome();
        this.transportaPremium = transportadora.getTransportaPremium();
        this.imposto = transportadora.getImposto();
        this.lucro = transportadora.getLucro();
        this.faturado = transportadora.getFaturado();
        this.volumeFaturado = transportadora.getVolumeFaturado();
    }

    public String getNome() {
        return nome;
    }

    public boolean getTransportaPremium() {
        return transportaPremium;
    }

    public float getImposto() {
        return imposto;
    }

    public float getLucro() {
        return lucro;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public void setTransportaPremium(boolean transportaPremium) {
        this.transportaPremium = transportaPremium;
    }


    public void setImposto(float imposto) {
        this.imposto = imposto;
    }

    public void setLucro(float lucro) {
        this.lucro = lucro;
    }

    public float getFaturado() {
        return faturado;
    }

    public void setFaturado(float faturado) {
        this.faturado = faturado;
    }

    public int getVolumeFaturado() {
        return volumeFaturado;
    }

    public void setVolumeFaturado(int volumeFaturado) {
        this.volumeFaturado = volumeFaturado;
    }

    public Transportadoras clone(){
        return new Transportadoras(this);
    }

    public String toString() {
        return "Transportadoras{" +
                "nome='" + nome  +
                ", transportaPremium=" + transportaPremium +
                ", imposto=" + imposto +
                ", lucro=" + lucro +
                ", faturado=" + faturado +
                ", volumeFaturado=" + volumeFaturado +
                '}';
    }

    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Transportadoras)) return false;
        Transportadoras that = (Transportadoras) o;
        return getNome().equals(that.getNome()) &&
                getTransportaPremium() == that.getTransportaPremium() &&
                getImposto() == that.getImposto() &&
                getLucro() == that.getLucro() &&
                getFaturado() == that.getFaturado() &&
                getVolumeFaturado() == that.getVolumeFaturado();
    }
}
