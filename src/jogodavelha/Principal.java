package jogodavelha;
import armazenamento.*;
import entradadados.*;
import java.util.Scanner;
public class Principal {
    public static void main(String[] args){
        menu();
    }
    public static void menu(){
        int opcao;
        System.out.println("JOGO DA VELHA!");
        System.out.println("Feito por Leonardo Caparica e Lucas Cogrossi.");
        System.out.println("Selecione sua Opção!");
        do
        {
            System.out.println("1. JOGAR");
            System.out.println("2. PONTUAÇÃO GERAL.");
            System.out.println("3. SAIR\n");
            System.out.print("Insira: ");
            Scanner scan = new Scanner(System.in);
            opcao = scan.nextInt();
            switch (opcao){
                case 1:
                    Jogo jogo = new Jogo();
                    break;
                case 2:
                    break;
                case 3:
                    System.out.println("Saindo...");
                    break;
            }
        }while(opcao!=3);

    }
}
