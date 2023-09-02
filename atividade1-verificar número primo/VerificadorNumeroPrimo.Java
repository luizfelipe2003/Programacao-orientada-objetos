public class VerificadorNumeroPrimo {

    // Método para verificar se um número é primo
    public static int verificaNumeroPrimo(Integer n) {
        if (n <= 1) {
            return 0; // Números menores ou iguais a 1 não são primos
        }
        for (int i = 2; i <= Math.sqrt(n); i++) {
            if (n % i == 0) {
                return 0; // O número não é primo
            }
        }
        return 1; // O número é primo
    }

    public static void main(verificaNumeroPrimo String[]) {
        // Número que você deseja verificar se é primo
        Integer numero = 17; // Você pode substituir por qualquer número inteiro

        // Chame o método verificaNumeroPrimo e imprima o resultado
        int resultado = verificaNumeroPrimo(numero);
        if (resultado == 1) {
            System.out.println(numero + " é um número primo.");
        } else {
            System.out.println(numero + " não é um número primo.");
        }
    }
}