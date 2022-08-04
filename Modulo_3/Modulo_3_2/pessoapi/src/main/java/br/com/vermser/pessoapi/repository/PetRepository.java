package br.com.vermser.pessoapi.repository;

import br.com.vermser.pessoapi.entity.PetEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PetRepository extends JpaRepository<PetEntity, Integer> {
}
