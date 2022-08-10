package com.veiculo.veiculoprodutorconsumidor.service;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.veiculo.veiculoprodutorconsumidor.DTO.VeiculoDTO;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.kafka.support.KafkaHeaders;
import org.springframework.messaging.handler.annotation.Header;
import org.springframework.messaging.handler.annotation.Payload;
import org.springframework.stereotype.Service;

@Service
@Slf4j
@RequiredArgsConstructor
public class VeiculoConsumerService {

    private final ObjectMapper objectMapper;

    private final VeiculoService veiculoService;

    @KafkaListener(
            topics = "${kafka.topico}",
            groupId = "group1",
            containerFactory = "listenerContainerFactory",
            clientIdPrefix = "primeiroTopico")
    public void consumirMensagem(@Payload String mensagem,
                                 @Header(KafkaHeaders.RECEIVED_MESSAGE_KEY) String key,
                                 @Header(KafkaHeaders.OFFSET) Long offset) throws JsonProcessingException {

        VeiculoDTO veiculoDTO = objectMapper.readValue(mensagem, VeiculoDTO.class);
        veiculoService.create(veiculoDTO);
        log.info("{COMSUMER} offset -> '{}' key -> '{}' -> Consumed Object message -> '{}'  ", offset, key, mensagem);

    }

}
