package armazenamento;

import java.util.ArrayList;
import java.util.Collections;
import jogodavelha.Jogador;

public class GerenciaJogadoresArrayList {

    private static final ArrayList<Jogador> jogadores = new ArrayList<>();

    public static void armazenarInfo(Jogador novoJogador) {
        boolean jogadorExistente = false;

        for (Jogador jogador : jogadores) {
            if (jogador.getNome().equals(novoJogador.getNome())) {
                jogador.pontuar(novoJogador.getPontuacao());
                jogadorExistente = true;
                break;
            }
        }

        if (!jogadorExistente) {
            jogadores.add(novoJogador);
        }

        ordenarJogadores();
        GerenciaJogadoresArquivos.atualizarArquivo(jogadores);
    }

    public static void ordenarJogadores() {
        // Ordena os jogadores por pontuação de forma decrescente
        jogadores.sort((j1, j2) -> Integer.compare(j2.getPontuacao(), j1.getPontuacao()));
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
        GerenciaJogadoresArquivos.verificarArquivo();
        ArrayList<String> linhas = GerenciaJogadoresArquivos.retornarInfo(); // Método que lê as linhas do arquivo e retorna uma lista de strings

        jogadores.clear(); // Limpa a lista antes de carregar novos dados

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
        ordenarJogadores();
    }
}
