package armazenamento;

import java.io.*;
import java.util.ArrayList;
import jogodavelha.Jogador;

/**
 * Classe responsável por gerenciar o armazenamento de jogadores em arquivo.
 *
 * @version 1.0
 */
public final class GerenciaJogadoresArquivos {

    private static final String nomeArquivo = "ArmazenaJogadores.txt";

    /**
     * Atualiza o arquivo com a lista de jogadores fornecida.
     *
     * @param jogadores Lista de jogadores a serem armazenados no arquivo.
     */
    public static void atualizarArquivo(ArrayList<Jogador> jogadores) {
        armazenarInfo(jogadores);
    }

    /**
     * Armazena a lista de jogadores no arquivo.
     *
     * @param jogadores Lista de jogadores a serem armazenados.
     * @exception IOException se ocorrer um erro ao escrever no arquivo.
     */
    private static void armazenarInfo(ArrayList<Jogador> jogadores) {
        try (BufferedWriter writer = new BufferedWriter(new FileWriter(nomeArquivo, true))) {
            for (Jogador jogador : jogadores) {
                writer.write(jogador.toString());
                writer.newLine();
            }
        } catch (IOException e) {
            System.err.println("Erro ao escrever no arquivo: " + e.getMessage());
        }
    }

    /**
     * Retorna as informações dos jogadores armazenadas no arquivo.
     *
     * @return Lista de strings contendo as informações dos jogadores.
     * @exception IOException se ocorrer um erro ao ler o arquivo.
     */
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

    /**
     * Verifica se o arquivo existe e, caso não exista, cria um novo arquivo.
     *
     * @exception IOException se ocorrer um erro ao criar o arquivo.
     */
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
