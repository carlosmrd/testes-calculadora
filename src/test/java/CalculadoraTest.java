import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Nested;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;



class CalculadoraTest {
    private Calculadora calculadora;

    @BeforeEach
    void configurar() {
        calculadora = new Calculadora();
    }

    @Nested
    @DisplayName("Testes de Adição")
    class TestesAdicao {
        @ParameterizedTest
        @CsvSource({
            "2, 3 ,5",
            "10, 5, 15",
            "-2, 2, 0",
            "0, 0, 0"
        })
        @DisplayName("Deve somar dois valores")
        void somarTest(int a, int b, int esperado) {

            int resultado = calculadora.somar(a, b);

            assertEquals(esperado, resultado);
        }
    }

    @Nested
    @DisplayName("Testes de Subtração")
    class TestesSubtracao {
        @ParameterizedTest
        @CsvSource({
            "8, 4, 4",
            "10, 5, 5",
            "4, 1, 3",
            "0, 0, 0"
        })
        @DisplayName("Deve subtrair um valor de outro")
        void subtrairTest(int a, int b, int esperado) {
            int resultado = calculadora.subtrair(a, b);

            assertEquals(esperado, resultado);
        }
    }

    @Nested
    @DisplayName("Testes de Multiplicação")
    class TestesMultiplicao {
        @ParameterizedTest
        @CsvSource({
            "4, 5, 20",
            "10, 5, 50",
            "4, 1, 4",
            "0, 0, 0"
        })
        @DisplayName("Deve multiplicar dois valores")
        void multiplicarTest(int a, int b, int esperado) {
            int resultado = calculadora.multiplicar(a, b);

            assertEquals(esperado, resultado);
        }
    }

    @Nested
    @DisplayName("Testes de Divisão")
    class TestesDivisao {
        @ParameterizedTest
        @CsvSource({
            "30, 6, 5",
            "50, 5, 10",
            "4, 1, 4"
        })
        @DisplayName("Deve dividir um valor por outro")
        void dividirTest(int a, int b, int esperado) {
            int resultado = calculadora.dividir(a, b);

            assertEquals(esperado, resultado);
        }

        @Test
        @DisplayName("Deve lançar exceção ao dividir por 0")
        void dividirExceptionTest() {
            int valor1 = 5;
            int valor2 = 0;

            assertThrows(IllegalArgumentException.class, () -> calculadora.dividir(valor1, valor2));
        }
    }

    @Nested
    @DisplayName("Testes de Potenciação")
    class TestesPotenciacao {
        @ParameterizedTest
        @CsvSource({
            "2, 3, 8",
            "5, 2, 25",
            "3, 3, 27"
        })
        @DisplayName("Deve elevar um valor por outro")
        void potenciaTest(int a, int b, int esperado) {
            int resultado = calculadora.potencia(a, b);

            assertEquals(esperado, resultado);
        }

        @Test
        @DisplayName("Deve lançar exceção se expoente for menor que 0")
        void potenciaExceptionTest1() {
            int valor1 = 5;
            int valor2 = -3;

            assertThrows(IllegalArgumentException.class, () -> calculadora.potencia(valor1, valor2));
        }

        @Test
        @DisplayName("Deve lançar exceção ao elevar 0 a 0")
        void potenciaExceptionTest2() {
            int valor1 = 0;
            int valor2 = 0;

            assertThrows(IllegalArgumentException.class, () -> calculadora.potencia(valor1, valor2));
        }
    }
}
