package jogodavelha;

/**
 * Classe que representa uma jogada no jogo da velha.
 *
 * @version 1.0
 */
public class Jogada {

    private int x;
    private int y;
    private String simbolo;

    /**
     * Construtor da classe Jogada.
     *
     * @param x Coordenada X da jogada.
     * @param y Coordenada Y da jogada.
     * @param simbolo Símbolo do jogador que realizou a jogada.
     */
    public Jogada(int x, int y, String simbolo) {
        this.x = x;
        this.y = y;
        this.simbolo = simbolo;
    }

    /**
     * Obtém a coordenada X da jogada.
     *
     * @return A coordenada X.
     */
    public int getX() {
        return this.x;
    }

    /**
     * Obtém a coordenada Y da jogada.
     *
     * @return A coordenada Y.
     */
    public int getY() {
        return this.y;
    }

    /**
     * Obtém o símbolo do jogador que realizou a jogada.
     *
     * @return O símbolo do jogador.
     */
    public String getSimbolo() {
        return this.simbolo;
    }
}
