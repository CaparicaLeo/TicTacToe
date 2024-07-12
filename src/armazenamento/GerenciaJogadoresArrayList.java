package armazenamento;

import java.util.ArrayList;
import jogodavelha.Jogador;
public class GerenciaJogadoresArrayList implements GerenciaJogadores {

    private static final ArrayList<Jogador> jogadores = new ArrayList<>();

    public static void armazenarInfo(Jogador jogador) {
        jogadores.add(jogador);
        ordenarJogadores();
    }

    public static void ordenarJogadores() {
        int n = jogadores.size();
        for (int i = 0; i < n - 1; i++) {
            for (int j = 0; j < n - 1 - i; j++) {
                // Compara a pontuação dos jogadores para ordenar em ordem decrescente
                if (jogadores.get(j).getPontuacao() < jogadores.get(j + 1).getPontuacao()) {
                    Jogador temp = jogadores.get(j);
                    jogadores.set(j, jogadores.get(j + 1));
                    jogadores.set(j + 1, temp);
                }
            }
        }
    }

    public static void apresentarPontuacao() {
        for (Jogador jogador : jogadores) {
            System.out.println(jogador);
        }
    }

    public static ArrayList<Jogador> retornaArrayList(){
        ordenarJogadores();
        return jogadores;
    }
}
