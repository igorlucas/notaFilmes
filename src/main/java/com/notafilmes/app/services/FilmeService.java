package com.notafilmes.app.services;


import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.notafilmes.app.domain.Filme;
import com.notafilmes.app.domain.dto.FilmeMediaAvaliacaoDTO;
import com.notafilmes.app.domain.dto.NovoFilmeDTO;
import com.notafilmes.app.repositories.FilmeRepository;

@Service
public class FilmeService {

	private final FilmeRepository _filmeRepository;

	@Autowired(required = true)
	FilmeService(FilmeRepository filmeRepository){
		_filmeRepository = filmeRepository;
	}
	
	public Filme cadastrarFilme(Filme filme) {	
		return _filmeRepository.save(filme);	
	}

	public List<FilmeMediaAvaliacaoDTO> listarFilmesMediaAvaliacao(){
		List<Filme> filmes = _filmeRepository.findAll(); 
		List<FilmeMediaAvaliacaoDTO> filmesMediaAvaliacaoDto = filmes.stream()
				.map(filme -> new FilmeMediaAvaliacaoDTO(filme)).collect(Collectors.toList());
		return filmesMediaAvaliacaoDto;
	}
	
	public List<Filme> listarFilmes(){
		return _filmeRepository.findAll();
	}
	
 	public Filme fromDTO(NovoFilmeDTO novoFilmeDto) {
 		String nomesProdutores = String.join(";", novoFilmeDto.getNomesProdutores());
		String nomesProtagonistas = String.join(";", novoFilmeDto.getNomesProtagonistas());
		return new Filme(
				null,
				novoFilmeDto.getTitulo(), 
				novoFilmeDto.getSinopse(), 
				novoFilmeDto.getDataLancamento(), 
				nomesProdutores, 
				nomesProtagonistas);
	}
}
