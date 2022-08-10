package com.chat.chatkafta.service;

import com.chat.chatkafta.dto.MensagemDTO;
import com.chat.chatkafta.interfaces.ChatConsumerInteface;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.kafka.support.KafkaHeaders;
import org.springframework.messaging.handler.annotation.Header;
import org.springframework.messaging.handler.annotation.Payload;
import org.springframework.stereotype.Service;

import java.time.format.DateTimeFormatter;

@Service
@Slf4j
@RequiredArgsConstructor
public class ChatConsumerService implements ChatConsumerInteface {

    private final ObjectMapper objectMapper;

    private MensagemDTO getMensagemDTO(String mensagem) throws JsonProcessingException {
        return objectMapper.readValue(mensagem, MensagemDTO.class);
    }

    public void consumirMensagemGeral(@Payload String mensagem,
                                 @Header(KafkaHeaders.RECEIVED_MESSAGE_KEY) String key,
                                 @Header(KafkaHeaders.OFFSET) Long offset) throws JsonProcessingException {
        mostrarLog(mensagem, "");
    }

    public void consumirMensagemUsuario(@Payload String mensagem,
                                      @Header(KafkaHeaders.RECEIVED_MESSAGE_KEY) String key,
                                      @Header(KafkaHeaders.OFFSET) Long offset) throws JsonProcessingException {
        mostrarLog(mensagem, "(privado)");


    }

    private void mostrarLog(String mensagem, String formato) throws JsonProcessingException {
        MensagemDTO mensagemDTO = getMensagemDTO(mensagem);
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd/MM/yyyy HH:mm:ss");

        log.info("{ " +
                mensagemDTO.getDataCriacao().format(formatter) + " [" +
                mensagemDTO.getUsuario() + "] " +
                formato + ": " +
                mensagemDTO.getMensagem() + " }"
        );
    }

}
