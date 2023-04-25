package Model;

import java.util.List;

public class Utilizador extends Login{
    private String nome;
    private String morada;
    private int n_fiscal;
    private List<String> produtos; // adquiridos, à venda e vendidos
}
