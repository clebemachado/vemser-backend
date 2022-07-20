package br.com.vermser.pessoapi.dto.enderecos;

import br.com.vermser.pessoapi.enums.TipoEndereco;
import io.swagger.v3.oas.annotations.media.Schema;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.validation.constraints.Min;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class EnderecoCreateDTO {

    @Schema(description = "Tipo do endereço. Ex. Comercial ou 0, Residencial ou 1")
    @NotNull
    private TipoEndereco tipo;

    @Schema(example = "Rua Edilson Coelho de Oliveira")
    @NotEmpty
    @Size(max = 250)
    private String logradouro;

    @Schema(example = "436")
    @NotNull
    @Min(1)
    private Integer numero;

    @Schema(example = "apt. 32", required = false)
    private String complemento;

    @Schema(example = "58801-213")
    @NotEmpty
    @Size(max = 8, min = 8)
    private String cep;

    @Schema(example = "Sousa")
    @NotEmpty
    @Size(max = 250)
    private String cidade;

    @Schema(example = "PB")
    @NotNull
    private String estado;

    @Schema(example = "Brasil")
    @NotNull
    private String pais;
}
