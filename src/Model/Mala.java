package Model;

import java.time.LocalDate;
import static java.time.temporal.ChronoUnit.YEARS;

public class Mala extends Artigos {

    //Dimensao da Mala
    private float altura;
    private float largura;
    private float profundidade;

    private String material;
    private LocalDate dataLancamento;

    public enum TipoMala{
        REGULAR,
        PREMIUM
    }
    private TipoMala tipoMala;

    public Mala(){
        super();
        this.altura = 0.0F;
        this.largura = 0.0F;
        this.profundidade = 0.0F;
        this.material = "";
        this.dataLancamento = LocalDate.now();
        this.tipoMala = TipoMala.REGULAR;
    }

    public Mala(String descricao, String marca, String cod, float precoBase, float desconto, int novoUsado, EstadoArtigo estado,
                int numDonos, Transportadoras transportadora,Utilizador vendedor, float altura, float largura, float profundidade, String material, LocalDate dataLancamento, TipoMala tipoMala){
        super(descricao, marca, cod, precoBase, desconto, novoUsado, estado, numDonos, transportadora, vendedor);
        this.altura = altura;
        this.largura = largura;
        this.profundidade = profundidade;
        this.material = material;
        this.dataLancamento = dataLancamento;
        this.tipoMala = tipoMala;
    }

    public Mala(Mala mala){
        super(mala);
        this.altura = mala.getAltura();
        this.largura = mala.getLargura();
        this.profundidade = mala.getProfundidade();
        this.material = mala.getMaterial();
        this.dataLancamento = mala.getDataLancamento();
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

    public LocalDate getDataLancamento() {
        return dataLancamento;
    }

    public void setDataLancamento(LocalDate dataLancamento) {
        this.dataLancamento = dataLancamento;
    }

    public TipoMala getTipoMala() {
        return tipoMala;
    }

    public void setTipoMala(TipoMala tipoMala) {
        this.tipoMala = tipoMala;
    }

    public float precoMala(){
        float pb = getPrecoBase();
        float desconto = pb * (1/(this.altura*this.largura*this.profundidade)) * (1/this.dataLancamento.getYear());
        float pf = pb * desconto;
        if (this.tipoMala == TipoMala.PREMIUM) pf = pf + this.valorizacaoMala(this.dataLancamento, LocalDate.now());
        return pf - this.getDesconto(); // + valorizacao
    }

    public float valorizacaoMala(LocalDate inicio, LocalDate fim){
        long anos = YEARS.between(inicio, fim);
        float val = (float) ((0.1 * anos)/this.getPrecoBase()) * 100;
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
                this.dataLancamento == ((Mala) o).getDataLancamento() &&
                this.tipoMala == ((Mala) o).getTipoMala());
    }

    public String toString(){
        StringBuilder string = new StringBuilder();
        string.append(super.toString());
        string.append("-------------Mala-----------").append("\n");
        string.append("Dimensao: ").append(this.altura).append(" x ").append(this.largura).append(" x ").append(this.profundidade).append("\n");
        string.append("Material: ").append(this.material).append("\n");
        string.append("Data: ").append(this.dataLancamento).append("\n");
        string.append("Tipo de Mala: ").append(this.tipoMala).append("\n");
        string.append("-----------------");
        return string.toString();
    }

    public Mala clone(){
        return new Mala(this);
    }
}