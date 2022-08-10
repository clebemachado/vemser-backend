package com.veiculo.veiculoprodutorconsumidor.entity;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import nonapi.io.github.classgraph.json.Id;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.data.mongodb.core.mapping.Field;

import javax.validation.constraints.NotNull;
import java.time.LocalDateTime;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Document(collection = "veiculo")
public class VeiculoEntity {

    @Id
    @Field("_id")
    private String idVeiculo;

    @Field("dataCriacao")
    private LocalDateTime dataCriacao;

    @Field("velocidade")
    private Double velocidade;

    @Field("rotacao")
    private Integer rotacao;

    @Field("sensorFrenagem")
    private boolean sensorFrenagem;


}
