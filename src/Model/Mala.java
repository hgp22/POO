package Model;

import java.time.LocalDate;
import static java.time.temporal.ChronoUnit.YEARS;

public class Mala extends Artigos {

    //Dimensao da Mala
    private float altura;
    private float largura;
    private float profundidade;

    private String material;
    private int anoColecao;

    private enum Tipo{
        REGULAR,
        PREMIUM
    }
    private Tipo tipoMala;

    public Mala(){
        super();
        this.altura = 0.0F;
        this.largura = 0.0F;
        this.profundidade = 0.0F;
        this.material = "";
        this.anoColecao = 0;
        this.tipoMala = Tipo.REGULAR;
    }

    public Mala(String descricao, String marca, String cod, float precoBase, float desconto, int novoUsado, Estado estado,
                int numDonos, float altura, float largura, float profundidade, String material, int anoColecao, Tipo tipoMala){
        super(descricao, marca, cod, precoBase, desconto, novoUsado, estado, numDonos);
        this.altura = altura;
        this.largura = largura;
        this.profundidade = profundidade;
        this.material = material;
        this.anoColecao = anoColecao;
        this.tipoMala = tipoMala;
    }

    public Mala(Mala mala){
        super(mala);
        this.altura = mala.getAltura();
        this.largura = mala.getLargura();
        this.profundidade = mala.getProfundidade();
        this.material = mala.getMaterial();
        this.anoColecao = mala.getAnoColecao();
        this.tipoMala = mala.getTipoMala();
    }

    public float getAltura() {
        return altura;
    }

    public void setAltura(float altura) {
        this.altura = altura;
    }

    public float getLargura() {
        return largura;
    }

    public void setLargura(float largura) {
        this.largura = largura;
    }

    public float getProfundidade() {
        return profundidade;
    }

    public void setProfundidade(float profundidade) {
        this.profundidade = profundidade;
    }

    public String getMaterial() {
        return material;
    }

    public void setMaterial(String material) {
        this.material = material;
    }

    public int getAnoColecao() {
        return anoColecao;
    }

    public void setAnoColecao(int anoColecao) {
        this.anoColecao = anoColecao;
    }

    public Tipo getTipoMala() {
        return tipoMala;
    }

    public void setTipoMala(Tipo tipoMala) {
        this.tipoMala = tipoMala;
    }

    public float preco(){
        float pb = getPrecoBase();
        float desconto = pb * (1/(this.altura*this.largura*this.profundidade)) * (1/this.anoColecao);
        float pf = pb * desconto;
        return pf; // + valorizacao
    }

    public float valorizacao(LocalDate inicio, LocalDate fim){
        long anos = YEARS.between(inicio, fim);
        float val = (float) (0.1 * anos);
        return val;
    }

    public boolean equals(Object o){
        Artigos artigo = (Mala) o;
        if (!super.equals(artigo)) return false;
        if(this == o) return true;
        if(o == null || this.getClass() != o.getClass()) return false;

        return (this.altura == ((Mala) o).getAltura() &&
                this.largura == ((Mala) o).getLargura() &&
                this.profundidade == ((Mala) o).getProfundidade() &&
                this.material == ((Mala) o).getMaterial() &&
                this.anoColecao == ((Mala) o).getAnoColecao() &&
                this.tipoMala == ((Mala) o).getTipoMala());
    }

    public String toString(){
        StringBuilder string = new StringBuilder();
        string.append(super.toString());
        string.append("Mala-----------").append("\n");
        string.append("Dimensao: ").append(this.altura).append("x").append(this.largura).append("x").append(this.profundidade);
        string.append("Material: ").append(this.material).append("\n");
        string.append("Ano: ").append(this.anoColecao).append("\n");
        string.append("Tipo de Mala: ").append(this.tipoMala).append("\n");
        string.append("-----------------");
        return string.toString();
    }

    public Mala clone(){
        Mala mala = this;
        return mala;
    }
}