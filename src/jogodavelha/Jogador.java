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
    private Jogador(String nome, int pontuacao){
        this.nome = nome;
        this.pontuacao = pontuacao;
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
    public void determinaSimbolo(String simbolo){
        this.simbolo = simbolo;
    }

    public Jogada getJogada() {
        return jogada;
    }
    private void setPontuacao(int p){
        this.pontuacao = p;
    }
    public void pontuar(int p){
        this.setPontuacao(this.getPontuacao()+p);
    }

    @Override
    public String toString() {
        return "Jogador{" +
                "Nome='" + nome + '\'' +
                ", pontuacao =" + pontuacao +
                '}';
    }
    public static Jogador fromString(String linha) {
        String[] partes = linha.split(": ");
        String nome = partes[0];
        int pontos = Integer.parseInt(partes[1].split(" ")[0]);
        return new Jogador(nome, pontos);
    }
}
