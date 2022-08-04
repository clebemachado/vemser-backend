package br.com.vermser.pessoapi.dto.contato;

import br.com.vermser.pessoapi.enums.TipoContato;
import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Data;
import lombok.EqualsAndHashCode;

import javax.persistence.Column;

@EqualsAndHashCode(callSuper = false)
@Data
public class ContatoDTO extends ContatoCreateDTO {

    @Schema(required = false)
    private Integer idContato;

}
