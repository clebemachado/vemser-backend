package br.com.vermser.pessoapi.controller;

import br.com.vermser.pessoapi.documentation.DocumentationPeopleController;
import br.com.vermser.pessoapi.dto.pessoa.PessoaCreateDTO;
import br.com.vermser.pessoapi.dto.pessoa.PessoaFullDTO;
import br.com.vermser.pessoapi.dto.pessoa.PessoaDTO;
import br.com.vermser.pessoapi.exceptions.PessoaException;
import br.com.vermser.pessoapi.service.PessoaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@Validated
@RestController
@RequestMapping(value = "/pessoa")
public class PessoaController implements DocumentationPeopleController {

    @Autowired
    private PessoaService pessoaService;

    @GetMapping("/{idPessoa}")
    public PessoaDTO findById(@PathVariable Integer idPessoa) throws PessoaException {
        return pessoaService.findById(idPessoa);
    }

    @GetMapping
    public List<PessoaDTO> list(){
        return pessoaService.list();
    }

    @GetMapping("/byname/{nome}")
    public List<PessoaDTO> getPessoaPorName(@RequestParam String nome) {
        return pessoaService.findByName(nome);
    }

    @GetMapping("/cpf/{cpf}")
    public PessoaDTO getPessoaPorCpf(@RequestParam String cpf)  {
        return pessoaService.findByCpf(cpf);
    }

    @PostMapping
    public ResponseEntity<PessoaCreateDTO> create(@Valid @RequestBody PessoaCreateDTO pessoaCDTO){

        return ResponseEntity.ok(pessoaService.create(pessoaCDTO));
    }

    @PutMapping("/{idPessoa}")
    public ResponseEntity<PessoaCreateDTO> update(@PathVariable Integer idPessoa,
                            @Valid @RequestBody PessoaCreateDTO pessoaAtualizar) throws Exception {
        return ResponseEntity.ok(pessoaService.update(idPessoa, pessoaAtualizar));
    }

    @DeleteMapping("/{idUsuario}")
    public void delete(@PathVariable Integer idUsuario) throws Exception {
        pessoaService.delete(idUsuario);
    }

    @GetMapping("/listar-com-contatos")
    public ResponseEntity<List<PessoaDTO>> findWithContact(Integer idPessoa)
            throws PessoaException {
        return ResponseEntity.ok(pessoaService.findByIdWithContact(idPessoa));
    }

    @Override
    @GetMapping("/listar-com-enderecos")
    public ResponseEntity<List<PessoaDTO>> findWithEnderecos(Integer idPessoa) throws PessoaException {
        return ResponseEntity.ok(pessoaService.findByIdWithAddress(idPessoa));
    }

    @GetMapping("/listar-com-pets")
    public ResponseEntity<List<PessoaDTO>> findWithPet(Integer idPessoa)  {
        return ResponseEntity.ok(pessoaService.listPessoaWithPet(idPessoa));
    }

}
