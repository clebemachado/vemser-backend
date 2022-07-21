package br.com.vermser.pessoapi.repository;

import br.com.vermser.pessoapi.entity.EnderecoEntity;
import br.com.vermser.pessoapi.entity.PessoaEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface EnderecoRepository extends JpaRepository<EnderecoEntity, Integer> {

    List<EnderecoEntity> findByPessoas_idPessoa(Integer idPessoa);

}
