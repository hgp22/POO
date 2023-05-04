package Controller;

import java.io.Serializable;
import java.util.Scanner;
import java.util.InputMismatchException;

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

    
    
}
