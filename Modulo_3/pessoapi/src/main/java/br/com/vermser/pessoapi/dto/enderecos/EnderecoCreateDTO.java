package br.com.vermser.pessoapi.dto.enderecos;

import br.com.vermser.pessoapi.enums.TipoEndereco;
import lombok.Data;

import javax.validation.constraints.Min;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

@Data
public class EnderecoCreateDTO {

    @NotNull
    private TipoEndereco tipo;

    @NotEmpty
    @Size(max = 250)
    private String logradouro;

    @NotNull
    @Min(1)
    private Integer numero;

    private String complemento;

    @NotEmpty
    @Size(max = 8, min = 8)
    private String cep;

    @NotEmpty
    @Size(max = 250)
    private String cidade;

    @NotNull
    private String estado;

    @NotNull
    private String pais;
}
