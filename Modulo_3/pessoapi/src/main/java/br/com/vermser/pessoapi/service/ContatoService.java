package br.com.vermser.pessoapi.service;

import br.com.vermser.pessoapi.entity.Contato;
import br.com.vermser.pessoapi.exceptions.RegraDeNegocioException;
import br.com.vermser.pessoapi.repository.ContatoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class ContatoService {

    @Autowired
    private ContatoRepository contatoRepository;

    @Autowired
    private PessoaService pessoaService;

    public List<Contato> listarContatos() {
        return contatoRepository.listarContatos();
    }


    public List<Contato> listById(Integer idUser) {
        return contatoRepository.listarContatos().stream()
                .filter(c -> c.getIdPessoa().equals(idUser))
                .collect(Collectors.toList());
    }

    public Contato updateContato(Integer idContato, Contato novoContato) throws Exception {
        Contato contatoRecuperado = getContatoByID(idContato);
        contatoRecuperado.setTipoContato(novoContato.getTipoContato());
        contatoRecuperado.setDescricao(novoContato.getDescricao());
        contatoRecuperado.setNumero(novoContato.getNumero());

        return contatoRecuperado;
    }

    private Contato getContatoByID(Integer idContato) throws Exception {
        return contatoRepository.listarContatos().stream()
                .filter(c -> c.getIdContato().equals(idContato))
                .findFirst()
                .orElseThrow(() -> new RegraDeNegocioException("Contato não econtrada"));
    }

    public void delete(Integer idContato) throws Exception {
        Contato contatoRecuperado = getContatoByID(idContato);
        contatoRepository.listarContatos().remove(contatoRecuperado);
    }

    public Contato create(Integer idPessoa, Contato contato) throws Exception {
        pessoaService.getPessoa(idPessoa);
        contato.setIdPessoa(idPessoa);
        return contatoRepository.create(contato);
    }
}
