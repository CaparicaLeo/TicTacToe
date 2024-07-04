package jogodavelha;
import java.util.Random;
public class Bot extends Jogador implements Jogadores{
    private String nome;
    private String simbolo;
    private Jogada jogada;

    public Bot(){
        super("Robo");
    }
    public void realizarJogada(){
        Random aleatorio = new Random();
        int x = aleatorio.nextInt(3);
        int y = aleatorio.nextInt(3)+1;
        this.jogada = new Jogada(x,y,this.simbolo);
    }
    public String getSimbolo() {
        return simbolo;
    }

    @Override
    public void determinaSimbolo(String simbolo) {
        this.simbolo = simbolo;
    }
    public String getNome(){
        return this.nome;
    }
    public Jogada getJogada(){
        return this.jogada;
    }
}
