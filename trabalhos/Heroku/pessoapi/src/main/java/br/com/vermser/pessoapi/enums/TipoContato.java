package br.com.vermser.pessoapi.enums;

public enum TipoContato {
    COMERCIAL("COMERCIAL"),
    RESIDENCIAL("RESIDENCIAL");

    private String nome;

    private TipoContato(String nome) {
        this.nome = nome;
    }

    public String getNome() {
        return nome;
    }
}
