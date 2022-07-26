package br.com.vermser.pessoapi.service;

import br.com.vermser.pessoapi.dto.contato.ContatoDTO;
import br.com.vermser.pessoapi.dto.enderecos.EnderecoDTO;
import br.com.vermser.pessoapi.dto.pessoa.PessoaCreateDTO;
import br.com.vermser.pessoapi.dto.pessoa.PessoaFullDTO;
import br.com.vermser.pessoapi.dto.pessoa.PessoaDTO;
import br.com.vermser.pessoapi.dto.pet.PetDTO;
import br.com.vermser.pessoapi.dto.relatorio.PessoaRelatorioDTO;
import br.com.vermser.pessoapi.dto.relatorio.PessoaRelatorioFull;
import br.com.vermser.pessoapi.entity.ContatoEntity;
import br.com.vermser.pessoapi.entity.EnderecoEntity;
import br.com.vermser.pessoapi.entity.PessoaEntity;
import br.com.vermser.pessoapi.entity.PetEntity;
import br.com.vermser.pessoapi.exceptions.PessoaException;
import br.com.vermser.pessoapi.repository.PessoaRepository;
import com.fasterxml.jackson.databind.ObjectMapper;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;
import java.util.stream.Stream;

@Service
@Slf4j
public class PessoaService {
    @Autowired
    private PessoaRepository pessoaRepository;

    @Autowired
    private ObjectMapper objectMapper;

    @Autowired
    private EmailService emailService;

    public PessoaEntity toPessoaEntity(PessoaFullDTO pessoa) {
        return objectMapper.convertValue(pessoa, PessoaEntity.class);
    }

    public PessoaEntity createToPessoaEntity(PessoaCreateDTO pessoa) {
        return objectMapper.convertValue(pessoa, PessoaEntity.class);
    }

    public PessoaCreateDTO createToPessoaDTO(PessoaEntity pessoa) {
        return objectMapper.convertValue(pessoa, PessoaCreateDTO.class);
    }

    public PessoaDTO toPessoaDTO(PessoaEntity pessoa) {
        return objectMapper.convertValue(pessoa, PessoaDTO.class);
    }

    public PetDTO toPetDTO(PetEntity petEntity) {
        return objectMapper.convertValue(petEntity, PetDTO.class);
    }

    public ContatoDTO toContatoDTO(ContatoEntity contato) {
        return objectMapper.convertValue(contato, ContatoDTO.class);
    }

    public EnderecoDTO toEnderecoDTO(EnderecoEntity endereco) {
        return objectMapper.convertValue(endereco, EnderecoDTO.class);
    }

    public PessoaEntity getPessoaById(Integer idPessoa) throws PessoaException {
        return pessoaRepository.findById(idPessoa)
                .orElseThrow(()-> new PessoaException("Error ao buscar pessoa."));
    }

    public PessoaDTO findById(Integer idPessoa) throws PessoaException {
        return toPessoaDTO(
                getPessoaById(idPessoa)
        );
    }

    private Stream<PessoaEntity> streamListPessoas(){
        return pessoaRepository.findAll().stream();
    }

    private Stream<PessoaEntity> streamOnePessoa(Integer idPessoa){
        return pessoaRepository.findById(idPessoa).stream();
    }

    public List<PessoaDTO> list() {
        return pessoaRepository
                .findAll()
                .stream()
                .map(this::toPessoaDTO)
                .collect(Collectors.toList());
    }

    public List<PessoaDTO> listByName(String nome) {
        return pessoaRepository
                .findAll()
                .stream()
                .filter(pessoa -> pessoa.getNome()
                        .toUpperCase()
                        .contains(nome.toUpperCase()))
                .map(this::toPessoaDTO)
                .collect(Collectors.toList());
    }

    public PessoaCreateDTO create(PessoaCreateDTO pessoa) {
        PessoaEntity pessoaEntity = createToPessoaEntity(pessoa);
        pessoaEntity = pessoaRepository.save(pessoaEntity);
        System.out.println("PESSOA CREATE " + pessoaEntity);
        //emailService.sendCreatePessoa(pessoaDTO);
        return createToPessoaDTO(pessoaEntity);
    }

