package br.com.freela.dao;

public interface TrabalhadorRepositorio {

    void cadastrarTrabalhador(String nome, String cpf, String rg, String cidade,
            String email, String senha, String telefone, String tipoTrabalho);
}