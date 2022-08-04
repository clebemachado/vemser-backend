package br.com.vermser.pessoapi.dto.enderecos;

import br.com.vermser.pessoapi.enums.TipoEndereco;
import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Data;

import javax.validation.constraints.Min;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

@Data
public class EnderecoCreateDTO {

    @Schema(description = "Tipo do endereço. Ex. Comercial ou 0, Residencial ou 1")
    @NotNull
    private TipoEndereco tipo;

    @Schema(description = "Nome da rua: ex. Alameda dois")
    @NotEmpty
    @Size(max = 250)
    private String logradouro;

    @Schema(description = "Número do estabelcimento: ex. 21")
    @NotNull
    @Min(1)
    private Integer numero;

    @Schema(description = "Informações para localização do complemento.")
    private String complemento;

    @Schema(description = "Cep da cidade/bairro: ex 6413000.")
    @NotEmpty
    @Size(max = 8, min = 8)
    private String cep;

    @Schema(description = "Nome da cidade: Ex. São Luís")
    @NotEmpty
    @Size(max = 250)
    private String cidade;

    @Schema(description = "Nome da estado: Ex. Maranhão")
    @NotNull
    private String estado;

    @Schema(description = "Nome do país: Ex. Brasil")
    @NotNull
    private String pais;
}
