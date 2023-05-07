package View;

import Controller.Controlador;
import Controller.Input;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.Serializable;
import java.time.LocalDate;
import java.util.Scanner;

import Model.VintageException;
import Model.Artigos.*;
import Model.Mala.TipoMala;
import Model.Sapatilhas.*;
import Model.Tshirt.*;

public class Viewer implements Serializable {
    private Controlador controlador;
    private Input input;
    private Scanner sc;

    public Viewer(Controlador controlador) {
        this.controlador = controlador.clone();
        this.sc = new Scanner(System.in);
    }

    public void menu() throws FileNotFoundException, IOException, ClassNotFoundException, VintageException {
        this.input = new Input(sc);
        int opcao;

        do {
            System.out.println("                                 _________ _       _________ _______  _______  _______          ");
            System.out.println("                        |\\     /|\\__   __/( (    /|\\__   __/(  ___  )(  ____ \\(  ____ \\    ");
            System.out.println("                        | )   ( |   ) (   |  \\  ( |   ) (   | (   ) || (    \\/| (    \\/      ");
            System.out.println("                        | |   | |   | |   |   \\ | |   | |   | (___) || |      | (__            ");
            System.out.println("                        ( (   ) )   | |   | (\\ \\) |   | |   |  ___  || | ____ |  __)          ");
            System.out.println("                         \\ \\_/ /    | |   | | \\   |   | |   | (   ) || | \\_  )| (           ");
            System.out.println("                          \\   /  ___) (___| )  \\  |   | |   | )   ( || (___) || (____/\\      ");
            System.out.println("                           \\_/   \\_______/|/    )_)   )_(   |/     \\|(_______)(_______/      ");
            System.out.println("                                                                                                ");
            System.out.println("                                                                                                ");
            System.out.println("                                                Bem-vindo à Vintage!                            ");

            System.out.println("1 - Login/Registar");
            System.out.println("2 - Criar Transportadora");
            System.out.println("3 - Avançar tempo");
            System.out.println("4 - Carregar estado");
            System.out.println("5 - Gravar estado");
            System.out.println("0 - Sair");
            opcao = input.lerInteiro(0, 5);

            switch (opcao) {
                case 1:
                    menuLogin();
                    break;
                case 2:
                    menuTransportadora();
                    break;
                 case 3:
                    //avançarTempo();
                    break;
                case 4:
                    System.out.println("Insira o nome do ficheiro: ");
                    String nomeFicheiro2 = this.sc.nextLine();
                    controlador.carregarEstado(nomeFicheiro2 + ".dat");
                    System.out.println("Estado carregado com sucesso!");
                    break;
                case 5:
                    System.out.println("Insira o nome do ficheiro: ");
                    String nomeFicheiro = this.sc.nextLine();
                    controlador.guardarEstado(nomeFicheiro + ".dat");
                    System.out.println("Estado guardado com sucesso!");
                    break;
                case 0:
                    System.out.println("Obrigado por usar a Vintage!");
                    break;
                default:
                    System.out.println("Opção inválida!");
                    break;
            }


        } while (opcao != 0);
    }

    public void menuLogin() throws FileNotFoundException, ClassNotFoundException, IOException, VintageException{
        System.out.println("==================================");
        System.out.println("            MENU LOGIN            ");
        System.out.println("==================================" + "\n");
        System.out.println("1 - Login");
        System.out.println("2 - Registar");
        System.out.println("0 - Voltar atrás");

        int opcao = input.lerInteiro(0, 2);

        switch (opcao) {
            case 1:
                System.out.println("Email: ");
                String email = this.sc.nextLine();
                System.out.println("Password: ");
                String password = this.sc.nextLine();

                this.controlador.login(email, password);
                System.out.println("Login efetuado com sucesso!");
                menuInicial();
                break;
            case 2:
                System.out.println("Email: ");
                String email2 = this.sc.nextLine();
                System.out.println("Password: ");
                String password2 = this.sc.nextLine();
                System.out.println("Nome: ");
                String nome = this.sc.nextLine();
                System.out.println("Morada: ");
                String morada = this.sc.nextLine();
                System.out.println("NIF: ");
                int nif = this.sc.nextInt();

                this.controlador.criaUtilizador(email2, password2, nome, morada, nif);
                this.controlador.login(email2, password2);
                System.out.println("Utilizador criado com sucesso, login efetuado!");
                menuInicial();
                break;
            case 0:
                menu();
                break;
            default:
                System.out.println("Opção inválida!");
                break;
        }
    }

