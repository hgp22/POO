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

    private Tamanho tamanho;
    private Padrao padrao;

    public Tshirt() {
        super();
        this.tamanho = Tamanho.S;
        this.padrao = Padrao.LISO;
    }

    public Tshirt(String descricao, String marca, String cod, float precoBase, float desconto, int novoUsado, EstadoArtigo estado,
                  int numDonos, Transportadoras transportadora, Utilizador vendedor, Tamanho tamanho, Padrao padrao) {
        super(descricao, marca, cod, precoBase, desconto, novoUsado, estado, numDonos, transportadora, vendedor);
        this.tamanho = tamanho;
        this.padrao = padrao;
    }

    public Tshirt(Tshirt tshirt){
        super(tshirt);
        this.tamanho = Tamanho.S;
        this.padrao = Padrao.LISO;
    }

    public Tamanho getTamanho() {
        return tamanho;
    }

    public void setTamanho(Tamanho tamanho) {
        this.tamanho = tamanho;
    }

    public Padrao getPadrao() {
        return padrao;
    }

    public void setPadrao(Padrao padrao) {
        this.padrao = padrao;
    }

    public double precoTshirt(){
        double pb = super.getPrecoBase();

        if(this.padrao != Padrao.LISO && super.getNovoUsado() == 1)
            return pb * 0.5;

        return pb - this.getDesconto();
    }

    public boolean equals(Object o){
        if (!super.equals(o)) return false;
        if(this == o) return true;
        if(o == null || this.getClass() != o.getClass()) return false;

        return (this.tamanho == ((Tshirt) o).getTamanho() &&
                this.padrao == ((Tshirt) o).getPadrao());
    }

    public String toString(){
        StringBuilder string = new StringBuilder();
        string.append(super.toString());
        string.append("Tshirt-----------").append("\n");
        string.append("Padrao > ").append(this.padrao).append("\n");
        string.append("Tamanho > ").append(this.tamanho).append("\n");
        string.append("-----------------");
        return string.toString();
    }

    public Tshirt clone(){
        return new Tshirt(this);
    }
}