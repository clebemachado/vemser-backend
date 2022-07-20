package br.com.vermser.pessoapi.dto.pet;

import br.com.vermser.pessoapi.enums.TipoPet;
import io.swagger.v3.oas.annotations.media.Schema;
import lombok.*;

import javax.persistence.Column;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.validation.constraints.NotNull;

@Data
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class PetCreateDTO {

    @NotNull
    @Schema(example = "Rex")
    private String nome;

    @NotNull
    @Schema(example = "Cachorro")
    private TipoPet tipo;


}
