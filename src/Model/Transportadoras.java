package Model;

public class Transportadoras {
    private String nome;
    private boolean transportaPremium; //nao sei se isto é preciso
    private float imposto;
    private float lucro;
    private float faturado;
    
    public Transportadoras(){
        this.nome = "";
        this.transportaPremium = false;
        this.imposto = 0.3F;
        this.lucro = 0.0F;
        this.faturado = 0.0F;
    }

    public Transportadoras(String nome, boolean transportaPremium, float lucro) {
        this.nome = nome;
        this.transportaPremium = transportaPremium;
        this.imposto = 0.3F;
        this.lucro = lucro;
        this.faturado = 0.0F;
    }

    public Transportadoras(Transportadoras transportadora) {
        this.nome = transportadora.getNome();
        this.transportaPremium = transportadora.getTransportaPremium();
        this.imposto = transportadora.getImposto();
        this.lucro = transportadora.getLucro();
        this.faturado = transportadora.getFaturado();
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

    public Transportadoras clone(){
        return new Transportadoras(this);
    }

    public String toString() {
        return "Transportadoras{" +
                "nome='" + nome  +
                ", transportaPremium=" + transportaPremium +
                ", imposto=" + imposto +
                ", lucro=" + lucro +
                '}';
    }

    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || this.getClass() != o.getClass()) return false;

        Transportadoras transportadora = (Transportadoras) o;

        if (getTransportaPremium() != transportadora.getTransportaPremium()) return false;
        if (Float.compare(transportadora.getImposto(), getImposto()) != 0) return false;
        if (Float.compare(transportadora.getLucro(), getLucro()) != 0) return false;
        return getNome().equals(transportadora.getNome());
    }
}
