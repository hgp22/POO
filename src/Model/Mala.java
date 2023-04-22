package Model;

import java.time.LocalDate;
import static java.time.temporal.ChronoUnit.YEARS;

public class Mala extends Artigos {

    //Dimensao da Mala
    private float altura;
    private float largura;
    private float profundidade;

    private String material;
    private int ano_colecao;

    private enum Tipo{
        REGULAR,
        PREMIUM
    }
    private Tipo tipo_mala;

    public Mala(){
        super();
        this.altura = 0.0F;
        this.largura = 0.0F;
        this.profundidade = 0.0F;
        this.material = "";
        this.ano_colecao = 0;
        this.tipo_mala = Tipo.REGULAR;
    }

    public Mala(String descricao, String marca, String cod, float preco_base, float desconto, int novo_usado, Estado estado,
                int num_donos, float altura, float largura, float profundidade, String material, int ano_colecao, Tipo tipo_mala){
        super(descricao, marca, cod, preco_base, desconto, novo_usado, estado, num_donos);
        this.altura = altura;
        this.largura = largura;
        this.profundidade = profundidade;
        this.material = material;
        this.ano_colecao = ano_colecao;
        this.tipo_mala = tipo_mala;
    }

    public Mala(Mala mala){
        super(mala);
        this.altura = mala.getAltura();
        this.largura = mala.getLargura();
        this.profundidade = mala.getProfundidade();
        this.material = mala.getMaterial();
        this.ano_colecao = mala.getAno_colecao();
        this.tipo_mala = mala.getTipo_mala();
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

    public int getAno_colecao() {
        return ano_colecao;
    }

    public void setAno_colecao(int ano_colecao) {
        this.ano_colecao = ano_colecao;
    }

    public Tipo getTipo_mala() {
        return tipo_mala;
    }

    public void setTipo_mala(Tipo tipo_mala) {
        this.tipo_mala = tipo_mala;
    }

    public float preco(){
        float pb = getPreco_base();
        float desconto = pb * (1/(this.altura*this.largura*this.profundidade)) * (1/this.ano_colecao);
        float pf;
        return pf = pb * desconto; // + valorizacao
    }

    public float valorizacao(LocalDate inicio, LocalDate fim){
        long anos = YEARS.between(inicio, fim);
        float val = (float) (0.1 * anos);
        return val;
    }

    public boolean equals(Object o){
        if(this == o) return true;
        if(o == null || this.getClass() != o.getClass()) return false

        Artigos artigo = (Mala) o;
        return (this.altura == ((Mala) o).getAltura() &&
                this.largura == ((Mala) o).getLargura() &&
                this.profundidade == ((Mala) o).getProfundidade() &&
                this.material == ((Mala) o).getMaterial() &&
                this.ano_colecao == ((Mala) o).getAno_colecao() &&
                this.tipo_mala == ((Mala) o).getTipo_mala());
    }

    public String toString(){
        StringBuilder string = new StringBuilder();
        string.append(super.toString());
        string.append("Mala-----------").append("\n");
        string.append("Dimensao: ").append(this.altura).append("x").append(this.largura).append("x").append(this.profundidade);
        string.append("Material: ").append(this.material).append("\n");
        string.append("Ano: ").append(this.ano_colecao).append("\n");
        string.append("Tipo de Mala: ").append(this.tipo_mala).append("\n");
        string.append("-----------------");
        return string.toString();
    }

    public Mala clone(){
        Mala mala = this;
        return mala;
    }
}