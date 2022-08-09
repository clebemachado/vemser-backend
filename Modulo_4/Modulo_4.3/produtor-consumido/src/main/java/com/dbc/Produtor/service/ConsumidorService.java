package com.dbc.Produtor.service;

import lombok.extern.slf4j.Slf4j;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.kafka.support.KafkaHeaders;
import org.springframework.messaging.handler.annotation.Header;
import org.springframework.messaging.handler.annotation.Payload;
import org.springframework.stereotype.Service;


@Service
@Slf4j
public class ConsumidorService {

    @KafkaListener(
            topics = "${kafka.topico}",
            groupId = "group1",
            containerFactory = "listenerContainerFactory",
            clientIdPrefix = "primeiroTopico")
    public void consumirMensagem(@Payload String mensagem,
                         @Header(KafkaHeaders.RECEIVED_MESSAGE_KEY) String key,
                         @Header(KafkaHeaders.OFFSET) Long offset){
        log.info("{COMSUMER} offset -> '{}' key -> '{}' -> Consumed Object message -> '{}'  ", offset, key, mensagem);
    }
}
