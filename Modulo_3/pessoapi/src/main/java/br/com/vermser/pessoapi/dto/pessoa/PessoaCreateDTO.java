package br.com.vermser.pessoapi.dto.pessoa;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Data;

import javax.validation.constraints.*;
import java.time.LocalDate;

@Data
public class PessoaCreateDTO {

    @Schema(description = "Nome da pessoa.", example = "Cleber")
    @NotEmpty(message = "Deve ser informado um nome.")
    private String nome;

    @Schema(description = "Exemplo data de nascimento: 1990-12-25.")
    @Past(message = "A data de nascimento não pode ser a atual.")
    @NotNull
    private LocalDate dataNascimento;

    @Schema(description = "Exemplo CPF: 66564787450 .")
    @Size(min=11, max = 11, message = "O CPF deve ter 11 caracteres.")
    private String cpf;

    @Schema(description = "Email válido: nome@domain.com")
    @Email
    @NotNull
    private String email;

}
