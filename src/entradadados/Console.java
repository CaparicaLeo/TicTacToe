package entradadados;

import java.util.Scanner;

public class Console {

    private static final Scanner scanner = new Scanner(System.in);

    public static String lerString(String mensagem) {
        System.out.print(mensagem);
        return scanner.nextLine();
    }
    public static int lerInt(String mensagem) {
        System.out.print(mensagem);
        while (!scanner.hasNextInt()) {
            System.out.println("Por favor, insira um número inteiro.");
            System.out.print(mensagem);
            scanner.next(); // Descartar entrada inválida
        }
        int valor = scanner.nextInt();
        scanner.nextLine(); // Limpar buffer
        return valor;
    }
    public static char lerChar(String mensagem){
        System.out.print(mensagem);
        String input = scanner.nextLine();
        while (input.length() != 1) {
            System.out.println("Por favor, insira um único caractere.");
            System.out.print(mensagem);
            input = scanner.nextLine();
        }
        return input.charAt(0);
    }
}
