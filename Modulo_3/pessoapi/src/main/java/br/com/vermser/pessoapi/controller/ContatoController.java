package br.com.vermser.pessoapi.controller;

import br.com.vermser.pessoapi.entity.Contato;
import br.com.vermser.pessoapi.service.ContatoService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/contato")
public class ContatoController {

    ContatoService contatoService;

    public ContatoController(){
        contatoService = new ContatoService();
    }

    @GetMapping
    public List<Contato> listarContatos(){
        return contatoService.listarContatos();
    }

    @GetMapping("/{idUser}")
    public List<Contato> listById(@PathVariable Integer idUser) {
        return contatoService.listById(idUser);
    }

    @PutMapping("/{idContato}")
    public Contato updateContato(@PathVariable Integer idContato,@RequestBody Contato novoContato) throws Exception {
        return contatoService.updateContato(idContato, novoContato);
    }

    @DeleteMapping("/{idContato}")
    public void delete(@PathVariable Integer idContato) throws Exception {
        contatoService.delete(idContato);
    }

    @PostMapping
    public Contato create(@RequestBody Contato contato) {
        System.out.println("CONTATOS " + contato);
        return contatoService.create(contato);
    }
}
