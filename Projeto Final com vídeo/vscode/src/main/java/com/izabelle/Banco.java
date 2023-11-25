package com.izabelle;

import java.util.ArrayList;

public class Banco extends ArrayList<ContaBancaria> {

    public void adicionarConta(ContaBancaria conta) {
        this.add(conta);
    }

    public void removerConta(ContaBancaria conta) {
        this.remove(conta);
    }

    public ContaBancaria consultarConta(int numeroConta) {
        for (ContaBancaria conta : this) {
            if (conta.getNumeroConta() == numeroConta) {
                return conta;
            }
        }
        return null;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) return true;
        if (!(obj instanceof Banco)) return false;

        Banco outroBanco = (Banco) obj;
        return this.containsAll(outroBanco) && outroBanco.containsAll(this);
    }

    @Override
    public String toString() {
        StringBuilder builder = new StringBuilder();
        builder.append("Banco: [");
        for (ContaBancaria conta : this) {
            builder.append(conta).append(", ");
        }
        if (!this.isEmpty()) {
            builder.setLength(builder.length() - 2);
        }
        builder.append("]");
        return builder.toString();
    }
}
