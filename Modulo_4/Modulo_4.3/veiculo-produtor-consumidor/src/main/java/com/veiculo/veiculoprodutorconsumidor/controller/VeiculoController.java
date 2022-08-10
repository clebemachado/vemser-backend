package com.veiculo.veiculoprodutorconsumidor.controller;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.veiculo.veiculoprodutorconsumidor.DTO.VeiculoDTO;
import com.veiculo.veiculoprodutorconsumidor.service.VeiculoProducerService;
import com.veiculo.veiculoprodutorconsumidor.service.VeiculoService;
import lombok.RequiredArgsConstructor;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
@RequestMapping("/veiculo")
@Validated
@RequiredArgsConstructor
public class VeiculoController {

    private final VeiculoProducerService veiculoProducerService;
    private final VeiculoService veiculoService;

    @PostMapping("/send-dados")
    public void enviarDadosVeiculo(@Valid @RequestBody VeiculoDTO veiculo) throws JsonProcessingException {
        veiculoProducerService.enviarDadosVeiculoViaKafka(veiculo);
    }

    @GetMapping
    public List<VeiculoDTO> getListVeiculo(){
        return veiculoService.getList();
    }

    @GetMapping("/velocidade-media")
    public Double getVelocidadeMedia(){
        return veiculoService.velocidadeMedia();
    }

    @GetMapping("/rotacao-media")
    public Double getRotacaoMedia(){
        return veiculoService.rotacaoMedia();
    }

    @GetMapping("/contar-registros")
    public Long getContarTodosOsRegistros(){
        return veiculoService.contarTodosOsRegistros();
    }

}
