package br.com.vermser.pessoapi.entity;

import br.com.vermser.pessoapi.enums.TipoEndereco;
import lombok.*;

import javax.validation.constraints.Min;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;


@NoArgsConstructor
@AllArgsConstructor
@Data
public class Endereco {

    private Integer idEndereco;
    private Integer idPessoa;

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