package br.com.vermser.pessoapi.dto.enderecos;

import lombok.Data;
import lombok.EqualsAndHashCode;


@EqualsAndHashCode(callSuper = false)
@Data
public class EnderecoDTO extends EnderecoCreateDTO{

    private Integer idEndereco;
    private Integer idPessoa;

}
