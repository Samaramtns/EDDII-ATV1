class BubbleSort {
    public static void ordenar(int[] vetor) {
        int n = vetor.length;
        boolean trocado;
        for (int i = 0; i < n - 1; i++) {
            trocado = false;
            for (int j = 0; j < n - i - 1; j++) {
                Resultado.incrementaComparacoes();
                if (vetor[j] > vetor[j + 1]) {
                    int temp = vetor[j];
                    vetor[j] = vetor[j + 1];
                    vetor[j + 1] = temp;
                    Resultado.incrementaTrocas();
                    trocado = true;
                }
            }
            if (!trocado) break;
        }
    }
}
