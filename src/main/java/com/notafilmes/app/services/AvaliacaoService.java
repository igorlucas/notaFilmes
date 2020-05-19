package com.notafilmes.app.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.notafilmes.app.domain.Avaliacao;
import com.notafilmes.app.domain.Filme;
import com.notafilmes.app.domain.dto.NovaAvaliacaoDTO;
import com.notafilmes.app.repositories.AvaliacaoRepository;

@Service
public class AvaliacaoService {

	private final AvaliacaoRepository _avaliacaoRepository;

	@Autowired(required = true)
	AvaliacaoService(AvaliacaoRepository avaliacaoRepository) {
		_avaliacaoRepository = avaliacaoRepository;
	}
	
	public Avaliacao cadastrarAvaliacao(Avaliacao avaliacao) throws Exception {
		
		Avaliacao avaliacaoBD = _avaliacaoRepository.findByFilmeAndIp(avaliacao.getFilme(), avaliacao.getIp());
		if(avaliacaoBD != null){
			avaliacao.setId(avaliacaoBD.getId());	
		}
		return _avaliacaoRepository.save(avaliacao);
	}

	public Avaliacao fromDTO(NovaAvaliacaoDTO novaAvaliacaoDto) {
		Filme filme = new Filme();
		filme.setId(novaAvaliacaoDto.getFilme_id());
		Avaliacao avaliacao = new Avaliacao();
		avaliacao.setFilme(filme);
		avaliacao.setIp(novaAvaliacaoDto.getIp());
		avaliacao.setComentario(novaAvaliacaoDto.getComentario());
		avaliacao.setNota(novaAvaliacaoDto.getNota());
		return avaliacao;
	}
	
}