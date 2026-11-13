package com.javanauta.agenda_tarefa.infrastructure.repository;

import com.javanauta.agenda_tarefa.infrastructure.entity.Endereco;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;


@Repository
public interface EnderecoRepository extends JpaRepository<Endereco, Long> {
}
