package br.com.vermser.pessoapi.documentation;

import br.com.vermser.pessoapi.dto.dadosPessoais.DadosPessoaisDTO;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@ApiResponses(
        value = {
                @ApiResponse(responseCode = "401", description = "Ação não autorizado."),
                @ApiResponse(responseCode = "500", description = "Error interno.")
        }
)
public interface DocumentationDadosPessoaController {

    @Operation(summary = "Retorna um dado pessoal.")
    @ApiResponses(
            value = {
                    @ApiResponse(responseCode = "200", description = "Sucesso ao buscar dados pessoais."),
                    @ApiResponse(responseCode = "404", description = "Error se cpf não existir"),
            }
    )
    public DadosPessoaisDTO get(@PathVariable String cpf);

    @Operation(summary = "Retorna uma lista de dados pessoais.")
    @ApiResponses(
            value = {
                    @ApiResponse(responseCode = "200", description = "Retorna uma lista de dados pessoais."),
            }
    )
    public List<DadosPessoaisDTO> getListPessoas();

    @Operation(summary = "Cria um dado pessoal.")
    @ApiResponses(
            value = {
                    @ApiResponse(responseCode = "200", description = "Sucesso ao criar contato pessoal."),
            }
    )
    public ResponseEntity<DadosPessoaisDTO> create(@Valid @RequestBody DadosPessoaisDTO dadosPessoaisDTO);

    @Operation(summary = "Atualiza um dado pessoal.")
    @ApiResponses(
            value = {
                    @ApiResponse(responseCode = "200", description = "Sucesso ao atualizar dados pessoais."),
                    @ApiResponse(responseCode = "404", description = "Error se cpf não existir"),
            }
    )
    public ResponseEntity<DadosPessoaisDTO> put(@PathVariable String cpf,
                                                @RequestBody  DadosPessoaisDTO dadosPessoaisDTO);

    @Operation(summary = "Deletar um dado pessoal.")
    @ApiResponses(
            value = {
                    @ApiResponse(responseCode = "200", description = "Sucesso ao deletar dados pessoais."),
                    @ApiResponse(responseCode = "404", description = "Error se cpf não existir"),
            }
    )
    public void delete(@PathVariable String cpf);

}




