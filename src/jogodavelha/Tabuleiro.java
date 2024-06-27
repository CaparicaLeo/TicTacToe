package jogodavelha;

public class Tabuleiro {
    private final int tamanho;
    private final String[][] matriz;
    public Tabuleiro(int tamanho){
        this.tamanho = tamanho;
        matriz = new String[tamanho][tamanho];
        for(int i=0;i<tamanho;i++){
            for(int j=0;j<tamanho;j++){
                matriz[i][j]= " ";
            }
        }
    }
    public void imprimeTabuleiro(){
        System.out.println("  0 1 2");
        for (int i = 0; i < tamanho; i++) {
            System.out.print(i + " ");
            for (int j = 0; j < tamanho; j++) {
                System.out.print(matriz[i][j]);
                if (j < tamanho - 1) System.out.print("|");
            }
            System.out.println();
            if (i < tamanho - 1) System.out.println("  -----");
        }
    }
    public void receberJogada(Jogada jogada){
        this.matriz[jogada.getX()][jogada.getY()]= jogada.getJogador().getSimbolo();
    }
}
