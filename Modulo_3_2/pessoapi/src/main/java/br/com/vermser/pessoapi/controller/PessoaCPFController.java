package br.com.vermser.pessoapi.controller;

import br.com.vermser.pessoapi.dto.pessoacpf.PessoaCPFDTO;
import br.com.vermser.pessoapi.service.PessoaCPFService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/pcfp")
public class PessoaCPFController {
    @Autowired
    private PessoaCPFService pessoaCPFService;

    @GetMapping
    public List<PessoaCPFDTO> getPeople(){
        return pessoaCPFService.list();
    }

    @GetMapping("/idpessoa/{idUser}")
    public PessoaCPFDTO getPeopleID(@PathVariable Integer idUser) throws Exception {
        return pessoaCPFService.getById(idUser);
    }

    @GetMapping("/cpf/{cpf}")
    public PessoaCPFDTO getPeopleCpf(@PathVariable String cpf) throws Exception {
        return pessoaCPFService.getByCpf(cpf);
    }

    @PostMapping
    public void create(@RequestBody PessoaCPFDTO pessoaCPFDTO) throws Exception {
        System.out.println("AQUI\n" + pessoaCPFDTO);
        //return   pessoaCPFService.create(pessoaCPFDTO);
    }

    @DeleteMapping("/delete/{idUser}")
    public void delete(@PathVariable Integer idUser) throws Exception {
        pessoaCPFService.delete(idUser);
    }

}
