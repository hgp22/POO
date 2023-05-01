package Controller;

import Model.Encomenda;
import Model.Utilizador;
import View.Print;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.time.format.DateTimeParseException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class ParseInputs {
    public static LocalDateTime readDateTime(Print p, String message) {
        Scanner scanner = new Scanner(System.in);

        p.printMessage("Introduza uma data no formato: YYYY-MM-dd HH:mm:ss");
        String input = scanner.nextLine();

        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");
        LocalDateTime dateTime = LocalDateTime.parse(input, formatter);

        try {
            dateTime = LocalDateTime.parse(input, formatter);
        } catch (DateTimeParseException e) {
            p.printMessage("Formato invalido.");
            return readDateTime(p, message);
        }

        return dateTime;
    }

    public static Utilizador readUtilizador(Print p) {
        Scanner scanner = new Scanner(System.in);

        p.printMessage("Introduza um email");
        String email = scanner.nextLine();

        p.printMessage("Introduza uma password");
        String pw = scanner.nextLine();

        p.printMessage("ID:");
        String id = scanner.nextLine();

        p.printMessage("Nome:");
        String nome = scanner.nextLine();

        p.printMessage("Morada:");
        String morada = scanner.nextLine();

        p.printMessage("NIF:");
        String nif = scanner.nextLine();

        p.printMessage("Introduza os Produtos Comprados -- se existirem");
        List<String> produtosComprados = readList(p);

        p.printMessage("Introduza os Produtos Vendidos -- se existirem");
        List<String> produtosVendidos = readList(p);

        p.printMessage("Introduza os Produtos a Venda -- se existirem");
        List<String> produtosAVenda = readList(p);

        return new Utilizador(email, pw, nome, morada, Integer.parseInt(nif),
                produtosComprados, produtosVendidos, produtosAVenda);
    }

    public static List<String> readList(Print p){
        Scanner s = new Scanner(System.in);
        List<String> strings = new ArrayList<>();

        p.printMessage("Introduze o conteudo necessario -- escreva stop para parar");

        while(true){
            String input = s.nextLine();
            if(input.equals("stop")){break;}
            strings.add(input);
        }

        return strings;
    }

    public static Encomenda readEncomenda(Print p){
        Scanner s = new Scanner(System.in);
        return new Encomenda();
    }
}
