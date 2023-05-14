package Model;

public class Utilizador extends Login{
    private static int idCounter = 0;
    private int id;
    private String nome;
    private String morada;
    private int numeroFiscal;
    private float faturado;

    public Utilizador() {
        super();
        this.id = idCounter++;
        this.nome = "";
        this.morada = "";
        this.numeroFiscal = 0;
        this.faturado = 0.0F;
    }

    public Utilizador(String email, String password, String nome, String morada, int numeroFiscal) {
        super(email, password);
        this.id = idCounter++;
        this.nome = nome;
        this.morada = morada;
        this.numeroFiscal = numeroFiscal;
        this.faturado = 0.0F;
    }

    public Utilizador(Utilizador u) {
        super(u);
        this.id = idCounter++;
        this.nome = u.getNome();
        this.morada = u.getMorada();
        this.numeroFiscal = u.getnumeroFiscal();
        this.faturado = u.getFaturado();
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

    public float getFaturado() {
        return faturado;
    }

    public void setFaturado (float faturado) {
        this.faturado = faturado;
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
                ", faturado=" + faturado +
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
                getFaturado() == that.getFaturado();
    }


}
