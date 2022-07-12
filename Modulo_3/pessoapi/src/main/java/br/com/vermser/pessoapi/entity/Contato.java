package br.com.vermser.pessoapi.entity;

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

    @NotEmpty(message = "O número não pode ser vazio.")
    @Size( max = 13, message = "O maximo é 13 para o número.")
    private String numero;

    @NotEmpty(message = "Descrição não pode ser vazio.")
    private String descricao;

    @NotNull(message = "Tipo de contato inválido.")
    private TipoContato tipoContato;

}
