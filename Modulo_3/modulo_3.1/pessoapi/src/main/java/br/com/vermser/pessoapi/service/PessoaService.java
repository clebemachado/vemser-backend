package br.com.vermser.pessoapi.service;

import br.com.vermser.pessoapi.dto.pessoa.PessoaCreateDTO;
import br.com.vermser.pessoapi.dto.pessoa.PessoaDTO;
import br.com.vermser.pessoapi.dto.dadosPessoais.entity.Pessoa;
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

    public Pessoa converterPessoaCreateParaPessoa(PessoaCreateDTO pessoa) {
        return objectMapper.convertValue(pessoa, Pessoa.class);
    }

    public PessoaDTO converterPessoaParaPessoaDTO(Pessoa pessoa) {
        return objectMapper.convertValue(pessoa, PessoaDTO.class);
    }

    public Pessoa buscarUsuarioPorId(Integer idPessoa) throws Exception {
        return PessoaRepository.getListaPessoas()
                .stream()
                .filter(pessoa -> pessoa.getIdPessoa().equals(idPessoa))
                .findFirst()
                .orElseThrow( () -> new RegraDeNegocioException("Pessoa com Id " + idPessoa
                                + " não existe"));
    }

    public PessoaDTO getPessoaPorId(Integer idPessoa) throws Exception {
        return converterPessoaParaPessoaDTO(buscarUsuarioPorId(idPessoa));
    }

    public List<PessoaDTO> list() {
        return pessoaRepository.list()
                .stream()
                .map(this::converterPessoaParaPessoaDTO)
                .collect(Collectors.toList());
    }

    public List<PessoaDTO> listByName(String nome) {
        return PessoaRepository
                .getListaPessoas()
                .stream()
                .filter(pessoa -> pessoa.getNome()
                        .toUpperCase()
                        .contains(nome.toUpperCase()))
                .map(this::converterPessoaParaPessoaDTO)
                .collect(Collectors.toList());
    }

    public PessoaDTO create(PessoaCreateDTO pessoa) {
        Pessoa pessoaEntity = converterPessoaCreateParaPessoa(pessoa);
        pessoaEntity = pessoaRepository.create(pessoaEntity);
        PessoaDTO pessoaDTO = converterPessoaParaPessoaDTO(pessoaEntity);
        //emailService.sendCreatePessoa(pessoaDTO);
        return pessoaDTO;
    }

    public PessoaDTO update(Integer id, PessoaCreateDTO pessoaAtualizar) throws Exception {
        Pessoa pessoaRecuperada = buscarUsuarioPorId(id);
        pessoaRecuperada.setCpf(pessoaAtualizar.getCpf());
        pessoaRecuperada.setNome(pessoaAtualizar.getNome());
        pessoaRecuperada.setDataNascimento(pessoaAtualizar.getDataNascimento());
        PessoaDTO pessoaDTO = converterPessoaParaPessoaDTO(pessoaRecuperada);
        emailService.sendAlterarPessoa(pessoaDTO);
        return pessoaDTO;
    }

    public void delete(Integer id) throws Exception {
        Pessoa pessoaRecuperada = buscarUsuarioPorId(id);
        PessoaRepository.getListaPessoas().remove(pessoaRecuperada);
        emailService.sendExluirPessoa(converterPessoaParaPessoaDTO(pessoaRecuperada));
    }

}
