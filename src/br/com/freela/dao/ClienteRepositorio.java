package br.com.freela.dao;

public interface ClienteRepositorio {

    void cadastrarCliente(String nome, String cpf, String rg, String cidade,
            String email, String senha, String telefone);
}