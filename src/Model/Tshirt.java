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

    public Tshirt(String descricao, String marca, String cod, float precoBase, float desconto, int novoUsado, Estado estado,
                  int numDonos,Tamanho tamanho, Padrao padrao) {
        super(descricao, marca, cod, precoBase, desconto, novoUsado, estado, numDonos);
        this.t = tamanho;
        this.padrao = padrao;
    }

    public Tshirt(Tshirt tshirt){
        super(tshirt);
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
        double pb = getPrecoBase();

        if(this.padrao != Padrao.LISO && super.getNovoUsado() == false)
            return pb * 0.5;

        return pb;
    }

    public boolean equals(Object o){
        if (!super.equals(o)) return false;
        if(this == o) return true;
        if(o == null || this.getClass() != o.getClass()) return false;

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