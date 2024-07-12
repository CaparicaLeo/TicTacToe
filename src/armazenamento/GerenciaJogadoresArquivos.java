package armazenamento;

import java.io.*;
import java.util.ArrayList;
import jogodavelha.Jogador;

public final class GerenciaJogadoresArquivos {

    private static final String nomeArquivo = "ArmazenaJogadores.txt";

    public static void atualizarArquivo(ArrayList<Jogador> jogadores){
        armazenarInfo(jogadores);
    }
    private static void armazenarInfo(ArrayList<Jogador> jogadores) {
        try (BufferedWriter writer = new BufferedWriter(new FileWriter(nomeArquivo))) {
            for (Jogador jogador : jogadores) {
                writer.write(jogador.toString());
                writer.newLine();
            }
        } catch (IOException e) {
            System.err.println("Erro ao escrever no arquivo: " + e.getMessage());
        }
    }

    public static ArrayList<String> retornarInfo() {
        ArrayList<String> conteudo = new ArrayList<>();
        try (BufferedReader reader = new BufferedReader(new FileReader(nomeArquivo))) {
            String linha;
            while ((linha = reader.readLine()) != null) {
                conteudo.add(linha);
            }
        } catch (IOException e) {
            System.err.println("Erro ao ler o arquivo: " + e.getMessage());
        }
        return conteudo;
    }
    private static void verificarArquivo() {
        File arquivo = new File(nomeArquivo);
        if (!arquivo.exists()) {
            try {
                arquivo.createNewFile();
            } catch (IOException e) {
                System.err.println("Erro ao criar o arquivo: " + e.getMessage());
            }
        }
    }
}
