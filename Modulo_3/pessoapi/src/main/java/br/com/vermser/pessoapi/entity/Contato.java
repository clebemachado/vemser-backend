package br.com.vermser.pessoapi.entity;

import br.com.vermser.pessoapi.enums.TipoContato;

import javax.validation.constraints.Max;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;

public class Contato {

    private Integer idContato;
    private Integer idPessoa;
    @NotNull
    @Max(13)
    private Integer numero;
    @NotEmpty
    private String descricao;
    @NotNull
    private TipoContato tipoContato;

    public Contato() {}

    public Contato(Integer idContato, Integer idPessoa, Integer numero, String descricao, TipoContato tipoContato) {
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

    public Integer getNumero() {
        return numero;
    }

    public void setNumero(Integer numero) {
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
