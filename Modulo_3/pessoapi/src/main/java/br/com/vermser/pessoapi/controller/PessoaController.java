package br.com.vermser.pessoapi.controller;

import br.com.vermser.pessoapi.entity.Pessoa;
import br.com.vermser.pessoapi.entity.PropertieReader;
import br.com.vermser.pessoapi.service.PessoaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(value = "/pessoa")
public class PessoaController {
    @Autowired
    private PessoaService pessoaService;

    @Autowired
    private PropertieReader propertieReader;

    @GetMapping("/hello")
    public String hello(){
        return "Hello World";
    }

    @PostMapping
    public Pessoa create(@RequestBody Pessoa pessoa){
        return pessoaService.create(pessoa);
    }

    @GetMapping
    public List<Pessoa> list(){
        return pessoaService.list();
    }

    @PutMapping("/{idPessoa}")
    public Pessoa update(@PathVariable Integer idPessoa,
                         @RequestBody Pessoa pessoaAtualizar) throws Exception{
        return pessoaService.update(idPessoa, pessoaAtualizar);
    }

    @DeleteMapping("/{idUsuario}")
    public void delete(@PathVariable Integer idUsuario) throws Exception {
        pessoaService.delete(idUsuario);
    }

    @GetMapping("/byname") //pessoa/byname?nome=Rafa
    public List<Pessoa> listByName(@RequestParam("nome") String nome) {
        return pessoaService.listByName(nome);
    }

    @GetMapping("/getpropertie")
    public String getPropertieReader(){
        return propertieReader.getNome();
    }


}
