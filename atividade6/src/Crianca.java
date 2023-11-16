package atividade6.src;

// Classe Crianca que herda de SerHumano
public class Crianca extends SerHumano {
    private String brinquedoFavorito;

    public Crianca(String nome, int idade, String brinquedoFavorito) {
        super(nome, idade);
        this.brinquedoFavorito = brinquedoFavorito;
    }

    public String getBrinquedoFavorito() {
        return brinquedoFavorito;
    }

    @Override
    public void falar() {
        System.out.println("A criança está falando.");
    }
}