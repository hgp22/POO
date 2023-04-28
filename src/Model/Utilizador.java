package Model;

import java.util.List;

public class Utilizador extends Login{
    private static int idCounter = 0;
    private int id;
    private String nome;
    private String morada;
    private int n_fiscal;
    private List<String> produtosComprados;
    private List<String> produtosVendidos;
    private List<String> produtosAVenda;
    private double lucro;

    public Utilizador() {
        super();
        this.id = idCounter++;
        this.nome = "";
        this.morada = "";
        this.n_fiscal = 0;
        this.produtosComprados = null;
        this.produtosVendidos = null;
        this.produtosAVenda = null;
        this.lucro = 0.0;
    }

    public Utilizador(String email, String password, String nome, String morada, int n_fiscal, List<String> produtosComprados, List<String> produtosVendidos, List<String> produtosAVenda, double lucro) {
        super(email, password);
        this.id = idCounter++;
        this.nome = nome;
        this.morada = morada;
        this.n_fiscal = n_fiscal;
        this.produtosComprados = produtosComprados;
        this.produtosVendidos = produtosVendidos;
        this.produtosAVenda = produtosAVenda;
        this.lucro = lucro;
    }

    public Utilizador(Utilizador u) {
        super(u.getEmail(), u.getPassword());
        this.id = idCounter++;
        this.nome = u.getNome();
        this.morada = u.getMorada();
        this.n_fiscal = u.getN_fiscal();
        this.produtosComprados = u.getProdutosComprados();
        this.produtosVendidos = u.getProdutosVendidos();
        this.produtosAVenda = u.getProdutosAVenda();
        this.lucro = u.getLucro();
    }


    public int getId() {
        return id;
    }

    public void setId() {
        this.id = idCounter++;
    }

    public String getNome() {
        return nome;
    }

    public void setNome (String nome) {
        this.nome = nome;
    }

    public String getMorada() {
        return morada;
    }

    public void setMorada (String morada) {
        this.morada = morada;
    }

    public int getN_fiscal() {
        return n_fiscal;
    }

    public void setN_fiscal (int n_fiscal) {
        this.n_fiscal = n_fiscal;
    }

    public List<String> getProdutosComprados() {
        return produtosComprados;
    }

    public void setProdutosComprados (List<String> produtosComprados) {
        this.produtosComprados = produtosComprados;
    }

    public List<String> getProdutosVendidos() {
        return produtosVendidos;
    }

    public void setProdutosVendidos (List<String> produtosVendidos) {
        this.produtosVendidos = produtosVendidos;
    }

    public List<String> getProdutosAVenda() {
        return produtosAVenda;
    }

    public void setProdutosAVenda (List<String> produtosAVenda) {
        this.produtosAVenda = produtosAVenda;
    }

    public double getLucro() {
        return lucro;
    }

    public void setLucro (double lucro) {
        this.lucro = lucro;
    }

    public Utilizador clone() {
        return new Utilizador(this);
    }

    public String toString() {
        return "Utilizador{" +
                "id=" + id +
                ", nome='" + nome + '\'' +
                ", morada='" + morada + '\'' +
                ", n_fiscal=" + n_fiscal +
                ", produtosComprados=" + produtosComprados +
                ", produtosVendidos=" + produtosVendidos +
                ", produtosAVenda=" + produtosAVenda +
                ", lucro=" + lucro +
                '}';
    }

    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Utilizador)) return false;
        Utilizador that = (Utilizador) o;
        return getId() == that.getId() &&
                getN_fiscal() == that.getN_fiscal() &&
                Double.compare(that.getLucro(), getLucro()) == 0 &&
                getNome().equals(that.getNome()) &&
                getMorada().equals(that.getMorada()) &&
                getProdutosComprados().equals(that.getProdutosComprados()) &&
                getProdutosVendidos().equals(that.getProdutosVendidos()) &&
                getProdutosAVenda().equals(that.getProdutosAVenda());
    }



}
