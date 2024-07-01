package jogodavelha;

public class Jogador{
    private String nome;
    private String simbolo;
    private int pontuacao;
    private Jogada jogada;

    public Jogador(String nome){
        this.nome = nome;
        this.pontuacao = 0;
    }

    public void setPontuacao(int pontuacao){
        this.pontuacao = pontuacao;
    }
    public int getPontuacao() {
        return pontuacao;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getSimbolo() {
        return simbolo;
    }

    public void determinaSimbolo(String simbolo){
        this.simbolo = simbolo;
    }
    public Jogada realizarJogada(int x, int y){
        this.jogada = new Jogada(x,y,this.simbolo);
        return this.jogada;
    }
    
    public Jogada getJogada() {
        return this.jogada;
    }
}
