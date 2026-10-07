package br.com.freela.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class TrabalhadorDAO {

    public void cadastrarTrabalhador(String nome, String cpf, String rg, String cidade,
            String email, String senha, String telefone, String tipoTrabalho) {

        String sql = "INSERT INTO trabalhador (nomeTrabalhador, cpfTrabalhador, rgTrabalhador, cidadeTrabalhador, emailTrabalhador, telefoneTrabalhador, tipo_de_trabalho, senhaTrabalhador) VALUES (?, ?, ?, ?, ?, ?, ?, ?)";

        try (Connection conn = Conexao.conectar(); PreparedStatement stmt = conn.prepareStatement(sql)) {

            stmt.setString(1, nome);
            stmt.setString(2, cpf);
            stmt.setString(3, rg);
            stmt.setString(4, cidade);
            stmt.setString(5, email);
            stmt.setString(6, telefone);
            stmt.setString(7, tipoTrabalho);
            stmt.setString(8, senha);

            stmt.executeUpdate();

        } catch (SQLException e) {
            throw new RuntimeException("Erro ao cadastrar trabalhador: " + e.getMessage());
        }
    }
}
