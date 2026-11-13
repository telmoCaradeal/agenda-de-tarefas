package com.javanauta.agenda_tarefa.infrastructure.repository;

import com.javanauta.agenda_tarefa.infrastructure.entity.Telefone;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;


@Repository
public interface TelefoneRepository extends JpaRepository<Telefone, Long> {
}
