class InsertionSort {
    public static void ordenar(int[] vetor) {
        for (int i = 1; i < vetor.length; i++) {
            int chave = vetor[i];
            int j = i - 1;
            while (j >= 0) {
                Resultado.incrementaComparacoes();
                if (vetor[j] > chave) {
                    vetor[j + 1] = vetor[j];
                    Resultado.incrementaTrocas();
                    j--;
                } else {
                    break;
                }
            }
            vetor[j + 1] = chave;
        }
    }
}