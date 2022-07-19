package br.com.vermser.pessoapi.service;

import br.com.vermser.pessoapi.dto.pessoa.PessoaCreateDTO;
import br.com.vermser.pessoapi.dto.pessoa.PessoaDTO;
import br.com.vermser.pessoapi.entity.PessoaEntity;
import br.com.vermser.pessoapi.exceptions.RegraDeNegocioException;
import br.com.vermser.pessoapi.repository.PessoaRepository;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class PessoaService {
    @Autowired
    private PessoaRepository pessoaRepository;

    @Autowired
    private ObjectMapper objectMapper;

    @Autowired
    private EmailService emailService;

    public PessoaEntity converterPessoaCreateParaPessoa(PessoaCreateDTO pessoa) {
        return objectMapper.convertValue(pessoa, PessoaEntity.class);
    }

    public PessoaDTO converterPessoaParaPessoaDTO(PessoaEntity pessoa) {
        return objectMapper.convertValue(pessoa, PessoaDTO.class);
    }

    public PessoaEntity buscarUsuarioPorId(Integer idPessoa) throws Exception {
        return pessoaRepository.findById(idPessoa)
                .orElseThrow( () -> new RegraDeNegocioException("Pessoa não encontrada"));
    }

    public PessoaDTO buscarUsuarioPorCpf(String cpf) throws Exception {
        PessoaEntity pessoa = pessoaRepository.findAll()
                .stream()
                .filter(p -> p.getCpf().equals(cpf))
                .findFirst()
                .orElseThrow( () -> new RegraDeNegocioException("Pessoa com cpf " + cpf
                        + " não existe"));
        return converterPessoaParaPessoaDTO(pessoa);
    }

    public PessoaDTO getPessoaPorId(Integer idPessoa) throws Exception {
        return converterPessoaParaPessoaDTO(buscarUsuarioPorId(idPessoa));
    }

    public List<PessoaDTO> list() {
        return pessoaRepository
                .findAll()
                .stream()
                .map(this::converterPessoaParaPessoaDTO)
                .collect(Collectors.toList());
    }

    public List<PessoaDTO> listByName(String nome) {
        return pessoaRepository
                .findAll()
                .stream()
                .filter(pessoa -> pessoa.getNome()
                        .toUpperCase()
                        .contains(nome.toUpperCase()))
                .map(this::converterPessoaParaPessoaDTO)
                .collect(Collectors.toList());
    }

    public PessoaDTO create(PessoaCreateDTO pessoa) {
        PessoaEntity pessoaEntity = converterPessoaCreateParaPessoa(pessoa);
        pessoaEntity = pessoaRepository.save(pessoaEntity);
        //emailService.sendCreatePessoa(pessoaDTO);
        return converterPessoaParaPessoaDTO(pessoaEntity);
    }

    public PessoaDTO update(Integer id, PessoaCreateDTO pessoaAtualizar) throws Exception {
        PessoaEntity pessoaRecuperada = buscarUsuarioPorId(id);
        pessoaRecuperada.setCpf(pessoaAtualizar.getCpf());
        pessoaRecuperada.setNome(pessoaAtualizar.getNome());
        pessoaRecuperada.setDataNascimento(pessoaAtualizar.getDataNascimento());
        pessoaRecuperada.setEmail(pessoaAtualizar.getEmail());
        //emailService.sendAlterarPessoa(pessoaDTO);
        return converterPessoaParaPessoaDTO(pessoaRepository.save(pessoaRecuperada));
    }

    public void delete(Integer id) throws Exception {
        PessoaEntity pessoaRecuperada = buscarUsuarioPorId(id);
        pessoaRepository.delete(pessoaRecuperada);
        //emailService.sendExluirPessoa(converterPessoaParaPessoaDTO(pessoaRecuperada));
    }

}
