package br.com.vermser.pessoapi.documentation;

import br.com.vermser.pessoapi.anotations.MagiaResponse;
import br.com.vermser.pessoapi.dto.pessoa.PessoaCreateDTO;
import br.com.vermser.pessoapi.dto.pessoa.PessoaFullDTO;
import br.com.vermser.pessoapi.dto.pessoa.PessoaDTO;
import br.com.vermser.pessoapi.exceptions.PessoaException;
import io.swagger.v3.oas.annotations.Operation;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;

import javax.validation.Valid;
import java.util.List;

@MagiaResponse
public interface DocumentationPeopleController {

    @Operation(summary = "Retorna uma pessoa filtrada pelo id.")
    public PessoaDTO findById(Integer idPessoa) throws PessoaException;

    @Operation(summary = "Retorna uma pessoa(s) seus contatos.")
    public ResponseEntity<List<PessoaDTO>> findWithContact(@RequestParam(required = false) Integer idPessoa) throws PessoaException;

    @Operation(summary = "Retorna pessoa(s) com seu(s) endereco(s).")
    public ResponseEntity<List<PessoaDTO>> findWithEnderecos(@RequestParam(required = false) Integer idPessoa) throws PessoaException;

    @Operation(summary = "Retorna pessoa(s) com seu(s) pet(s).")
    public ResponseEntity<List<PessoaDTO>> findWithPet(@RequestParam(required = false) Integer idPessoa) throws PessoaException;

    @Operation(description = "Retorna uma lista de pessoa.")
    public List<PessoaDTO> list();

    @Operation(summary = "Cria uma pessoa.")
    public ResponseEntity<PessoaCreateDTO> create(@Valid @RequestBody PessoaCreateDTO pessoaCDTO);

    @Operation(summary = "Atualiza uma pessoa")
    public ResponseEntity<PessoaCreateDTO> update(Integer idPessoa,
                            @Valid @RequestBody PessoaCreateDTO pessoaAtualizar) throws Exception;

    @Operation(summary = "Remover uma pessoa.")
    public void delete(Integer idUsuario) throws Exception;

}




