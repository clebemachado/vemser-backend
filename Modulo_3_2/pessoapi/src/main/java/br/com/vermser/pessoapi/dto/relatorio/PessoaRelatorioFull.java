package br.com.vermser.pessoapi.dto.relatorio;

import java.util.List;

public class PessoaRelatorioFull {

    private Integer idPessoa;
    private String nome;
    private String email;
    private List<ContatoRelatorioDTO> contatos;
    private List<EnderecoRelatorioDTO> enderecos;
    private String nomePet;

}
