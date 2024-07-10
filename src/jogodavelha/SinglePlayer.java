package jogodavelha;
import entradadados.Console;

import java.util.Random;

public class SinglePlayer extends Jogo {
    private Bot computador;
    @Override
    public void iniciar() {
        do {
            mesa = new Tabuleiro();
            inicializaJogadores();
            inicializaJogo();
            jogar();
            novamente = Console.lerChar("Jogar Novamente? (S/N): ");
        } while (Character.toUpperCase(novamente) != 'N');
        Principal.menu();
    }
    @Override
    public void inicializaJogadores() {
        this.jogador1 = new Jogador(Console.lerString("Insira seu nome: "));
        this.computador = new Bot();
    }
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
    @Override
    public void jogar() {
        Jogada jogadaAtual;
        do
        {
            boolean jogadaValida;
            do
            {
                if (this.jogadorAtual.getClass() == this.computador.getClass()) {
                    this.computador.realizarJogada();
                    jogadaAtual = new Jogada(this.jogadorAtual.getJogada().getX(),this.jogadorAtual.getJogada().getY()-1, this.jogadorAtual.getSimbolo());
                }
                else {
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
                    if(jogadorAtual.getClass() != computador.getClass()) {
                        System.out.println("Jogada inválida. Tente novamente.");
                    }
                } else {
                    mesa.receberJogada(jogadaAtual);
                }
            } while(!jogadaValida);
        } while(jogoContinua());
        Principal.menu();
    }

    @Override
    public void alternarJogador() {
        jogadorAtual = (jogadorAtual == jogador1) ? computador : jogador1;
    }
}
