class Calculadora {
    public int somar(int a, int b) {
        int x = a + b;
        return x;
    }

    public int subtrair(int a, int b) {
        int x = a - b;
        return x;
    }

    public int multiplicar(int a, int b) {
        int x = a * b;
        return x;
    }

    public int dividir(int a, int b) {
        if (b == 0) {
            throw new IllegalArgumentException("Divisor não pode ser 0.");
        }
        int x = a / b;
        return x;
    }

    public int potencia(int base, int exp) {
        if (exp < 0) {
            throw new IllegalArgumentException("Expoente deve ser >= 0.");
        }

        if (base == 0 && exp == 0) {
            throw new IllegalArgumentException("Indeterminação 0∧0");
        }

        double doubleBase = base;
        double doubleExp = exp;

        double x = Math.pow(doubleBase, doubleExp);

        int result = (int) x;

        return result;
    }
}
