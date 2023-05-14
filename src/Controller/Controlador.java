package Controller;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import Model.*;
import Model.Encomenda.estadoEncomenda;
import View.*;


public class Controlador {
    private ControladorUser cu;
    private ControladorEncomenda ce;
    private ControladorArtigo ca;
    private ControladorTransportadora ct;
    private ControladorEstado cestado;
    private Input input;
    

    public Controlador(){
        this.cu = new ControladorUser();
        this.ce = new ControladorEncomenda();
        this.ca = new ControladorArtigo();
        this.ct = new ControladorTransportadora();
        this.cestado = new ControladorEstado();
        this.input = new Input();
    }


    // ============================================================================================ //

    public void controlador(GestorVintage gestor, Apresentacao a) throws NullPointerException{
        boolean ola = true;
        int opcao;
        int flag = 0;

        while(ola){
            if (flag == 0) a.printInicio();
            flag = 1;
            a.printMenu();
            opcao = input.lerInteiro(a, "Introduza um número", 0, 6);
            switch(opcao){
                case 1: 
                    ControladorUtilizador(gestor, a, null); //ver login -> acho que aqui nao pode ser null
                    break;
                case 2:
                    ControladorTransportadora(gestor, a);
                    break;
                case 3:
                    int dias = input.lerInteiro(a, "Introduza o número de dias", 0, 999999999);
                    gestor.avancarTempo(dias);
                    a.printMessage("Tempo foi avançado em " + dias + " dias");
                    break;
                case 4:
                    gestor = cestado.loadEstado(a); 
                    break;
                case 5:
                    cestado.salvarEstado(a, gestor); 
                    break;
                case 0:
                    ola = false;
                    a.printMessage("Até à próxima!");
                    break;
                default:
                    a.printMessage("Opção inválida");
                    break;
            }
        }
        
    }

    public void controladorInicial(GestorVintage gestor, Apresentacao a, Login login){
        boolean ola = true;
        int opcao;

        while(ola){
            a.printMenuInicial();
            opcao = input.lerInteiro(a, "Introduza um número", 0, 7);
            switch(opcao){
                case 1: 
                    ControladorEncomenda(gestor, a, login);
                    break;
                case 2:
                    ControladorArtigo(gestor, a, login);
                    break;               
                case 3:
                    ControladorTransportadora(gestor, a);
                    break;
                case 4:
                    gestor.getEncomendasComprador(login);
                    int encomenda = input.lerInteiro(a, "Indique a encomenda que deseja cancelar", 0,100);
                    Encomenda e = gestor.getEncomendasComprador(login).get(encomenda);
                    if (e == null) a.printMessage("Encomenda não existe");
                    else if (e.getEstado() == estadoEncomenda.EXPEDIDA || e.getEstado() == estadoEncomenda.PENDENTE){
                        gestor.cancelarEncomenda(e, login);
                        a.printMessage("Encomenda cancelada com sucesso!");
                    }
                    else a.printMessage("Não foi possível cancelar a encomenda");
                    break;
                case 5:
                    ControladorEstatisticas(gestor, a, login);
                    break;
                case 6:                
                    ola = false;
                    break;                        
                case 0:
                // sair da aplicacao
                    ola = false;
                    a.printMessage("Até à próxima!");
                    break;
                default:
                    a.printMessage("Opção inválida");
                    break;
            }
        }
    }



    public void ControladorUtilizador(GestorVintage gestor, Apresentacao a, Login login){
        boolean ola = true;
        int opcao;

        while(ola){
            a.printLogin();
            opcao = input.lerInteiro(a, "Introduza um número", 0, 3);
            switch(opcao){
                case 1: 
                    if((login = cu.login(gestor, a)) != null){
                        controladorInicial(gestor, a, login);
                        ola = false;
                    } 
                    break;
                case 2:
                    Utilizador u = cu.registarUtilizador(gestor, a);
                    gestor.addUtilizador(u);
                    login = new Login(u.getEmail(), u.getPassword());
                    controladorInicial(gestor, a, login);
                    ola = false;   
                    break;
                case 0:
                    ola = false;
                    //a.printMenuInicial();
                    break;
                default:
                    a.printMessage("Opção inválida");
                    break;
            
            }
        }
    }
    
