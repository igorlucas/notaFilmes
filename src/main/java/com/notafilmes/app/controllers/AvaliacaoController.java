package com.notafilmes.app.controllers;

import static org.springframework.http.MediaType.APPLICATION_JSON_VALUE;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.notafilmes.app.domain.Avaliacao;
import com.notafilmes.app.domain.dto.NovaAvaliacaoDTO;
import com.notafilmes.app.services.AvaliacaoService;

@RestController
@RequestMapping(value="/avaliacoes")
public class AvaliacaoController {

	private final AvaliacaoService _avaliacaoService;
	
	@Autowired(required = true)
	AvaliacaoController(AvaliacaoService avaliacaoService){
		_avaliacaoService = avaliacaoService;
	}
	
	@PostMapping(consumes = APPLICATION_JSON_VALUE, produces = APPLICATION_JSON_VALUE)
    public ResponseEntity<Avaliacao> cadastrarAvaliacao(@Valid @RequestBody NovaAvaliacaoDTO novaAvaliacaoDto) throws Exception {
		Avaliacao avaliacao = _avaliacaoService.fromDTO(novaAvaliacaoDto);
		try {
			avaliacao = _avaliacaoService.cadastrarAvaliacao(avaliacao);	
		} catch (Exception e) {
			throw new Exception(e.getMessage());
		}
		return ResponseEntity
                .status(HttpStatus.CREATED)
                .body(avaliacao);
    }
}