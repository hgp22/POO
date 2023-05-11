import View.*;

import java.io.FileNotFoundException;
import java.io.IOException;

import Controller.*;
import Model.*;
import View.*;

public class VintageApp {
    public static void main(String[] args) throws FileNotFoundException, IOException, ClassNotFoundException, VintageException {
        GestorVintage gestor = new GestorVintage();
        Apresentacao viewer = new Apresentacao();
        Controlador controlador = new Controlador();
        
        controlador.controlador(viewer, gestor);
    
    }
}
