package br.com.vermser.pessoapi.dto.relatorio;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class EnderecoRelatorioDTO {
    private String cep;
    private String cidade;
    private String estado;
    private String pais;
}
