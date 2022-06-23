package models;

public class Contato {

    private String descricao;
    private String telefone;
    private Integer tipo;

    public  Contato(){}

    public Contato(String descricao, String telefone, Integer tipo) {
        this.descricao = descricao;
        this.telefone = telefone;
        this.tipo = tipo;
    }

    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }

    public String getTelefone() {
        return telefone;
    }

    public void setTelefone(String telefone) {
        this.telefone = telefone;
    }

    public Integer getTipo() {
        return tipo;
    }

    public void setTipo(Integer tipo) {
        this.tipo = tipo;
    }

    void imprimirContato(){
        System.out.println(this);
    }

    @Override
    public String toString() {
        String tipoContato = tipo == 1 ? "Residencial" : "Comercial";
        return "Contato{descricao=" + descricao + ", telefone='" + telefone
                + "tipo=" + tipoContato + "}";
    }
}