    public void menuInicial() throws FileNotFoundException, ClassNotFoundException, IOException, VintageException{
        int opcao;
        do{
            System.out.println("==================================");
            System.out.println("           MENU INICIAL           ");
            System.out.println("==================================" + "\n");
            System.out.println("1 - Comprar Artigo");
            System.out.println("2 - Vender Artigo");
            System.out.println("3 - Devolver Encomenda");
            System.out.println("4 - Estatisiticas");
            System.out.println("4 - Consultas");
            System.out.println("6 - Logout");
            System.out.println("0 - Sair");

            opcao = input.lerInteiro(0, 6);

            switch(opcao){
                case 1:
                    menuVenderArtigo();
                    break;
                case 2:
                    menuComprarArtigo();
                    break;
                case 3:
                    menuDevolverEncomenda();
                    break;
                case 4:
                    menuEstatisticas();
                    break;
                case 5:
                    menuConsultas();
                    break;
                case 6:
                    menu();
                    break;
                case 0:
                    System.out.println("Obrigado por usar a Vintage!");
                    System.exit(0);
                    break;
                default:
                    System.out.println("Opção inválida!");
                    break;
            }
        } while(opcao != 0);

    }

    // falta a transportadora para todos os artigos
    private void menuVenderArtigo() throws FileNotFoundException, ClassNotFoundException, IOException, VintageException {
        System.out.println("=========================================");
        System.out.println("           MENU VENDER ARTIGOS           ");
        System.out.println("=========================================" + "\n");
        System.out.println("1 - Vender Mala");
        System.out.println("2 - Vender Sapatilhas");
        System.out.println("3 - Vender Tshirt");
        System.out.println("0 - Voltar atrás");

        int opcao = input.lerInteiro(0, 3);

        switch(opcao){
            case 1:
                System.out.println("========== MALA ==========");
                System.out.println("Insira a marca da mala: ");
                String marca = this.sc.nextLine();
                System.out.println("Insira a altura da mala: ");
                float altura = this.sc.nextFloat();
                System.out.println("Insira a largura da mala: ");
                float largura = this.sc.nextFloat();
                System.out.println("Insira a profundidade da mala: ");
                float profundidade = this.sc.nextFloat();
                System.out.println("Insira o material da mala: ");
                String material = this.sc.nextLine();
                System.out.println("Insira o ano da coleção da mala: ");
                int anoColecao = this.sc.nextInt();
                System.out.println("Insira o tipo da mala [REGULAR, PREMIUM]: ");
                TipoMala tipo = TipoMala.valueOf(this.sc.nextLine());
                System.out.println("Insira o estado da mala [0-NOVO, 1-USADO]: ");
                int estado2 = this.sc.nextInt();    
                EstadoArtigo estado = null;
                int numDonos = 0;
                if(estado2 == 1){
                    System.out.println("Insira o ... da mala [QUASE NOVO, GASTO, MUITO GASTO]: ");
                    estado = EstadoArtigo.valueOf(this.sc.nextLine());
                }
                if(estado2 == 1){
                    System.out.println("Insira o numero de donos: ");
                    numDonos = this.sc.nextInt();
                }
                System.out.println("Insira o codigo da mala: ");
                String codigo = this.sc.nextLine();
                System.out.println("Insira o preco base da mala: ");
                float precoBase = this.sc.nextFloat();
                System.out.println("Insira o desconto da mala: ");
                float desconto = this.sc.nextFloat();
                System.out.println("Insira a descrição da mala: ");
                String descricao = this.sc.nextLine();

                this.controlador.criaMala(descricao, marca, codigo, precoBase, desconto, estado2, estado, numDonos, altura, largura, profundidade, material, anoColecao, tipo);
                
                System.out.println("Mala criada com sucesso!");
                break;
            case 2:
                System.out.println("========== SAPATILHAS ==========");
                System.out.println("Insira a marca das sapatilhas: ");
                String marca2 = this.sc.nextLine();
                System.out.println("Insira o tamanho das sapatilhas: ");
                float tamanho = this.sc.nextInt();
                System.out.println("Insira a cor das sapatilhas: ");
                String cor = this.sc.nextLine();
                System.out.println("Insira o tipo das sapatilhas [REGULAR, PREMIUM]: ");
                TipoSapatilhas tipo2 = TipoSapatilhas.valueOf(this.sc.nextLine());
                System.out.println("Tem atacadores as sapatilhas? [S/N] ");
                boolean atacadores = this.sc.nextBoolean();
                System.out.println("Insira o codigo das sapatilhas: ");
                String codigo2 = this.sc.nextLine();
                System.out.println("Insira a descrição das sapatilhas: ");
                String descricao2 = this.sc.nextLine();
                System.out.println("Insira o estado das sapatilhas [0-NOVO, 1-USADO]: ");
                int estado3 = this.sc.nextInt();
                EstadoArtigo estado4 = null;
                int numDonos2 = 0;
                if(estado3 == 1){
                    System.out.println("Insira o ... das sapatilhas [QUASE NOVO, GASTO, MUITO GASTO]: ");
                    estado4 = EstadoArtigo.valueOf(this.sc.nextLine());
                }
                if(estado3 == 1){
                    System.out.println("Insira o numero de donos: ");
                    numDonos2 = this.sc.nextInt();
                } 
                System.out.println("Insira o preco base das sapatilhas: ");
                float precoBase2 = this.sc.nextFloat();
                System.out.println("Insira o desconto das sapatilhas: ");
                float desconto2 = this.sc.nextFloat();
                System.out.println("Insira a data de lançamento das sapatilhas [DD-MM-YYYY]: ");
                LocalDate data = LocalDate.parse(this.sc.nextLine());
                
                this.controlador.criarSapatilhas(descricao2, marca2, codigo2, precoBase2, desconto2, estado3, estado4, numDonos2, tamanho, atacadores, cor, data, tipo2);
                System.out.println("Sapatilhas registadas com sucesso!");
                break;
            case 3:
                System.out.println("========== TSHIRT ==========");
                System.out.println("Insira a marca da tshirt: ");
                String marca3 = this.sc.nextLine();
                System.out.println("Insira a descrição da tshirt: ");
                String descricao3 = this.sc.nextLine();
                System.out.println("Insira o codigo da tshirt: ");
                String codigo3 = this.sc.nextLine();
                System.out.println("Insira o preco base da tshirt: ");
                float precoBase3 = this.sc.nextFloat();
                System.out.println("Insira o desconto da tshirt: ");
                float desconto3 = this.sc.nextFloat();
                System.out.println("Insira o estado da tshirt [0-NOVO, 1-USADO]: ");
                int estado5 = this.sc.nextInt();
                EstadoArtigo estado6 = null;
                int numDonos3 = 0;
                if(estado5 == 1){
                    System.out.println("Insira o ... da tshirt [QUASE NOVO, GASTO, MUITO GASTO]: ");
                    estado6 = EstadoArtigo.valueOf(this.sc.nextLine());
                }
                if(estado5 == 1){
                    System.out.println("Insira o numero de donos: ");
                    numDonos3 = this.sc.nextInt();
                }
                System.out.println("Insira o tamanho da tshirt [S,M,L,XL]: ");
                Tamanho tamanho2 = Tamanho.valueOf(this.sc.nextLine());
                System.out.println("Insira o padrao da tshirt [LISO, RISCAS, PALMEIRAS]: ");
                Padrao padrao = Padrao.valueOf(this.sc.nextLine());

                this.controlador.criarTshirt(descricao3, marca3, codigo3, precoBase3, desconto3, estado5, estado6, numDonos3, tamanho2, padrao);
                System.out.println("Tshirt registada com sucesso!");
                break;
            case 0:
                menuInicial();
                break;
            default:
                System.out.println("Opção inválida!");
                break;
        }
    }
    private void menuComprarArtigo() {
        int opcao;
        do{       
            System.out.println("==========================================");
            System.out.println("           MENU COMPRAR ARTIGOS           ");
            System.out.println("==========================================" + "\n");
            System.out.println("1 - Escolher Artigo");
            System.out.println("2 - Remover Artigo");
            System.out.println("3 - Terminar Encomenda");
            System.out.println("0 - Voltar atrás");

            opcao = input.lerInteiro(1, 3);

            switch(opcao){
                case 1:
                    System.out.println("========== ESCOLHER ARTIGO ==========");
                    // printar todos os artigos

                    System.out.println("Insira o codigo do artigo que pretende comprar: ");
                    //String codigo = this.sc.nextLine();



                }
        } while(opcao != 3);
        System.out.println("Encomenda terminada com sucesso!");

    }

    private void menuTransportadora() {         
        System.out.println("==========================================");
        System.out.println("            CRIAR TRANSPORTADORA          ");          
        System.out.println("==========================================" + "\n");
        System.out.println("Nome da transportadora: ");
        String nome = this.sc.nextLine();
        System.out.println("Lucro da transportadora: ");
        float lucro = this.sc.nextFloat();  
        //isto esta a printar 2x, nao porque
        boolean premium = input.readSN("É premium? [S, N]: ");

        this.controlador.criarTransportadora(nome, premium, lucro);
        System.out.println("Transportadora criada com sucesso!");
    }
    
    private void menuDevolverEncomenda() {
    }
    private void menuEstatisticas() {
    }
    private void menuConsultas() {
    }
}
    