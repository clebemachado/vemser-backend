package br.com.vermser.pessoapi.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import java.time.LocalDate;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class PessoaCPF {

    private Integer idPessoa;
    private String nome;
    private LocalDate dataNascimento;
    private String email;
    private String cpf;
    private DadosPessoais dadosPessoais;
}
