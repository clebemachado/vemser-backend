package br.com.vermser.pessoapi.controller;

import br.com.vermser.pessoapi.client.DadosPessoaisClient;
import br.com.vermser.pessoapi.documentation.DocumentationDadosPessoaController;
import br.com.vermser.pessoapi.dto.dadosPessoais.DadosPessoaisDTO;
import br.com.vermser.pessoapi.service.DadosPessoaisService;
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
    private DadosPessoaisService dadosPessoaisService;

    @GetMapping("/dados-pessoais/{cpf}")
    public DadosPessoaisDTO get(@PathVariable String cpf){

        return dadosPessoaisService.get(cpf);
    };

    @GetMapping
    public List<DadosPessoaisDTO> getListPessoas(){
        return dadosPessoaisService.getListPessoas();
    }

    @PostMapping
    public ResponseEntity<DadosPessoaisDTO> create(@Valid @RequestBody DadosPessoaisDTO dadosPessoaisDTO)
    {
        return ResponseEntity.ok(dadosPessoaisService.create(dadosPessoaisDTO));
    }

    @PutMapping("/{cpf}")
    public ResponseEntity<DadosPessoaisDTO> put(@PathVariable String cpf,
                                @RequestBody  DadosPessoaisDTO dadosPessoaisDTO){
        return ResponseEntity.ok(dadosPessoaisService.put(cpf, dadosPessoaisDTO));
    };

    @DeleteMapping("/dados-pessoais/{cpf}")
    public void delete(@PathVariable String cpf){
        dadosPessoaisService.delete(cpf);
    }

}
