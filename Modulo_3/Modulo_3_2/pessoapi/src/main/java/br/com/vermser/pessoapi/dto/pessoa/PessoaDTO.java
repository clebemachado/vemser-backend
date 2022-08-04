package br.com.vermser.pessoapi.dto.pessoa;

import lombok.*;

@EqualsAndHashCode(callSuper = true)
@Data
@AllArgsConstructor
@NoArgsConstructor
public class PessoaDTO extends PessoaFullDTO {

    private Integer idPessoa;

}
