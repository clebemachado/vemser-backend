package br.com.vermser.pessoapi.controller;

import br.com.vermser.pessoapi.documentation.DocumentationPeopleController;
import br.com.vermser.pessoapi.dto.pessoa.PessoaCreateDTO;
import br.com.vermser.pessoapi.dto.pessoa.PessoaDTO;
import br.com.vermser.pessoapi.dto.relatorio.PessoaRelatorioDTO;
import br.com.vermser.pessoapi.entity.EnderecoEntity;
import br.com.vermser.pessoapi.entity.PessoaEntity;
import br.com.vermser.pessoapi.enums.TipoContato;
import br.com.vermser.pessoapi.exceptions.PessoaException;
import br.com.vermser.pessoapi.repository.PessoaRepository;
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

    @Autowired
    private PessoaRepository pessoaRepository;

    @GetMapping("/pessoa-cpf")
    public PessoaEntity getPessoaByCPF(String cpf){
        return pessoaRepository.getPessoaCPF(cpf);
    }

    @GetMapping("/endereco-pessoa")
    public EnderecoEntity getPessoaEndereco(Integer id){
        return pessoaRepository.findByEndereco(id);
    }

    @GetMapping("/contato-por-tipo")
     public List<PessoaEntity> getContato(TipoContato tipoContato){
        return pessoaRepository.findByContatos_tipoContato(tipoContato);
    }

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
    public ResponseEntity<List<PessoaDTO>> findWithContact(@RequestParam(required = false)Integer idPessoa)
            throws PessoaException {
        return ResponseEntity.ok(pessoaService.findByIdWithContact(idPessoa));
    }

    @Override
    @GetMapping("/listar-com-enderecos")
    public ResponseEntity<List<PessoaDTO>> findWithEnderecos(@RequestParam(required = false)Integer idPessoa) throws PessoaException {
        return ResponseEntity.ok(pessoaService.findByIdWithAddress(idPessoa));
    }

    @GetMapping("/listar-com-pets")
    public ResponseEntity<List<PessoaDTO>> findWithPet(@RequestParam(required = false)Integer idPessoa)  {
        return ResponseEntity.ok(pessoaService.listPessoaWithPet(idPessoa));
    }

    @GetMapping("/pessoa-completo")
    public ResponseEntity<List<PessoaDTO>> getCompleto(@RequestParam(required = false) Integer idPessoa)
            throws PessoaException {
        return ResponseEntity.ok(pessoaService.getCompleto(idPessoa));
    };

    @GetMapping("/relatorio")
    public ResponseEntity<List<PessoaRelatorioDTO>> getRelatorio(
            @RequestParam(required = false) Integer idPessoa) throws PessoaException {
        return ResponseEntity.ok(pessoaService.getRelatorio(idPessoa));
    };

}
