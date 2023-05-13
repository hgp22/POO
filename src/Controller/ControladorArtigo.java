package Controller;

import java.time.LocalDate;
import java.util.Map;

import Model.Artigos;
import Model.GestorVintage;
import Model.Login;
import Model.Mala;
import Model.Sapatilhas;
import Model.Transportadoras;
import Model.Tshirt;
import Model.Utilizador;
import View.Apresentacao;
import View.Prints;

public class ControladorArtigo {
    private Input input;

    public ControladorArtigo() {
        this.input = new Input();
    }

     public Tshirt criaTshirt(Apresentacao a, GestorVintage gestor, Login login){
        Tshirt.EstadoArtigo estado = null;
        int numDonos = 0;
        Map<String, Transportadoras> transportadoras = gestor.getTransportadoras();

        a.printMessage("---------------  TSHIRT ---------------");
        String descricao = this.input.lerString(a, "Insira a descricao da tshirt: ");
        String marca = this.input.lerString(a, "Insira a marca da tshirt: ");
        String codigo = this.input.lerString(a, "Insira o codigo da tshirt: ");
        float precoBase = this.input.lerFloat(a, "Insira o preco base da tshirt: ", 0, 1000000000);
        float desconto = this.input.lerFloat(a, "Insira o desconto da tshirt: ", 0, 1000000000);
        int novoUsado = this.input.lerInteiro(a, "Insira o estado da tshirt [0-NOVO, 1-USADO]: ", 0, 1);
        if(novoUsado == 1){
            String estado1 = this.input.lerString(a, "Insira o estado da tshirt [QUASE_NOVO,GASTO,MUITO_GASTO]: ");
            estado = Tshirt.EstadoArtigo.valueOf(estado1);
            numDonos = this.input.lerInteiro(a, "Insira o numero de donos da tshirt: ", 0, 1000000000);
        }
        String tamanho1 = this.input.lerString(a, "Insira o tamanho da tshirt [S,M,L,XL]: ");
        Tshirt.Tamanho tamanho = Tshirt.Tamanho.valueOf(tamanho1);
        String padrao1 = this.input.lerString(a, "Insira o padrao da tshirt [LISO,RISCAS,PALMEIRAS]: ");
        Tshirt.Padrao padrao = Tshirt.Padrao.valueOf(padrao1);
        a.printTransportadoras(transportadoras);
        String transportadora1 = this.input.lerString(a, "Insira a transportadora da tshirt: ");
        Transportadoras transportadora = transportadoras.get(transportadora1);
        Utilizador vendedor = gestor.getUtilizadores().get(login.getEmail());
        

        return new Tshirt(descricao, marca, codigo, precoBase, desconto, novoUsado, estado, numDonos, transportadora, vendedor, tamanho, padrao);
     }

