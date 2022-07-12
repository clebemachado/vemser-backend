package br.com.vermser.pessoapi.controller;

import br.com.vermser.pessoapi.dto.pessoa.PessoaCreateDTO;
import br.com.vermser.pessoapi.dto.pessoa.PessoaDTO;
import br.com.vermser.pessoapi.entity.PropertieReader;
import br.com.vermser.pessoapi.service.PessoaService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import lombok.SneakyThrows;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@Validated
@RestController
@RequestMapping(value = "/pessoa")
public class PessoaController {
    @Autowired
    private PessoaService pessoaService;

    @Autowired
    private PropertieReader propertieReader;

    @GetMapping("/getpropertie")
    public String getPropertieReader(){
        return propertieReader.getNome();
    }

    @Operation(summary = "Retorna uma lista de pessoas")
    @ApiResponses(
        value = {
                @ApiResponse(responseCode = "200", description = "Retorna a lista de pessoa"),
                @ApiResponse(responseCode = "500", description = "Error interno no servidor")
        }
    )
    @GetMapping
    public List<PessoaDTO> list(){
        return pessoaService.list();
    }

    @Operation(summary = "Retorna uma lista de pessoas filtrada pelo nome")
    @ApiResponses(
            value = {
                    @ApiResponse(responseCode = "200", description = "Retorna a lista de pessoa"),
                    @ApiResponse(responseCode = "500", description = "Error interno no servidor")
            }
    )
    @GetMapping("/byname") //pessoa/byname?nome=Rafa
    public List<PessoaDTO> listByName(@RequestParam("nome") String nome) {
        return pessoaService.listByName(nome);
    }

    @Operation(summary = "Retorna uma pessoa.")
    @ApiResponses(
            value = {
                    @ApiResponse(responseCode = "200", description = "Retorna uma pessoa caso a pessoa exista"),
                    @ApiResponse(responseCode = "404", description = "Retorna um error caso a pessoa não exista"),
                    @ApiResponse(responseCode = "500", description = "Error interno no servidor")
            }
    )
    @GetMapping("/{idPessoa}")
    public PessoaDTO getPessoaPorId(@PathVariable Integer idPessoa) throws Exception {
        return pessoaService.getPessoaPorId(idPessoa);
    }


    @Operation(summary = "Adiciona uma pessoa na lista")
    @ApiResponses(
            value = {
                    @ApiResponse(responseCode = "200", description = "Retorna uma pessoa caso os dados estejam validados"),
                    @ApiResponse(responseCode = "404", description = "Retorna um error informando os dados para serem validados"),
                    @ApiResponse(responseCode = "500", description = "Error interno no servidor")
            }
    )
    @PostMapping
    public ResponseEntity<PessoaDTO> create(@Valid @RequestBody PessoaCreateDTO pessoaCDTO){
        return ResponseEntity.ok(pessoaService.create(pessoaCDTO));
    }

    @Operation(summary = "Atualiza a pessoa")
    @ApiResponses(
            value = {
                    @ApiResponse(responseCode = "200", description = "Retorna uma pessoas com dados atualizados"),
                    @ApiResponse(responseCode = "400", description = "Retorna um erro se o id da pessoa não for encontrada"),
                    @ApiResponse(responseCode = "500", description = "Foi gerada uma exceção")
            }
    )
    @PutMapping("/{idPessoa}")
    public PessoaDTO update(@PathVariable Integer idPessoa,
                         @Valid @RequestBody PessoaCreateDTO pessoaAtualizar) throws Exception{
        return pessoaService.update(idPessoa, pessoaAtualizar);
    }

    @Operation(summary = "Remover uma pessoa da lista.")
    @ApiResponses(
            value = {
                    @ApiResponse(responseCode = "200", description = "Caso a operação for um sucesso"),
                    @ApiResponse(responseCode = "404", description = "Retorna um error caso a pessoa não exista"),
                    @ApiResponse(responseCode = "500", description = "Error interno no servidor")
            }
    )
    @DeleteMapping("/{idUsuario}")
    public void delete(@PathVariable Integer idUsuario) throws Exception {
        pessoaService.delete(idUsuario);
    }

}
