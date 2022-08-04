package br.com.vermser.pessoapi.dto.contato;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Data;
import lombok.EqualsAndHashCode;

@EqualsAndHashCode(callSuper = false)
@Data
public class ContatoDTO extends ContatoCreateDTO {

    @Schema(description = "Id de contato")
    private Integer idContato;
    @Schema(description = "Id da pessoa")
    private Integer idPessoa;

}
