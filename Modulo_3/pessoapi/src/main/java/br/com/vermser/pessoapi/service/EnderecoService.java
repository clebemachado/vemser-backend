package br.com.vermser.pessoapi.service;

import br.com.vermser.pessoapi.dto.enderecos.EnderecoCreateDTO;
import br.com.vermser.pessoapi.dto.enderecos.EnderecoDTO;
import br.com.vermser.pessoapi.entity.Endereco;
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
    ObjectMapper objectMapper;

    public EnderecoDTO convertEnderecoParaEnderecoDTO(Endereco endereco){
        return objectMapper.convertValue(endereco, EnderecoDTO.class);
    }

    public Endereco convertEnderecoCreateDTOParaEndereco(EnderecoCreateDTO enderecoCDTO){
        return objectMapper.convertValue(enderecoCDTO, Endereco.class);
    }

    private Endereco getEnderecoPorID(Integer idEndereco) throws Exception {
        return  enderecoRepository.getEnderecoList()
                .stream()
                .filter(e -> e.getIdEndereco().equals(idEndereco))
                .findFirst()
                .orElseThrow(() -> new RegraDeNegocioException("Endereco do id " + idEndereco
                        + " não encontrado."));
    }

    public List<EnderecoDTO> pegarTodosOsEnderecos(){
        return enderecoRepository
                .pegarTodosOsEnderecos()
                .stream()
                .map(this::convertEnderecoParaEnderecoDTO)
                .collect(Collectors.toList());
    }

    public EnderecoDTO pegarEnderecoPorID(Integer idEndereco) throws Exception {
        return convertEnderecoParaEnderecoDTO(getEnderecoPorID(idEndereco));
    }

    public List<Endereco> pegarEnderecoPorPessoa(Integer idPessoa) throws Exception {
        pessoaService.buscarUsuarioPorId(idPessoa);
        return  enderecoRepository.getEnderecoList()
                .stream().filter(e -> e.getIdPessoa().equals(idPessoa))
                .collect(Collectors.toList());
    }

    public EnderecoDTO createEndereco(Integer idPessoa, EnderecoCreateDTO enderecoCDTO)
            throws Exception {
        pessoaService.buscarUsuarioPorId(idPessoa);
        Endereco endereco = convertEnderecoCreateDTOParaEndereco(enderecoCDTO);
        endereco.setIdPessoa(idPessoa);
        return convertEnderecoParaEnderecoDTO(enderecoRepository.createEndereco(endereco));
    }

    public EnderecoDTO update(Integer idEndereco, EnderecoCreateDTO enderecoCreateDTO) throws Exception{
        Endereco enderecoRecuperado = getEnderecoPorID(idEndereco);
        enderecoRecuperado.setCep(enderecoCreateDTO.getCep());
        enderecoRecuperado.setCidade(enderecoCreateDTO.getCidade());
        enderecoRecuperado.setComplemento(enderecoCreateDTO.getComplemento());
        enderecoRecuperado.setLogradouro(enderecoCreateDTO.getLogradouro());
        enderecoRecuperado.setNumero(enderecoCreateDTO.getNumero());
        enderecoRecuperado.setCidade(enderecoCreateDTO.getCidade());
        enderecoRecuperado.setEstado(enderecoCreateDTO.getEstado());
        enderecoRecuperado.setPais(enderecoCreateDTO.getPais());
        enderecoRecuperado.setTipo(enderecoCreateDTO.getTipo());
        return convertEnderecoParaEnderecoDTO(enderecoRecuperado);
    }

    public void delete(Integer idEndereco) throws Exception {
        enderecoRepository.getEnderecoList().remove(getEnderecoPorID(idEndereco));
    }

}
