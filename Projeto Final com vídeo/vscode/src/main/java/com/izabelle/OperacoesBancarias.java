package com.izabelle;

import java.util.Iterator;

public class OperacoesBancarias {

    private static final ContaBancaria[] Banco = null;

    public static void cadastrarConta(Banco banco, ContaBancaria conta) {
        banco.add(conta);
        System.out.println("Conta cadastrada com sucesso!");
    }

    /**
     * @param banco
     * @param numeroConta
     */
    public static void consultarConta(Banco banco, int numeroConta) {
        for (ContaBancaria conta : Banco) {
            if (conta.getNumeroConta() == numeroConta) {
                System.out.println("Titular: " + conta.getTitular());
                System.out.println("Saldo: " + conta.getSaldo());
                return;
            }
        }
        System.out.println("Conta não encontrada.");
    }

    public static void atualizarConta(Banco banco, int numeroConta, double novoSaldo) {
        Iterator<ContaBancaria> iterator = banco.iterator();
        while (iterator.hasNext()) {
            ContaBancaria conta = iterator.next();
            if (conta.getNumeroConta() == numeroConta) {
                conta.setSaldo(novoSaldo);
                System.out.println("Saldo atualizado com sucesso!");
                return;
            }
        }
        System.out.println("Conta não encontrada.");
    }

    public static void excluirConta(Banco banco, int numeroConta) {
        Iterator<ContaBancaria> iterator = banco.iterator();
        while (iterator.hasNext()) {
            ContaBancaria conta = iterator.next();
            if (conta.getNumeroConta() == numeroConta) {
                iterator.remove();
                System.out.println("Conta excluída com sucesso!");
                return;
            }
        }
        System.out.println("Conta não encontrada.");
    }
}
