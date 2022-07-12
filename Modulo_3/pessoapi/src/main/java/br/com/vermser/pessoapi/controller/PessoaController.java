package br.com.vermser.pessoapi.controller;

import br.com.vermser.pessoapi.dto.pessoa.PessoaCreateDTO;
import br.com.vermser.pessoapi.dto.pessoa.PessoaDTO;
import br.com.vermser.pessoapi.entity.PropertieReader;
import br.com.vermser.pessoapi.service.PessoaService;
import lombok.SneakyThrows;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@Validated
@RestController
@RequestMapping(value = "/pessoa")
public class PessoaController {
    @Autowired
    private PessoaService pessoaService;

    @Autowired
    private PropertieReader propertieReader;

    @GetMapping("/getpropertie")
    public String getPropertieReader(){
        return propertieReader.getNome();
    }

    @GetMapping
    public List<PessoaDTO> list(){
        return pessoaService.list();
    }

    @GetMapping("/byname") //pessoa/byname?nome=Rafa
    public List<PessoaDTO> listByName(@RequestParam("nome") String nome) {
        return pessoaService.listByName(nome);
    }

    @GetMapping("/{idPessoa}")
    public PessoaDTO getPessoaPorId(@PathVariable Integer idPessoa) throws Exception {
        return pessoaService.getPessoaPorId(idPessoa);
    }

    @PostMapping
    public ResponseEntity<PessoaDTO> create(@Valid @RequestBody PessoaCreateDTO pessoaCDTO){
        return ResponseEntity.ok(pessoaService.create(pessoaCDTO));
    }

    @PutMapping("/{idPessoa}")
    public PessoaDTO update(@PathVariable Integer idPessoa,
                         @Valid @RequestBody PessoaCreateDTO pessoaAtualizar) throws Exception{
        return pessoaService.update(idPessoa, pessoaAtualizar);
    }

    @DeleteMapping("/{idUsuario}")
    public void delete(@PathVariable Integer idUsuario) throws Exception {
        pessoaService.delete(idUsuario);
    }

}
