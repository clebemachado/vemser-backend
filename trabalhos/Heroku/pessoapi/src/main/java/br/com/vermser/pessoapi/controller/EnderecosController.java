package br.com.vermser.pessoapi.controller;

import br.com.vermser.pessoapi.documentation.DocumentationEnderecoController;
import br.com.vermser.pessoapi.dto.enderecos.EnderecoCreateDTO;
import br.com.vermser.pessoapi.dto.enderecos.EnderecoDTO;
import br.com.vermser.pessoapi.dto.dadosPessoais.entity.Endereco;
import br.com.vermser.pessoapi.service.EnderecoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@Validated
@RestController
@RequestMapping(value = "/endereco")
public class EnderecosController implements DocumentationEnderecoController {

    @Autowired
    EnderecoService enderecoService;

    @GetMapping
    public List<EnderecoDTO> pegarTodosOsEnderecos(){
        return enderecoService.pegarTodosOsEnderecos();
    }

    @GetMapping("/{idEndereco}")
    public EnderecoDTO pegarEnderecoPorID(@PathVariable Integer idEndereco) throws Exception {
        return enderecoService.pegarEnderecoPorID(idEndereco);
    }

    @GetMapping("/{idPessoa}/pessoa")
    public List<Endereco> pegarEnderecoPorPessoa(@PathVariable Integer idPessoa) throws Exception {
        return enderecoService.pegarEnderecoPorPessoa(idPessoa);
    }

    @PostMapping("/{idPessoa}")
    public EnderecoDTO createEndereco(@PathVariable Integer idPessoa,
                                   @Valid @RequestBody EnderecoCreateDTO endereco) throws Exception {
        System.out.println("CREATE");
        return enderecoService.createEndereco(idPessoa, endereco);
    }

    @PutMapping("/{idEndereco}")
    public EnderecoDTO update(@PathVariable Integer idEndereco,
                           @Valid @RequestBody EnderecoCreateDTO enderecoPut) throws Exception{
        return enderecoService.update(idEndereco, enderecoPut);
    }

    @DeleteMapping("/{idEndereco}")
    public void delete(@PathVariable Integer idEndereco) throws Exception {
        enderecoService.delete(idEndereco);
    }

}
