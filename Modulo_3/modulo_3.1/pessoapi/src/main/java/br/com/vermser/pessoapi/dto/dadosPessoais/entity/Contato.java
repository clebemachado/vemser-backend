package br.com.vermser.pessoapi.dto.dadosPessoais.entity;

import br.com.vermser.pessoapi.enums.TipoContato;
import io.swagger.v3.oas.annotations.media.Schema;
import lombok.*;

import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

@Getter
@Setter
@ToString
@EqualsAndHashCode
@AllArgsConstructor
@NoArgsConstructor
public class Contato {

    private Integer idContato;
    private Integer idPessoa;

    private String numero;

    private String descricao;

    private TipoContato tipoContato;

}