    public PessoaCreateDTO update(Integer id, PessoaCreateDTO pessoaAtualizar) throws Exception {
        PessoaEntity pessoaRecuperada = toPessoaEntity(findById(id));
        pessoaRecuperada.setCpf(pessoaAtualizar.getCpf());
        pessoaRecuperada.setNome(pessoaAtualizar.getNome());
        pessoaRecuperada.setDataNascimento(pessoaAtualizar.getDataNascimento());
        pessoaRecuperada.setEmail(pessoaAtualizar.getEmail());

        //emailService.sendAlterarPessoa(pessoaDTO);
        return createToPessoaDTO(pessoaRepository.save(pessoaRecuperada));
    }

    public void delete(Integer id) throws Exception {
        PessoaEntity pessoaRecuperada = toPessoaEntity(findById(id));
        pessoaRepository.delete(pessoaRecuperada);
        //emailService.sendExluirPessoa(toPessoaDTO()(pessoaRecuperada));
    }

    public List<PessoaDTO> findByName(String nome){
         return pessoaRepository.findByNomeContainsIgnoreCase(nome)
                 .stream()
                 .map(this::toPessoaDTO)
                 .collect(Collectors.toList());
    }

    public PessoaDTO findByCpf(String cpf){
        return toPessoaDTO(pessoaRepository.findByCpf(cpf));
    }

    public List<PessoaDTO> listPessoaWithPet(Integer idPessoa){
        Stream<PessoaEntity> pessoaEntityStream =
                idPessoa == null ? streamListPessoas() : streamOnePessoa(idPessoa);

        return pessoaEntityStream.map(p -> {
            PessoaDTO pessoaDTO = toPessoaDTO(p);
            if(p.getPet() != null){
                pessoaDTO.setPet(toPetDTO(p.getPet()));
            }
            return pessoaDTO;
        }).collect(Collectors.toList());
    }

    public List<PessoaDTO> findByIdWithContact(Integer idPessoa) throws PessoaException {
        Stream<PessoaEntity> pessoaEntityStream =
                idPessoa == null ? streamListPessoas() : streamOnePessoa(idPessoa);
        return pessoaEntityStream
                .map(p->
                        {
                            PessoaDTO pessoaDTO = toPessoaDTO(p);
                            Set<ContatoEntity> contatos = p.getContatos();
                            if( contatos!= null){
                                Set<ContatoDTO> contatosDTO =
                                        contatos.stream()
                                                .map(this::toContatoDTO)
                                                .collect(Collectors.toSet());
                                pessoaDTO.setContatos(contatosDTO);
                            }
                            return pessoaDTO;
                        }
                ).collect(Collectors.toList());
    }

    public List<PessoaDTO> findByIdWithAddress(Integer idPessoa) throws PessoaException {
        Stream<PessoaEntity> pessoaEntityStream =
                idPessoa == null ? streamListPessoas() : streamOnePessoa(idPessoa);
        return pessoaEntityStream
                .map(p->
                        {
                            PessoaDTO pessoaDTO = toPessoaDTO(p);
                            Set<EnderecoEntity> enderecosSet = p.getEnderecos();
                            Set<EnderecoDTO> enderecos =
                                    enderecosSet.stream()
                                            .map(this::toEnderecoDTO)
                                            .collect(Collectors.toSet());
                            pessoaDTO.setEnderecos(enderecos);
                            return pessoaDTO;
                        }
                ).collect(Collectors.toList());
    }

    public List<PessoaDTO> getCompleto(Integer idPessoa) throws PessoaException {
        try {
            if(idPessoa == null) {
                return pessoaRepository.getPessoaDados()
                        .stream()
                        .map(this::streamMap)
                        .collect(Collectors.toList());
            } else {
                return pessoaRepository.getPessoaDados(idPessoa)
                        .stream()
                        .map(this::streamMap)
                        .collect(Collectors.toList());
            }
        } catch (Exception e) {
            throw new PessoaException("Error ao buscar pessoa");
        }
    }

    public List<PessoaRelatorioDTO> getRelatorio(Integer idPessoa){
        return pessoaRepository.getRelatorio(idPessoa);
    }

    private PessoaDTO streamMap(PessoaEntity p) {
        PessoaDTO pessoaDTO = toPessoaDTO(p);
        pessoaDTO.setContatos(p.getContatos()
                .stream()
                .map(this::toContatoDTO).collect(Collectors.toSet()));
        pessoaDTO.setPet(toPetDTO(p.getPet()));
        pessoaDTO.setEnderecos(p.getEnderecos()
                .stream().map(this::toEnderecoDTO)
                .collect(Collectors.toSet())
        );
        return pessoaDTO;
    }

}
