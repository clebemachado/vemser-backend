package br.com.vermser.pessoapi.dto.pessoa;

import lombok.Data;

import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Past;
import javax.validation.constraints.Size;
import java.time.LocalDate;

@Data
public class PessoaCreateDTO {

    @NotEmpty(message = "Deve ser informado um nome.")
    private String nome;

    @Past(message = "A data de nascimento não pode ser a atual.")
    @NotNull
    private LocalDate dataNascimento;

    @Size(min=11, max = 11, message = "O CPF deve ter 11 caracteres.")
    private String cpf;

}
