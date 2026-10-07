package br.com.freela.service;

import br.com.freela.exception.DadosInvalidosException;
import br.com.freela.model.TipoCadastro;

public class ValidadorCadastro {

    public void validarConta(String email, String senha) {
        if (vazio(email) || vazio(senha)) {
            throw new DadosInvalidosException("Preencha e-mail e senha para continuar.");
        }
    }

    public void validarDados(DadosCadastro dados) {
        if (vazio(dados.nome()) || vazio(dados.telefone()) || vazio(dados.cpf())
                || vazio(dados.rg()) || vazio(dados.cidade())) {
            throw new DadosInvalidosException("Preencha todos os campos obrigatórios.");
        }
        if (dados.tipo() == TipoCadastro.TRABALHADOR && vazio(dados.tipoTrabalho())) {
            throw new DadosInvalidosException("Informe o tipo de trabalho do trabalhador.");
        }
    }

    private boolean vazio(String texto) {
        return texto == null || texto.isBlank();
    }
}