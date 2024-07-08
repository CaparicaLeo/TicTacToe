package armazenamento;
import jogodavelha.Jogador;

import java.util.ArrayList;

public final class GerenciaJogadoresArrayList implements GerenciaJogadores{
    private ArrayList<Jogador> jogadores;
    public GerenciaJogadoresArrayList(){

    }
    @Override
    public void armazenarInfo(Jogador jogador){
        jogadores.add(jogador);
    }
    @Override
    public Jogador retornarInfo() {
        return null;
    }
    public void apresentarPontuacao(){
        System.out.println("Nome      | Pontuação    ");
        for(int i=0;i<jogadores.size();i++){
            System.out.println(i + ". " + jogadores.get(i).getNome() + "|" + jogadores.get(i).getPontuacao());
        }
    }
}
