package br.com.vermser.pessoapi.dto.pessoa;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Data;

@Data
public class PessoaDTO extends PessoaCreateDTO{

    @Schema(description = "Id para identificação da pessoa.")
    private Integer idPessoa;

}
