package br.com.vermser.pessoapi.controller;

import br.com.vermser.pessoapi.entity.ContatoEntity;
import br.com.vermser.pessoapi.entity.EnderecoEntity;
import br.com.vermser.pessoapi.repository.ContatoRepository;
import br.com.vermser.pessoapi.repository.EnderecoRepository;
import org.jetbrains.annotations.NotNull;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/p")
public class PaginacaoController {
    @Autowired
    private ContatoRepository contatoRepository;

    @Autowired
    private EnderecoRepository enderecoRepository;

    @GetMapping("/contato")
    public Page<ContatoEntity> getContatoPaginacao(Integer pagina,
                                          Integer quantidadeRegistro){
        return contatoRepository.findAll(getPagination(pagina, quantidadeRegistro, "descricao"));
    }

    @GetMapping("/endereco-cep")
    public Page<EnderecoEntity> getEnderecoPaginacao(Integer pagina, Integer quantidadeRegistro){
        return enderecoRepository.findAll(getPagination(pagina, quantidadeRegistro, "cep"));
    }

    @GetMapping("/endereco-pais")
    public Page<EnderecoEntity> getPaisPaginacao(Integer pagina, Integer quantidadeRegistro,
                                                 String pais){
        Pageable pageable = PageRequest.of(pagina, quantidadeRegistro);
        return enderecoRepository.findByOrderPais(pageable, pais);
    }

    @NotNull
    private Pageable getPagination(Integer pagina, Integer quantidadeRegistro, String filtro) {
        return PageRequest.of(pagina, quantidadeRegistro, Sort.by(filtro));
    }
}
