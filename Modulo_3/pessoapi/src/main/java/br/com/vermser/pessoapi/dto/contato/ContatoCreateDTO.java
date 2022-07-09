package br.com.vermser.pessoapi.dto.contato;

import br.com.vermser.pessoapi.enums.TipoContato;
import lombok.Data;

import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

@Data
public class ContatoCreateDTO {

    @NotEmpty(message = "O número não pode ser vazio.")
    @Size( max = 13, message = "O maximo é 13 para o número.")
    private String numero;

    @NotEmpty(message = "Descrição não pode ser vazio.")
    private String descricao;

    @NotNull(message = "Tipo de contato não pode ser nulo.")
    private TipoContato tipoContato;

}
