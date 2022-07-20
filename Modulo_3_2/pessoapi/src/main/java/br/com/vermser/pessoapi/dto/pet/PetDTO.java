package br.com.vermser.pessoapi.dto.pet;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.*;



@Data
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class PetDTO extends PetCreateDTO {
    @Schema(required = false)
    private Integer idPet;
}
