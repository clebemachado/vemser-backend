package br.com.vermser.pessoapi.service;

import br.com.vermser.pessoapi.dto.enderecos.EnderecoCreateDTO;
import br.com.vermser.pessoapi.dto.enderecos.EnderecoDTO;
import br.com.vermser.pessoapi.entity.EnderecoEntity;
import br.com.vermser.pessoapi.entity.PessoaEntity;
import br.com.vermser.pessoapi.exceptions.RegraDeNegocioException;
import br.com.vermser.pessoapi.repository.EnderecoRepository;
import com.fasterxml.jackson.databind.ObjectMapper;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Slf4j
@Service
public class EnderecoService {

    @Autowired
    EnderecoRepository enderecoRepository;

    @Autowired
    PessoaService pessoaService;

    @Autowired
    EmailService emailService;

    @Autowired
    ObjectMapper objectMapper;

    public EnderecoDTO convertEnderecoParaEnderecoDTO(EnderecoEntity endereco){
        return objectMapper.convertValue(endereco, EnderecoDTO.class);
    }

    public EnderecoEntity convertEnderecoCreateDTOParaEndereco(EnderecoCreateDTO enderecoCDTO){
        return objectMapper.convertValue(enderecoCDTO, EnderecoEntity.class);
    }

    private EnderecoEntity getEnderecoPorID(Integer idEndereco) throws Exception {
        return  enderecoRepository.findById(idEndereco)
                .orElseThrow(() -> new RegraDeNegocioException("Endereco não encontrado."));
    }

    public List<EnderecoDTO> pegarTodosOsEnderecos(){
        return enderecoRepository
                .findAll()
                .stream()
                .map(this::convertEnderecoParaEnderecoDTO)
                .collect(Collectors.toList());
    }

    public EnderecoDTO pegarEnderecoPorID(Integer idEndereco) throws Exception {
        return convertEnderecoParaEnderecoDTO(getEnderecoPorID(idEndereco));
    }

//    public List<EnderecoDTO> pegarEnderecoPorPessoa(Integer idPessoa) throws Exception {
//        pessoaService.buscarUsuarioPorId(idPessoa);
//        return  enderecoRepository.findAll()
//                .stream().filter(e -> e.getIdPessoa().equals(idPessoa))
//                .map(this::convertEnderecoParaEnderecoDTO)
//                .collect(Collectors.toList());
//    }

    public EnderecoDTO createEndereco(Integer idPessoa, EnderecoCreateDTO enderecoCDTO)
            throws Exception {
        //PessoaEntity pessoa = pessoaService.findById(idPessoa);
        //EnderecoEntity endereco = convertEnderecoCreateDTOParaEndereco(enderecoCDTO);
        //EnderecoDTO enderecoDTO = convertEnderecoParaEnderecoDTO(enderecoRepository.save(endereco));
        //emailService.sendCreateEndereco(pessoaService.converterPessoaParaPessoaDTO(pessoa), enderecoDTO);
        //return enderecoDTO;
        return null;
    }

    public EnderecoDTO update(Integer idEndereco, EnderecoCreateDTO enderecoCreateDTO) throws Exception{
        EnderecoEntity enderecoRecuperado = getEnderecoPorID(idEndereco);
        String nomeEnderecoAntigo = enderecoRecuperado.getLogradouro();

        enderecoRecuperado.setCep(enderecoCreateDTO.getCep());
        enderecoRecuperado.setCidade(enderecoCreateDTO.getCidade());
        enderecoRecuperado.setComplemento(enderecoCreateDTO.getComplemento());
        enderecoRecuperado.setLogradouro(enderecoCreateDTO.getLogradouro());
        enderecoRecuperado.setNumero(enderecoCreateDTO.getNumero());
        enderecoRecuperado.setCidade(enderecoCreateDTO.getCidade());
        enderecoRecuperado.setEstado(enderecoCreateDTO.getEstado());
        enderecoRecuperado.setPais(enderecoCreateDTO.getPais());
        enderecoRecuperado.setTipo(enderecoCreateDTO.getTipo());

//        emailService.sendAlterarEndereco(
//                pessoaService.getPessoaPorId(enderecoRecuperado.getIdPessoa()),
//                enderecoCreateDTO,
//                nomeEnderecoAntigo
//                );
        return convertEnderecoParaEnderecoDTO(enderecoRepository.save(enderecoRecuperado));
    }

    public void delete(Integer idEndereco) throws Exception {
        EnderecoEntity endereco = getEnderecoPorID(idEndereco);
        enderecoRepository.delete(endereco);
//        emailService.sendExluirEndereco(
//                pessoaService.getPessoaPorId(endereco.getIdPessoa()),
//                endereco
//        );
    }

}
