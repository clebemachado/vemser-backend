package com.dbc.pessoaapi.dto;
import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Data;

import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;

@Data
public class LoginDTO {

    @Schema(example = "user")
    @NotEmpty
    private String login;

    @Schema(example = "123")
    @NotEmpty
    private String senha;
}
