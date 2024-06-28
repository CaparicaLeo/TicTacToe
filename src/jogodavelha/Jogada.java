package jogodavelha;

public class Jogada {
    private int x;
    private int y;
    private String simbolo;

    public Jogada(int x, int y, String simbolo){
        this.x = x;
        this.y = y;
        this.simbolo = simbolo;
    }
    public int getX() {
        return this.x;
    }

    public int getY() {
        return this.y;
    }

    public String getSimbolo(){
        return this.simbolo;
    }
}
