package Model;

import java.time.LocalDate;

public class Sapatilhas extends Artigos {
    private float tamanho;
    private boolean atacadores;
    private String cor;
    private LocalDate dataLancamento;
    public enum TipoSapatilhas{
        REGULAR,
        PREMIUM
    }
    private TipoSapatilhas tipoSapatilhas;

    public Sapatilhas(){
        super();
        this.tamanho = 0.0F;
        this.atacadores = true;
        this.cor = "";
        this.dataLancamento = LocalDate.now();
        this.tipoSapatilhas = TipoSapatilhas.REGULAR;
    }

    public Sapatilhas(String descricao, String marca, String cod, float precoBase, float desconto, int novoUsado,
                      EstadoArtigo estado, int numDonos, Transportadoras transportadora, Utilizador vendedor, float tamanho, boolean atacadores, String cor, LocalDate dataLancamento,
                      TipoSapatilhas tipoSapatilhas) {
        super(descricao, marca, cod, precoBase, desconto, novoUsado, estado, numDonos, transportadora, vendedor);
        this.tamanho = tamanho;
        this.atacadores = atacadores;
        this.cor = cor;
        this.dataLancamento = dataLancamento;
        this.tipoSapatilhas = tipoSapatilhas;
    }
    public Sapatilhas(Sapatilhas sapatilhas){
        super(sapatilhas);
        this.tamanho = sapatilhas.getTamanho();
        this.atacadores = sapatilhas.getAtacadores();
        this.cor = sapatilhas.getCor();
        this.dataLancamento = sapatilhas.getDataLancamento();
        this.tipoSapatilhas = sapatilhas.getTipo();
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

    public TipoSapatilhas getTipo() {
        return tipoSapatilhas;
    }

    public void setTipo(TipoSapatilhas tipoSapatilhas) {
        this.tipoSapatilhas = tipoSapatilhas;
    }

    @Override
    public String toString() {
        StringBuilder tsSapatilhas = new StringBuilder();
        tsSapatilhas.append(super.toString());
        tsSapatilhas.append("Tamanho: ").append(this.tamanho).append("\n");
        tsSapatilhas.append("Atacadores: ").append(this.atacadores).append("\n");
        tsSapatilhas.append("Cor: ").append(this.cor).append("\n");
        tsSapatilhas.append("Data de lançamento: ").append(this.dataLancamento).append("\n");
        tsSapatilhas.append("Tipo de sapatilha: ").append(this.tipoSapatilhas).append("\n");
        return tsSapatilhas.toString();
    }

    public Sapatilhas clone() {
        return new Sapatilhas(this);
    }

    @Override
    public boolean equals(Object o) {
        if (!super.equals(o)) return false;
        if(this == o) return true;
        if (this.getClass() != o.getClass()) return false;

        return this.tamanho == ((Sapatilhas) o).getTamanho() &&
               this.atacadores == ((Sapatilhas) o).getAtacadores() &&
               this.cor == ((Sapatilhas) o).getCor() &&
               this.dataLancamento == ((Sapatilhas) o).getDataLancamento() &&
               this.tipoSapatilhas == ((Sapatilhas) o).getTipo();
    }

    public float precoSapatilhas(){
         float pb = super.getPrecoBase();
         int donos = super.getNumDonos();

         if (this.getTipo() == TipoSapatilhas.REGULAR){
            if(tamanho > 45 || super.getNovoUsado() == 1){
                if(this.getEstado() == EstadoArtigo.MUITO_GASTO){
                    pb = (float)(pb * (1 / donos) * 0.5);
                }
                if(this.getEstado() == EstadoArtigo.GASTO){
                    pb = (float)(pb * (1 / donos) * 0.25);
                }
                if(this.getEstado() == EstadoArtigo.QUASE_NOVO){
                    pb = (float)(pb * (1 / donos) * 0.1);
                }
                return pb - this.getDesconto();
         } else return pb - this.getDesconto();
    }
            else pb = precoSapatilhasPremium();
            return pb;
}

    public float precoSapatilhasPremium(){
        float pp = getPrecoBase();
        pp = (float)(pp * (1.10 *(LocalDate.now().getYear() - this.dataLancamento.getYear())));
        return pp;
    }
}