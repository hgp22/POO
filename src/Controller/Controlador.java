package Controller;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import Model.*;
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

    public void controlador(Apresentacao a, GestorVintage gestor) throws NullPointerException{
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
                    //avancar no tempo
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

    public void controladorInicial(Apresentacao a, GestorVintage gestor, Login login){
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
                    // devolver encomenda
                    break;
                case 5:
                    // estatisticas
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
                        controladorInicial(a, gestor, login);
                        ola = false;
                    } 
                    break;
                case 2:
                    Utilizador u = cu.registarUtilizador(gestor, a);
                    gestor.addUtilizador(u);
                    login = new Login(u.getEmail(), u.getPassword());
                    controladorInicial(a, gestor, login);
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
                    a.printMessage("Transportadora criada com sucesso!");
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
        List<Artigos> artigosVenda = gestor.getArtigosVenda(login);
        List<Artigos> artigosFinal = new ArrayList<>();


        while(ola){
            a.printMenuComprar();
            opcao = input.lerInteiro(a, "Introduza um número", 0, 6);
            switch(opcao){
                case 1:
                    a.printArtigosDisponiveis(artigosVenda);
                    ce.addArtigo(a, artigosFinal, artigosVenda, login);

                    break;
                case 2:
                    ce.removeArtigo(a, artigosFinal, login);
                    break;
                case 3:
                    
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
