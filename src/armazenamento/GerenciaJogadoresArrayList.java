package armazenamento;

import java.util.ArrayList;
import jogodavelha.Jogador;
public class GerenciaJogadoresArrayList implements GerenciaJogadores {

    private static final ArrayList<Jogador> jogadores = new ArrayList<>();
    public void adicionarJogador(Jogador jogador) {
        jogadores.add(jogador);
    }

    public void removerJogador(Jogador jogador) {
        jogadores.remove(jogador);
    }

    public void ordenarJogadores() {
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

    @Override
    public void apresentarPontuacao() {
        for (Jogador jogador : jogadores) {
            System.out.println(jogador);
        }
    }

    public ArrayList<Jogador> getJogadores() {
        return jogadores;
    }

    @Override
    public void armazenarInfo(Jogador jogador) {

    }

    @Override
    public Jogador retornarInfo() {
        return null;
    }
}
