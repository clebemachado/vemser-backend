package br.com.vermser.pessoapi.service;

import br.com.vermser.pessoapi.entity.Contato;
import br.com.vermser.pessoapi.entity.Pessoa;
import br.com.vermser.pessoapi.repository.ContatoRepository;

import java.util.List;

public class ContatoService {

    private ContatoRepository contatoRepository;
    private PessoaService pessoaService;

    public ContatoService() {
        contatoRepository = new ContatoRepository();
        pessoaService = new PessoaService();
    }

    public List<Contato> listarContatos() {
        return contatoRepository.listarContatos();
    }


    public List<Contato> listById(Integer idUser) {
        return contatoRepository.listById(idUser);
    }

    public Contato updateContato(Integer idContato, Contato novoContato) throws Exception {
        return contatoRepository.updateContato(idContato, novoContato);
    }

    public void delete(Integer idContato) throws Exception {
         contatoRepository.delete(idContato);
    }

    public Contato create(Integer idPessoa, Contato contato) throws Exception {
        pessoaService.getPessoa(idPessoa);
        contato.setIdPessoa(idPessoa);
        return contatoRepository.create(contato);
    }


}
