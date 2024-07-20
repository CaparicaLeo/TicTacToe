package armazenamento;

import java.io.*;
import java.util.ArrayList;
import jogodavelha.Jogador;

/**
 * Classe responsável por gerenciar a leitura e escrita de jogadores em um arquivo.
 */
public final class GerenciaJogadoresArquivos {

    private static final String nomeArquivo = "ArmazenaJogadores.txt";

    /**
     * Atualiza o arquivo com a lista de jogadores fornecida.
     *
     * @param jogadores Lista de jogadores a serem salvos no arquivo.
     */
    public static void atualizarArquivo(ArrayList<Jogador> jogadores){
        try (BufferedWriter writer = new BufferedWriter(new FileWriter(nomeArquivo))) {
            for (Jogador jogador : jogadores) {
                writer.write(jogador.toString());
                writer.newLine();
            }
        } catch (IOException e) {
            System.err.println("Erro ao escrever no arquivo: " + e.getMessage());
        }
    }

    /**
     * Retorna o conteúdo do arquivo como uma lista de strings.
     *
     * @return Lista de strings com o conteúdo do arquivo.
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
        System.out.println("Conteúdo lido do arquivo: " + conteudo);
        return conteudo;
    }

    /**
     * Verifica se o arquivo existe e, caso não exista, cria um novo arquivo.
     */
    public static void verificarArquivo() {
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
