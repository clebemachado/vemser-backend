package com.chat.chatkafta.service;

import com.chat.chatkafta.dto.MensagemDTO;
import com.chat.chatkafta.enums.OpcoesEnvio;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.kafka.support.KafkaHeaders;
import org.springframework.kafka.support.SendResult;
import org.springframework.messaging.Message;
import org.springframework.messaging.support.MessageBuilder;
import org.springframework.stereotype.Service;
import org.springframework.util.concurrent.ListenableFuture;
import org.springframework.util.concurrent.ListenableFutureCallback;

import java.time.LocalDateTime;
import java.util.Set;
import java.util.UUID;

@Service
@RequiredArgsConstructor
@Slf4j
public class ChatProducerService {

    private final KafkaTemplate<String, String> kafkaTemplate;
    private final ObjectMapper objectMapper;

    @Value("${kafka.usuario}")
    private String usuario;


    public void enviarDadosVeiculoViaKafka(MensagemDTO mensagemDTO, Set<OpcoesEnvio> opcoesEnvios)
            throws JsonProcessingException {

        mensagemDTO.setUsuario(usuario);
        mensagemDTO.setDataCriacao(LocalDateTime.now());

        String payload = objectMapper.writeValueAsString(mensagemDTO);
        opcoesEnvios.forEach(topico -> sendMensage(payload, topico.getChat()));
    }

    private void sendMensage(String payload, String topico) {

        MessageBuilder<String> messageString =
                MessageBuilder.withPayload(payload)
                        .setHeader(KafkaHeaders.TOPIC, topico)
                        .setHeader(KafkaHeaders.MESSAGE_KEY, UUID.randomUUID().toString());

        Message<String> stringMessage = messageString.build();

        ListenableFuture<SendResult<String, String>> future =
                kafkaTemplate.send(stringMessage);

        future.addCallback(new ListenableFutureCallback<>() {
            @Override
            public void onSuccess(SendResult result) {
                log.info("LOG <PRODUCTO>{ SUCESSO AO ENVIAR MENSAGEM:  " + messageString + " }");
            }

            @Override
            public void onFailure(Throwable ex) {
                log.error("LOG<PRODUCTOR>{ ERROR AO ENVIAR MENSAGEM:  " + messageString + " }");
            }
        });
    }

}
