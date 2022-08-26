package br.com.vermser.pessoapi.dto.dadosPessoais;

import br.com.vermser.pessoapi.enums.Sexo;
import io.swagger.v3.oas.annotations.media.Schema;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class DadosPessoaisDTO {

    @NotEmpty
    private String cnh;

    @Schema(description = "Exemplo CPF: 66564787450 .")
    @NotEmpty
    @Size(min=11, max = 11, message = "O CPF deve ter 11 caracteres.")
    private String cpf;

    @NotEmpty
    private String nome;

    @NotEmpty
    private String nomeMae;

    @NotEmpty
    private String nomePai;

    @NotEmpty
    private String rg;

    @NotNull
    private Sexo sexo;

    @NotEmpty
    private String tituloEleitor;

}
