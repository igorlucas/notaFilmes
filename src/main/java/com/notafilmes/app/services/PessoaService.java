package com.notafilmes.app.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import com.notafilmes.app.domain.Pessoa;
import com.notafilmes.app.domain.dto.NovaPessoaDTO;
import com.notafilmes.app.repositories.PessoaRepository;

@Service
public class PessoaService {

	private final PessoaRepository _pessoaRepository;
	
	private BCryptPasswordEncoder _pe;
	
	@Autowired(required = true)
	PessoaService(PessoaRepository pessoaRepository, BCryptPasswordEncoder pe){
		_pessoaRepository = pessoaRepository;
		_pe = pe;
	}
	
	public Pessoa cadastrarPessoa(Pessoa pessoa){
		return _pessoaRepository.save(pessoa);
	}
	
	public List<Pessoa> listarPessoas(){
		return _pessoaRepository.findAll();
	}
	
	public Pessoa fromDTO(NovaPessoaDTO novaPessoaDto) {
		return new Pessoa(
				null, 
				novaPessoaDto.getNome(), 
				novaPessoaDto.getEmail(), 
				_pe.encode(novaPessoaDto.getSenha()), 
				novaPessoaDto.getFotoPerfil());	
	}
}