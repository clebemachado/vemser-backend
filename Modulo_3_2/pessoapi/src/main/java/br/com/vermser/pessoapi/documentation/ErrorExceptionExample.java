package br.com.vermser.pessoapi.documentation;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Data;

@Data
public abstract class ErrorExceptionExample {
    @Schema(example = "18-07-2017 06:20:19")
    private String timestamp;
    @Schema(example = "status: NOT_FOUND")
    private String status;
    @Schema(example = "May the Force be with you! Because here it went bad.")
    private String menssage;
}
