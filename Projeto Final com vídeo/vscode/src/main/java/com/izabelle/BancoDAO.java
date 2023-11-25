package com.izabelle;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class BancoDAO {
    private static final String URL = "jdbc:sqlite:banco.db";

    static {
        try {
            Class.forName("org.sqlite.JDBC");
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
    }

    public static void criarTabela() {
        try {
            try (Connection connection = DriverManager.getConnection(URL);
                 PreparedStatement statement = connection.prepareStatement(
                         "CREATE TABLE IF NOT EXISTS contas (numeroConta INTEGER PRIMARY KEY, titular TEXT, saldo REAL)"
                 )) {
                statement.executeUpdate();
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public static void cadastrarConta(ContaBancaria conta) {
        try (Connection connection = DriverManager.getConnection(URL);
             PreparedStatement statement = connection.prepareStatement(
                     "INSERT INTO contas (numeroConta, titular, saldo) VALUES (?, ?, ?)"
             )) {
            statement.setInt(1, conta.getNumeroConta());
            statement.setString(2, conta.getTitular());
            statement.setDouble(3, conta.getSaldo());
            statement.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public static ContaBancaria consultarConta(int numeroConta) {
        try (Connection connection = DriverManager.getConnection(URL);
             PreparedStatement statement = connection.prepareStatement(
                     "SELECT * FROM contas WHERE numeroConta = ?"
             )) {
            statement.setInt(1, numeroConta);
            ResultSet resultSet = statement.executeQuery();

            if (resultSet.next()) {
                return new ContaBancaria(
                        resultSet.getInt("numeroConta"),
                        resultSet.getString("titular"),
                        resultSet.getDouble("saldo")
                );
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }

    public static void atualizarConta(ContaBancaria conta) {
        try (Connection connection = DriverManager.getConnection(URL);
             PreparedStatement statement = connection.prepareStatement(
                     "UPDATE contas SET saldo = ? WHERE numeroConta = ?"
             )) {
            statement.setDouble(1, conta.getSaldo());
            statement.setInt(2, conta.getNumeroConta());
            statement.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public static void excluirConta(int numeroConta) {
        try (Connection connection = DriverManager.getConnection(URL);
             PreparedStatement statement = connection.prepareStatement(
                     "DELETE FROM contas WHERE numeroConta = ?"
             )) {
            statement.setInt(1, numeroConta);
            statement.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
