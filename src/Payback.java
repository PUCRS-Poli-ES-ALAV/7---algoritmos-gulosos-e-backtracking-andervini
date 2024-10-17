import java.util.Arrays;

/**
 * Payback
 */

//    Objetivo: construa um algorítmo que recebe a lista das moedas disponíveis e um valor, e retorna uma lista com a menor quantidade de moedas para este troco;
//    Defina uma assinatura adequada para este método;
//    Utiliza uma abordagem gulosa (se puder);
//    Contabilize e exiba o número de iterações para cada caso de teste;
//    O exercício pode ser feito em grupos de um, dois ou três elementos.

public class Payback {

    public static Counter counter = new Counter();

    public static void main(String[] args) {
        Payback payback = new Payback();

        // Teste 1: Troco exato com moedas disponíveis
        double valor1 = 3.41; // R$ 3,41
        int[] moedas1 = {10, 10, 10, 10, 10}; // Quantidade de moedas de 1, 5, 10, 25, 100 centavos
        System.out.println("Teste 1: " + Arrays.toString(payback.troco(valor1, moedas1)));
        System.out.println(counter);

        // Teste 2: Troco com quantidade limitada de moedas
        double valor2 = 1.87; // R$ 1,87
        int[] moedas2 = {3, 2, 1, 1, 2}; // Poucas moedas de cada denominação
        System.out.println("Teste 2: " + Arrays.toString(payback.troco(valor2, moedas2)));
        System.out.println(counter);

        // Teste 3: Troco exato sem precisar usar moedas de 1 centavo
        double valor3 = 0.50; // R$ 0,50
        int[] moedas3 = {0, 5, 5, 5, 5}; // Não há moedas de 1 centavo
        System.out.println("Teste 3: " + Arrays.toString(payback.troco(valor3, moedas3)));
        System.out.println(counter);

        // Teste 4: Troco impossível com moedas insuficientes
        double valor4 = 0.99; // R$ 0,99
        int[] moedas4 = {0, 0, 0, 0, 0}; // Nenhuma moeda disponível
        System.out.println("Teste 4: " + Arrays.toString(payback.troco(valor4, moedas4)));
        System.out.println(counter);

        // Teste 5: Troco grande com muitas moedas disponíveis
        double valor5 = 15.76; // R$ 15,76
        int[] moedas5 = {100, 100, 100, 100, 100}; // Muitas moedas disponíveis
        System.out.println("Teste 5: " + Arrays.toString(payback.troco(valor5, moedas5)));
        System.out.println(counter);

        // Teste 6: Troco com valor pequeno
        double valor6 = 0.01; // R$ 0,01
        int[] moedas6 = {1, 0, 0, 0, 0}; // Apenas uma moeda de 1 centavo disponível
        System.out.println("Teste 6: " + Arrays.toString(payback.troco(valor6, moedas6)));
        System.out.println(counter);

        // Teste 7: Troco exato com muitas moedas de menor valor
        double valor7 = 0.15; // R$ 0,15
        int[] moedas7 = {100, 100, 0, 0, 0}; // Apenas moedas de 1 e 5 centavos disponíveis
        System.out.println("Teste 7: " + Arrays.toString(payback.troco(valor7, moedas7)));
        System.out.println(counter);

        // Teste 8: Troco zero
        double valor8 = 0.0; // R$ 0,00
        int[] moedas8 = {0, 0, 0, 0, 0}; // Nenhuma moeda disponível, mas o troco é 0
        System.out.println("Teste 8: " + Arrays.toString(payback.troco(valor8, moedas8)));
        System.out.println(counter);

    }

    public int[] troco(double valor, int[] moedas) {
        counter.startCount();

        int valorInt = (int) (valor * 100);
        counter.addCount(3);
        int moedas1 = moedas[0];
        int moedas5 = moedas[1];
        int moedas10 = moedas[2];
        int moedas25 = moedas[3];
        int moedas100 = moedas[4];
        counter.addCount(5);

        int qt100 = valorInt / 100;
        counter.addCount(2); // /, =
        if (qt100 > moedas100) {
            qt100 = moedas100;
            counter.addCount(1);
        }
        counter.addCount(1); // if
        valorInt -= qt100 * 100;
        counter.addCount(3); // *, -, =

        int qt25 = valorInt / 25;
        counter.addCount(2); // /, =
        if (qt25 > moedas25) {
            qt25 = moedas25;
            counter.addCount(1);
        }
        counter.addCount(1); // if
        valorInt -= qt25 * 25;
        counter.addCount(3); // *, -, =

        int qt10 = valorInt / 10;
        counter.addCount(2); // /, =
        if (qt10 > moedas10) {
            qt10 = moedas10;
            counter.addCount(1);
        }
        counter.addCount(1); // if
        valorInt -= qt10 * 10;
        counter.addCount(3); // *, -, =

        int qt5 = valorInt / 5;
        counter.addCount(2); // /, =
        if (qt5 > moedas5) {
            qt5 = moedas5;
            counter.addCount(1);
        }
        counter.addCount(1); // if
        valorInt -= qt5 * 5;
        counter.addCount(3); // *, -, =

        int qt1 = valorInt;
        counter.addCount(1); // =
        if (qt1 > moedas1) {
            qt1 = moedas1;
            counter.addCount(1);
        }
        counter.addCount(1); // if

        counter.endCount();

        return new int[]{qt1, qt5, qt10, qt25, qt100};
    }



}