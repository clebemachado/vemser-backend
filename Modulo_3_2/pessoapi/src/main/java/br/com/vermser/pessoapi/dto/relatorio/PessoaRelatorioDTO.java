package br.com.vermser.pessoapi.dto.relatorio;

import lombok.*;

import java.util.List;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class PessoaRelatorioDTO {

    private Integer id;
    private String nome;
    private String email;
    private String numero;
    private String cep;
    private String cidade;
    private String estado;
    private String pais;
    private String pet;

}
