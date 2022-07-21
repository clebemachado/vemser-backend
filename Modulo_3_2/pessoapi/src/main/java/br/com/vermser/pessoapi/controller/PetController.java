package br.com.vermser.pessoapi.controller;

import br.com.vermser.pessoapi.documentation.DocumentationPetController;
import br.com.vermser.pessoapi.dto.pet.PetCreateDTO;
import br.com.vermser.pessoapi.dto.pet.PetDTO;
import br.com.vermser.pessoapi.exceptions.PessoaException;
import br.com.vermser.pessoapi.exceptions.RegraDeNegocioException;
import br.com.vermser.pessoapi.service.PetService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@Validated
@RestController
@RequestMapping("/pet")
public class PetController implements DocumentationPetController {

    @Autowired
    private PetService petService;

    @Override
    @GetMapping("/{idPet}")
    public ResponseEntity<PetDTO> findById(Integer idPet) throws RegraDeNegocioException {
        return ResponseEntity.ok(petService.findById(idPet));
    }

    @Override
    @GetMapping
    public ResponseEntity<List<PetDTO>> findAllPets() {
        return ResponseEntity.ok(petService.findAll());
    }

    @Override
    @PostMapping("/{idPessoa}")
    public ResponseEntity<PetDTO> create(@PathVariable Integer idPessoa,
                                         @Valid @RequestBody PetCreateDTO petCreateDTO)
            throws PessoaException {
        return ResponseEntity.ok(petService.create(idPessoa, petCreateDTO));
    }

    @Override
    @PutMapping("/{idPet}")
    public ResponseEntity<PetDTO> update(@PathVariable Integer idPet,
                                         @Valid @RequestBody PetCreateDTO petCreateDTO)
            throws Exception {
        return ResponseEntity.ok(petService.update(idPet, petCreateDTO));
    }

    @Override
    @DeleteMapping("/{idPet}")
    public void delete(Integer idPet) throws Exception {
        petService.delete(idPet);
    }
}
