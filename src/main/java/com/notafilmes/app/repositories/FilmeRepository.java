package com.notafilmes.app.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.notafilmes.app.domain.Filme;

@Repository
public interface FilmeRepository  extends JpaRepository<Filme, Integer> {
	
}
