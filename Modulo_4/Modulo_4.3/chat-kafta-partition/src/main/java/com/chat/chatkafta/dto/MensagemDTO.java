package com.chat.chatkafta.dto;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.validation.constraints.NotEmpty;
import java.time.LocalDateTime;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class MensagemDTO {

    @Schema(hidden = true)
    private String usuario;

    @Schema(example = "Oi, bom dia a todos!")
    @NotEmpty
    private String mensagem;

    @Schema(hidden = true)
    private LocalDateTime dataCriacao;
}
