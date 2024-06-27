package armazenamento;
import jogodavelha.Jogador;

import java.util.ArrayList;

public class GerenciaJogadoresArrayList {
    ArrayList<Jogador> jogadores = new ArrayList<Jogador>();
    public void armazenarInfo(Jogador jogador){
        jogadores.add(jogador);
    }
    public void apresentarPontuacao(){
        System.out.println("Nome      | Pontuação    ");
        for(int i=0;i<jogadores.size();i++){
            System.out.println(i + ". " + jogadores.get(i).getNome() + "|" + jogadores.get(i).getPontuacao());
        }
    }


}
