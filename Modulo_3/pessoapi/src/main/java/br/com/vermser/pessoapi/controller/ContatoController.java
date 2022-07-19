package br.com.vermser.pessoapi.controller;

import br.com.vermser.pessoapi.anotations.MagiaResponse;
import br.com.vermser.pessoapi.documentation.DocumentationContatoController;
import br.com.vermser.pessoapi.dto.contato.ContatoCreateDTO;
import br.com.vermser.pessoapi.dto.contato.ContatoDTO;
import br.com.vermser.pessoapi.service.ContatoService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@Validated
@RestController
@RequestMapping("/contato")
public class ContatoController implements DocumentationContatoController {

    @Autowired
    ContatoService contatoService;

    @GetMapping
    public List<ContatoDTO> list(){
        return contatoService.list();
    }

    @GetMapping("/{idUser}")
    public List<ContatoDTO> listById(@PathVariable Integer idUser) {
        return contatoService.listById(idUser);
    }

    @PostMapping("/{idPessoa}")
    public ContatoDTO create(@PathVariable Integer idPessoa,
                             @Valid @RequestBody ContatoCreateDTO contato) throws Exception {
        return contatoService.create(idPessoa, contato);
    }

    @PutMapping("/{idContato}")
    public ContatoDTO updateContato(@PathVariable Integer idContato,
                                    @Valid @RequestBody ContatoCreateDTO novoContato) throws Exception {
        return contatoService.updateContato(idContato, novoContato);
    }

    @DeleteMapping("/{idContato}")
    public void delete(@PathVariable Integer idContato) throws Exception {
        contatoService.delete(idContato);
    }

}
