package com.notafilmes.app.controllers;

import static org.springframework.http.MediaType.APPLICATION_JSON_VALUE;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.notafilmes.app.domain.Filme;
import com.notafilmes.app.domain.dto.FilmeMediaAvaliacaoDTO;
import com.notafilmes.app.domain.dto.NovoFilmeDTO;
import com.notafilmes.app.services.FilmeService;

@RestController
@RequestMapping(value = "/filmes")
public class FilmeController {

	private final FilmeService _filmeService;

	@Autowired(required = true)
	FilmeController(FilmeService filmeService) {
		_filmeService = filmeService;
	}

	@GetMapping(produces = APPLICATION_JSON_VALUE)
	public ResponseEntity<List<FilmeMediaAvaliacaoDTO>> listarFilmesMediaAvaliacao() {
		List<FilmeMediaAvaliacaoDTO> filmesAvaliacaoDTO = _filmeService.listarFilmesMediaAvaliacao();
		return ResponseEntity.ok().body(filmesAvaliacaoDTO);
	}

	@PostMapping(consumes = APPLICATION_JSON_VALUE, produces = APPLICATION_JSON_VALUE)
	public ResponseEntity<Filme> cadastrarFilme(@Valid @RequestBody NovoFilmeDTO novoFilmeDto) throws Exception {
		Filme filme = _filmeService.fromDTO(novoFilmeDto);
		try {
			filme = _filmeService.cadastrarFilme(filme);
		} catch (Exception e) {
			throw new Exception(e.getMessage());
		}
		return ResponseEntity.status(HttpStatus.CREATED).body(filme);
	}
}