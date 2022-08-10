package com.chat.chatkafta.interfaces;

import com.fasterxml.jackson.core.JsonProcessingException;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.kafka.support.KafkaHeaders;
import org.springframework.messaging.handler.annotation.Header;
import org.springframework.messaging.handler.annotation.Payload;

public interface ChatConsumerInterface {

    @KafkaListener(
            topics = "${kafka.topico.geral}",
            groupId = "${kafka.client-id}",
            containerFactory = "listenerContainerFactory",
            clientIdPrefix = "topicogeral")
    public void consumirMensagemGeral(@Payload String mensagem,
                                 @Header(KafkaHeaders.RECEIVED_MESSAGE_KEY) String key,
                                 @Header(KafkaHeaders.OFFSET) Long offset) throws JsonProcessingException;

    @KafkaListener(
            topics = "${kafka.topico.usuario}",
            groupId = "${kafka.client-id}",
            containerFactory = "listenerContainerFactory",
            clientIdPrefix = "topicousuario")
    public void consumirMensagemUsuario(@Payload String mensagem,
                                      @Header(KafkaHeaders.RECEIVED_MESSAGE_KEY) String key,
                                      @Header(KafkaHeaders.OFFSET) Long offset) throws JsonProcessingException;

}
