package jogodavelha;

/**
 * Classe que representa um jogador no jogo da velha.
 *
 * @version 1.0
 */
public class Jogador{

    private final String nome;
    private String simbolo;
    private int pontuacao;
    private Jogada jogada;
    /**
     * Construtor da classe Jogador.
     *
     * @param nome Nome do jogador.
     */
    public Jogador(String nome) {
        this.nome = nome;
        this.pontuacao = 0;
    }

    /**
     * Construtor privado da classe Jogador.
     *
     * @param nome Nome do jogador.
     * @param pontuacao Pontuação do jogador.
     */
    private Jogador(String nome, int pontuacao) {
        this.nome = nome;
        this.pontuacao = pontuacao;
    }

    /**
     * Obtém a pontuação do jogador.
     *
     * @return A pontuação do jogador.
     */
    public int getPontuacao() {
        return pontuacao;
    }

    /**
     * Obtém o nome do jogador.
     *
     * @return O nome do jogador.
     */
    public String getNome() {
        return nome;
    }

    /**
     * Obtém o símbolo do jogador.
     *
     * @return O símbolo do jogador.
     */
    public String getSimbolo() {
        return simbolo;
    }

    /**
     * Define o símbolo do jogador.
     *
     * @param simbolo O símbolo a ser definido para o jogador.
     */
    public void determinaSimbolo(String simbolo) {
        this.simbolo = simbolo;
    }

    /**
     * Obtém a jogada realizada pelo jogador.
     *
     * @return A jogada realizada pelo jogador.
     */
    public Jogada getJogada() {
        return this.jogada;
    }

    /**
     * Define a pontuação do jogador.
     *
     * @param p A pontuação a ser definida.
     */
    private void setPontuacao(int p) {
        this.pontuacao = p;
    }

    /**
     * Adiciona pontos à pontuação do jogador.
     *
     * @param p Pontos a serem adicionados à pontuação do jogador.
     */
    public void pontuar(int p) {
        this.setPontuacao(this.getPontuacao() + p);
    }

    /**
     * Retorna uma representação em string do jogador, incluindo nome e pontuação.
     *
     * @return A string representando o jogador.
     */
    @Override
    public String toString() {
        return this.nome + ": " + this.pontuacao + " pontos.";
    }

    /**
     * Constrói um objeto Jogador a partir de uma string formatada.
     *
     * @param linha A string contendo os dados do jogador no formato "Nome: Pontos pontos."
     * @return O objeto Jogador construído a partir da string.
     * @exception IllegalArgumentException se a string não estiver no formato esperado.
     */
    public static Jogador fromString(String linha) {
        String[] partes = linha.split(": ");

        if (partes.length < 2) {
            throw new IllegalArgumentException("Formato inválido para a linha: " + linha);
        }

        String nome = partes[0];
        String[] pontosPartes = partes[1].split(" ");
        if (pontosPartes.length < 2) {
            throw new IllegalArgumentException("Formato inválido para a linha: " + linha);
        }

        int pontos;
        try {
            pontos = Integer.parseInt(pontosPartes[0]);
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException("Formato de pontos inválido para a linha: " + linha);
        }

        return new Jogador(nome, pontos);
    }
}
