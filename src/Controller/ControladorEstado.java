package Controller;

import java.io.IOException;

import Files.Estados;
import Model.GestorVintage;
import View.Apresentacao;

public class ControladorEstado {
    private Input input;

    public ControladorEstado() {
        this.input = new Input();
    }

    public void salvarEstado(Apresentacao a, GestorVintage gestor) {
        String nomeFicheiro;
        do{
            nomeFicheiro = this.input.lerString(a, "Introduza o nome do ficheiro com .dat: ");
        } while(nomeFicheiro.equals("default.dat"));
        Estados estado = new Estados();
        try{
            estado.guardarEstado(nomeFicheiro + ".dat", gestor);
            a.printMessage("Estado guardado com sucesso!");
        } catch (IOException e) {
            a.printMessage("Erro ao guardar o estado!");
            e.printStackTrace();
        }
    }

    public void carregarEstado(Apresentacao a, GestorVintage gestor){
        String s = this.input.lerString(a, "Introduza o nome do ficheiro .dat a carregar: ");
        try{
            Estados.carregarEstado(s + ".dat", gestor);
            a.printMessage("Estado carregado com sucesso!");
        } catch (ClassNotFoundException | IOException e) {
            a.printMessage("Ficheiro nao existente!");
            e.printStackTrace();
        }
    }

    public GestorVintage loadEstado(Apresentacao a){
        String s = this.input.lerString(a, "Introduza o nome do ficheiro .dat a carregar: ");
        GestorVintage gestorLoaded = new GestorVintage();
        try{
            gestorLoaded = Estados.carregarEstado(s + ".dat");
            a.printMessage("Estado carregado com sucesso!");
        } catch (ClassNotFoundException | IOException e) {
            a.printMessage("Ficheiro nao existente!");
            e.printStackTrace();
        }
        return gestorLoaded;
    }
}
