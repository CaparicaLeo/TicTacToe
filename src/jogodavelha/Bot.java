package jogodavelha;

import java.util.Random;

/**
 * Classe que representa o bot do jogo da velha.
 *
 * @version 1.0
 */
public class Bot extends Jogador {

    private final String nome = "Robo";
    private String simbolo;
    private Jogada jogada;

    /**
     * Construtor da classe Bot.
     * Inicializa o bot com o nome "Robo".
     */
    public Bot() {
        super("Robo");
    }

    /**
     * Realiza uma jogada aleatória.
     * Gera coordenadas aleatórias e cria uma jogada com o símbolo do bot.
     */
    public void realizarJogada() {
        Random aleatorio = new Random();
        int x = aleatorio.nextInt(3);
        int y = aleatorio.nextInt(3);
        this.jogada = new Jogada(x, y, this.simbolo);
    }

    /**
     * Obtém o símbolo do bot.
     *
     * @return O símbolo do bot.
     */
    public String getSimbolo() {
        return simbolo;
    }

    /**
     * Define o símbolo do bot.
     *
     * @param simbolo O símbolo a ser definido para o bot.
     */
    @Override
    public void determinaSimbolo(String simbolo) {
        this.simbolo = simbolo;
    }

    /**
     * Obtém o nome do bot.
     *
     * @return O nome do bot.
     */
    public String getNome() {
        return this.nome;
    }

    /**
     * Obtém a jogada realizada pelo bot.
     *
     * @return A jogada realizada pelo bot.
     */
    public Jogada getJogada() {
        return this.jogada;
    }
}
