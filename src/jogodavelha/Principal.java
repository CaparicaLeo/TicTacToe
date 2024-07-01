package jogodavelha;
// dentro da package comando: javac Principal.java Jogador.java Jogada.java Tabuleiro.java Jogo.java
// o executavel: java Principal.java Jogador.java Jogada.java Tabuleiro.java Jogo.java

//import armazenamento.*;
//import entradadados.*;
import java.util.Scanner;
public class Principal {
    public static void main(String[] args){
        menu();
    }
    public static void menu(){
        int opcao;

        System.out.println("Selecione sua Opção!");
        Scanner scan = new Scanner(System.in);
        do
        {
            System.out.println("*****************");
            System.out.println("*               *");
            System.out.println("* JOGO DA VELHA *");
            System.out.println("*               *");
            System.out.println("*****************");
            System.out.println("1. JOGAR");
            System.out.println("2. JOGAR CONTRA BOT");
            System.out.println("3. PONTUAÇÃO GERAL.");
            System.out.println("4. CREDITOS.");
            System.out.println("5. SAIR\n");
            System.out.print("Insira: ");
            opcao = scan.nextInt();
            scan.nextLine();
            switch (opcao) {

                case 1:
                    Jogo jogo = new Jogo();
                    break;
                case 2:
                    break;
                case 5:
                    System.out.println("Saindo...");
                    return;
            }
        }while(opcao!=3);
        scan.close();

    }
}
