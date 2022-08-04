package br.com.vermser.pessoapi.service;

import br.com.vermser.pessoapi.dto.contato.ContatoCreateDTO;
import br.com.vermser.pessoapi.dto.contato.ContatoDTO;
import br.com.vermser.pessoapi.dto.dadosPessoais.entity.Contato;
import br.com.vermser.pessoapi.exceptions.RegraDeNegocioException;
import br.com.vermser.pessoapi.repository.ContatoRepository;
import com.fasterxml.jackson.databind.ObjectMapper;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
@Slf4j
public class ContatoService {

    @Autowired
    private ContatoRepository contatoRepository;

    @Autowired
    private PessoaService pessoaService;

    @Autowired
    private ObjectMapper objectMapper;

    public ContatoDTO converterContatoParaContatoDTO(Contato contato){
        return objectMapper.convertValue(contato, ContatoDTO.class);
    }

    public Contato converterContatoCreateDTOParaContato(ContatoCreateDTO contatoCDTO){
        return objectMapper.convertValue(contatoCDTO, Contato.class);
    }

    private Contato getContatoByID(Integer idContato) throws Exception {
        return contatoRepository.listarContatos().stream()
                .filter(c -> c.getIdContato().equals(idContato))
                .findFirst()
                .orElseThrow(() -> new RegraDeNegocioException("Contato com id "
                        + idContato + " não existe."));
    }

    public List<ContatoDTO> list() {
        return contatoRepository.listarContatos()
                .stream()
                .map(this::converterContatoParaContatoDTO)
                .collect(Collectors.toList());
    }

    public List<ContatoDTO> listById(Integer idUser) {
        return contatoRepository.listarContatos().stream()
                .filter(c -> c.getIdPessoa().equals(idUser))
                .map(this::converterContatoParaContatoDTO)
                .collect(Collectors.toList());
    }

    public ContatoDTO create(Integer idPessoa, ContatoCreateDTO contatoCDTO) throws Exception {
        pessoaService.buscarUsuarioPorId(idPessoa);
        Contato contato = converterContatoCreateDTOParaContato(contatoCDTO);
        contato.setIdPessoa(idPessoa);
        return converterContatoParaContatoDTO(contatoRepository.create(contato));
    }

    public ContatoDTO updateContato(Integer idContato, ContatoCreateDTO contatoCDTO)
            throws Exception {
        Contato contatoRecuperado = getContatoByID(idContato);
        contatoRecuperado.setTipoContato(contatoCDTO.getTipoContato());
        contatoRecuperado.setDescricao(contatoCDTO.getDescricao());
        contatoRecuperado.setNumero(contatoCDTO.getNumero());
        return converterContatoParaContatoDTO(contatoRecuperado);
    }

    public void delete(Integer idContato) throws Exception {
        contatoRepository.listarContatos().remove(getContatoByID(idContato));
    }
}
