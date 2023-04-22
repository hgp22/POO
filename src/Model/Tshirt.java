package Model;

public class Tshirt extends Artigos {
    public enum Tamanho{
        S,
        L,
        M,
        XL
    }

    public enum Padrao{
        LISO,
        RISCAS,
        PALMEIRAS
    }

    private Tamanho t;
    private Padrao padrao;

    public Tshirt() {
        super();
        this.t = Tamanho.S;
        this.padrao = Padrao.LISO;
    }

    public Tshirt(Tamanho tamanho, Padrao padrao) {
        super();
        this.t = tamanho;
        this.padrao = padrao;
    }

    public Tshirt(Tshirt tshirt){
        this.t = Tamanho.S;
        this.padrao = Padrao.LISO;
    }

    public Tamanho getTamanho() {
        return t;
    }

    public void setTamanho(Tamanho tamanho) {
        this.t = tamanho;
    }

    public Padrao getPadrao() {
        return padrao;
    }

    public void setPadrao(Padrao padrao) {
        this.padrao = padrao;
    }

    public double precoTshirt(){
        double pb = getPreco_base();
        double correcao_preco = pb;

        if(this.padrao != Padrao.LISO)
            return correcao_preco = pb * 0.5;

        return pb;
    }

    public boolean equals(Object o){
        if(this == o) return true;
        if(o == null || this.getClass() != o.getClass()) return false;

        Artigos artigo = (Tshirt) o;
        return (this.t == ((Tshirt) o).getTamanho() &&
                this.padrao == ((Tshirt) o).getPadrao());
    }

    public String toString(){
        StringBuilder string = new StringBuilder();
        string.append(super.toString());
        string.append("Tshirt-----------").append("\n");
        string.append("Padrao > ").append(this.padrao).append("\n");
        string.append("Tamanho > ").append(this.t).append("\n");
        string.append("-----------------");
        return string.toString();
    }

    public Tshirt clone(){
        return new Tshirt(this);
    }
}