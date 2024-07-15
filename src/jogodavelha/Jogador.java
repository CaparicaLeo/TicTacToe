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
        return this.nome + ": " + this.pontuacao + " pontos.";
    }
    public static Jogador fromString(String linha) {
        // Divida a linha em partes usando ": " como delimitador
        String[] partes = linha.split(": ");

        // Verifique se o array partes possui ao menos 2 elementos (nome e pontos)
        if (partes.length < 2) {
            throw new IllegalArgumentException("Formato inválido para a linha: " + linha);
        }

        // Obtenha o nome do jogador
        String nome = partes[0];

        // Divida a segunda parte usando " " como delimitador e verifique se há pelo menos 2 elementos (pontos e "pontos")
        String[] pontosPartes = partes[1].split(" ");
        if (pontosPartes.length < 2) {
            throw new IllegalArgumentException("Formato inválido para a linha: " + linha);
        }

        // Converta os pontos para um inteiro
        int pontos;
        try {
            pontos = Integer.parseInt(pontosPartes[0]);
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException("Formato de pontos inválido para a linha: " + linha);
        }

        // Retorne um novo objeto Jogador com o nome e os pontos
        return new Jogador(nome, pontos);
    }

}
