package br.com.vermser.pessoapi.dto.dadosPessoais;

import br.com.vermser.pessoapi.enums.Sexo;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class DadosPessoaisDTO {

    @NotEmpty
    private String cnh;
    @NotEmpty
    private String cpf;
    @NotEmpty
    private String nome;
    @NotEmpty
    private String nomeMae;
    @NotEmpty
    private String nomePai;
    @NotEmpty
    private String rg;
    @NotEmpty
    private Sexo sexo;
    @NotEmpty
    private String tituloEleitor;

}
