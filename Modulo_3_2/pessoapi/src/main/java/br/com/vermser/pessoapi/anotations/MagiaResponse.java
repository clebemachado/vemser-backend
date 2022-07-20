package br.com.vermser.pessoapi.anotations;

import br.com.vermser.pessoapi.documentation.ErrorExceptionExample;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

@Target(ElementType.TYPE)
@Retention(RetentionPolicy.RUNTIME)
@ApiResponses(
        value = {
                @ApiResponse(responseCode = "200", description = "Sucesso."),
                @ApiResponse(responseCode = "401", description = "Não autorizado.",
                        content = @Content(schema = @Schema(oneOf = {ErrorExceptionExample.class}))),
                @ApiResponse(responseCode = "404", description = "Não encontrado.",
                        content = @Content(schema = @Schema(oneOf = {ErrorExceptionExample.class}))),
                @ApiResponse(responseCode = "500", description = "Error interno.",
                        content = @Content(schema = @Schema(oneOf = {ErrorExceptionExample.class}))),
        }
)
public @interface MagiaResponse {
}
