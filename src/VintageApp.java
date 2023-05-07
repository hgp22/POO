import View.*;

import java.io.FileNotFoundException;
import java.io.IOException;

import Controller.*;
import Model.*;

public class VintageApp {
    public static void main(String[] args) throws FileNotFoundException, IOException, ClassNotFoundException, VintageException {
        GestorVintage gestor = new GestorVintage();
        Controlador controlador = new Controlador(gestor);
        Viewer viewer = new Viewer(controlador);

        viewer.menu();
    }
}
