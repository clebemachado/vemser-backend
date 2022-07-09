package br.com.vermser.pessoapi.controller;

import br.com.vermser.pessoapi.dto.contato.ContatoCreateDTO;
import br.com.vermser.pessoapi.dto.contato.ContatoDTO;
import br.com.vermser.pessoapi.entity.Contato;
import br.com.vermser.pessoapi.service.ContatoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
@RequestMapping("/contato")
@Validated

public class ContatoController {
    @Autowired
    ContatoService contatoService;

    @GetMapping
    public List<ContatoDTO> listarContatos(){
        return contatoService.listarContatos();
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
