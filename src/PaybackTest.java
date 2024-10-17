import static org.junit.jupiter.api.Assertions.assertArrayEquals;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class PaybackTest {

    private Payback payback;

    @BeforeEach
    public void setUp() {
        payback = new Payback();
    }

    @Test
    public void testTrocoExatoComMoedasDisponiveis() {
        double valor = 3.41; // R$ 3,41
        int[] moedas = {10, 10, 10, 10, 10}; // Quantidade de moedas de 1, 5, 10, 25, 100 centavos
        int[] expected = {1, 1, 1, 1, 3}; // Esperado: 1 moeda de 1, 1 de 5, 1 de 10, 1 de 25 e 3 de 100
        assertArrayEquals(expected, payback.troco(valor, moedas));
    }

    @Test
    public void testTrocoComQuantidadeLimitadaDeMoedas() {
        double valor = 1.87; // R$ 1,87
        int[] moedas = {3, 2, 1, 1, 2}; // Quantidade de moedas limitada
        int[] expected = {3, 2, 1, 1, 1}; // Esperado: usar as moedas disponíveis
        assertArrayEquals(expected, payback.troco(valor, moedas));
    }

    @Test
    public void testTrocoExatoSemUsarMoedasDe1Centavo() {
        double valor = 0.50; // R$ 0,50
        int[] moedas = {0, 5, 5, 5, 5}; // Sem moedas de 1 centavo
        int[] expected = {0, 0, 0, 2, 0}; // Esperado: 2 moedas de 25 centavos
        assertArrayEquals(expected, payback.troco(valor, moedas));
    }

    @Test
    public void testTrocoImpossivelComMoedasInsuficientes() {
        double valor = 0.99; // R$ 0,99
        int[] moedas = {0, 0, 0, 0, 0}; // Sem moedas disponíveis
        int[] expected = {0, 0, 0, 0, 0}; // Esperado: não pode dar o troco, retorna vazio
        assertArrayEquals(expected, payback.troco(valor, moedas));
    }

    @Test
    public void testTrocoGrandeComMuitasMoedasDisponiveis() {
        double valor = 15.76; // R$ 15,76
        int[] moedas = {100, 100, 100, 100, 100}; // Muitas moedas disponíveis
        int[] expected = {1, 0, 0, 3, 15}; // Esperado: usar moedas de maior valor
        assertArrayEquals(expected, payback.troco(valor, moedas));
    }

    @Test
    public void testTrocoComValorPequeno() {
        double valor = 0.01; // R$ 0,01
        int[] moedas = {1, 0, 0, 0, 0}; // Uma moeda de 1 centavo disponível
        int[] expected = {1, 0, 0, 0, 0}; // Esperado: 1 moeda de 1 centavo
        assertArrayEquals(expected, payback.troco(valor, moedas));
    }

    @Test
    public void testTrocoExatoComMuitasMoedasDeMenorValor() {
        double valor = 0.15; // R$ 0,15
        int[] moedas = {100, 100, 0, 0, 0}; // Muitas moedas de 1 e 5 centavos
        int[] expected = {0, 3, 0, 0, 0}; // Esperado: 3 moedas de 5 centavos
        assertArrayEquals(expected, payback.troco(valor, moedas));
    }

    @Test
    public void testTrocoZero() {
        double valor = 0.0; // R$ 0,00
        int[] moedas = {0, 0, 0, 0, 0}; // Nenhuma moeda disponível, mas o troco é 0
        int[] expected = {0, 0, 0, 0, 0}; // Esperado: nenhuma moeda é usada
        assertArrayEquals(expected, payback.troco(valor, moedas));
    }
}
