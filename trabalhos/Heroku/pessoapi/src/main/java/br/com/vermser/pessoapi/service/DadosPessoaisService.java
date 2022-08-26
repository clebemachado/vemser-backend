package br.com.vermser.pessoapi.service;

import br.com.vermser.pessoapi.client.DadosPessoaisClient;
import br.com.vermser.pessoapi.dto.dadosPessoais.DadosPessoaisDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class DadosPessoaisService {

    @Autowired
    private DadosPessoaisClient client;

    public DadosPessoaisDTO get(String cpf){
        return client.get(cpf);
    };

    public List<DadosPessoaisDTO> getListPessoas(){
        return client.getAll();
    }

    public DadosPessoaisDTO create(DadosPessoaisDTO dadosPessoaisDTO)
    {
        return client.post(dadosPessoaisDTO);
    }

    public DadosPessoaisDTO put(String cpf, DadosPessoaisDTO dadosPessoaisDTO){
        return client.put(cpf, dadosPessoaisDTO);
    };

    public void delete(String cpf){
        client.delete(cpf);
    }
}
