import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.Arrays;
import java.util.Random;

public class Main {
    public static void main(String[] args) {
        String caminhoArquivo = "C:\\Users\\Samara\\OneDrive\\Área de Trabalho\\AtividadeFernando(Aula3)\\Trabalho-em-Dupla\\src\\dados100mil.txt";
        int[] dadosOriginais = lerArquivo(caminhoArquivo);

        if (dadosOriginais == null || dadosOriginais.length == 0) {
            System.out.println("Erro ao ler o arquivo ou arquivo vazio. Gerando dados aleatórios para teste...");
            dadosOriginais = gerarAleatorios(100_000);
        }

        ResumoResultado[] resultados = {
            testarAlgoritmo("BubbleSort", dadosOriginais, BubbleSort::ordenar),
            testarAlgoritmo("InsertionSort", dadosOriginais, InsertionSort::ordenar),
            testarAlgoritmo("SelectionSort", dadosOriginais, SelectionSort::ordenar),
            testarAlgoritmo("ShellSort", dadosOriginais, ShellSort::ordenar),
            testarAlgoritmo("ComboSort", dadosOriginais, ComboSort::ordenar)
        };

        System.out.println("\n==== RESUMO FINAL ====\n");
        for (ResumoResultado r : resultados) {
            System.out.printf(
                "%-15s | Tempo: %6d ms | Comp: %10d | Trocas: %10d | OK: %s%n",
                r.nome, r.tempo, r.comparacoes, r.trocas, r.ordenado ? "SIM" : "NÃO"
            );
        }
    }

    private static int[] lerArquivo(String caminho) {
        try (BufferedReader br = new BufferedReader(new FileReader(caminho))) {
            StringBuilder sb = new StringBuilder();
            String linha;

            while ((linha = br.readLine()) != null) {
                sb.append(linha).append(",");
            }

            return Arrays.stream(sb.toString().split("[,\\s]+"))
                    .map(String::trim)
                    .filter(s -> !s.isEmpty() && s.matches("-?\\d+"))
                    .mapToInt(Integer::parseInt)
                    .toArray();
        } catch (IOException | NumberFormatException e) {
            e.printStackTrace();
            return null;
        }
    }

    private static int[] gerarAleatorios(int tamanho) {
        Random rand = new Random();
        int[] vetor = new int[tamanho];
        for (int i = 0; i < tamanho; i++) {
            vetor[i] = rand.nextInt(100_000);
        }
        return vetor;
    }

    private static boolean estaOrdenado(int[] vetor) {
        for (int i = 1; i < vetor.length; i++) {
            if (vetor[i - 1] > vetor[i]) {
                return false;
            }
        }
        return true;
    }

    private static ResumoResultado testarAlgoritmo(String nome, int[] dadosOriginais, AlgoritmoOrdenacao algoritmo) {
        int[] dados = Arrays.copyOf(dadosOriginais, dadosOriginais.length);
        Resultado.resetar();

        long inicio = System.nanoTime();
        algoritmo.ordenar(dados);
        long fim = System.nanoTime();

        long tempoMs = (fim - inicio) / 1_000_000;
        boolean ordenado = estaOrdenado(dados);

        return new ResumoResultado(
            nome, tempoMs, Resultado.getComparacoes(), Resultado.getTrocas(), ordenado
        );
    }

    interface AlgoritmoOrdenacao {
        void ordenar(int[] vetor);
    }

    static class ResumoResultado {
        String nome;
        long tempo;
        long comparacoes;
        long trocas;
        boolean ordenado;

        ResumoResultado(String nome, long tempo, long comparacoes, long trocas, boolean ordenado) {
            this.nome = nome;
            this.tempo = tempo;
            this.comparacoes = comparacoes;
            this.trocas = trocas;
            this.ordenado = ordenado;
        }
    }
}
