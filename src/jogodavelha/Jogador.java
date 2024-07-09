package jogodavelha;

public class Jogador implements Jogadores {
    protected String nome;
    protected String simbolo;
    protected int pontuacao;
    protected Jogada jogada;

    public Jogador(String nome) {
        this.nome = nome;
        this.pontuacao = 0;
    }
    public int getPontuacao() {
        return pontuacao;
    }

    public String getNome() {
        return nome;
    }


    public String getSimbolo() {
        return simbolo;
    }

    @Override
    public void determinaSimbolo(String simbolo){
        this.simbolo = simbolo;
    }

    public Jogada getJogada() {
        return jogada;
    }
}
