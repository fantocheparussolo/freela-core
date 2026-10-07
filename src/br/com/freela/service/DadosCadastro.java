package br.com.freela.service;

import br.com.freela.model.TipoCadastro;

public record DadosCadastro(
        String nome,
        String cpf,
        String rg,
        String cidade,
        String email,
        String senha,
        String telefone,
        TipoCadastro tipo,
        String tipoTrabalho) {
}