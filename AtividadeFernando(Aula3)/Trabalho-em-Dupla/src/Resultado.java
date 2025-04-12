class Resultado {
    private static long comparacoes = 0;
    private static long trocas = 0;

    public static void resetar() {
        comparacoes = 0;
        trocas = 0;
    }

    public static void incrementaComparacoes() {
        comparacoes++;
    }

    public static void incrementaTrocas() {
        trocas++;
    }

    public static long getComparacoes() {
        return comparacoes;
    }

    public static long getTrocas() {
        return trocas;
    }
}