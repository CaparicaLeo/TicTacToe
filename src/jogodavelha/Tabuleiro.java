package jogodavelha;

public class Tabuleiro {
    private static final int tamanho = 3;
    private final String[][] matriz;
    public Tabuleiro(){
        matriz = new String[tamanho][tamanho];
        for(int i=0;i<tamanho;i++){
            for(int j=0;j<tamanho;j++){
                matriz[i][j]= " ";
            }
        }
    }
    //imprime o tabuleiro para o jogo
    public void imprimeTabuleiro()
    {
        int i;
        for (i = 0; i < tamanho; i++) {
            char ch = (char) (i + 65);
            System.out.print(ch + " ");
            System.out.print(" ");
            for (int j = 0; j < tamanho; j++) {
                System.out.print(matriz[i][j]);
                if (j < tamanho - 1) System.out.print(" | ");
            }
            System.out.println();
            if (i < tamanho - 1) System.out.println("  -----------");
        }
        System.out.println("   0   1   2");
    }
    public void receberJogada(Jogada jogada){
        this.matriz[jogada.getX()][jogada.getY()]= jogada.getSimbolo();

    }
    public String[][] getMatriz() {
        return this.matriz;
    }

    public int getTamanho() {
        return tamanho;
    }
}
