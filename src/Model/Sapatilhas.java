
import java.time.LocalDate;
import java.time.Month;
public class Sapatilhas extends Artigos{
    private float tamanho;
    private boolean atacadores;
    private String cor;
    private LocalDate dataLancamento;
    public enum Tipo{
        REGULAR,
        PREMIUM
    }
    private Tipo tipo_sapatilhas;

    public  Sapatilhas(){
        super();
        this.tamanho = 0.0;
        this.atacadores = true;
        this.cor = "";
        this.dataLancamento = LocalDate.now;
        this.tipos_sapatilhas = Tipo.REGULAR;
    }

    public Sapatilhas(float tamanho, boolean atacadores, String cor, LocalDate dataLancamento, Tipo tipo_sapatilhas) {
        super(descricao, marca, cod, preco_base, desconto, novo_usado, estado, num_donos);
        this.tamanho = tamanho;
        this.atacadores = atacadores;
        this.cor = cor;
        this.dataLancamento = dataLancamento;
        this.tipo_sapatilhas = tipo_sapatilhas;
    }
    public Sapatilhas(Sapatilhas sapatilhas){
        super(sapatilhas);
        this.tamanho = sapatilhas.getTamanho();
        this.atacadores = sapatilhas.getAtacadores();
        this.cor = sapatilhas.getCor();
        this.dataLancamento = sapatilhas.getDataLancamento();
        this.tipo_sapatilhas = sapatilhas.getTipo();
    }

    public float getTamanho() {
        return tamanho;
    }

    public void setTamanho(float tamanho) {
        this.tamanho = tamanho;
    }

    public boolean getAtacadores() {
        return atacadores;
    }

    public void setAtacadores(boolean atacadores) {
        this.atacadores = atacadores;
    }

    public String getCor() {
        return cor;
    }

    public void setCor(String cor) {
        this.cor = cor;
    }

    public LocalDate getDataLancamento() {
        return dataLancamento;
    }

    public void setDataLancamento(LocalDate dataLancamento) {
        this.dataLancamento = dataLancamento;
    }

    public Tipo getTipo() {
        return tipo_sapatilhas;
    }

    public void setTipo(Tipo tipo_sapatilhas) {
        this.tipo_sapatilhas = tipo_sapatilhas;
    }

    public String toString() {
        StringBuilder tsSapatilhas = new StringBuilder();
        tsSapatilhas.append(super.toString());
        tsSapatilhas.append("Tamanho: ").append(this.tamanho).append("\n");
        tsSapatilhas.append("Atacadores: ").append(this.atacadores).append("\n");
        tsSapatilhas.append("Cor: ").append(this.cor).append("\n");
        tsSapatilhas.append("Data de lançamento: ").append(this.dataLancamento).apppend("\n");
        tsSapatilhas.append("Tipo de sapatilha: ").append(this.tipo_sapatilhas).append("\n");
        return tsSapatilhas.toString();
    }

    public Sapatilhas clone() {
        return new Sapatilhas(this);
    }

    public boolean equals(Object o) {
        if (!super.equals(o)) return false;
        if(this == o) return true;
        if (o == null || this.getClass() != o.getClass()) return false;

        Artigos sapatilha = (Sapatilhas) o;
        return this.tamanho == sapatilha.getTamanho() &&
               this.atacadores == sapatilha.getAtacadores() &&
               this.cor == sapatilha.getCor() &&
               this.dataLancamento == sapatilha.getDataLancamento() &&
               this.tipo_sapatilhas == sapatilha.getTipo();
    }

    public float precoSapatilhas(){
         float pb = getPreco_base();
         int donos = getNum_donos();

         if(tamanho > 45 || this.getNovo_usado() == 0){
             if(this.getEstado() == Estado.MUITO_GASTO){
                 pb = pb * (1 / donos) * 0.5;
             }
             if(this.getEstado() == Estado.GASTO){
                 pb = pb * (1 / donos) * 0.25;
             }
             if(this.getEstado() == Estado.QUASE_NOVO){
                 pb = pb * (1 / donos) * 0.1;
             }
             return pb;
         } else return pb;
    }

    public float precoSapatilhasPremium(){
        double pp = getPreco_base();
        if(tipo_sapatilhas == Tipo.PREMIUM){
            pp *= 1.25;
        }
        return pp;
    }
}