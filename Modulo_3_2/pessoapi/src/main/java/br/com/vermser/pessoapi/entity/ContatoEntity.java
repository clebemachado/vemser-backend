package br.com.vermser.pessoapi.entity;

import br.com.vermser.pessoapi.enums.TipoContato;
import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.*;

import javax.persistence.*;
import java.io.Serializable;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Entity(name = "CONTATO")
public class ContatoEntity implements Serializable {
    private static final long serialVersionUUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "SEQ_CONTATO")
    @SequenceGenerator(name = "SEQ_CONTATO", sequenceName = "SEQ_CONTATO",allocationSize = 1)
    @Column(name = "id_contato")
    private Integer idContato;

    private String numero;

    private String descricao;
    @Column(name = "TIPO")

    private TipoContato tipoContato;

    @JsonIgnore
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "id_pessoa", referencedColumnName = "id_pessoa")
    private PessoaEntity pessoa;

}