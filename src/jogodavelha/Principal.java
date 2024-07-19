package jogodavelha;

import entradadados.Console;
import armazenamento.*;

/**
 * Classe principal do jogo da velha.
 * Esta classe contém o método main que inicia o jogo e o menu de opções.
 *
 * @version 1.0
 */
public class Principal {

    /**
     * Método principal que inicia a execução do programa.
     *
     * @param args Argumentos da linha de comando.
     */
    public static void main(String[] args) {
        GerenciaJogadoresArrayList.carregarLista();
        menu();
    }

    /**
     * Exibe o menu principal do jogo e gerencia as opções selecionadas pelo usuário.
     *
     * @exception Exception se ocorrer um erro durante a execução.
     */
    public static void menu() {
        int opcao;
        Jogo jogo;
        GerenciaJogadoresArquivos.atualizarArquivo(GerenciaJogadoresArrayList.retornaArrayList());
        do {
        GerenciaJogadoresArrayList.carregarLista();
            System.out.println("*****************");
            System.out.println("*               *");
            System.out.println("* JOGO DA VELHA *");
            System.out.println("*               *");
            System.out.println("*****************");
            System.out.println("1. JOGAR SINGLE PLAYER");
            System.out.println("2. JOGAR MULTIPLAYER");
            System.out.println("3. PONTUAÇÃO GERAL.");
            System.out.println("4. CREDITOS.");
            System.out.println("5. SAIR\n");

            opcao = Console.lerInt("Insira: ");
            switch (opcao) {
                case 1:
                    jogo = new SinglePlayer();
                    jogo.iniciar();
                    break;
                case 2:
                    jogo = new Multiplayer();
                    jogo.iniciar();
                    break;
                case 3:
                    GerenciaJogadoresArrayList.apresentarPontuacao();
                    break;
                case 4:
                    creditos();
                    break;
                case 5:
                    System.out.println("Saindo...");
                    break;
                default:
                    System.out.println("OPÇÃO INVÁLIDA!");
                    break;
            }
        } while(opcao != 5);
    }

    /**
     * Exibe os créditos do jogo.
     *
     * @exception Exception se ocorrer um erro durante a execução.
     */
    public static void creditos() {
        int op;
        System.out.println("JOGO DA VELHA");
        System.out.println("Criado por Lucas Machado Cogrossi");
        System.out.println("                &                ");
        System.out.println("Leonardo Brzezinski Caparica de Almeida\n");
        do {
            op = Console.lerInt("Pressione 1 para sair: ");
            if(op != 1) {
                System.out.println("\nOPCAO INVALIDA!\n");
            }
        } while(op != 1);
    }

}
