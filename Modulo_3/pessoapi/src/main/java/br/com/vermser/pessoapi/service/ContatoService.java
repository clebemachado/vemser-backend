package br.com.vermser.pessoapi.service;

import br.com.vermser.pessoapi.entity.Contato;
import br.com.vermser.pessoapi.entity.Pessoa;
import br.com.vermser.pessoapi.repository.ContatoRepository;

import java.util.List;

public class ContatoService {

    ContatoRepository contatoRepository;

    public ContatoService() {
        contatoRepository = new ContatoRepository();
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

    public Contato create(Contato contato) {
        return contatoRepository.create(contato);
    }
}
