package entradadados;
import java.util.Scanner;
public class Console {
    //Classe para a entrada de dados
    private int opcao;

    public int getOpcao() {
        return opcao;
    }
    public void zerarOpcao(){
        this.opcao = Integer.parseInt(null);
    }
    public void entrada(){
        Scanner scan = new Scanner(System.in);
        opcao = scan.nextInt();
    }
}
