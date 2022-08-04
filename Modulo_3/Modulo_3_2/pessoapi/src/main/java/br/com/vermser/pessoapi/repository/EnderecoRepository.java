package br.com.vermser.pessoapi.repository;

import br.com.vermser.pessoapi.entity.EnderecoEntity;
import br.com.vermser.pessoapi.entity.PessoaEntity;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface EnderecoRepository extends JpaRepository<EnderecoEntity, Integer> {

    List<EnderecoEntity> findByPessoas_idPessoa(Integer idPessoa);

    @Query("SELECT E FROM ENDERECO_PESSOA E WHERE E.pais = :pais  ")
    Page<EnderecoEntity> findByOrderPais(Pageable pageable, String pais);


}
