package com.chat.chatkafta.interfaces;

import com.fasterxml.jackson.core.JsonProcessingException;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.kafka.annotation.TopicPartition;
import org.springframework.kafka.support.KafkaHeaders;
import org.springframework.messaging.handler.annotation.Header;
import org.springframework.messaging.handler.annotation.Payload;

public interface ChatConsumerInterface {


    @KafkaListener(
            groupId = "${kafka.client-id}-mensagem-geral",
            containerFactory = "listenerContainerFactory",
            topicPartitions = {@TopicPartition(topic ="${kafka.partition.envio-mensagem}", partitions = {"0", "4"})},
            clientIdPrefix = "topicoenviomensagem")
    public void consumirEnvioMensagem(
            @Payload String mensagem,
            @Header(KafkaHeaders.RECEIVED_PARTITION_ID) Integer partition) throws JsonProcessingException;

}
