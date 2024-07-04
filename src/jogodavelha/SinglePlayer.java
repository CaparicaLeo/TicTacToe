package jogodavelha;
import java.util.Random;
import java.util.Scanner;
public class SinglePlayer extends Jogo{
    private Bot computador;
    Jogador jogadorAtual;
    public SinglePlayer(){
        inicializaJogadores();
        inicializaJogo();
        jogar();
    }
    @Override
    public void inicializaJogadores(){
        Scanner scan = new Scanner(System.in);
        System.out.println("Insira seu nome: ");
        jogador1 = new Jogador(scan.nextLine());
        computador = new Bot();
    }
    @Override
    public void inicializaJogo() {
        Random random = new Random();
        int aleatorio = random.nextInt(2) + 1;
        if (aleatorio == 1) {
            jogador1.determinaSimbolo("X");
            jogadorAtual = jogador1;
            computador.determinaSimbolo("O");
        } else {
            computador.determinaSimbolo("X");
            jogadorAtual = computador;
            jogador1.determinaSimbolo("O");
        }
    }
    @Override
    public void jogar(){
        Scanner scanner = new Scanner(System.in);
        boolean jogoContinua = true;
        Jogada jogadaAtual;
        while (jogoContinua) {
            mesa.imprimeTabuleiro();
            System.out.println("Vez do jogador: " + jogadorAtual.getNome() + " (" + jogadorAtual.getSimbolo() + ")");

            boolean jogadaValida;
            do {
                if(jogadorAtual.getClass() == computador.getClass()){
                    computador.realizarJogada();
                    jogadaAtual = new Jogada(jogadorAtual.getJogada().getX(),  jogadorAtual.getJogada().getY()-1, jogadorAtual.getSimbolo());
                }
                else{
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
                    if(jogadorAtual.getClass() == computador.getClass()) {
                        System.out.println("Jogada inválida. Tente novamente.");
                    }
                } else {
                    mesa.receberJogada(jogadaAtual);
                }
            } while (!jogadaValida);

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

    @Override
    protected void alternarJogador() {
        super.alternarJogador();
    }

    @Override
    public boolean vitoria() {
        return super.vitoria();
    }

    @Override
    public boolean empate() {
        return super.empate();
    }
    @Override
    protected boolean jogadaValida(Jogada jogadaAtual) {
        return super.jogadaValida(jogadaAtual);
    }
}
