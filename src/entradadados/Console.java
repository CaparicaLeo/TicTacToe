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

    public static double lerDouble(String mensagem) {
        System.out.print(mensagem);
        while (!scanner.hasNextDouble()) {
            System.out.println("Por favor, insira um número válido.");
            System.out.print(mensagem);
            scanner.next(); // Descartar entrada inválida
        }
        double valor = scanner.nextDouble();
        scanner.nextLine(); // Limpar buffer
        return valor;
    }

    public static boolean lerBoolean(String mensagem) {
        System.out.print(mensagem);
        while (!scanner.hasNextBoolean()) {
            System.out.println("Por favor, insira 'true' ou 'false'.");
            System.out.print(mensagem);
            scanner.next(); // Descartar entrada inválida
        }
        boolean valor = scanner.nextBoolean();
        scanner.nextLine(); // Limpar buffer
        return valor;
    }
    public static char lerChar(String mensagem){
        System.out.print(mensagem);
        return scanner.next().charAt(0);
    }
}
