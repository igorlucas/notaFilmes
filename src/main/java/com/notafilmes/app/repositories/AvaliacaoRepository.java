package com.notafilmes.app.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.notafilmes.app.domain.Avaliacao;

@Repository
public interface AvaliacaoRepository  extends JpaRepository<Avaliacao, Integer> {

}
