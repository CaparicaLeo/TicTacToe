package jogodavelha;

import java.util.Random;
import java.util.Scanner;

public class Jogo {
    public Tabuleiro mesa = new Tabuleiro();
    public Jogador jogador1;
    public Jogador jogador2;
    public Jogador jogadorAtual;

    public Jogo() {
        inicializaJogadores();
        inicializaJogo();
        jogar();
    }

    public void inicializaJogadores(){
        Scanner scan = new Scanner(System.in);
        System.out.print("Insira o nome do primeiro jogador: ");
        jogador1 = new Jogador(scan.nextLine());
        System.out.print("Insira o nome do segundo jogador: ");
        jogador2 = new Jogador(scan.nextLine());
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
        Scanner scanner = new Scanner(System.in);
        boolean jogoContinua = true;

        while (jogoContinua) {
            mesa.imprimeTabuleiro();
            System.out.println("Vez do jogador: " + jogadorAtual.getNome() + " (" + jogadorAtual.getSimbolo() + ")");

            do {
                System.out.print("Insira a linha (A-C): ");

                char linha = scanner.next().charAt(0);
                if (Character.isLowerCase(linha)) {
                    linha = Character.toUpperCase(linha);
                }

                int trueLinha = ((int) linha) - 65;
                System.out.print("Insira a coluna (0-2): ");
                int coluna = scanner.nextInt();
                jogadorAtual.realizarJogada(trueLinha, coluna);

                if (!jogadaValida(jogadorAtual.getJogada())) {
                    System.out.println("Jogada inválida. Tente novamente.");
                } else {
                    mesa.receberJogada(jogadorAtual.getJogada());
                }

            } while (jogadaValida(jogadorAtual.getJogada()));

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

    public boolean vitoria() {
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

    public boolean empate() {
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

    private void alternarJogador() {
        jogadorAtual = (jogadorAtual == jogador1) ? jogador2 : jogador1;
    }

    private boolean jogadaValida(Jogada jogadaAtual){
            if (!mesa.getMatriz()[jogadaAtual.getX()][jogadaAtual.getY()].equals(" ")) {
            return false;
        } else {
            return true;
        }
    }
}
