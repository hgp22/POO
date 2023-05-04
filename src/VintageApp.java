import View.*;

import java.io.FileNotFoundException;
import java.io.IOException;

import Controller.*;
import Model.*;

public class VintageApp {
    public static void main(String[] args) throws FileNotFoundException, IOException {
        Controlador controlador = new Controlador();
        Viewer viewer = new Viewer(controlador);
        GestorVintage gestor = new GestorVintage();

        viewer.menu();
    }
}
