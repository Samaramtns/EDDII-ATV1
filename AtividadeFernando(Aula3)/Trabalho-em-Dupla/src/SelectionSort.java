class SelectionSort {
    public static void ordenar(int[] vetor) {
        int n = vetor.length;
        for (int i = 0; i < n - 1; i++) {
            int minIndex = i;
            for (int j = i + 1; j < n; j++) {
                Resultado.incrementaComparacoes();
                if (vetor[j] < vetor[minIndex]) {
                    minIndex = j;
                }
            }
            if (minIndex != i) {
                int temp = vetor[minIndex];
                vetor[minIndex] = vetor[i];
                vetor[i] = temp;
                Resultado.incrementaTrocas();
            }
        }
    }
}