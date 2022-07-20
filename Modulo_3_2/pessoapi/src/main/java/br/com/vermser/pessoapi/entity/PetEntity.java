package br.com.vermser.pessoapi.entity;

import br.com.vermser.pessoapi.enums.TipoPet;
import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.io.Serializable;

@Setter
@Getter
@NoArgsConstructor
@AllArgsConstructor
@Entity(name = "PET")
public class PetEntity implements Serializable {
    private static final long serialVersionUUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "SEQ_PET")
    @SequenceGenerator(name = "SEQ_PET", sequenceName = "SEQ_PET", allocationSize = 1)
    @Column(name = "id_pet")
    private Integer idPet;

    private String nome;

    @Column
    @Enumerated(EnumType.ORDINAL)
    private TipoPet tipo;

    @JsonIgnore
    @OneToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "id_pessoa", referencedColumnName = "id_pessoa")
    private PessoaEntity pessoa;

}
