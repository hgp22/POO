package Model;

import java.io.Serializable;

public class Artigos implements Serializable {
    private String descricao;
    private String marca;
    private String cod;
    private float precoBase;
    private float desconto;
    private int novoUsado; // Flag = 0 se novo, 1 se usado
    public enum EstadoArtigo{
        QUASE_NOVO,
        GASTO,
        MUITO_GASTO;
    }
    private EstadoArtigo estado;
    private int numDonos;
    private Transportadoras transportadora;
    private Utilizador vendedor;

    public Artigos(){
        this.descricao = "";
        this.marca = "";
        this.cod = "";
        this.precoBase = 0.0F;
        this.desconto = 0.0F;
        this.novoUsado = 0;
        this.estado = null;
        this.numDonos = 0;
        this.transportadora = null;
        this.vendedor = null;
    }

    public Artigos(String descricao, String marca, String cod, float precoBase, float desconto, int novoUsado, EstadoArtigo estado,int numDonos, Transportadoras transportadora, Utilizador vendedor) {
        this.descricao = descricao;
        this.marca = marca;
        this.cod = cod;
        this.precoBase = precoBase;
        this.desconto = desconto;
        this.novoUsado = novoUsado;
        this.estado = estado;
        this.numDonos = numDonos;
        this.transportadora = transportadora;
        this.vendedor = vendedor;
    }

    public Artigos (Artigos artigo) {
        this.descricao = artigo.getDescricao();
        this.marca = artigo.getMarca();
        this.cod = artigo.getCod();
        this.precoBase = artigo.getPrecoBase();
        this.desconto = artigo.getDesconto();
        this.novoUsado = artigo.getNovoUsado();
        this.estado = artigo.getEstado();
        this.numDonos = artigo.getNumDonos();
        this.transportadora = artigo.getTransportadora();
        this.vendedor = artigo.getVendedor();
    }

    /**
     * devolve a descrição do artigo
     * @return descrição
    */

    public String getDescricao() {
        return descricao;
    }

    /**
     * altera a descrição do artigo
     * @param descricao
     */
    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }

    /**
     * devolve a marca do artigo
     * @return marca
     */
    public String getMarca() {
        return marca;
    }

    /**
     * altera a marca do artigo
     * @param marca
     */
    public void setMarca(String marca) {
        this.marca = marca;
    }

    /**
     * devolve o código do artigo
     * @return código
     */
    public String getCod() {
        return cod;
    }

    /**
     * altera o código do artigo
     * @param cod
     */
    public void setCod(String cod) {
        this.cod = cod;
    }

    /**
     * devolve o preço base do artigo
     * @return preço base
     */
    public float getPrecoBase() {
        return precoBase;
    }

    /**
     * altera o preço base do artigo
     * @param precoBase
     */
    public void setPrecoBase(float precoBase) {
        this.precoBase = precoBase;
    }

    /**
     * devolve o desconto do artigo
     * @return desconto
     */
    public float getDesconto() {
        return desconto;
    }

    /**
     * altera o desconto do artigo
     * @param desconto
     */
    public void setDesconto(float desconto) {
        this.desconto = desconto;
    }

    /**
     * devolve se o artigo é novo ou usado
     * @return novoUsado
     */
    public int getNovoUsado() {
        return novoUsado;
    }

    /**
     * altera se o artigo é novo ou usado
     * @param novoUsado
     */
    public void setNovoUsado(int novoUsado) {
        this.novoUsado = novoUsado;
    }

    /**
     * devolve o estado do artigo
     * @return estado
     */
    public void setEstado(EstadoArtigo estado) {
        this.estado = estado;
    }

    /**
     * altera o estado do artigo
     * @param estado
     */
    public EstadoArtigo getEstado() {
        return estado;
    }

    /**
     * devolve o número de donos do artigo
     * @return número de donos
     */
    public int getNumDonos() {
        return numDonos;
    }

    /**
     * altera o número de donos do artigo
     * @param numDonos
     */
    public void setNumDonos(int numDonos) {
        this.numDonos = numDonos;
    }

    /**
     * devolve a transportadora do artigo
     * @return transportadora
     */

    public Transportadoras getTransportadora() {
        return transportadora;

    }

    /**
     * altera a transportadora do artigo
     * @param transportadora
     */

    public void setTransportadora(Transportadoras transportadora) {
        this.transportadora = transportadora;

    }

    /**
     * devolve o vendedor do artigo
     * @return vendedor
     */

    public Utilizador getVendedor() {
        return vendedor;
    }

    /**
     * altera o vendedor do artigo
     * @param vendedor
     */

    public void setVendedor(Utilizador vendedor) {
        this.vendedor = vendedor;
    }



    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || this.getClass() != o.getClass()) return false;
        Artigos artigo = (Artigos) o;
        return this.descricao == artigo.getDescricao() &&
                this.marca.equals(artigo.getMarca()) &&
                this.descricao.equals(artigo.getDescricao()) &&
                this.cod.equals(artigo.getCod()) &&
                this.precoBase == artigo.getPrecoBase() &&
                this.desconto == artigo.getDesconto() &&
                this.novoUsado == artigo.getNovoUsado() &&
                this.estado == artigo.getEstado() &&
                this.numDonos == artigo.getNumDonos() &&
                this.transportadora == artigo.getTransportadora() &&
                this.vendedor == artigo.getVendedor();
    }

    @Override
    public String toString() {
        StringBuilder tsArtigo = new StringBuilder();
        tsArtigo.append("Descrição: ").append(this.descricao).append("\n");
        tsArtigo.append("Marca: ").append(this.marca).append("\n");
        tsArtigo.append("Código: ").append(this.cod).append("\n");
        tsArtigo.append("Preço Base: ").append(this.precoBase).append("\n");
        tsArtigo.append("Desconto: ").append(this.desconto).append("\n");
        tsArtigo.append("Novo(1) / Usado(0): ").append(this.novoUsado).append("\n");
        tsArtigo.append("Estado: ").append(this.estado).append("\n");
        tsArtigo.append("Número de donos: ").append(this.numDonos).append("\n");
        tsArtigo.append("Transportadora: ").append(this.transportadora).append("\n");
        tsArtigo.append("Vendedor: ").append(this.vendedor).append("\n");
        return tsArtigo.toString();
    }
    public Artigos clone() {
        return new Artigos(this);
    }




}