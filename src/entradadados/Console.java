package entradadados;

import java.util.Scanner;

/**
 * Classe utilitária para leitura de dados a partir do console.
 *
 * @version 1.0
 */
public class Console {

    private static final Scanner scanner = new Scanner(System.in);

    /**
     * Lê uma string do console.
     *
     * @param mensagem Mensagem a ser exibida antes da leitura.
     * @return A string lida do console.
     */
    public static String lerString(String mensagem) {
        System.out.print(mensagem);
        return scanner.nextLine();
    }

    /**
     * Lê um número inteiro do console.
     *
     * @param mensagem Mensagem a ser exibida antes da leitura.
     * @return O número inteiro lido do console.
     * @exception IllegalArgumentException se a entrada não for um número inteiro.
     */
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

    /**
     * Lê um caractere do console.
     *
     * @param mensagem Mensagem a ser exibida antes da leitura.
     * @return O caractere lido do console.
     * @exception IllegalArgumentException se a entrada não for um único caractere.
     */
    public static char lerChar(String mensagem) {
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
