package View;

import java.io.Serializable;

public class PrintLogin implements Serializable {
    private final Print print;

    public PrintLogin() {
        print = new Print();
    }

    /**
     * Apresenta menu login
     */
    public void printMenuLogin() {
        print.printMenus((new String[]{"Login", "Registar"}),"MENU LOGIN",1);
    }

    /**
     * Apresenta login com sucesso
     */
    public void printLoginSucesso() {
        System.out.println("Login efetuado com sucesso");
    }

    /**
     * Apresenta logout com sucesso
     */
    public void printLogoutSucesso() {
        System.out.println("Logout efetuado com sucesso");
    }

    /**
     * Apresenta registo com sucesso
     */
    public void printRegistoSucesso() {
        System.out.println("Registo efetuado com sucesso");
    }

    /**
     * Apresenta dados inválidos
     */
    public void printErroDadosInvalidos() {
        System.out.println("Dados inválidos");
    }

    /**
     * Apresenta pedir username
     */
    public void printPedirEmail() {
        System.out.println("Introduza o email: ");
    }

    /**
     * Apresenta pedir pass
     */
    public void printPedirPassword() {
        System.out.println("Introduza a password: ");
    }

}
