package br.com.vermser.pessoapi.entity;

import javax.validation.constraints.*;
import java.time.LocalDate;
import java.util.Objects;

public class Pessoa {

    private Integer idPessoa;
    @NotEmpty(message = "Deve ser informado um nome")
    private String nome;
    @Past(message = "A data deve ser antes do dia atual")
    @NotNull
    private LocalDate dataNascimento;
    @Size(min=11, max = 11, message = "CPF DEVE TER NO 11 CARACTERES")
    private String cpf;

    public Pessoa() {}

    public Pessoa(Integer idPessoa, String nome, LocalDate dataNascimento, String cpf) {
        this.idPessoa = idPessoa;
        this.nome = nome;
        this.dataNascimento = dataNascimento;
        this.cpf = cpf;
    }

    public Integer getIdPessoa() {
        return idPessoa;
    }

    public void setIdPessoa(Integer idPessoa) {
        this.idPessoa = idPessoa;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public LocalDate getDataNascimento() {
        return dataNascimento;
    }

    public void setDataNascimento(LocalDate dataNascimento) {
        this.dataNascimento = dataNascimento;
    }

    public String getCpf() {
        return cpf;
    }

    public void setCpf(String cpf) {
        this.cpf = cpf;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Pessoa pessoa = (Pessoa) o;
        return Objects.equals(idPessoa, pessoa.idPessoa);
    }

    @Override
    public int hashCode() {
        return Objects.hash(idPessoa);
    }

    @Override
    public String toString() {
        return "Pessoa{" +
                "idPessoa=" + idPessoa +
                ", nome='" + nome + '\'' +
                ", dataNascimento=" + dataNascimento +
                ", cpf='" + cpf + '\'' +
                '}';
    }
}
