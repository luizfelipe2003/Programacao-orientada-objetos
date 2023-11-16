package atividade6.src;

// Classe SerHumano
public class SerHumano {
    private String nome;
    private int idade;

    public SerHumano(String nome, int idade) {
        this.nome = nome;
        this.idade = idade;
    }

    public String getNome() {
        return nome;
    }

    public int getIdade() {
        return idade;
    }

    public void falar() {
        System.out.println("O ser humano está falando.");
    }

    // Método main para a classe SerHumano
    public static void main(String[] args) {
        // Criar um objeto SerHumano
        SerHumano humano = new SerHumano("NomeDoHumano", 25);

        // Chamar o método falar do objeto SerHumano
        humano.falar();

        // Exibir informações sobre o SerHumano
        System.out.println("Nome do ser humano: " + humano.getNome());
        System.out.println("Idade do ser humano: " + humano.getIdade());
    }
}