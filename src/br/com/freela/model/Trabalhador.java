package br.com.freela.model;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Trabalhador extends Perfil {

    private List<String> tiposTrabalho;

    public Trabalhador(int id, String nome, String cpf, String rg, String cidade, String email, String senha, String telefone) {
        super(id, nome, cpf, rg, cidade, email, senha, telefone);
        this.tiposTrabalho = new ArrayList<>();
    }

    public void adicionarTrabalho(String tipo) {
        tiposTrabalho.add(tipo);
    }

    public List<String> getTiposTrabalho() {
        return Collections.unmodifiableList(tiposTrabalho);
    }
}