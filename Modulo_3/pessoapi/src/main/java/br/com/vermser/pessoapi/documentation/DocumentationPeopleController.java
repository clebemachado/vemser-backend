package br.com.vermser.pessoapi.documentation;

import br.com.vermser.pessoapi.dto.pessoa.PessoaCreateDTO;
import br.com.vermser.pessoapi.dto.pessoa.PessoaDTO;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;

import javax.validation.Valid;
import java.util.List;

@ApiResponses(
        value = {
                @ApiResponse(responseCode = "401", description = "Ação não autorizado."),
                @ApiResponse(responseCode = "500", description = "Error interno.")
        }
)
public interface DocumentationPeopleController {

    @Operation(summary = "Retorna uma lista de pessoas")
    @ApiResponses(
            value = {
                    @ApiResponse(responseCode = "200", description = "Retorna a lista de pessoa"),
                    @ApiResponse(responseCode = "500", description = "Error interno no servidor")
            }
    )
    @GetMapping
    public List<PessoaDTO> list();

    @Operation(summary = "Retorna uma lista de pessoas filtrada pelo nome")
    @ApiResponses(
            value = {
                    @ApiResponse(responseCode = "200", description = "Retorna a lista de pessoa"),
                    @ApiResponse(responseCode = "500", description = "Error interno no servidor")
            }
    )
    public List<PessoaDTO> listByName(@RequestParam("nome") String nome);

    @Operation(summary = "Retorna uma pessoa.")
    @ApiResponses(
            value = {
                    @ApiResponse(responseCode = "200", description = "Sucesso ao buscar pessoa."),
                    @ApiResponse(responseCode = "404", description = "Pessoa não encontrada."),
            }
    )
    @GetMapping("/{idPessoa}")
    public PessoaDTO getPessoaPorId(@PathVariable Integer idPessoa) throws Exception;


    @Operation(summary = "Adiciona uma pessoa.")
    @ApiResponses(
            value = {
                    @ApiResponse(responseCode = "200", description = "Pessoa criada com sucesso."),
                    @ApiResponse(responseCode = "400", description = "Ops! Alguma coisa deu errada."),
            }
    )
    public ResponseEntity<PessoaDTO> create(@Valid @RequestBody PessoaCreateDTO pessoaCDTO);

    @Operation(summary = "Atualiza a pessoa")
    @ApiResponses(
            value = {
                    @ApiResponse(responseCode = "200", description = "Sucesso ao atualizar pessoa."),
                    @ApiResponse(responseCode = "400", description = "Error 400."),
                    @ApiResponse(responseCode = "404", description = "Pessoa não encontrada."),
            }
    )
    public PessoaDTO update(@PathVariable Integer idPessoa,
                            @Valid @RequestBody PessoaCreateDTO pessoaAtualizar) throws Exception;



    @Operation(summary = "Remover uma pessoa da lista.")
    @ApiResponses(
            value = {
                    @ApiResponse(responseCode = "200", description = "Sucesso ao remover Pessoa."),
                    @ApiResponse(responseCode = "404", description = "Pessoa não encontrada."),
            }
    )
    public void delete(@PathVariable Integer idUsuario) throws Exception;

}




