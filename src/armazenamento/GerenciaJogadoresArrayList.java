package armazenamento;

import java.util.ArrayList;
import java.util.Collections;
import jogodavelha.Jogador;

public class GerenciaJogadoresArrayList {

    private static final ArrayList<Jogador> jogadores = new ArrayList<>();

    public static void armazenarInfo(Jogador jogador) {
        jogadores.add(jogador);
        ordenarJogadores();
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

    public static void carregarLista(ArrayList<String> dados) {
        jogadores.clear(); // Limpa a lista atual de jogadores
        for (String linha : dados) {
            Jogador jogador = Jogador.fromString(linha);
            jogadores.add(jogador);
        }
        ordenarJogadores(); // Garante que a lista esteja ordenada após o carregamento
    }
}
