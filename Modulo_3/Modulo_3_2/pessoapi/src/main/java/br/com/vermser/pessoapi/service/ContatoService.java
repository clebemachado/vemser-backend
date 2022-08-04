package br.com.vermser.pessoapi.service;

import br.com.vermser.pessoapi.dto.contato.ContatoCreateDTO;
import br.com.vermser.pessoapi.dto.contato.ContatoDTO;
import br.com.vermser.pessoapi.entity.ContatoEntity;
import br.com.vermser.pessoapi.entity.PessoaEntity;
import br.com.vermser.pessoapi.exceptions.ContatoException;
import br.com.vermser.pessoapi.exceptions.PessoaException;
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

    public ContatoDTO toContatoDTO(ContatoEntity contato){
        return objectMapper.convertValue(contato, ContatoDTO.class);
    }

    public ContatoEntity toContato(ContatoCreateDTO contatoCDTO){
        return objectMapper.convertValue(contatoCDTO, ContatoEntity.class);
    }

    private ContatoEntity getContatoByID(Integer idContato) throws Exception {
        return contatoRepository.findById(idContato)
                .orElseThrow(() -> new ContatoException("Contato não encontrado."));
    }

    public ContatoDTO findById(Integer idContato) throws Exception {
        return toContatoDTO(getContatoByID(idContato));
    }

    public List<ContatoDTO> list() {
        return contatoRepository.findAll()
                .stream()
                .map(this::toContatoDTO)
                .collect(Collectors.toList());
    }

    public List<ContatoDTO> listByIdUser(Integer idUser) {
        return contatoRepository.findAll()
                .stream()
                .filter(c -> c.getPessoa().getIdPessoa().equals(idUser))
                .map(this::toContatoDTO)
                .collect(Collectors.toList());
    }

    public ContatoDTO create(Integer idPessoa, ContatoCreateDTO contatoCDTO) throws PessoaException {
        PessoaEntity pessoaEntity = pessoaService.getPessoaById(idPessoa);
        ContatoEntity contatoEntity = toContato(contatoCDTO);
        contatoEntity.setPessoa(pessoaEntity);
        System.out.println(contatoEntity);
        return toContatoDTO(contatoRepository.save(contatoEntity));
    }

    public ContatoDTO updateContato(Integer idContato, ContatoCreateDTO contatoCDTO)
            throws Exception {
        ContatoEntity contatoRecuperado = getContatoByID(idContato);
        contatoRecuperado.setTipoContato(contatoCDTO.getTipoContato());
        contatoRecuperado.setDescricao(contatoCDTO.getDescricao());
        contatoRecuperado.setNumero(contatoCDTO.getNumero());
        contatoRepository.save(contatoRecuperado);
        return toContatoDTO(contatoRecuperado);
    }

    public void delete(Integer idContato) throws Exception {
        ContatoEntity contato = getContatoByID(idContato);
        contatoRepository.delete(contato);
    }
}
