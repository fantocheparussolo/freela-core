package br.com.freela.model;

public class Cliente extends Perfil {

    public Cliente(int id, String nome, String cpf, String rg, String cidade, String email, String senha, String telefone) {
        super(id, nome, cpf, rg, cidade, email, senha, telefone);
    }

}
