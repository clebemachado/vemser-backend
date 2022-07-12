package br.com.vermser.pessoapi.controller;

import br.com.vermser.pessoapi.dto.enderecos.EnderecoCreateDTO;
import br.com.vermser.pessoapi.dto.enderecos.EnderecoDTO;
import br.com.vermser.pessoapi.entity.Endereco;
import br.com.vermser.pessoapi.service.EnderecoService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@Validated
@RestController
@RequestMapping(value = "/endereco")
public class EnderecosController {

    @Autowired
    EnderecoService enderecoService;

    @Operation(summary = "Retorna uma lista de endereço.")
    @ApiResponses(
            value = {
                    @ApiResponse(responseCode = "200", description = "Retorna um lista contendo endereços "),
                    @ApiResponse(responseCode = "500", description = "Error interno no servidor")
            }
    )
    @GetMapping
    public List<EnderecoDTO> pegarTodosOsEnderecos(){
        return enderecoService.pegarTodosOsEnderecos();
    }

    @Operation(summary = "Retorna um endereço específico.")
    @ApiResponses(
            value = {
                    @ApiResponse(responseCode = "200", description = "Retorna um determinado endereço "),
                    @ApiResponse(responseCode = "404", description = "Retorna um error caso o endereço não exista"),
                    @ApiResponse(responseCode = "500", description = "Error interno no servidor")
            }
    )
    @GetMapping("/{idEndereco}")
    public EnderecoDTO pegarEnderecoPorID(@PathVariable Integer idEndereco) throws Exception {
        return enderecoService.pegarEnderecoPorID(idEndereco);
    }

    @Operation(summary = "Retorna uma lista de endereço de um determinado id.")
    @ApiResponses(
            value = {
                    @ApiResponse(responseCode = "200", description = "Retorna uma lista de endereço filtrada por endereço caso o id da pessoa exista"),
                    @ApiResponse(responseCode = "404", description = "Retorna um error caso a pessoa não exista"),
                    @ApiResponse(responseCode = "500", description = "Error interno no servidor")
            }
    )
    @GetMapping("/{idPessoa}/pessoa")
    public List<Endereco> pegarEnderecoPorPessoa(@PathVariable Integer idPessoa) throws Exception {
        return enderecoService.pegarEnderecoPorPessoa(idPessoa);
    }

    @Operation(summary = "Cria um novo endereço.")
    @ApiResponses(
            value = {
                    @ApiResponse(responseCode = "200", description = "Retorna o endereço criado"),
                    @ApiResponse(responseCode = "404", description = "Retorna um error caso os dados não sejam válidos"),
                    @ApiResponse(responseCode = "500", description = "Error interno no servidor")
            }
    )
    @PostMapping("/{idPessoa}")
    public EnderecoDTO createEndereco(@PathVariable Integer idPessoa,
                                   @Valid @RequestBody EnderecoCreateDTO endereco) throws Exception {
        return enderecoService.createEndereco(idPessoa, endereco);
    }

    @Operation(summary = "Atualiza o endereço")
    @ApiResponses(
            value = {
                    @ApiResponse(responseCode = "200", description = "Retorna um endereço com os dados atualizados"),
                    @ApiResponse(responseCode = "404", description = "Retorna um error caso o endereço não exista"),
                    @ApiResponse(responseCode = "500", description = "Error interno no servidor")
            }
    )
    @PutMapping("/{idEndereco}")
    public EnderecoDTO update(@PathVariable Integer idEndereco,
                           @Valid @RequestBody EnderecoCreateDTO enderecoPut) throws Exception{
        return enderecoService.update(idEndereco, enderecoPut);
    }

    @Operation(summary = "Deletar endereço.")
    @ApiResponses(
            value = {
                    @ApiResponse(responseCode = "200", description = "Caso o endereço for removido com sucesso."),
                    @ApiResponse(responseCode = "404", description = "Retorna um error caso o endreço não exista"),
                    @ApiResponse(responseCode = "500", description = "Error interno no servidor")
            }
    )
    @DeleteMapping("/{idEndereco}")
    public void delete(@PathVariable Integer idEndereco) throws Exception {
        enderecoService.delete(idEndereco);
    }

}
