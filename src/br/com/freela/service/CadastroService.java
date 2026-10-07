package br.com.freela.service;

import br.com.freela.dao.ClienteRepositorio;
import br.com.freela.dao.TrabalhadorRepositorio;

public class CadastroService {

    private final ValidadorCadastro validador;
    private final ClienteRepositorio clienteRepositorio;
    private final TrabalhadorRepositorio trabalhadorRepositorio;

    public CadastroService(ValidadorCadastro validador,
            ClienteRepositorio clienteRepositorio,
            TrabalhadorRepositorio trabalhadorRepositorio) {
        this.validador = validador;
        this.clienteRepositorio = clienteRepositorio;
        this.trabalhadorRepositorio = trabalhadorRepositorio;
    }

    public void cadastrar(DadosCadastro dados) {
        validador.validarConta(dados.email(), dados.senha());
        validador.validarDados(dados);

        switch (dados.tipo()) {
            case CLIENTE -> clienteRepositorio.cadastrarCliente(
                    dados.nome(), dados.cpf(), dados.rg(), dados.cidade(),
                    dados.email(), dados.senha(), dados.telefone());
            case TRABALHADOR -> trabalhadorRepositorio.cadastrarTrabalhador(
                    dados.nome(), dados.cpf(), dados.rg(), dados.cidade(),
                    dados.email(), dados.senha(), dados.telefone(), dados.tipoTrabalho());
        }
    }
}