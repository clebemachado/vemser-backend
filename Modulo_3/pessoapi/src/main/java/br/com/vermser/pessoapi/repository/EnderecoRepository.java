package br.com.vermser.pessoapi.repository;

import br.com.vermser.pessoapi.dto.dadosPessoais.entity.Endereco;
import br.com.vermser.pessoapi.enums.TipoEndereco;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.atomic.AtomicInteger;

@Repository
public class EnderecoRepository {
    private AtomicInteger COUNTER = new AtomicInteger();
    private List<Endereco> enderecoList = new ArrayList<>();

    public EnderecoRepository(){
        enderecoList.add(new Endereco(COUNTER.incrementAndGet(), 1, TipoEndereco.COMERCIAL, "Alameda dois", 21, "Próximo do posto","65413000", "São Luís", "Maranhão", "Brasil"));
        enderecoList.add(new Endereco(COUNTER.incrementAndGet(),1, TipoEndereco.RESIDENCIAL, "Holandesa", 501, "","65048500", "São Luís", "Maranhão", "Brasil"));
        enderecoList.add(new Endereco(COUNTER.incrementAndGet(),5, TipoEndereco.RESIDENCIAL, "Avenida Tupy", 17, "Casa verde","64000020", "Teresina", "Piauí", "Brasil"));
    }

    public List<Endereco> getEnderecoList() {
        return enderecoList;
    }

    public List<Endereco> pegarTodosOsEnderecos(){
        return enderecoList;
    }

    public Endereco createEndereco(Endereco endereco){
        endereco.setIdEndereco(COUNTER.incrementAndGet());
        enderecoList.add(endereco);
        return endereco;
    }


}
