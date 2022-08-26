package br.com.vermser.pessoapi.dto.pessoacpf;

import br.com.vermser.pessoapi.dto.dadosPessoais.DadosPessoaisDTO;
import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Data;

import javax.validation.constraints.*;
import java.time.LocalDate;

@Data
public class PessoaCPFDTO {

    @Schema(description = "Id para identificação da pessoa.")
    private Integer idPessoa;

    @Schema(description = "Nome da pessoa.", example = "Cleber")
    @NotEmpty(message = "Deve ser informado um nome.")
    private String nome;

    @Schema(description = "Exemplo data de nascimento: 1990-12-25.")
    @Past(message = "A data de nascimento não pode ser a atual.")
    @NotNull
    private LocalDate dataNascimento;

    @Schema(description = "Email válido: nome@domain.com")
    @Email
    @NotNull
    private String email;
    private String cpf;

    private DadosPessoaisDTO dadosPessoais;

}
