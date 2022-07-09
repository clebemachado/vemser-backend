package br.com.vermser.pessoapi.entity;

import lombok.*;

import javax.validation.constraints.*;
import java.time.LocalDate;

@Setter
@Getter
@NoArgsConstructor
@AllArgsConstructor
@ToString
@EqualsAndHashCode
public class Pessoa {

    private Integer idPessoa;

    @NotEmpty(message = "Deve ser informado um nome")
    private String nome;

    @Past(message = "A data deve ser antes do dia atual")
    @NotNull
    private LocalDate dataNascimento;

    @Size(min=11, max = 11, message = "CPF DEVE TER NO 11 CARACTERES")
    private String cpf;

}
