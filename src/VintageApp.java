import View.*;
import Controller.*;
import Model.*;

public class VintageApp {
    public static void main(String[] args) {
        Controlador controlador = new Controlador();
        Viewer viewer = new Viewer(controlador);
        GestorVintage gestor = new GestorVintage();

        viewer.menu();
    }
}
