package br.com.vermser.pessoapi.repository;

import br.com.vermser.pessoapi.dto.relatorio.PessoaRelatorioDTO;
import br.com.vermser.pessoapi.entity.EnderecoEntity;
import br.com.vermser.pessoapi.entity.PessoaEntity;
import br.com.vermser.pessoapi.enums.TipoContato;
import feign.Param;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import java.util.List;
import java.util.Optional;


@Repository
public interface PessoaRepository extends JpaRepository<PessoaEntity, Integer> {

    List<PessoaEntity> findByNomeContainsIgnoreCase(String nome);

    PessoaEntity findByCpf(String cpf);

    public List<PessoaEntity> findByContatos_tipoContato(TipoContato tipoContato);

    @Query("select p from PESSOA p where p.cpf = :cpf")
    PessoaEntity getPessoaCPF(@Param("cpf") String cpf);

    @Query("SELECT e FROM ENDERECO_PESSOA e JOIN e.pessoas p where e.idEndereco =  :idPessoa")
    public EnderecoEntity findByEndereco(@Param("idPessoa") Integer idPessoa);

    @Query("SELECT p FROM PESSOA p where p.idPessoa = :idPessoa")
    public Optional<PessoaEntity> getPessoaDados(@Param("idPessoa") Integer idPessoa);

    @Query("SELECT p FROM PESSOA p")
    public List<PessoaEntity> getPessoaDados();

    @Query("SELECT new br.com.vermser.pessoapi.dto.relatorio.PessoaRelatorioDTO ( " +
            " p.idPessoa," +
            " p.nome," +
            " p.email," +
            " c.numero," +
            " e.cep," +
            " e.cidade," +
            " e.estado," +
            " e.pais," +
            " pt.nome" +
            ")" +
            " from PESSOA p " +
            " left join p.contatos c " +
            " left join p.enderecos e " +
            " left join p.pet pt " +
            " where (:idPessoa is null OR p.idPessoa = :idPessoa )")
    List<PessoaRelatorioDTO> getRelatorio(@Param("idPessoa") Integer idPessoa);

}