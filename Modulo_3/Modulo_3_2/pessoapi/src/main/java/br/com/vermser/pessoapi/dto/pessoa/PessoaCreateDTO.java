package br.com.vermser.pessoapi.dto.pessoa;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.*;

import javax.validation.constraints.*;
import java.time.LocalDate;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class PessoaCreateDTO {

    @Schema(required = false, hidden = true)
    private Integer idPessoa;

    @Schema(example = "Cleber", required = true)
    @NotEmpty(message = "Deve ser informado um nome.")
    private String nome;

    @Schema(example = "1994-10-13", required = true)
    @Past(message = "A data de nascimento não pode ser a atual.")
    @NotNull
    private LocalDate dataNascimento;

    @Schema(example = "11353597091")
    @Size(min=11, max = 11, message = "O CPF deve possuir 11 caracteres.")
    private String cpf;

    @Schema(example = "example@email.com", required = true)
    @Email
    @NotNull
    private String email;
}
