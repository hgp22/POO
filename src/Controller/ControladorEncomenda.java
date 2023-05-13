package Controller;

import java.time.LocalDate;
import java.util.List;
import Model.*;
import Model.Encomenda.dimensaoEncomenda;
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

    public Encomenda criarEncomenda(GestorVintage gestor, Apresentacao a, List<Artigos> artigosFinal, Login login) {
        int tamanho = artigosFinal.size();
        dimensaoEncomenda dimensao = gestor.dimensaoEncomenda(tamanho);
        LocalDate data = LocalDate.now();
        float preco = gestor.precoFinal(artigosFinal);


        
        return encomenda;
    }

}
