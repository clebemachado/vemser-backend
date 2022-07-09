package br.com.vermser.pessoapi.dto.contato;

import lombok.Data;
import lombok.EqualsAndHashCode;

@EqualsAndHashCode(callSuper = false)
@Data
public class ContatoDTO extends ContatoCreateDTO {

    private Integer idContato;
    private Integer idPessoa;

}
