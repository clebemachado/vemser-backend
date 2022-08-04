package br.com.vermser.pessoapi.dto.contato;

import br.com.vermser.pessoapi.enums.TipoContato;
import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Data;

import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

@Data
public class ContatoCreateDTO {

    @Schema(description = "Número do contato: ex. 98985374151")
    @NotEmpty(message = "O número não pode ser vazio.")
    @Size( max = 13, message = "O maximo é 13 para o número.")
    private String numero;

    @Schema(description = "Descrição do contato: ex. Contato da casa do Fulano.")
    @NotEmpty(message = "Descrição não pode ser vazio.")
    private String descricao;

    @Schema(description = "O tipo de contato só pode ser Residencial ou Comercial")
    @NotNull(message = "Tipo de contato não pode ser nulo.")
    private TipoContato tipoContato;

}
