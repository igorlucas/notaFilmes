package com.notafilmes.app.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.notafilmes.app.domain.Avaliacao;
import com.notafilmes.app.domain.Filme;
import com.notafilmes.app.domain.Pessoa;
import com.notafilmes.app.domain.dto.NovaAvaliacaoDTO;
import com.notafilmes.app.repositories.AvaliacaoRepository;

@Service
public class AvaliacaoService {

	private final AvaliacaoRepository _avaliacaoRepository;

	@Autowired(required = true)
	AvaliacaoService(AvaliacaoRepository avaliacaoRepository) {
		_avaliacaoRepository = avaliacaoRepository;
	}

	public Avaliacao cadastrarAvaliacao(Avaliacao avaliacao) {
		return _avaliacaoRepository.save(avaliacao);
	}

	public Avaliacao fromDTO(NovaAvaliacaoDTO novaAvaliacaoDto) {
		Pessoa pessoa = new Pessoa();
		pessoa.setId(novaAvaliacaoDto.getPessoa_id());
		Filme filme = new Filme();
		filme.setId(novaAvaliacaoDto.getFilme_id());
		Avaliacao avaliacao = new Avaliacao();
					
		avaliacao.setPessoa(pessoa);
		avaliacao.setFilme(filme);
		avaliacao.setComentario(novaAvaliacaoDto.getComentario());
		avaliacao.setNota(novaAvaliacaoDto.getNota());
		return avaliacao;
	}

}