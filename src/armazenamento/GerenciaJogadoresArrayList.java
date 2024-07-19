package armazenamento;

import java.util.ArrayList;
import java.util.Collections;
import jogodavelha.Jogador;

/**
 * Classe responsável por gerenciar a lista de jogadores utilizando um ArrayList.
 *
 * @version 1.0
 */
public class GerenciaJogadoresArrayList {

    private static final ArrayList<Jogador> jogadores = new ArrayList<>();

    /**
     * Armazena as informações de um jogador na lista e atualiza o arquivo.
     *
     * @param jogador O jogador a ser armazenado.
     */
    public static void armazenarInfo(Jogador jogador) {
        jogadores.add(jogador);
        ordenarJogadores();
        GerenciaJogadoresArquivos.atualizarArquivo(jogadores);
    }

    /**
     * Ordena os jogadores por pontuação de forma decrescente.
     */
    public static void ordenarJogadores() {
        Collections.sort(jogadores, (j1, j2) -> Integer.compare(j2.getPontuacao(), j1.getPontuacao()));
    }

    /**
     * Apresenta a pontuação de todos os jogadores armazenados.
     */
    public static void apresentarPontuacao() {
        for (Jogador jogador : jogadores) {
            System.out.println(jogador);
        }
    }

    /**
     * Retorna a lista de jogadores armazenada.
     *
     * @return A lista de jogadores.
     */
    public static ArrayList<Jogador> retornaArrayList() {
        ordenarJogadores();
        return jogadores;
    }

    /**
     * Carrega a lista de jogadores a partir das informações armazenadas no arquivo.
     */
    public static void carregarLista() {
        ArrayList<String> linhas = GerenciaJogadoresArquivos.retornarInfo(); // Método que lê as linhas do arquivo e retorna uma lista de strings
        ArrayList<Jogador> jogadoresTemp = new ArrayList<>();

        for (String linha : linhas) {
            if (linha.trim().isEmpty()) {
                continue; // Pule linhas vazias
            }

            try {
                Jogador jogador = Jogador.fromString(linha);
                jogadoresTemp.add(jogador);
            } catch (IllegalArgumentException e) {
                System.out.println("Erro ao processar a linha: " + linha);
                System.out.println(e.getMessage());
            }
        }
        jogadores.clear();
        jogadores.addAll(jogadoresTemp);
        ordenarJogadores();
    }
}
