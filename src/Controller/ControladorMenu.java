package Controller;

import java.util.Scanner;

import Model.GestorVintage;

public class ControladorMenu {
    private Input input;
    private Scanner sc;
    private GestorVintage gestor;

    public ControladorMenu(GestorVintage gestor) {
        this.input = new Input(sc);
        this.gestor = gestor;
    }

    public ControladorMenu(ControladorMenu controlador) {
        this.input = controlador.getInput();
        this.gestor = controlador.getGestor();
    }

    private GestorVintage getGestor() {
        return this.gestor;
    }

    public Input getInput() {
        return this.input;
    }
    
}
