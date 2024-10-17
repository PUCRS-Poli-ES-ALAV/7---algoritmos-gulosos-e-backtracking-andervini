public class SDM {

    private static Counter counter = new Counter();

    public static void main(String[] args) {
        System.out.println("Hello World!");
    }

    /**
     * Subcoleção Disjunta Máxima - Solução Gulosa
     *
     * @param s array com os inícios dos intervalos da coleção
     * @param f array com os finais dos intervalos
     * @param n quantidade de intervalos
     * @return um array com 1 nos indices dos intervalos que pertencem a subcoleção encontrada ou 0 caso contrario
     */
    public int[] sdmGuloso(int[] s, int[] f, int n) {
        counter.startCount();

        int[] x = new int[n];
        counter.addCount(n);
        int i = 0;
        counter.addCount(1);

        for (int k = 1; k < n; k++) {
            counter.addCount(1);

            if (s[k] > f[i]) {
                x[k] = 1;
                i = k;
                counter.addCount(2);
            }
            counter.addCount(1);
        }

        counter.endCount();
        return x;
    }


    private int[][] sortF(int[][] x) {
        // TODO: usar merge / quick sort...
        for (int i = 0; i < x.length - 1; i++) {
            if (x[i][1] > x[i + 1][1]) {
                // swap
                int temp = x[i][0];
                x[i][0] = x[i + 1][0];
                x[i + 1][0] = temp;

                temp = x[i][1];
                x[i][1] = x[i + 1][1];
                x[i + 1][1] = temp;

                i = 0;
            }
        }

        return x;
    }
}
