package br.com.vermser.pessoapi.dto.dadosPessoais.entity;

import br.com.vermser.pessoapi.enums.TipoEndereco;
import lombok.*;

import javax.validation.constraints.Min;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;


@NoArgsConstructor
@AllArgsConstructor
@Data
public class Endereco {

    private Integer idEndereco;
    private Integer idPessoa;

    private TipoEndereco tipo;

    private String logradouro;

    private Integer numero;

    private String complemento;

    private String cep;

    private String cidade;

    private String estado;

    private String pais;

}