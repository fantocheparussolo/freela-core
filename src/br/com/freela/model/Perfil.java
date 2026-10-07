package br.com.freela.model;

public class Perfil {

    private int idPerfil;
    private String nomePerfil;
    private String cpfPerfil;
    private String rgPerfil;
    private String cidadePerfil;
    private String emailPerfil;
    private String senhaPerfil;
    private String telefonePerfil;

    public Perfil(int id, String nome, String cpf, String rg, String cidade, String email, String senha, String telefone) {
        this.idPerfil = id;
        this.nomePerfil = nome;
        this.cpfPerfil = cpf;
        this.rgPerfil = rg;
        this.cidadePerfil = cidade;
        this.emailPerfil = email;
        this.senhaPerfil = senha;
        this.telefonePerfil = telefone;
    }

    public int getId() {
        return idPerfil;
    }

    public String getNome() {
        return nomePerfil;
    }

    public String getCpf() {
        return cpfPerfil;
    }

    public String getRg() {
        return rgPerfil;
    }

    public String getCidade() {
        return cidadePerfil;
    }

    public String getEmail() {
        return emailPerfil;
    }

    public String getSenha() {
        return senhaPerfil;
    }

    public String getTelefone() {
        return telefonePerfil;
    }

    public void exibirPerfil() {
        System.out.println("ID: " + idPerfil);
        System.out.println("Nome: " + nomePerfil);
        System.out.println("Cidade: " + cidadePerfil);
        System.out.println("E-mail: " + emailPerfil);
        System.out.println("Telefone: " + telefonePerfil);

    }
}
