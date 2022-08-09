package com.dbc.Produtor.controller;

import com.dbc.Produtor.service.ProdutorService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/kafka-controller")
@RequiredArgsConstructor
public class ProdutorController {

    private final ProdutorService produtorService;

    @PostMapping("/enviar")
    public void enviarMensagemParaOTopico(String mensagem){
        produtorService.enviarMensagemKafka(mensagem);
    }

}
