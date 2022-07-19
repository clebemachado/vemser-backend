package br.com.vermser.pessoapi.dto.dadosPessoais.entity;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

@Component
public class PropertieReader {

    @Value("${ambiente}")
    private String nome;

    public PropertieReader() {}

    public PropertieReader(String nome) {
        this.nome = nome;
    }

    public String getNome() {
        return nome;
    }

}
