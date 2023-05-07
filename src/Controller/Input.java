package Controller;

import java.io.Serializable;
import java.util.Scanner;

import javax.swing.text.View;

import View.Viewer;

public class Input implements Serializable {
    private Scanner sc;
    
    public Input(Scanner sc) {
        this.sc = sc;
    }
    public int lerInteiro(int min, int max) {
        int input = -1;
        do {
            try { 
                input = sc.nextInt();
                sc.nextLine();

                if (input < min || input > max) {
                    System.out.println("Por favor insira um número entre " + min + " e " + max + ".");
                    sc.nextLine();
                    input = -1;
                }
            } catch (InputMismatchException e) {
                System.out.println("Por favor insira um número entre " + min + " e " + max + ".");
                sc.nextLine();
            }
        } while (input == -1);
        return input;
    }

    public boolean readSN(String mensagem) {
        sc.nextLine(); // limpar buffer do scanner
        String input;
        do {
            System.out.println(mensagem);
            input = sc.nextLine();
        } while (!input.equals("S") && !input.equals("N"));
        return input.equals("S");
    }

    public String leString(Viewer viewer, String mensagem) {
        String s = null;
        do
        {
            viewer.printMessage(mensagem);
            s = this.sc.nextLine();
        } while (s==null || s.isBlank());
        return s;
    }
}
