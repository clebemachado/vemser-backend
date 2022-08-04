package br.com.vermser.pessoapi.documentation;

import br.com.vermser.pessoapi.anotations.MagiaResponse;
import br.com.vermser.pessoapi.dto.pet.PetCreateDTO;
import br.com.vermser.pessoapi.dto.pet.PetDTO;
import br.com.vermser.pessoapi.exceptions.PessoaException;
import br.com.vermser.pessoapi.exceptions.RegraDeNegocioException;
import io.swagger.v3.oas.annotations.Operation;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;

import javax.validation.Valid;
import java.util.List;

@MagiaResponse
public interface DocumentationPetController {

    @Operation(summary = "Retorna um pet filtrada pelo id.")
    public ResponseEntity<PetDTO> findById(Integer idPet) throws RegraDeNegocioException;

    @Operation(summary = "Retorna uma lista de pet")
    public ResponseEntity<List<PetDTO>> findAllPets() ;

    @Operation(summary = "Cria um pet.")
    public ResponseEntity<PetDTO> create(@PathVariable Integer idPessoa,
                                         @Valid @RequestBody PetCreateDTO petCreateDTO)
            throws PessoaException;

    @Operation(summary = "Atualiza um pet")
    public ResponseEntity<PetDTO> update(Integer idPet,
                            @Valid @RequestBody PetCreateDTO petCreateDTO) throws Exception;

    @Operation(summary = "Remover um pet.")
    public void delete(Integer idPet) throws Exception;

}




