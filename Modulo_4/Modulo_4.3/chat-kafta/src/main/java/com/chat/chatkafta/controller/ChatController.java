package com.chat.chatkafta.controller;

import com.chat.chatkafta.dto.MensagemDTO;
import com.chat.chatkafta.enums.OpcoesEnvio;
import com.chat.chatkafta.service.ChatProducerService;
import com.fasterxml.jackson.core.JsonProcessingException;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.util.Set;

@Controller
@RestController
@RequestMapping("/chat")
@Validated
@RequiredArgsConstructor
public class ChatController {

    private final ChatProducerService producerService;

    @PostMapping("/enviar-msg")
    public void enviarMensagem(
            @RequestBody MensagemDTO mensagemDTO,
            @RequestParam("Opcoes de Envio")
                    Set<OpcoesEnvio> opcoesEnvios) throws JsonProcessingException {
        producerService.enviarDadosVeiculoViaKafka(mensagemDTO, opcoesEnvios);
    }
}
