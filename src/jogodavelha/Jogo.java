package jogodavelha;

import armazenamento.GerenciaJogadoresArrayList;

/**
 * Classe abstrata que representa o jogo da velha.
 * Define métodos e propriedades comuns para jogos single player e multiplayer.
 *
 * @version 1.0
 */
public abstract class Jogo {
    protected Jogador jogador1;
    protected Jogador jogador2;
    protected Jogador jogadorAtual;
    protected Tabuleiro mesa;
    protected char novamente;

    /**
     * Alterna o jogador atual.
     */
    protected void alternarJogador() {
        jogadorAtual = (jogadorAtual == jogador1) ? jogador2 : jogador1;
    }

    /**
     * Verifica se o jogador atual venceu o jogo.
     *
     * @return true se o jogador atual venceu, false caso contrário.
     */
    protected boolean vitoria() {
        String simbolo = jogadorAtual.getSimbolo();
        String[][] tabuleiro = mesa.getMatriz();

        // Verificar linhas
        for (int i = 0; i < mesa.getTamanho(); i++) {
            if (tabuleiro[i][0].equals(simbolo) && tabuleiro[i][1].equals(simbolo) && tabuleiro[i][2].equals(simbolo)) {
                return true;
            }
        }
        // Verificar colunas
        for (int j = 0; j < mesa.getTamanho(); j++) {
            if (tabuleiro[0][j].equals(simbolo) && tabuleiro[1][j].equals(simbolo) && tabuleiro[2][j].equals(simbolo)) {
                return true;
            }
        }
        // Verificar diagonais
        if (tabuleiro[0][0].equals(simbolo) && tabuleiro[1][1].equals(simbolo) && tabuleiro[2][2].equals(simbolo)) {
            return true;
        } else if (tabuleiro[0][2].equals(simbolo) && tabuleiro[1][1].equals(simbolo) && tabuleiro[2][0].equals(simbolo)) {
            return true;
        }
        return false;
    }

    /**
     * Verifica se o jogo terminou em empate.
     *
     * @return true se o jogo terminou em empate, false caso contrário.
     */
    protected boolean empate() {
        int count = 0;
        for (int i = 0; i < mesa.getTamanho(); i++) {
            for (int j = 0; j < mesa.getTamanho(); j++) {
                if (!mesa.getMatriz()[i][j].equals(" ")) {
                    count++;
                }
            }
        }
        return count == 9;
    }

    /**
     * Verifica se a jogada atual é válida.
     *
     * @param jogadaAtual A jogada a ser verificada.
     * @return true se a jogada é válida, false caso contrário.
     */
    protected boolean jogadaValida(Jogada jogadaAtual) {
        int x = jogadaAtual.getX();
        int y = jogadaAtual.getY();

        // Verificar se a jogada está dentro dos limites da matriz
        if (x < 0 || x >= mesa.getTamanho() || y < 0 || y >= mesa.getTamanho()) {
            return false;
        }
        return mesa.getMatriz()[x][y].equals(" ");
    }

    /**
     * Verifica se o jogo deve continuar.
     *
     * @return true se o jogo deve continuar, false caso contrário.
     */
    protected boolean jogoContinua() {
        if (vitoria()) {
            mesa.imprimeTabuleiro();
            System.out.println("Jogador " + jogadorAtual.getNome() + " venceu!");
            jogadorAtual.pontuar(10);
            GerenciaJogadoresArrayList.armazenarInfo(jogadorAtual);
            return false;
        } else if (empate()) {
            mesa.imprimeTabuleiro();
            System.out.println("Empate!");
            return false;
        } else {
            alternarJogador();
            return true;
        }
    }

    /**
     * Método abstrato para iniciar o jogo.
     * Deve ser implementado pelas classes filhas.
     */
    protected abstract void iniciar();

    /**
     * Método abstrato para inicializar os jogadores.
     * Deve ser implementado pelas classes filhas.
     */
    protected abstract void inicializaJogadores();

    /**
     * Método abstrato para inicializar o jogo.
     * Deve ser implementado pelas classes filhas.
     */
    protected abstract void inicializaJogo();

    /**
     * Método abstrato para realizar a jogada.
     * Deve ser implementado pelas classes filhas.
     */
    protected abstract void jogar();
}
