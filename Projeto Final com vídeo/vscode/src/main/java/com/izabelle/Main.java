package com.izabelle;

import java.util.InputMismatchException;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        BancoDAO.criarTabela(); // Certifica-se de que a tabela está criada

        try (Scanner scanner = new Scanner(System.in)) {
            int opcao;
            do {
                displayMenu();
                opcao = readOption(scanner);

                switch (opcao) {
                    case 1:
                        // Cadastrar
                        cadastrarConta(scanner);
                        break;

                    case 2:
                        // Consultar
                        consultarConta(scanner);
                        break;

                    case 3:
                        // Atualizar
                        atualizarConta(scanner);
                        break;

                    case 4:
                        // Excluir
                        excluirConta(scanner);
                        break;

                    case 0:
                        // Sair
                        System.out.println("Saindo do programa. Até logo!");
                        break;

                    default:
                        System.out.println("Opção inválida. Tente novamente.");
                        break;
                }
            } while (opcao != 0);
        }
    }

    private static void displayMenu() {
        System.out.println("Menu:");
        System.out.println("1 - Cadastrar");
        System.out.println("2 - Consultar");
        System.out.println("3 - Atualizar");
        System.out.println("4 - Excluir");
        System.out.println("0 - Sair");
        System.out.print("Escolha a opção: ");
    }

    private static int readOption(Scanner scanner) {
        int opcao = -1;
        while (opcao == -1) {
            try {
                opcao = scanner.nextInt();
                if (opcao < 0 || opcao > 4) {
                    System.out.println("Opção inválida. Tente novamente.");
                    opcao = -1;
                    displayMenu();
                }
            } catch (InputMismatchException e) {
                System.out.println("Por favor, insira um número válido.");
                scanner.next(); // Consume the invalid input
                displayMenu();
            }
        }
        return opcao;
    }

    private static void cadastrarConta(Scanner scanner) {
        System.out.print("Número da conta: ");
        int numeroConta = scanner.nextInt();
        System.out.print("Titular: ");
        String titular = scanner.next();
        System.out.print("Saldo inicial: ");
        double saldoInicial = scanner.nextDouble();
        ContaBancaria novaConta = new ContaBancaria(numeroConta, titular, saldoInicial);
        BancoDAO.cadastrarConta(novaConta);
    }

    private static void consultarConta(Scanner scanner) {
        System.out.print("Número da conta: ");
        int consultaConta = scanner.nextInt();
        ContaBancaria contaConsultada = BancoDAO.consultarConta(consultaConta);
        if (contaConsultada != null) {
            System.out.println("Titular: " + contaConsultada.getTitular());
            System.out.println("Saldo: " + contaConsultada.getSaldo());
        } else {
            System.out.println("Conta não encontrada.");
        }
    }

    private static void atualizarConta(Scanner scanner) {
        System.out.print("Número da conta: ");
        int contaAtualizar = scanner.nextInt();
        System.out.print("Novo saldo: ");
        double novoSaldo = scanner.nextDouble();
        ContaBancaria contaAtualizada = new ContaBancaria(contaAtualizar, "", novoSaldo);
        BancoDAO.atualizarConta(contaAtualizada);
    }

    private static void excluirConta(Scanner scanner) {
        System.out.print("Número da conta: ");
        int contaExcluir = scanner.nextInt();
        BancoDAO.excluirConta(contaExcluir);
    }
}
