package br.com.vermser.pessoapi.service;

import br.com.vermser.pessoapi.client.DadosPessoaisClient;
import br.com.vermser.pessoapi.dto.dadosPessoais.DadosPessoaisDTO;
import br.com.vermser.pessoapi.dto.pessoa.PessoaDTO;
import br.com.vermser.pessoapi.dto.pessoacpf.PessoaCPFDTO;
import br.com.vermser.pessoapi.entity.DadosPessoais;
import br.com.vermser.pessoapi.entity.PessoaCPF;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class PessoaCPFService {

    @Autowired
    private PessoaService pessoaService;

    @Autowired
    private DadosPessoaisClient client;

    @Autowired
    ObjectMapper objectMapper;

    private PessoaCPF pDTOconvertPCPF(PessoaDTO p){
        return objectMapper.convertValue(p, PessoaCPF.class);
    }

    private PessoaCPFDTO pCPFconvert2PCPFDTO(PessoaCPF dp){
        return objectMapper.convertValue(dp, PessoaCPFDTO.class);
    }

    private PessoaDTO pCPFconvert2PCPFDTO(PessoaCPFDTO pessoaCPFDTO){
        return objectMapper.convertValue(pessoaCPFDTO, PessoaDTO.class);
    }

    private DadosPessoaisDTO dadosPessoaconvertDPDTO(DadosPessoais dadosPessoais){
        return objectMapper.convertValue(dadosPessoais, DadosPessoaisDTO.class);
    }

    public List<PessoaCPFDTO> list(){
        List<PessoaCPFDTO> pessoaCPFS = new ArrayList<>();

        for(PessoaDTO p: pessoaService.list()){
            PessoaCPF pessoaCPF = new PessoaCPF();
            pessoaCPF = pDTOconvertPCPF(p);
            DadosPessoaisDTO dadosPessoais = new DadosPessoaisDTO();

            try {
                dadosPessoais = client.get(p.getCpf());
            } catch (Exception e){
                System.out.println("CPF NÃO CADASTRADO");
            }

            PessoaCPFDTO pessoaCPFDTO = pCPFconvert2PCPFDTO(pessoaCPF);
            pessoaCPFDTO.setDadosPessoais(dadosPessoais);
            pessoaCPFS.add(pessoaCPFDTO);
        }
        return pessoaCPFS;
    }

    public PessoaCPFDTO getById(Integer id) throws Exception {
        PessoaDTO pessoaDTO = pessoaService.getPessoaPorId(id);
        DadosPessoaisDTO dadosPessoaisDTO = new DadosPessoaisDTO();

        try {
            dadosPessoaisDTO = client.get(pessoaDTO.getCpf());
        } catch (Exception e) {
            System.out.println("CPF não cadastrado");
        }

        PessoaCPF pessoaCPF = pDTOconvertPCPF(pessoaDTO);
        PessoaCPFDTO pessoaCPFDTO =pCPFconvert2PCPFDTO(pessoaCPF);
        pessoaCPFDTO.setDadosPessoais(dadosPessoaisDTO);
        return pessoaCPFDTO;
    }

    public PessoaCPFDTO getByCpf(String cpf) throws Exception {

        DadosPessoaisDTO dadosPessoaisDTO = client.get(cpf);

        PessoaDTO pessoaDTO = pessoaService.buscarUsuarioPorCpf(dadosPessoaisDTO.getCpf());

        PessoaCPF pessoaCPF = pDTOconvertPCPF(pessoaDTO);
        PessoaCPFDTO pessoaCPFDTO =pCPFconvert2PCPFDTO(pessoaCPF);
        pessoaCPFDTO.setDadosPessoais(dadosPessoaisDTO);
        return pessoaCPFDTO;
    }

    public void delete(Integer idUser) throws Exception {
        PessoaCPFDTO pessoaCPFDTO = getById(idUser);
        try {
            client.delete(pessoaCPFDTO.getCpf());
        } catch (Exception e){
            System.out.println("PROVAVEL ERROR / USUARIO NAO CADASTROU DADOS");
        }

        pessoaService.delete(idUser);
    }

    public PessoaCPFDTO create(PessoaCPFDTO pessoaCPFDTO) throws Exception {
        client.post(pessoaCPFDTO.getDadosPessoais());
        PessoaDTO pessoaDTO = pessoaService.create(pCPFconvert2PCPFDTO(pessoaCPFDTO));
        pessoaCPFDTO.setIdPessoa(pessoaCPFDTO.getIdPessoa());
        return pessoaCPFDTO;
    }

}
