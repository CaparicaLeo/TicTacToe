package jogodavelha;

import armazenamento.GerenciaJogadoresArrayList;
import entradadados.Console;

import java.util.Random;

/**
 * Classe que representa o modo de jogo Single Player no jogo da velha.
 * O jogador humano enfrenta um bot (computador).
 *
 * @version 1.0
 */
public class SinglePlayer extends Jogo {
    private Bot computador;

    /**
     * Inicia o jogo Single Player, exibindo o menu e gerenciando o fluxo do jogo.
     *
     * @exception Exception se ocorrer um erro durante a execução.
     */
    @Override
    public void iniciar() {
        do {
            mesa = new Tabuleiro();
            inicializaJogadores();
            inicializaJogo();
            jogar();
            novamente = Console.lerChar("Jogar Novamente? (S/N): ");
        } while (Character.toUpperCase(novamente) != 'N');
    }

    /**
     * Inicializa os jogadores do jogo. O jogador humano e o bot.
     *
     * @exception Exception se ocorrer um erro durante a execução.
     */
    @Override
    public void inicializaJogadores() {
        this.jogador1 = new Jogador(Console.lerString("Insira seu nome: "));
        this.computador = new Bot();
    }

    /**
     * Inicializa o jogo definindo os símbolos dos jogadores e determinando qual jogador começa.
     *
     * @exception Exception se ocorrer um erro durante a execução.
     */
    @Override
    public void inicializaJogo() {
        Random random = new Random();
        int aleatorio = random.nextInt(2);
        if (aleatorio == 0) {
            this.jogador1.determinaSimbolo("X");
            this.jogadorAtual = this.jogador1;
            this.computador.determinaSimbolo("O");
        } else {
            this.computador.determinaSimbolo("X");
            this.jogadorAtual = this.computador;
            this.jogador1.determinaSimbolo("O");
        }
    }

    /**
     * Gerencia o loop do jogo, permitindo que o jogador e o bot façam suas jogadas alternadamente.
     *
     * @exception Exception se ocorrer um erro durante a execução.
     */
    @Override
    public void jogar() {
        Jogada jogadaAtual;
        do {
            boolean jogadaValida;
            do {
                if (this.jogadorAtual.getClass() == this.computador.getClass()) {
                    this.computador.realizarJogada();
                    jogadaAtual = new Jogada(this.jogadorAtual.getJogada().getX(), this.jogadorAtual.getJogada().getY(), this.jogadorAtual.getSimbolo());
                } else {
                    mesa.imprimeTabuleiro();
                    System.out.println("Vez do jogador: " + this.jogadorAtual.getNome() + " (" + this.jogadorAtual.getSimbolo() + ")");
                    char linha = Console.lerChar("Insira a linha (A-C): ");

                    if (Character.isLowerCase(linha)) {
                        linha = Character.toUpperCase(linha);
                    }

                    int trueLinha = linha - 'A';
                    int coluna = Console.lerInt("Insira a coluna (1-3): ");

                    jogadaAtual = new Jogada(trueLinha, coluna - 1, jogadorAtual.getSimbolo());
                }
                jogadaValida = jogadaValida(jogadaAtual);
                if (!jogadaValida) {
                    if (jogadorAtual.getClass() != computador.getClass()) {
                        System.out.println("Jogada inválida. Tente novamente.");
                    }
                } else {
                    mesa.receberJogada(jogadaAtual);
                }
            } while (!jogadaValida);
        } while (jogoContinua());
    }

    /**
     * Alterna o jogador atual entre o jogador humano e o bot.
     *
     * @exception Exception se ocorrer um erro durante a execução.
     */
    @Override
    public void alternarJogador() {
        jogadorAtual = (jogadorAtual == jogador1) ? computador : jogador1;
    }

    /**
     * Verifica se o jogo continua, se há vitória, empate ou se o jogo deve continuar.
     *
     * @return true se o jogo deve continuar, false se houver vitória ou empate.
     */
    @Override
    protected boolean jogoContinua() {
        if (vitoria()) {
            mesa.imprimeTabuleiro();
            System.out.println("Jogador " + jogadorAtual.getNome() + " venceu!");
            if (jogadorAtual != computador) {
                jogadorAtual.pontuar(10);
                GerenciaJogadoresArrayList.armazenarInfo(jogadorAtual);
            }
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
}
