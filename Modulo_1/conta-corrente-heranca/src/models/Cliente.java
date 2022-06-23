package models;

public class Cliente {

    private String nome;
    private String cpf;
    private Contato[] contatos= new Contato[2];
    private Endereco[] enderecos= new Endereco[2];

    public Cliente(){}

    public Cliente(String nome, String cpf) {
        this.nome = nome;
        this.cpf = cpf;
    }

    public Cliente(String nome, String cpf, Contato[] contatos, Endereco[] enderecos) {
        this.nome = nome;
        this.cpf = cpf;
        this.contatos = contatos;
        this.enderecos = enderecos;
    }

    void imprimirContatos(){
        for (Contato contato: contatos) {
            if(contato != null) contato.imprimirContato();
        }
    }

    void imprimirEnderecos(){
        for (Endereco endereco: enderecos) {
            if(endereco != null) endereco.imprimirEndereco();
        }
    }

    void imprimirCliente(){
        System.out.println(this);
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getCpf() {
        return cpf;
    }

    public void setCpf(String cpf) {
        this.cpf = cpf;
    }

    public Contato[] getContatos() {
        return contatos;
    }

    public void setContatos(Contato[] contatos) {
        this.contatos = contatos;
    }

    public Endereco[] getEnderecos() {
        return enderecos;
    }

    public void setEnderecos(Endereco[] enderecos) {
        this.enderecos = enderecos;
    }

    @Override
    public String toString() {
        return "Cliente{nome= " + nome + "cpf= " + cpf + "}";
    }
}
