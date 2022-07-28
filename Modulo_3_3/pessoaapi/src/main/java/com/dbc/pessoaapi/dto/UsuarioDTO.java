package com.dbc.pessoaapi.dto;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class UsuarioDTO{

    @Schema(example = "1")
    private Integer idUsuario;

    @Schema(example = "userLogin")
    private String login;

}
