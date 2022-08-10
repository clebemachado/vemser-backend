package com.veiculo.veiculoprodutorconsumidor.DTO;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Data;

import javax.validation.constraints.NotNull;
import java.time.LocalDateTime;

@Data
public class VeiculoDTO {

    @Schema(hidden = true)
    private LocalDateTime dataCriacao;

    @Schema(example = "80.00")
    @NotNull
    private Double velocidade;
    @Schema(example = "3600")
    private Integer rotacao;

    @Schema(example = "true")
    @NotNull
    private boolean sensorFrenagem;

}
