package br.com.vermser.pessoapi.repository;

import br.com.vermser.pessoapi.entity.Contato;
import br.com.vermser.pessoapi.entity.Pessoa;
import br.com.vermser.pessoapi.enums.TipoContato;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.stream.Collectors;

public class ContatoRepository {

    private static List<Contato> listaContatos = new ArrayList<>();
    private AtomicInteger COUNTER = new AtomicInteger();

    public ContatoRepository() {
        listaContatos.add(new Contato(COUNTER.incrementAndGet(), 1, 1234567,"Residencial", TipoContato.COMERCIAL));
        listaContatos.add(new Contato(COUNTER.incrementAndGet(), 1, 9874561,"Comercial", TipoContato.COMERCIAL));
        listaContatos.add(new Contato(COUNTER.incrementAndGet(),2, 7654321,"Comercial", TipoContato.RESIDENCIAL));
    }

    public List<Contato> listarContatos() {
        System.out.println("LISTA DE CONTATOS " + listaContatos);
        return listaContatos;
    }

    public List<Contato> listById(Integer idUser) {
        return listaContatos.stream()
                .filter(c -> c.getIdPessoa().equals(idUser))
                .collect(Collectors.toList());
    }

    public Contato updateContato(Integer idContato,
                         Contato contatoAtualizar) throws Exception {
        Contato contatoRecuperado = listaContatos.stream()
                .filter(c -> c.getIdContato().equals(idContato))
                .findFirst()
                .orElseThrow(() -> new Exception("Pessoa não econtrada"));

        contatoRecuperado.setTipoContato(contatoAtualizar.getTipoContato());
        contatoRecuperado.setDescricao(contatoAtualizar.getDescricao());
        contatoRecuperado.setNumero(contatoAtualizar.getNumero());

        return contatoRecuperado;
    }

    public void delete(Integer idContato) throws Exception {
        Contato contatoRecuperado = listaContatos.stream()
                .filter(c -> c.getIdContato().equals(idContato))
                .findFirst()
                .orElseThrow(() -> new Exception("Pessoa não econtrada"));

        listaContatos.remove(contatoRecuperado);
    }

    public Contato create(Contato contato) {

        contato.setIdContato(COUNTER.incrementAndGet());
        listaContatos.add(contato);
        return contato;
    }

}
