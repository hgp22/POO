package Model;

import java.time.LocalDate;
import java.util.Map;

public class Encomenda {
    private Map<String, Artigos> artigos;
    public enum estadoEncomenda {
        PENDENTE,
        FINALIZADA,
        EXPEDIDA
    }
    private estadoEncomenda estado;
    public enum dimensaoEncomenda {
        PEQUENA,
        MEDIA,
        GRANDE
    }
    private dimensaoEncomenda dimensao;
    private float preco;
    private LocalDate data;
    
}
