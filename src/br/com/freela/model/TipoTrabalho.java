package br.com.freela.model;

public class TipoTrabalho {

    private int idTrabalho;
    private String nomeTrabalho;
    private String descricaoTrabalho;

    public TipoTrabalho(int idTipo, String nome, String descricao) {
        this.idTrabalho = idTipo;
        this.nomeTrabalho = nome;
        this.descricaoTrabalho = descricao;
    }

    public int getIdTrabalho() {
        return idTrabalho;
    }

    public String getNomeTrabalho() {
        return nomeTrabalho;
    }

    public String getDescricaoTrabalho() {
        return descricaoTrabalho;
    }

    public void exibirInformacao() {
        System.out.println("Tipo de trabalho: " + nomeTrabalho);
        System.out.println("Descrição do trabalho: " + descricaoTrabalho);
    }

}
