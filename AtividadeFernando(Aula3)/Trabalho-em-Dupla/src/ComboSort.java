class ComboSort {
    public static void ordenar(int[] vetor) {
        int gap = vetor.length;
        boolean trocado = true;

        while (gap != 1 || trocado) {
            gap = getProximoGap(gap);
            trocado = false;

            for (int i = 0; i < vetor.length - gap; i++) {
                Resultado.incrementaComparacoes();
                if (vetor[i] > vetor[i + gap]) {
                    int temp = vetor[i];
                    vetor[i] = vetor[i + gap];
                    vetor[i + gap] = temp;
                    Resultado.incrementaTrocas();
                    trocado = true;
                }
            }
        }
    }

    private static int getProximoGap(int gap) {
        gap = (gap * 10) / 13;
        if (gap < 1) return 1;
        return gap;
    }
}
