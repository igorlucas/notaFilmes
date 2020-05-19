package com.notafilmes.app.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import com.notafilmes.app.domain.Avaliacao;
import com.notafilmes.app.domain.Filme;

@Repository
public interface AvaliacaoRepository extends JpaRepository<Avaliacao, Integer> {
	Avaliacao findByFilmeAndIp(Filme filme, String ip);
	boolean existsByFilmeAndIp(Filme filme, String ip);
}
