package br.com.vermser.pessoapi.controller;

import br.com.vermser.pessoapi.entity.Endereco;
import br.com.vermser.pessoapi.service.EnderecoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
@RequestMapping(value = "/endereco")
@Validated
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
                                   @Valid @RequestBody Endereco endereco) throws Exception {
        System.out.println("ID PESSOA" + idPessoa);
        return enderecoService.createEndereco(idPessoa, endereco);
    }

    @PutMapping("/{idEndereco}")
    public Endereco update(@PathVariable Integer idEndereco,
                           @Valid @RequestBody Endereco enderecoPut) throws Exception{

        return enderecoService.update(idEndereco, enderecoPut);
    }

    @DeleteMapping("/{idEndereco}")
    public void delete(@PathVariable Integer idEndereco) throws Exception {
        enderecoService.delete(idEndereco);
    }


}
