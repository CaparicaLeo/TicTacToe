package jogodavelha;
import entradadados.Console;
import java.util.Random;

public class Multiplayer extends Jogo {
    public Multiplayer() {
        do
        {
            mesa = new Tabuleiro();
            inicializaJogadores();
            inicializaJogo();
            jogar();
            novamente = Console.lerChar("Jogador novamente? (S/N): ");
        } while(Character.toUpperCase(novamente)!= 'N');
        Principal.menu();
    }

    public void inicializaJogadores() {
        jogador1 = new Jogador(Console.lerString("Insira o nome do primeiro jogador: "));
        jogador2 = new Jogador(Console.lerString("Insira o nome do segundo jogador: "));
    }

    public void inicializaJogo() {
        Random random = new Random();
        int aleatorio = random.nextInt(2) + 1;

        if (aleatorio == 1) {
            jogador1.determinaSimbolo("X");
            jogadorAtual = jogador1;
            jogador2.determinaSimbolo("O");
        } else {
            jogador2.determinaSimbolo("X");
            jogadorAtual = jogador2;
            jogador1.determinaSimbolo("O");
        }
    }

    public void jogar() {
        boolean jogoContinua = true;

        while (jogoContinua) {
            mesa.imprimeTabuleiro();
            System.out.println("Vez do jogador: " + jogadorAtual.getNome() + " (" + jogadorAtual.getSimbolo() + ")");

            boolean jogadaValida;
            do
            {
                char linha = Console.lerChar("Insira a linha (A-C): ");
                if (Character.isLowerCase(linha)) {
                    linha = Character.toUpperCase(linha);
                }

                int trueLinha = linha - 'A';
                int coluna = Console.lerInt("Insira a coluna (1-3): ");

                Jogada jogadaAtual = new Jogada(trueLinha, coluna - 1, jogadorAtual.getSimbolo());
                jogadaValida = jogadaValida(jogadaAtual);

                if (!jogadaValida) {
                    System.out.println("Jogada inválida. Tente novamente.");
                } else {
                    mesa.receberJogada(jogadaAtual);
                }

            } while(!jogadaValida);

            if (vitoria()) {
                mesa.imprimeTabuleiro();
                System.out.println("Jogador " + jogadorAtual.getNome() + " venceu!");
                jogoContinua = false;

            } else if (empate()) {
                mesa.imprimeTabuleiro();
                System.out.println("Empate!");
                jogoContinua = false;

            } else {
                alternarJogador();
            }
        }
    }
}
