package br.com.vermser.pessoapi.controller;

import br.com.vermser.pessoapi.client.DadosPessoaisClient;
import br.com.vermser.pessoapi.documentation.DocumentationDadosPessoaController;
import br.com.vermser.pessoapi.dto.dadosPessoais.DadosPessoaisDTO;
import feign.Param;
import feign.RequestLine;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("/dados-pessoais")
public class DadosPessoaisController implements DocumentationDadosPessoaController {

    @Autowired
    private DadosPessoaisClient client;

    @GetMapping("/dados-pessoais/{cpf}")
    public DadosPessoaisDTO get(@PathVariable String cpf){
        return client.get(cpf);
    };

    @GetMapping
    public List<DadosPessoaisDTO> getListPessoas(){
        return client.getAll();
    }

    @PostMapping
    public ResponseEntity<DadosPessoaisDTO> create(@Valid @RequestBody DadosPessoaisDTO dadosPessoaisDTO){
        return ResponseEntity.ok(client.post(dadosPessoaisDTO));
    }

    @PutMapping("/{cpf}")
    public ResponseEntity<DadosPessoaisDTO> put(@PathVariable String cpf,
                                @RequestBody  DadosPessoaisDTO dadosPessoaisDTO){
        return ResponseEntity.ok(client.put(cpf, dadosPessoaisDTO));
    };

    @DeleteMapping("/dados-pessoais/{cpf}")
    public void delete(@PathVariable String cpf){
        client.delete(cpf);
    }

}
