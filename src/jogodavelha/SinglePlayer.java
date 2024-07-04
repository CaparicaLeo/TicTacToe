package jogodavelha;
import java.util.Random;
import java.util.Scanner;
public class SinglePlayer extends Jogo{
    private Bot computador;
    private Jogador jogadorAtual;

    public SinglePlayer(){
        this.inicializaJogadores();
        this.inicializaJogo();
        this.jogar();
    }
    @Override
    public void inicializaJogadores(){
        Scanner scan = new Scanner(System.in);
        System.out.print("Insira seu nome: ");
        this.jogador1 = new Jogador(scan.nextLine());
        this.computador = new Bot();
    }
    @Override
    public void inicializaJogo() {
        Random random = new Random();
        int aleatorio = random.nextInt(2) + 1;
        if (aleatorio == 1) {
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
    public void jogar(){
        Scanner scanner = new Scanner(System.in);
        Jogada jogadaAtual;

        do {
            boolean jogadaValida;
            do {
                if(this.jogadorAtual.getClass() == this.computador.getClass()){
                    this.computador.realizarJogada();
                    jogadaAtual = new Jogada(this.jogadorAtual.getJogada().getX(),this.jogadorAtual.getJogada().getY()-1, this.jogadorAtual.getSimbolo());
                }
                else{
                    mesa.imprimeTabuleiro();
                    System.out.println("Vez do jogador: " + this.jogadorAtual.getNome() + " (" + this.jogadorAtual.getSimbolo() + ")");
                    System.out.print("Insira a linha (A-C): ");
                    char linha = scanner.next().charAt(0);
                    if (Character.isLowerCase(linha)) {
                        linha = Character.toUpperCase(linha);
                    }

                    int trueLinha = linha - 'A';
                    System.out.print("Insira a coluna (1-3): ");
                    int coluna = scanner.nextInt();

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
            } while (!jogadaValida);
        }while(jogoContinua());
    }

    @Override
    protected void alternarJogador() {
        jogadorAtual = (jogadorAtual == jogador1) ? computador : jogador1;
    }

    @Override
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

    @Override
    public boolean empate() {
        return super.empate();
    }
    public boolean jogoContinua(){
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
}
