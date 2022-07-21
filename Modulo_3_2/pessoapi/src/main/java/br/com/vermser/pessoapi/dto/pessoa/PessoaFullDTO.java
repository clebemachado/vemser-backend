package br.com.vermser.pessoapi.dto.pessoa;

import br.com.vermser.pessoapi.dto.contato.ContatoDTO;
import br.com.vermser.pessoapi.dto.enderecos.EnderecoDTO;
import br.com.vermser.pessoapi.dto.pet.PetDTO;
import com.fasterxml.jackson.annotation.JsonInclude;
import io.swagger.v3.oas.annotations.media.Schema;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.validation.constraints.*;
import java.time.LocalDate;
import java.util.Set;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class PessoaFullDTO {

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

    //@JsonInclude(JsonInclude.Include.NON_NULL)
    private PetDTO pet;

    //@JsonInclude(JsonInclude.Include.NON_NULL)
    private Set<ContatoDTO> contatos;

    //
    private Set<EnderecoDTO> enderecos;

}
