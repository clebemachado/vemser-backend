package br.com.vermser.pessoapi.documentation;

import br.com.vermser.pessoapi.dto.dadosPessoais.entity.Endereco;
import br.com.vermser.pessoapi.dto.enderecos.EnderecoCreateDTO;
import br.com.vermser.pessoapi.dto.enderecos.EnderecoDTO;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@ApiResponses(
        value = {
                @ApiResponse(responseCode = "401", description = "Ação não autorizado."),
                @ApiResponse(responseCode = "500", description = "Error interno.")
        }
)
public interface DocumentationEnderecoController {

    @Operation(summary = "Retorna uma lista de endereço.")
    @ApiResponses(
            value = {
                    @ApiResponse(responseCode = "200", description = "Retorna um lista contendo endereços "),
            }
    )
    public List<EnderecoDTO> pegarTodosOsEnderecos();

    @Operation(summary = "Retorna um endereço específico.")
    @ApiResponses(
            value = {
                    @ApiResponse(responseCode = "200", description = "Retorna um determinado endereço "),
                    @ApiResponse(responseCode = "404", description = "Retorna um error caso o endereço não exista"),
            }
    )
    public EnderecoDTO pegarEnderecoPorID(@PathVariable Integer idEndereco) throws Exception;

    @Operation(summary = "Retorna uma lista de endereço de um determinado id.")
    @ApiResponses(
            value = {
                    @ApiResponse(responseCode = "200", description = "Retorna uma lista de endereço filtrada por endereço caso o id da pessoa exista"),
                    @ApiResponse(responseCode = "404", description = "Retorna um error caso a pessoa não exista"),
            }
    )
    public List<Endereco> pegarEnderecoPorPessoa(@PathVariable Integer idPessoa) throws Exception;

    @Operation(summary = "Cria um novo endereço.")
    @ApiResponses(
            value = {
                    @ApiResponse(responseCode = "200", description = "Retorna o endereço criado"),
                    @ApiResponse(responseCode = "404", description = "Retorna um error caso os dados não sejam válidos"),
            }
    )
    @PostMapping("/{idPessoa}")
    public EnderecoDTO createEndereco(@PathVariable Integer idPessoa,
                                      @Valid @RequestBody EnderecoCreateDTO endereco) throws Exception ;

    @Operation(summary = "Atualiza o endereço")
    @ApiResponses(
            value = {
                    @ApiResponse(responseCode = "200", description = "Retorna um endereço com os dados atualizados"),
                    @ApiResponse(responseCode = "404", description = "Retorna um error caso o endereço não exista"),
            }
    )
    public EnderecoDTO update(@PathVariable Integer idEndereco,
                              @Valid @RequestBody EnderecoCreateDTO enderecoPut) throws Exception;

    @Operation(summary = "Deletar endereço.")
    @ApiResponses(
            value = {
                    @ApiResponse(responseCode = "200", description = "Caso o endereço for removido com sucesso."),
                    @ApiResponse(responseCode = "404", description = "Retorna um error caso o endreço não exista"),
            }
    )
    public void delete(@PathVariable Integer idEndereco) throws Exception;

}




