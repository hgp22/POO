package View;

import Controller.Controlador;
import Controller.Input;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.Serializable;
import java.util.Scanner;

import Files.*;

public class Viewer implements Serializable {
    private Controlador controlador;
    private Input input;
    private Scanner sc;
    private Estado estado;

    public Viewer(Controlador controlador) {
        this.controlador = controlador.clone();
        this.sc = new Scanner(System.in);
        this.estado = new Estado();
    }

    public void menu() throws FileNotFoundException, IOException {
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
            System.out.println("2 - Gravar estado");
            System.out.println("3 - Carregar estado");
            System.out.println("4 - Criar Transportadora");
           // System.out.println("5 - Avançar tempo");
            System.out.println("0 - Sair");
            opcao = input.lerInteiro(0, 5);
            //opcao = this.sc.nextInt();
            switch (opcao) {
                case 1:
                    menuLogin();
                    break;
                case 2:
                    System.out.println("Insira o nome do ficheiro: ");
                    String nomeFicheiro = this.sc.nextLine();
                    System.out.println("oi");
                    estado.guardarEstado(nomeFicheiro + ".dat");
                    System.out.println("Estado guardado com sucesso!");
                    break;
                case 3:
                    //carregarEstado();
                    break;
                case 4:
                    //criarTransportadora();
                    break;
                case 5:
                    //avançarTempo();
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

    public void menuLogin(){
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
                break;
            case 0:
                break;
            default:
                System.out.println("Opção inválida!");
                break;
        }
    }

}
