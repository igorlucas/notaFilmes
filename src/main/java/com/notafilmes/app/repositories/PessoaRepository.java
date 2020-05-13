package com.notafilmes.app.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.notafilmes.app.domain.Pessoa;

@Repository
public interface PessoaRepository  extends JpaRepository<Pessoa, Integer> {
	Pessoa findByEmail(String email);
}
