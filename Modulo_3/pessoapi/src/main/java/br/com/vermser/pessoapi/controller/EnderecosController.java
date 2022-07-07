package br.com.vermser.pessoapi.controller;

import br.com.vermser.pessoapi.entity.Endereco;
import br.com.vermser.pessoapi.service.EnderecoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping(value = "/endereco")
public class EnderecosController {

    @Autowired
    EnderecoService enderecoService;

    @GetMapping
    public List<Endereco> pegarTodosOsEnderecos(){
        return enderecoService.pegarTodosOsEnderecos();
    }

    @GetMapping("/{idEndereco}")
    public Endereco pegarEndereco(@PathVariable Integer idEndereco) throws Exception {
        return enderecoService.pegarEndereco(idEndereco);
    }

    @GetMapping("/{idPessoa}/pessoa")
    public List<Endereco> pegarEnderecoPorPessoa(@PathVariable Integer idPessoa) throws Exception {
        return enderecoService.pegarEnderecoPorPessoa(idPessoa);
    }

    @PostMapping("/{idPessoa}")
    public Endereco createEndereco(@PathVariable Integer idPessoa,
                                   @RequestBody Endereco endereco) throws Exception {
        return enderecoService.createEndereco(idPessoa, endereco);
    }

    @PutMapping("/{idEndereco}")
    public Endereco update(@PathVariable Integer idEndereco,
                           @RequestBody Endereco enderecoPut) throws Exception{

        return enderecoService.update(idEndereco, enderecoPut);
    }

    @DeleteMapping("/{idEndereco}")
    public void delete(@PathVariable Integer idEndereco) throws Exception {
        enderecoService.delete(idEndereco);
    }


}
