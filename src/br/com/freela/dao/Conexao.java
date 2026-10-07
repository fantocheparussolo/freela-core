package br.com.freela.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class Conexao {

    private static final String URL_PADRAO = "jdbc:mysql://localhost:3306/freela";

    public static Connection conectar() {
        String url = System.getenv().getOrDefault("FREELA_DB_URL", URL_PADRAO);
        String usuario = exigir("FREELA_DB_USER");
        String senha = exigir("FREELA_DB_PASSWORD");

        try {
            return DriverManager.getConnection(url, usuario, senha);
        } catch (SQLException e) {
            throw new RuntimeException("Erro na conexão: " + e.getMessage(), e);
        }
    }

    private static String exigir(String nomeVariavel) {
        String valor = System.getenv(nomeVariavel);
        if (valor == null || valor.isBlank()) {
            throw new IllegalStateException("Defina a variável de ambiente " + nomeVariavel);
        }
        return valor;
    }
}