package br.com.vermser.pessoapi.repository;

import br.com.vermser.pessoapi.entity.ProfessorEntity;
import br.com.vermser.pessoapi.entity.pk.ProfessorPK;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ProfessorRepository extends JpaRepository<ProfessorEntity, ProfessorPK> {
}
