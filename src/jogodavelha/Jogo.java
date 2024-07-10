package jogodavelha;

public abstract class Jogo {
    protected Jogador jogador1;
    protected Jogador jogador2;
    protected Jogador jogadorAtual;
    protected Tabuleiro mesa;
    protected char novamente;

    protected void alternarJogador() {
        jogadorAtual = (jogadorAtual == jogador1) ? jogador2 : jogador1;
    }
    protected boolean vitoria(){
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
    protected boolean jogadaValida(Jogada jogadaAtual){
        int x = jogadaAtual.getX();
        int y = jogadaAtual.getY();

        // Verificar se a jogada está dentro dos limites da matriz
        if (x < 0 || x >= mesa.getTamanho() || y < 0 || y >= mesa.getTamanho()) {
            return false;
        }
        return mesa.getMatriz()[x][y].equals(" ");
    }
    protected boolean jogoContinua(){
        if (vitoria()) {
            mesa.imprimeTabuleiro();
            System.out.println("Jogador " + jogadorAtual.getNome() + " venceu!");
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
    protected abstract void iniciar();
    protected abstract void inicializaJogadores();
    protected abstract void inicializaJogo();
    protected abstract void jogar();
}
