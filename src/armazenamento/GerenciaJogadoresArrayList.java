package armazenamento;

import java.util.ArrayList;
import java.util.Collections;
import jogodavelha.Jogador;

public class GerenciaJogadoresArrayList {

    private static final ArrayList<Jogador> jogadores = new ArrayList<>();

    public static void armazenarInfo(Jogador jogador) {
        jogadores.add(jogador);
        ordenarJogadores();
        GerenciaJogadoresArquivos.atualizarArquivo(jogadores);
    }

    public static void ordenarJogadores() {
        // Ordena os jogadores por pontuação de forma decrescente
        Collections.sort(jogadores, (j1, j2) -> Integer.compare(j2.getPontuacao(), j1.getPontuacao()));
    }

    public static void apresentarPontuacao() {
        for (Jogador jogador : jogadores) {
            System.out.println(jogador);
        }
    }

    public static ArrayList<Jogador> retornaArrayList() {
        ordenarJogadores();
        return jogadores;
    }

    public static void carregarLista() {
        ArrayList<String> linhas = GerenciaJogadoresArquivos.retornarInfo(); // Método que lê as linhas do arquivo e retorna uma lista de strings
        ArrayList<Jogador> jogadores = new ArrayList<>();

        for (String linha : linhas) {
            if (linha.trim().isEmpty()) {
                continue; // Pule linhas vazias
            }

            try {
                Jogador jogador = Jogador.fromString(linha);
                jogadores.add(jogador);
            } catch (IllegalArgumentException e) {
                System.out.println("Erro ao processar a linha: " + linha);
                System.out.println(e.getMessage());
            }
        }

        // Agora você pode usar a lista 'jogadores' como necessário
        // Exemplo: imprimir os jogadores
        for (Jogador jogador : jogadores) {
            System.out.println(jogador);
        }
    }

}
