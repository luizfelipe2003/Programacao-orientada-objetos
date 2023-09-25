package Veiculos;
public class Carro extends veiculo {
    private int numPortas;

    public Carro(String marca, String modelo, int anoFabricacao, int numPortas) {
        super(marca, modelo, anoFabricacao);
        this.numPortas = numPortas;
    }

    public int getNumPortas() {
        return numPortas;
    }
}