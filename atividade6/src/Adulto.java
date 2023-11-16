package atividade6.src;

// Classe Adulto que herda de SerHumano
public class Adulto extends SerHumano {
    private String profissao;

    public Adulto(String nome, int idade, String profissao) {
        super(nome, idade);
        this.profissao = profissao;
    }

    public String getProfissao() {
        return profissao;
    }

    @Override
    public void falar() {
        System.out.println("O adulto está falando.");
    }
}