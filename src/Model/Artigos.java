package Model;

public class Artigos{
    private String descricao;
    private String marca;
    private String cod;
    private float preco_base;
    private float desconto;
    private int novo_usado; // Flag = 1 se novo, 0 se usado
    public enum Estado{
        QUASE_NOVO,
        GASTO,
        MUITO_GASTO
    }
    private Estado estado;
    private int num_donos;

    public Artigos(){
        this.descricao = "";
        this.marca = "";
        this.cod = "";
        this.preco_base = 0.0F;
        this.desconto = 0.0F;
        this.novo_usado = 1;
        this.estado = Estado.QUASE_NOVO;
        this.num_donos = 0;
    }

    public Artigos(String descricao, String marca, String cod, float preco_base, float desconto, int novo_usado, Estado estado,int num_donos) {
        this.descricao = descricao;
        this.marca = marca;
        this.cod = cod;
        this.preco_base = preco_base;
        this.desconto = desconto;
        this.novo_usado = novo_usado;
        this.estado = estado;
        this.num_donos = num_donos;
    }

    public Artigos (Artigos artigo) {
        this.descricao = artigo.getDescricao();
        this.marca = artigo.getMarca();
        this.cod = artigo.getCod();
        this.preco_base = artigo.getPreco_base();
        this.desconto = artigo.getDesconto();
        this.novo_usado = artigo.getNovo_usado();
        this.estado = artigo.getEstado();
        this.num_donos = artigo.getNum_donos();
    }

    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }

    public String getMarca() {
        return marca;
    }

    public void setMarca(String marca) {
        this.marca = marca;
    }

    public String getCod() {
        return cod;
    }

    public void setCod(String cod) {
        this.cod = cod;
    }

    public float getPreco_base() {
        return preco_base;
    }

    public void setPreco_base(float preco_base) {
        this.preco_base = preco_base;
    }

    public float getDesconto() {
        return desconto;
    }

    public void setDesconto(float desconto) {
        this.desconto = desconto;
    }

    public int getNovo_usado() {
        return novo_usado;
    }

    public void setNovo_usado(int novo_usado) {
        this.novo_usado = novo_usado;
    }

    public void setEstado(Estado estado) {
        this.estado = estado;
    }

    public Estado getEstado() {
        return estado;
    }

    public int getNum_donos() {
        return num_donos;
    }

    public void setNum_donos(int num_donos) {
        this.num_donos = num_donos;
    }

    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || this.getClass() != o.getClass()) return false;
        Artigos artigo = (Artigos) o;
        return this.descricao == artigo.getDescricao() &&
                this.marca.equals(artigo.getMarca()) &&
                this.descricao.equals(artigo.getDescricao()) &&
                this.cod.equals(artigo.getCod()) &&
                this.preco_base == artigo.getPreco_base() &&
                this.desconto == artigo.getDesconto() &&
                this.novo_usado == artigo.getNovo_usado() &&
                this.estado == artigo.getEstado() &&
                this.num_donos == artigo.getNum_donos();
    }

    public String toString() {
        StringBuilder tsArtigo = new StringBuilder();
        tsArtigo.append("Descrição: ").append(this.descricao).append("\n");
        tsArtigo.append("Marca: ").append(this.marca).append("\n");
        tsArtigo.append("Código: ").append(this.cod).append("\n");
        tsArtigo.append("Preço Base: ").append(this.preco_base).append("\n");
        tsArtigo.append("Desconto: ").append(this.desconto).append("\n");
        tsArtigo.append("Novo(1) / Usado(0): ").append(this.novo_usado).append("\n");
        tsArtigo.append("Estado: ").append(this.estado).append("\n");
        tsArtigo.append("Número de donos: ").append(this.num_donos).append("\n");
        return tsArtigo.toString();
    }
    public Artigos clone() {
        return new Artigos(this);
    }



}