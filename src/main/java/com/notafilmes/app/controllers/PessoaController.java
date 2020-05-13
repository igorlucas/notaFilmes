package com.notafilmes.app.controllers;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.notafilmes.app.domain.Pessoa;
import com.notafilmes.app.domain.dto.NovaPessoaDTO;
import com.notafilmes.app.services.PessoaService;

import static org.springframework.http.MediaType.APPLICATION_JSON_VALUE;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;

@RestController
@RequestMapping(value = "/pessoas")
public class PessoaController {

	private final PessoaService _pessoaService;

	@Autowired(required = true)
	PessoaController(PessoaService pessoaService) {
		_pessoaService = pessoaService;
	}

	@GetMapping(produces = APPLICATION_JSON_VALUE)
	public ResponseEntity<List<Pessoa>> listarPessoas() {
		List<Pessoa> pessoas = _pessoaService.listarPessoas();
		return ResponseEntity.ok().body(pessoas);
	}

	@PostMapping(consumes = APPLICATION_JSON_VALUE, produces = APPLICATION_JSON_VALUE)
	public ResponseEntity<Pessoa> cadastrarPessoa(@Valid @RequestBody NovaPessoaDTO novaPessoaDto) throws Exception {
		Pessoa pessoa = _pessoaService.fromDTO(novaPessoaDto);
		try {
			pessoa = _pessoaService.cadastrarPessoa(pessoa);
		} catch (Exception e) {
			throw new Exception(e.getMessage());
		}
		return ResponseEntity.status(HttpStatus.CREATED).body(pessoa);
	}
}
