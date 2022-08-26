package com.chat.chatkafta.service;

import com.chat.chatkafta.dto.MensagemDTO;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.kafka.annotation.TopicPartition;
import org.springframework.kafka.support.KafkaHeaders;
import org.springframework.messaging.handler.annotation.Header;
import org.springframework.messaging.handler.annotation.Payload;
import org.springframework.stereotype.Service;

import java.time.format.DateTimeFormatter;

@Service
@Slf4j
@RequiredArgsConstructor
public class ChatConsumerService {

    private final ObjectMapper objectMapper;

    private MensagemDTO getMensagemDTO(String mensagem) throws JsonProcessingException {
        return objectMapper.readValue(mensagem, MensagemDTO.class);
    }

    @KafkaListener(
            groupId = "${kafka.client-id}-mensagem-geral",
            containerFactory = "listenerContainerFactory",
            topicPartitions = {@TopicPartition(topic = "${kafka.partition.envio-mensagem}", partitions = {"0", "4"})},
            clientIdPrefix = "topicoenviomensagem")
    public void consumirEnvioMensagem(
            @Payload String mensagem,
            @Header(KafkaHeaders.RECEIVED_PARTITION_ID) Integer partition) throws JsonProcessingException {
        if (partition == 0) {
            mostrarLog(mensagem, "");
        } else if (partition == 4) {
            mostrarLog(mensagem, "(privado)");
        }
    }

    private void mostrarLog(String mensagem, String formato) throws JsonProcessingException {

        MensagemDTO mensagemDTO = getMensagemDTO(mensagem);
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd/MM/yyyy HH:mm:ss");

        log.info(
                mensagemDTO.getDataCriacao().format(formatter) + " [" +
                        mensagemDTO.getUsuario() + "] " +
                        formato + ": " +
                        mensagemDTO.getMensagem()
        );
    }

}