    public void ControladorArtigo(GestorVintage gestor, Apresentacao a, Login login){
        boolean ola = true;
        int opcao;

        while(ola){
            a.printMenuVender();
            opcao = input.lerInteiro(a, "Introduza um número", 0, 3);
            switch(opcao){
                case 1: 
                    Mala m = ca.criaMala(a, gestor, login);
                    a.printMessage("Mala criada com sucesso!");
                    gestor.addArtigoPorVender(m, login);
                    break;
                case 2:
                    Sapatilhas s = ca.criaSapatilhas(a, gestor, login);
                    a.printMessage("Sapato criado com sucesso!");
                    gestor.addArtigoPorVender(s, login);
                    break;
                
                case 3:
                    Tshirt t = ca.criaTshirt(a, gestor, login);
                    a.printMessage("Tshirt criada com sucesso!");
                    gestor.addArtigoPorVender(t, login);
                    break;
                case 0:
                    ola = false;
                    break;
                default:
                    a.printMessage("Opção inválida");
                    break;
            
            }
        }
    }

    public void ControladorTransportadora(GestorVintage gestor, Apresentacao a){
        boolean ola = true;
        int opcao;
        
        while(ola){
            Map<String, Transportadoras> transportadoras = gestor.getTransportadoras();
            a.printMenuTransportadora();
            opcao = input.lerInteiro(a, "Introduza um número", 0, 2);
            switch(opcao){
                case 0:
                    ola = false;
                    break;
                case 1:
                    Transportadoras t = ct.criarTransportadora(a, gestor);
                    gestor.addTransportadora(t);
                    break;
                case 2:
                    a.printTransportadoras(transportadoras);
                    break;
                default:
                    a.printMessage("Opção inválida");
                    break;
            
            }
        }
    }
 
    public void ControladorEncomenda(GestorVintage gestor, Apresentacao a, Login login){
        boolean ola = true;
        int opcao;
        List<Artigos> artigosVenda = gestor.getArtigosDisponiveis(login);
        List<Artigos> artigosFinal = new ArrayList<>();


        while(ola){
            a.printMenuComprar();
            opcao = input.lerInteiro(a, "Introduza um número", 0, 3);
            switch(opcao){
                case 1:
                    a.printArtigosDisponiveis(artigosVenda, login);
                    ce.addArtigo(a, artigosFinal, artigosVenda, login);
                    break;
                case 2:
                    ce.removeArtigo(a, artigosFinal, login);
                    break;
                case 3:
                    Artigos artigo = artigosFinal.get(0);
                    Transportadoras t = artigo.getTransportadora();
                    Encomenda e = ce.criarEncomenda(gestor, artigosFinal, login, t);
                    a.printMessage("Encomenda criada com sucesso!");
                    gestor.addEncomenda(e);
                    break;
                case 0:
                    ola = false;
                    break;
                default:
                    a.printMessage("Opção inválida");
                    break;
            
            }
        }

    }

    public void ControladorEstatisticas(GestorVintage gestor, Apresentacao a, Login login){
        boolean ola = true;
        int opcao;
        Map<Integer, Encomenda> encomendas = gestor.getEncomendas();
        Map<String, Utilizador> utilizadores = gestor.getUtilizadores();
        Map<String, Transportadoras> transportadoras = gestor.getTransportadoras();

        while(ola){
            a.printMenuEstatisticas();
            opcao = input.lerInteiro(a, "Introduza um número", 0, 5);
            switch(opcao){
                case 1:
                    LocalDate inicio = input.lerData(a, "Introduza a data inicial");
                    LocalDate fim = input.lerData(a, "Introduza a data final");
                    a.printMessage("O utilizador com mais vendas entre " + inicio + " e " + fim + " é " + gestor.utilizadorMaisFaturado(inicio, fim).getNome());
                    break;
                case 2:
                    a.printMessage("A transportadora com maior volume de faturação é " + ct.maiorVolume(transportadoras).getNome() + " com um total de " + ct.maiorVolume(transportadoras).getVolumeFaturado() + " produtos vendidos");
                    break;
                case 3:
                    cu.utlizadorVendas(gestor, a);
                    break;
                case 4:
                    // ordenar maiores compradores
                    break;
                case 5:
                    a.printMessage("A Vintage fez um total de " + ce.lucroTotal(encomendas) + "€ em encomendas");
                    break;
                case 0:
                    ola = false;
                    break;
                default:
                    a.printMessage("Opção inválida");
                    break;
            
            }
        }
    }

}
