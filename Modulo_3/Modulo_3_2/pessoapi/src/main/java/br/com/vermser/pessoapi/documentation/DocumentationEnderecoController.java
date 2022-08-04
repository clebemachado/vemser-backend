package br.com.vermser.pessoapi.documentation;

import br.com.vermser.pessoapi.anotations.MagiaResponse;
import br.com.vermser.pessoapi.dto.enderecos.EnderecoCreateDTO;
import br.com.vermser.pessoapi.dto.enderecos.EnderecoDTO;
import br.com.vermser.pessoapi.entity.EnderecoEntity;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@MagiaResponse
public interface DocumentationEnderecoController {

    @Operation(summary = "Retorna uma lista de endereço.")
    public List<EnderecoDTO> pegarTodosOsEnderecos();

    @Operation(summary = "Retorna um endereço específico.")
    public EnderecoDTO pegarEnderecoPorID(@PathVariable Integer idEndereco) throws Exception;

    @Operation(summary = "Retorna uma lista de endereço de um determinado id.")
    public ResponseEntity<List<EnderecoDTO>> pegarEnderecoPorPessoa(@PathVariable Integer idPessoa) throws Exception;

    @Operation(summary = "Cria um novo endereço.")
    public EnderecoDTO createEndereco(@PathVariable Integer idPessoa,
                                      @Valid @RequestBody EnderecoCreateDTO endereco) throws Exception ;

    @Operation(summary = "Atualiza o endereço")
    public EnderecoDTO update(@PathVariable Integer idEndereco,
                              @Valid @RequestBody EnderecoCreateDTO enderecoPut) throws Exception;

    @Operation(summary = "Deletar endereço.")
    public void delete(@PathVariable Integer idEndereco) throws Exception;

}




