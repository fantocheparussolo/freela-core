package br.com.freela.model;

public enum TipoCadastro {
    CLIENTE("Cliente"),
    TRABALHADOR("Trabalhador");

    private final String rotulo;

    TipoCadastro(String rotulo) {
        this.rotulo = rotulo;
    }

    public String getRotulo() {
        return rotulo;
    }

    public static TipoCadastro doRotulo(String rotulo) {
        for (TipoCadastro tipo : values()) {
            if (tipo.rotulo.equals(rotulo)) {
                return tipo;
            }
        }
        throw new IllegalArgumentException("Tipo de cadastro desconhecido: " + rotulo);
    }
}