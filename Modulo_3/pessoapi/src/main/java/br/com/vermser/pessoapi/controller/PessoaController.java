package br.com.vermser.pessoapi.controller;

import br.com.vermser.pessoapi.entity.Pessoa;
import br.com.vermser.pessoapi.entity.PropertieReader;
import br.com.vermser.pessoapi.service.PessoaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
@RequestMapping(value = "/pessoa")
@Validated
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
    public ResponseEntity<Pessoa> create(@Valid @RequestBody Pessoa pessoa){
        //return ResponseEntity.ok(pessoaService.create(pessoa));
        return new ResponseEntity(pessoaService.create(pessoa), HttpStatus.OK);
    }

    @GetMapping
    public List<Pessoa> list(){
        return pessoaService.list();
    }

    @PutMapping("/{idPessoa}")
    public Pessoa update(@PathVariable Integer idPessoa,
                         @Valid @RequestBody Pessoa pessoaAtualizar) throws Exception{
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
