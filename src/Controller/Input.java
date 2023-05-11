package Controller;

import java.io.Serializable;
import java.time.LocalDate;
import java.util.Scanner;

import View.Apresentacao;

public class Input implements Serializable {
    private Scanner sc;
    
    public Input() {
        this.sc = new Scanner(System.in);
    }

    public int lerInteiro (Apresentacao a, String message, int min, int max) {
        int n = -1;

        do{
            a.printMessage(message);
            try {
                String line = this.sc.nextLine();
                n = Integer.parseInt(line);
            } catch (NumberFormatException nfe) {
                a.printMessage(nfe.getMessage());
                n = -1;
            }
        } while (n < min || n > max);
        return n;
    }

    public boolean readSN(Apresentacao a, String mensagem) {
        String input;
        do {
            System.out.println(mensagem);
            input = sc.nextLine();
        } while (!input.equals("S") && !input.equals("N"));
        return input.equals("S");
    }

    public String lerString(Apresentacao a, String mensagem) {
        String s = null;
        do
        {
            a.printMessage(mensagem);
            s = this.sc.nextLine();
        } while (s==null || s.isBlank());
        return s;
    }

    public float lerFloat(Apresentacao a, String string, float min, float max) {
        float n = -1;

        do{
            a.printMessage(string);
            try {
                String line = this.sc.nextLine();
                n = Float.parseFloat(line);
            } catch (NumberFormatException nfe) {
                a.printMessage(nfe.getMessage());
                n = -1;
            }
        } while (n < min || n > max);
        return n;
    }

    public LocalDate lerData(Apresentacao a, String string){
        LocalDate data = null;
        boolean flag = true;
        do{
            try{
                String line = this.sc.nextLine();
                data = LocalDate.parse(line);
                flag = false;
            } catch (Exception e){
                System.out.println("Data inválida");
            }
        } while (flag);
        return data;
        
    }
}
