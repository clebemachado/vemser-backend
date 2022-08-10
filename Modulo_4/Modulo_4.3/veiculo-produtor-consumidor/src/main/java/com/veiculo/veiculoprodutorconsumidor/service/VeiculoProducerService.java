package com.veiculo.veiculoprodutorconsumidor.service;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.veiculo.veiculoprodutorconsumidor.DTO.VeiculoDTO;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.kafka.support.SendResult;
import org.springframework.messaging.Message;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.kafka.support.KafkaHeaders;
import org.springframework.messaging.support.MessageBuilder;
import org.springframework.stereotype.Service;
import org.springframework.util.concurrent.ListenableFuture;
import org.springframework.util.concurrent.ListenableFutureCallback;

import java.time.LocalDateTime;
import java.util.UUID;

@Service
@RequiredArgsConstructor
@Slf4j
public class VeiculoProducerService {

    private final KafkaTemplate<String, String> kafkaTemplate;
    private final ObjectMapper objectMapper;

    @Value("${kafka.topico}")
    private String topico;

    public void enviarDadosVeiculoViaKafka(VeiculoDTO veiculo) throws JsonProcessingException {
        veiculo.setDataCriacao(LocalDateTime.now());

        String payload = objectMapper.writeValueAsString(veiculo);
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
                log.info("LOG <PRODUCTO>{ texto enviado:  " + messageString + " }");
            }

            @Override
            public void onFailure(Throwable ex) {
                log.info("LOG{ error ao publicar:  " + messageString + " }");
            }
        });

    }


}
