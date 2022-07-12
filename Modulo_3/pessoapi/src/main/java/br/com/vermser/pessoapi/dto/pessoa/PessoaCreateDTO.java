package br.com.vermser.pessoapi.dto.pessoa;

import lombok.Data;

import javax.validation.constraints.*;
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

    @Email
    @NotNull
    private String email;

}
