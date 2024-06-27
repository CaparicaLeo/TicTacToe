package jogodavelha;

public class Jogada {
    private int x;
    private int y;
    private Jogador jogador;

    public Jogada(Jogador jogador, int x, int y){
        this.jogador = jogador;
        this.x = x;
        this.y = y;
    }
    public Jogador getJogador() {
        return jogador;
    }

    public void setJogador(Jogador jogador) {
        this.jogador = jogador;
    }

    public int getX() {
        return x;
    }

    public void setX(int x) {
        this.x = x;
    }

    public int getY() {
        return y;
    }

    public void setY(int y) {
        this.y = y;
    }
}
