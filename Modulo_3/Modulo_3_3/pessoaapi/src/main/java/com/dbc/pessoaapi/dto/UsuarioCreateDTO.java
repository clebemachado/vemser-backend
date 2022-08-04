package com.dbc.pessoaapi.dto;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Data;

import javax.validation.constraints.NotEmpty;

@Data
public class UsuarioCreateDTO {
    @Schema(example = "user")
    @NotEmpty
    private String login;

    @NotEmpty
    private String senha;
}
