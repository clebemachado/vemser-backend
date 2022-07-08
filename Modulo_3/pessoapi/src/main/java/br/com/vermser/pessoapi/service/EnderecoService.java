package br.com.vermser.pessoapi.service;

import br.com.vermser.pessoapi.entity.Endereco;
import br.com.vermser.pessoapi.exceptions.RegraDeNegocioException;
import br.com.vermser.pessoapi.repository.EnderecoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class EnderecoService {

    @Autowired
    EnderecoRepository enderecoRepository;

    @Autowired
    PessoaService pessoaService;

    public List<Endereco> pegarTodosOsEnderecos(){
        return enderecoRepository.pegarTodosOsEnderecos();
    }

    private Endereco getEnderecoPorID(Integer idEndereco) throws Exception {
        return  enderecoRepository.getEnderecoList()
                .stream().filter(e -> e.getIdEndereco().equals(idEndereco))
                .findFirst()
                .orElseThrow(() -> new RegraDeNegocioException("Endereco não encontrado"));
    }

    public Endereco pegarEndereco(Integer idEndereco) throws Exception {
        return  getEnderecoPorID(idEndereco);
    }

    public List<Endereco> pegarEnderecoPorPessoa(Integer idPessoa) throws Exception {
        pessoaService.getPessoa(idPessoa);
        return  enderecoRepository.getEnderecoList()
                .stream().filter(e -> e.getIdPessoa().equals(idPessoa))
                .collect(Collectors.toList());
    }

    public Endereco createEndereco(Integer idPessoa, Endereco endereco) throws Exception {
        pessoaService.getPessoa(idPessoa);
        endereco.setIdPessoa(idPessoa);
        return enderecoRepository.createEndereco(endereco);
    }

    public Endereco update(Integer idEndereco, Endereco enderecoPut) throws Exception{
        Endereco enderecoRecuperado = getEnderecoPorID(idEndereco);

        enderecoRecuperado.setCep(enderecoPut.getCep());
        enderecoRecuperado.setCidade(enderecoPut.getCidade());
        enderecoRecuperado.setComplemento(enderecoPut.getComplemento());
        enderecoRecuperado.setLogradouro(enderecoPut.getLogradouro());
        enderecoRecuperado.setCidade(enderecoPut.getCidade());
        enderecoRecuperado.setEstado(enderecoPut.getEstado());
        enderecoRecuperado.setPais(enderecoPut.getPais());
        enderecoRecuperado.setTipo(enderecoPut.getTipo());

        return enderecoRecuperado;
    }

    public void delete(Integer idEndereco) throws Exception {
        enderecoRepository.getEnderecoList().remove(getEnderecoPorID(idEndereco));
    }

}
