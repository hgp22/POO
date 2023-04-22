package View;
import java.util.Map;
import java.util.Scanner;
import java.util.HashMap;

public class Login {
    private static Map<String, String> users = new HashMap<>();

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String username, password, escolha;

        System.out.print("\033[H\033[2J");
        System.out.flush();

        System.out.println("Bem vindo à Vintage!\n");
        System.out.println("Faça login ou registe-se na nossa aplicação\n");

        System.out.println("1 -> Login\n");
        System.out.println("2 -> Registar\n");

        escolha = scanner.nextLine();
        if (escolha.equals("1")) {
            do {
                System.out.print("Username: ");
                username = scanner.nextLine();

                System.out.print("Password: ");
                password = scanner.nextLine();

                if (loginValido(username, password)) {
                    System.out.println("Login efetuado com sucesso!\n");
                } else {
                    System.out.println("Login inválido!\n");
                }
            } while (!loginValido(username, password));

        } else if (escolha.equals("2")) {
            System.out.print("Introduza o username que deseja: \n");
            username = scanner.nextLine();

            System.out.print("Introduza a password que deseja: \n");
            password = scanner.nextLine();

            users.put(username, password);
            System.out.println(users);

            System.out.println("Registo efetuado com sucesso!\n");

        } else {
            System.out.println("Escolha inválida!\n");
        }

        System.out.println("--- MENU INICIAL ---\n");
    }

    public static boolean loginValido(String username, String password) {
        if (users.containsKey(username) && users.get(username).equals(password)) {
            return true;
        } else {
            return false;
        }
    }
}
