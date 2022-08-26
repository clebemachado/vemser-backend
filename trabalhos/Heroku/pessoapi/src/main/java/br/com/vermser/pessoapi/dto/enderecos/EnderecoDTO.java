package br.com.vermser.pessoapi.dto.enderecos;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Data;
import lombok.EqualsAndHashCode;


@EqualsAndHashCode(callSuper = false)
@Data
public class EnderecoDTO extends EnderecoCreateDTO{

    @Schema(description = "Identificação única do endereço.")
    private Integer idEndereco;

    @Schema(description = "Identificação da pessoa dona do endereço.")
    private Integer idPessoa;

}
