package br.com.vermser.pessoapi.dto.enderecos;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;


@Data
@AllArgsConstructor
@NoArgsConstructor
public class EnderecoDTO extends EnderecoCreateDTO{

    @Schema(description = "Identificação única do endereço.", required = false)
    private Integer idEndereco;

}