    public Mala criaMala(Apresentacao a, GestorVintage gestor, Login login){
        Mala.EstadoArtigo estado = null;
        int numDonos = 0;
        Map<String, Transportadoras> transportadoras = gestor.getTransportadoras();

        a.printMessage("---------------  MALA ---------------");
        String marca = this.input.lerString(a, "Insira a marca da mala: ");
        float altura = this.input.lerFloat(a, "Insira a altura da mala: ", 0, 1000000000);
        float largura = this.input.lerFloat(a, "Insira a largura da mala: ", 0, 1000000000);
        float profundidade = this.input.lerFloat(a, "Insira a profundidade da mala: ", 0, 1000000000);
        String material = this.input.lerString(a, "Insira o material da mala: ");
        String descricao = this.input.lerString(a, "Insira a descricao da mala: ");
        int anoColecao = this.input.lerInteiro(a, "Insira o ano da colecao da mala: ", 0, 1000000000);
        String tipo = this.input.lerString(a, "Insira o tipo da mala [REGULAR, PREMIUM]: ");
        Mala.TipoMala tipoMala = Mala.TipoMala.valueOf(tipo);
        int novoUsado = this.input.lerInteiro(a, "Insira o estado da mala [0-NOVO, 1-USADO]: ", 0, 2);
        if(novoUsado == 1){
            String estado1 = this.input.lerString(a, "Insira o estado da mala [QUASE_NOVO,GASTO,MUITO_GASTO]: ");
            estado = Mala.EstadoArtigo.valueOf(estado1);
            numDonos = this.input.lerInteiro(a, "Insira o numero de donos da mala: ", 0, 1000000000);
        }
        String codigo = this.input.lerString(a, "Insira o codigo da mala: ");
        float precoBase = this.input.lerFloat(a, "Insira o preco base da mala: ", 0, 1000000000);
        float desconto = this.input.lerFloat(a, "Insira o desconto da mala: ", 0, 1000000000);
        a.printTransportadoras(transportadoras);
        String transportadora1 = this.input.lerString(a, "Insira a transportadora da tshirt: ");
        Transportadoras transportadora = transportadoras.get(transportadora1);
        Utilizador vendedor = gestor.getUtilizadores().get(login.getEmail());

        return new Mala(descricao, marca, codigo, precoBase, desconto, novoUsado, estado, numDonos, transportadora, vendedor, altura, largura, profundidade, material, anoColecao, tipoMala);
    }

    public Sapatilhas criaSapatilhas(Apresentacao a, GestorVintage gestor, Login login){
        Sapatilhas.EstadoArtigo estado = null;
        int numDonos = 0;
        Map<String, Transportadoras> transportadoras = gestor.getTransportadoras();

        a.printMessage("---------------  SAPATILHAS ---------------");
        String marca = this.input.lerString(a, "Insira a marca das sapatilhas: ");
        float tamanho = this.input.lerFloat(a, "Insira o tamanho das sapatilhas: ", 0, 1000000000);
        String cor = this.input.lerString(a, "Insira a cor das sapatilhas: ");
        String tipo = this.input.lerString(a, "Insira o tipo das sapatilhas [REGULAR, PREMIUM]: ");
        Sapatilhas.TipoSapatilhas tipoSapatilhas = Sapatilhas.TipoSapatilhas.valueOf(tipo);
        boolean atacadores = this.input.readSN(a, "Insira se as sapatilhas tem atacadores [S/N]: ");
        String codigo = this.input.lerString(a, "Insira o codigo das sapatilhas: ");
        String descricao = this.input.lerString(a, "Insira a descricao das sapatilhas: ");
        int novoUsado = this.input.lerInteiro(a, "Insira o estado das sapatilhas [0-NOVO, 1-USADO]: ", 0, 2);
        if(novoUsado == 1){
            String estado1 = this.input.lerString(a, "Insira o estado das sapatilhas [QUASE_NOVO,GASTO,MUITO_GASTO]: ");
            estado = Sapatilhas.EstadoArtigo.valueOf(estado1);
            numDonos = this.input.lerInteiro(a, "Insira o numero de donos das sapatilhas: ", 0, 1000000000);
        }
        float precoBase = this.input.lerFloat(a, "Insira o preco base das sapatilhas: ", 0, 1000000000);
        float desconto = this.input.lerFloat(a, "Insira o desconto das sapatilhas: ", 0, 1000000000);
        LocalDate dataLancamento = this.input.lerData(a, "Insira a data de lancamento das sapatilhas: ");
        a.printTransportadoras(transportadoras);
        String transportadora1 = this.input.lerString(a, "Insira a transportadora da tshirt: ");
        Transportadoras transportadora = transportadoras.get(transportadora1);
        Utilizador vendedor = gestor.getUtilizadores().get(login.getEmail());
        


        return new Sapatilhas(descricao, marca, codigo, precoBase, desconto, novoUsado, estado, numDonos, transportadora, vendedor, tamanho, atacadores, cor, dataLancamento, tipoSapatilhas);   
    }
    
}
