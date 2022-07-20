package br.com.vermser.pessoapi.documentation;

import br.com.vermser.pessoapi.anotations.MagiaResponse;
import br.com.vermser.pessoapi.dto.contato.ContatoCreateDTO;
import br.com.vermser.pessoapi.dto.contato.ContatoDTO;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@MagiaResponse
public interface DocumentationContatoController {

    @Operation(summary = "Retorna uma lista de contato do usuário.")
    public ResponseEntity<ContatoDTO> findById(@PathVariable Integer idUser) throws Exception;

    @Operation(summary = "Retorna uma lista de contatos.")
    public ResponseEntity<List<ContatoDTO>> list();

    @Operation(summary = "Cria um contato")
    public ContatoDTO create(@PathVariable Integer idPessoa, @Valid @RequestBody ContatoCreateDTO contato
                             ) throws Exception;

    @Operation(summary = "Atualiza o contato.")
    public ResponseEntity<ContatoDTO> updateContato(@PathVariable Integer idContato,
                                                    @Valid @RequestBody ContatoCreateDTO novoContato) throws Exception;

    @Operation(summary = "Remover contato.")
    public void delete(@PathVariable Integer idContato) throws Exception;

}
