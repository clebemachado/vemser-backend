package br.com.vermser.pessoapi.entity;

import br.com.vermser.pessoapi.enums.TipoContato;
import org.hibernate.validator.constraints.Length;

import javax.validation.constraints.*;

public class Contato {

    private Integer idContato;
    private Integer idPessoa;
    @NotNull
    @Size( max = 13)
    private String numero;
    @NotEmpty
    private String descricao;
    @NotNull
    private TipoContato tipoContato;

    public Contato() {}

    public Contato(Integer idContato, Integer idPessoa, String numero, String descricao, TipoContato tipoContato) {
        this.idContato = idContato;
        this.idPessoa = idPessoa;
        this.numero = numero;
        this.descricao = descricao;
        this.tipoContato = tipoContato;
    }

    public Integer getIdContato() {
        return idContato;
    }

    public void setIdContato(Integer idContato) {
        this.idContato = idContato;
    }

    public String getNumero() {
        return numero;
    }

    public void setNumero(String numero) {
        this.numero = numero;
    }

    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }

    public TipoContato getTipoContato() {
        return tipoContato;
    }

    public void setTipoContato(TipoContato tipoContato) {
        this.tipoContato = tipoContato;
    }

    public Integer getIdPessoa() {
        return idPessoa;
    }

    public void setIdPessoa(Integer idPessoa) {
        this.idPessoa = idPessoa;
    }
}
