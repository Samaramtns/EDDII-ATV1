class ShellSort {
    public static void ordenar(int[] vetor) {
        int n = vetor.length;
        for (int gap = n / 2; gap > 0; gap /= 2) {
            for (int i = gap; i < n; i++) {
                int temp = vetor[i];
                int j;
                for (j = i; j >= gap; j -= gap) {
                    Resultado.incrementaComparacoes();
                    if (vetor[j - gap] > temp) {
                        vetor[j] = vetor[j - gap];
                        Resultado.incrementaTrocas();
                    } else {
                        break;
                    }
                }
                vetor[j] = temp;
            }
        }
    }
}