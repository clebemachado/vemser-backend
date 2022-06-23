package models;

import java.util.ArrayList;

public class Cliente {

    private String nome;
    private String cpf;
    private ArrayList<Contato> contatos= new ArrayList<>();
    private ArrayList<Endereco> enderecos= new ArrayList<>();

    public Cliente(){}

    public Cliente(String nome, String cpf) {
        this.nome = nome;
        this.cpf = cpf;
    }

    void imprimirContatos(){
        for (Contato contato: contatos) {
            if(contato != null){
                contato.imprimirContato();
            };
        }
    }

    void imprimirEnderecos(){
        for (Endereco endereco: enderecos) {
            if(endereco != null){
                endereco.imprimirEndereco();
            };
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

    public ArrayList<Contato> getContatos() {
        return contatos;
    }

    public void setContatos(ArrayList<Contato> contatos) {
        this.contatos = contatos;
    }

    public ArrayList<Endereco> getEnderecos() {
        return enderecos;
    }

    public void setEnderecos(ArrayList<Endereco> enderecos) {
        this.enderecos = enderecos;
    }

    @Override
    public String toString() {
        return "Cliente{nome= " + nome + "cpf= " + cpf + "}";
    }
}
