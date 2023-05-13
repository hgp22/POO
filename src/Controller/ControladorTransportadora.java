package Controller;

import Model.GestorVintage;
import Model.Transportadoras;
import View.Apresentacao;

public class ControladorTransportadora {
    private Input input;

    public ControladorTransportadora() {
        this.input = new Input();
    }

    public Transportadoras criarTransportadora(Apresentacao a, GestorVintage gestor) {
        a.printMessage("---------------  CRIAR TRANSPORTADORA  ---------------");
        String nome = this.input.lerString(a,"Insira o nome da transportadora: ");
        boolean transportaPremium = input.readSN(a,"Insira se é uma transportadora premium [S/N]:");
        float lucro = input.lerFloat(a,"Insira o lucro da transportadora, entre 0.1 e 1 :",0.1F,1);

        if (gestor.getTransportadoras().containsKey(nome)) {
            a.printMessage("Já existe uma transportadora com esse nome!");
            return null;
        } else {
            a.printMessage("Transportadora criada com sucesso!");
            return new Transportadoras(nome, transportaPremium, lucro);
        }
    }

    
}
