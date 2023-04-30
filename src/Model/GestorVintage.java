package Model;

import java.io.Serializable;
import java.util.Map;

public class GestorVintage implements Serializable {
    private Map<String, Login> utilizadores;
    private Map<String, Transportadoras> transportadoras;
    private Map<String, Artigos> artigos;
    private Map<String, Encomenda> encomendas;

    
}
