package Model;

import java.util.List;

public class Utilizador extends Login{
    private static int idCounter = 0;
    private int id;
    private String nome;
    private String morada;
    private int numeroFiscal;
    private List<String> produtosComprados;
    private List<String> produtosVendidos;
    private List<String> produtosAVenda;

    public Utilizador() {
        super();
        this.id = idCounter++;
        this.nome = "";
        this.morada = "";
        this.numeroFiscal = 0;
        this.produtosComprados = null;
        this.produtosVendidos = null;
        this.produtosAVenda = null;
        
    }

    public Utilizador(String email, String password, String nome, String morada, int numeroFiscal, List<String> produtosComprados, List<String> produtosVendidos, List<String> produtosAVenda) {
        super(email, password);
        this.id = idCounter++;
        this.nome = nome;
        this.morada = morada;
        this.numeroFiscal = numeroFiscal;
        this.produtosComprados = produtosComprados;
        this.produtosVendidos = produtosVendidos;
        this.produtosAVenda = produtosAVenda;
        
    }

    public Utilizador(Utilizador u) {
        super(u);
        this.id = idCounter++;
        this.nome = u.getNome();
        this.morada = u.getMorada();
        this.numeroFiscal = u.getnumeroFiscal();
        this.produtosComprados = u.getProdutosComprados();
        this.produtosVendidos = u.getProdutosVendidos();
        this.produtosAVenda = u.getProdutosAVenda();
        
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

    public int getnumeroFiscal() {
        return numeroFiscal;
    }

    public void setnumeroFiscal (int numeroFiscal) {
        this.numeroFiscal = numeroFiscal;
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

    public Utilizador clone() {
        return new Utilizador(this);
    }

    public String toString() {
        return "Utilizador{" +
                "id=" + id +
                ", nome='" + nome + '\'' +
                ", morada='" + morada + '\'' +
                ", numeroFiscal=" + numeroFiscal +
                ", produtosComprados=" + produtosComprados +
                ", produtosVendidos=" + produtosVendidos +
                ", produtosAVenda=" + produtosAVenda +
                '}';
    }

    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Utilizador)) return false;
        Utilizador that = (Utilizador) o;
        return getId() == that.getId() &&
                getnumeroFiscal() == that.getnumeroFiscal() &&
                getNome().equals(that.getNome()) &&
                getMorada().equals(that.getMorada()) &&
                getProdutosComprados().equals(that.getProdutosComprados()) &&
                getProdutosVendidos().equals(that.getProdutosVendidos()) &&
                getProdutosAVenda().equals(that.getProdutosAVenda());
    }

    public void addVender(Artigos a) {
        this.produtosAVenda.add(a.getCod());
    }


}
