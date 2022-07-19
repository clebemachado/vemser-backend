package br.com.vermser.pessoapi.repository;

import br.com.vermser.pessoapi.dto.dadosPessoais.entity.Contato;
import br.com.vermser.pessoapi.enums.TipoContato;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.atomic.AtomicInteger;

@Repository
public class ContatoRepository {

    private static List<Contato> listaContatos = new ArrayList<>();
    private AtomicInteger COUNTER = new AtomicInteger();

    public ContatoRepository() {
        listaContatos.add(new Contato(COUNTER.incrementAndGet(), 1, "1234567","Residencial", TipoContato.COMERCIAL));
        listaContatos.add(new Contato(COUNTER.incrementAndGet(), 1, "9874561","Comercial", TipoContato.COMERCIAL));
        listaContatos.add(new Contato(COUNTER.incrementAndGet(),2, "7654321","Comercial", TipoContato.RESIDENCIAL));
    }

    public static List<Contato> getListaContatos() {
        return listaContatos;
    }

    public List<Contato> listarContatos() {
        return listaContatos;
    }

    public Contato create(Contato contato) {
        contato.setIdContato(COUNTER.incrementAndGet());
        listaContatos.add(contato);
        return contato;
    }

}
