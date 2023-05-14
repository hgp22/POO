package Controller;

import java.time.LocalDate;
import java.util.List;
import java.util.Map;

import Model.*;
import View.*;

public class ControladorEncomenda {
    private final Input input;

    public ControladorEncomenda() {
        this.input = new Input();
    }

    // adicionar artigo a encomenda
    public List<Artigos> addArtigo(Apresentacao a, List<Artigos> artigosFinal, List<Artigos> artigosDisponiveis, Login login) {
        Artigos artigo = new Artigos();
        int opcao = -1;
        boolean ola = true;
        if (artigosDisponiveis.isEmpty()) {
            a.printMessage("Não existem artigos disponíveis");
            return artigosFinal;
        }
        while (ola != false) {
            opcao = input.lerInteiro(a, "Introduza o artigo a adicionar", 0, 999999999);
            artigo = artigosDisponiveis.get(opcao);
            if(artigosDisponiveis.contains(artigo)){
                ola = false;
                artigosFinal.add(artigo);
                a.printMessage("Artigo adicionado");
            }
            else if (artigosFinal.contains(artigo)){
                a.printMessage("Artigo já adicionado");
            } else {
                a.printMessage("Artigo não disponível");
            }
        }
        return artigosFinal;
    }

    // remover artigo a encomenda
    public List<Artigos> removeArtigo(Apresentacao a, List<Artigos> artigosFinal, Login login) {
        Artigos artigo = new Artigos();
        int opcao;
        boolean ola = true;
        if (artigosFinal.isEmpty()) {
            a.printMessage("Não existem artigos no carrinho");
            return artigosFinal;
        }
        while (ola) {
            opcao = input.lerInteiro(a, "Introduza o artigo a remover", 0, 999999999);
            artigo = artigosFinal.get(opcao);
            if(artigosFinal.contains(artigo)){
                ola = false;
                artigosFinal.remove(artigo);
                a.printMessage("Artigo removido");
            } else {
                a.printMessage("Artigo não existe no carrinho");
            }
        }
        return artigosFinal;
    }

    public Encomenda criarEncomenda(GestorVintage gestor, List<Artigos> artigosFinal, Login login, Transportadoras transportadora) {
        Encomenda encomenda = gestor.criarEncomenda(artigosFinal, login, transportadora);
        return encomenda;
    }

    public void cancelarEncomenda(GestorVintage gestor, Encomenda encomenda, Login login) {
        gestor.cancelarEncomenda(encomenda, login);
    }

    public float lucroTotal(Map<Integer, Encomenda> encomendas) {
        float lucro = 0;
        for (Encomenda e : encomendas.values()) {
            lucro += e.getPrecoFinal();
        }
        return lucro;
    }


}
