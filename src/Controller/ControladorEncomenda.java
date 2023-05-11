package Controller;

import java.util.List;
import Model.*;
import View.*;

public class ControladorEncomenda {
    private final Input input;

    public ControladorEncomenda() {
        this.input = new Input();
    }

    // adicionar artigo a encomenda
    public List<Integer> addArtigo(Apresentacao a, List<Integer> artigosFinal, List<Integer> artigosDisponiveis) {
        int opcao;
        boolean ola = true;
        while (ola) {
            opcao = input.lerInteiro(a, "Introduza o artigo a adicionar", 0, 999999999);
            if(artigosDisponiveis.contains(opcao)){
                ola = false;
                artigosFinal.add(opcao);
                a.printMessage("Artigo adicionado");
            }
            else if (artigosFinal.contains(opcao)){
                a.printMessage("Artigo já adicionado");
            } else {
                a.printMessage("Artigo não disponível");
            }
        }
        return artigosFinal;
    }

    // remover artigo a encomenda
    public List<Integer> removeArtigo(Apresentacao a, List<Integer> artigosFinal) {
        int opcao;
        boolean ola = true;
        while (ola) {
            opcao = input.lerInteiro(a, "Introduza o artigo a remover", 0, 999999999);
            if(artigosFinal.contains(opcao)){
                ola = false;
                artigosFinal.remove(opcao);
                a.printMessage("Artigo removido");
            } else {
                a.printMessage("Artigo não adicionado");
            }
        }
        return artigosFinal;
    }

}
