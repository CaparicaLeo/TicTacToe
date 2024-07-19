package jogodavelha;

/**
 * Classe que representa o tabuleiro do jogo da velha.
 * O tabuleiro é uma matriz 3x3 onde os jogadores fazem suas jogadas.
 *
 * @version 1.0
 */
public class Tabuleiro {
    private static final int tamanho = 3;
    private final String[][] matriz;

    /**
     * Construtor que inicializa o tabuleiro com espaços vazios.
     *
     * @exception Exception se ocorrer um erro durante a execução.
     */
    public Tabuleiro() {
        matriz = new String[tamanho][tamanho];
        for (int i = 0; i < tamanho; i++) {
            for (int j = 0; j < tamanho; j++) {
                matriz[i][j] = " ";
            }
        }
    }

    /**
     * Imprime o estado atual do tabuleiro no console.
     *
     * @exception Exception se ocorrer um erro durante a execução.
     */
    public void imprimeTabuleiro() {
        int i;

        for (i = 0; i < tamanho; i++) {
            char ch = (char) (i + 65);
            System.out.print(ch + " ");
            System.out.print(" ");
            for (int j = 0; j < tamanho; j++) {
                System.out.print(matriz[i][j]);
                if (j < tamanho - 1) System.out.print(" | ");
            }
            System.out.println();
            if (i < tamanho - 1) System.out.println("  -----------");
        }
        System.out.println("   1   2   3");
    }

    /**
     * Recebe uma jogada e atualiza o tabuleiro com o símbolo do jogador.
     *
     * @param jogada A jogada a ser aplicada no tabuleiro.
     * @exception Exception se ocorrer um erro durante a execução.
     */
    public void receberJogada(Jogada jogada) {
        this.matriz[jogada.getX()][jogada.getY()] = jogada.getSimbolo();
    }

    /**
     * Retorna a matriz que representa o tabuleiro.
     *
     * @return A matriz do tabuleiro.
     */
    public String[][] getMatriz() {
        return this.matriz;
    }

    /**
     * Retorna o tamanho do tabuleiro (número de linhas e colunas).
     *
     * @return O tamanho do tabuleiro.
     */
    public int getTamanho() {
        return tamanho;
    }
}
