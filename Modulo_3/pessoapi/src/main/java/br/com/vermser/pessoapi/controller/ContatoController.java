package br.com.vermser.pessoapi.controller;

import br.com.vermser.pessoapi.dto.contato.ContatoCreateDTO;
import br.com.vermser.pessoapi.dto.contato.ContatoDTO;
import br.com.vermser.pessoapi.service.ContatoService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
@RequestMapping("/contato")
@Validated

public class ContatoController {
    @Autowired
    ContatoService contatoService;

    @Operation(summary = "Retorna uma lista de contatos.")
    @ApiResponses(
            value = {
                    @ApiResponse(responseCode = "200", description = "Lista de contato"),
                    @ApiResponse(responseCode = "500", description = "Error interno no servidor")
            }
    )
    @GetMapping
    public List<ContatoDTO> listarContatos(){
        return contatoService.listarContatos();
    }

    @Operation(summary = "Busca uma lista de contato de uma determinad apessoa.")
    @ApiResponses(
            value = {
                    @ApiResponse(responseCode = "200", description = "Lista de contato filtrado por id"),
                    @ApiResponse(responseCode = "404", description = "Retorna um error caso a pessoa não exista"),
                    @ApiResponse(responseCode = "500", description = "Error interno no servidor")
            }
    )
    @GetMapping("/{idUser}")
    public List<ContatoDTO> listById(@PathVariable Integer idUser) {
        return contatoService.listById(idUser);
    }

    @Operation(summary = "Cria um contato.")
    @ApiResponses(
            value = {
                    @ApiResponse(responseCode = "200", description = "Retorna o contato criado."),
                    @ApiResponse(responseCode = "404", description = "Retorna um error caso a pessoa não exista ou dados inválidos"),
                    @ApiResponse(responseCode = "500", description = "Error interno no servidor")
            }
    )
    @PostMapping("/{idPessoa}")
    public ContatoDTO create(@PathVariable Integer idPessoa,
                          @Valid @RequestBody ContatoCreateDTO contato) throws Exception {
        return contatoService.create(idPessoa, contato);
    }

    @Operation(summary = "Atualiza o contato.")
    @ApiResponses(
            value = {
                    @ApiResponse(responseCode = "200", description = "Retorna um contato com as novas atualizações"),
                    @ApiResponse(responseCode = "404", description = "Retorna um error caso o contato ou os dados sejam inválidos"),
                    @ApiResponse(responseCode = "500", description = "Error interno no servidor")
            }
    )
    @PutMapping("/{idContato}")
    public ContatoDTO updateContato(@PathVariable Integer idContato,
                                 @Valid @RequestBody ContatoCreateDTO novoContato) throws Exception {
        return contatoService.updateContato(idContato, novoContato);
    }

    @Operation(summary = "Remover contato.")
    @ApiResponses(
            value = {
                    @ApiResponse(responseCode = "200", description = "Se a operação for finalizada com sucesso"),
                    @ApiResponse(responseCode = "404", description = "Retorna um error caso o id do contato não exista"),
                    @ApiResponse(responseCode = "500", description = "Error interno no servidor")
            }
    )
    @DeleteMapping("/{idContato}")
    public void delete(@PathVariable Integer idContato) throws Exception {
        contatoService.delete(idContato);
    }

}
