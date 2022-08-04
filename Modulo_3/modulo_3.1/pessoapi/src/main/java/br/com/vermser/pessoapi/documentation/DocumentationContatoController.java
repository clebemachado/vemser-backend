package br.com.vermser.pessoapi.documentation;

import br.com.vermser.pessoapi.dto.contato.ContatoCreateDTO;
import br.com.vermser.pessoapi.dto.contato.ContatoDTO;
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
public interface DocumentationContatoController {

    @Operation(summary = "Retorna uma lista de contatos.")
    @ApiResponses(
            value = {
                    @ApiResponse(responseCode = "200", description = "Sucesso ao buscar contato."),

            }
    )
    public List<ContatoDTO> list();

    @Operation(summary = "Retorna uma lista de contato do usuário.")
    @ApiResponses(
            value = {
                    @ApiResponse(responseCode = "200", description = "Sucesso ao buscar contatos do usuário."),
                    @ApiResponse(responseCode = "404", description = "Contato não encontrado.")
            }
    )
    public List<ContatoDTO> listById(@PathVariable Integer idUser);

    @Operation(summary = "Cria um contato.")
    @ApiResponses(
            value = {
                    @ApiResponse(responseCode = "200", description = "Sucesso ao criar um contato."),
                    @ApiResponse(responseCode = "404", description = "Pessoa não encontrado.")
            }
    )
    public ContatoDTO create(@PathVariable Integer idPessoa,
                             @Valid @RequestBody ContatoCreateDTO contato) throws Exception;

    @Operation(summary = "Atualiza o contato.")
    @ApiResponses(
            value = {
                    @ApiResponse(responseCode = "200", description = "Sucesso ao atualizar contato."),
                    @ApiResponse(responseCode = "404", description = "Contato não encontrado.")
            }
    )
    public ContatoDTO updateContato(@PathVariable Integer idContato,
                                    @Valid @RequestBody ContatoCreateDTO novoContato) throws Exception;

    @Operation(summary = "Remover contato.")
    @ApiResponses(
            value = {
                    @ApiResponse(responseCode = "200", description = "Sucesso ao remover contato."),
                    @ApiResponse(responseCode = "404", description = "Contato não encontrado.")
            }
    )
    public void delete(@PathVariable Integer idContato) throws Exception;
}
