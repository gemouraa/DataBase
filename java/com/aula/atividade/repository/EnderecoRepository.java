package com.aula.atividade.repository;

import com.aula.atividade.model.Endereco;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface EnderecoRepository extends JpaRepository<Endereco, Long> {
    Optional<Endereco> findByLogradouro(String logradouro);
}
