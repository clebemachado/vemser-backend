package br.com.vermser.pessoapi.service;

import br.com.vermser.pessoapi.dto.pet.PetCreateDTO;
import br.com.vermser.pessoapi.dto.pet.PetDTO;
import br.com.vermser.pessoapi.entity.PessoaEntity;
import br.com.vermser.pessoapi.entity.PetEntity;
import br.com.vermser.pessoapi.exceptions.PessoaException;
import br.com.vermser.pessoapi.exceptions.RegraDeNegocioException;
import br.com.vermser.pessoapi.repository.PessoaRepository;
import br.com.vermser.pessoapi.repository.PetRepository;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class PetService {

    @Autowired
    private PetRepository petRepository;

    @Autowired
    private PessoaRepository pessoaRepository;

    @Autowired
    private PessoaService pessoaService;

    @Autowired
    private ObjectMapper objectMapper;

    private PetDTO toPetDto(PetEntity entity){
        return objectMapper.convertValue(entity, PetDTO.class);
    }

    private PetEntity toPetEntity(PetCreateDTO petCreateDTO){
        return objectMapper.convertValue(petCreateDTO, PetEntity.class);
    }

    private PetEntity getPetById(Integer id) throws RegraDeNegocioException {
        return petRepository.findById(id)
                .orElseThrow(()-> new RegraDeNegocioException("Erro ao buscar id"));
    }

    public PetDTO findById(Integer id) throws RegraDeNegocioException {
        return toPetDto(getPetById(id));
    }

    public List<PetDTO> findAll(){
        return petRepository.findAll()
                .stream()
                .map(this::toPetDto)
                .collect(Collectors.toList());
    }

    public PetDTO create(Integer idPessoa, PetCreateDTO petCreateDTO) throws PessoaException {
        PessoaEntity pessoaEntity = pessoaService.getPessoaById(idPessoa);
        PetEntity petEntity = toPetEntity(petCreateDTO);
        petEntity.setPessoa(pessoaEntity);
        petEntity = petRepository.save(petEntity);
        pessoaEntity.setPet(petEntity);
        pessoaRepository.save(pessoaEntity);
        return toPetDto(petEntity);
    }

    public PetDTO update(Integer idPet, PetCreateDTO petCreateDTO)
            throws Exception {
        PetEntity petEntity = getPetById(idPet);
        petEntity.setNome(petCreateDTO.getNome());
        petEntity.setTipo(petCreateDTO.getTipo());
        petRepository.save(petEntity);

        PessoaEntity pessoa = petEntity.getPessoa();
        pessoa.setPet(petEntity);
        pessoaRepository.save(pessoa);

        return toPetDto(petEntity);
    }

    public void delete(Integer idPet) throws RegraDeNegocioException {
        try {
            petRepository.deleteById(idPet);
        } catch (Exception e){
            throw  new RegraDeNegocioException("Error ao remover pet");
        }
    }

}
