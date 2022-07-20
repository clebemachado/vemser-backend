package br.com.vermser.pessoapi.controller;

import br.com.vermser.pessoapi.documentation.DocumentationContatoController;
import br.com.vermser.pessoapi.dto.contato.ContatoCreateDTO;
import br.com.vermser.pessoapi.dto.contato.ContatoDTO;
import br.com.vermser.pessoapi.service.ContatoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Validated
@RestController
@RequestMapping("/contato")
public class ContatoController implements DocumentationContatoController {

    @Autowired
    private ContatoService contatoService;

    @Override
    @GetMapping("/{idContato}")
    public ResponseEntity<ContatoDTO> findById(Integer idContato) throws Exception {
        return ResponseEntity.ok(contatoService.findById(idContato));
    }

    @Override
    @GetMapping
    public ResponseEntity<List<ContatoDTO>> list() {
        return ResponseEntity.ok(
                contatoService.list()
        );
    }

    @Override
    @PostMapping("/{idPessoa}")
    public ContatoDTO create(Integer idPessoa, ContatoCreateDTO contato) throws Exception {
        System.out.println("AQUI");
        return contatoService.create(idPessoa, contato);
    }

    @Override
    @PutMapping("/{idContato}")
    public ResponseEntity<ContatoDTO> updateContato(Integer idContato, ContatoCreateDTO novoContato)
            throws Exception {
        return ResponseEntity.ok(contatoService.updateContato(idContato, novoContato));
    }

    @Override
    @DeleteMapping("/{idContato}")
    public void delete(Integer idContato) throws Exception {
        contatoService.delete(idContato);
    }
}
