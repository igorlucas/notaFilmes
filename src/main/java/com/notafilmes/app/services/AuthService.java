package com.notafilmes.app.services;

import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.PostMapping;

import com.notafilmes.app.domain.Pessoa;
import com.notafilmes.app.repositories.PessoaRepository;
import com.notafilmes.app.security.JwtUtil;
import com.notafilmes.app.security.User;

@Service
public class AuthService implements UserDetailsService {

	private final JwtUtil _jwtUtil;
			
	private final PessoaRepository _pessoaRepository;
	
	@Autowired(required = true)
	AuthService(JwtUtil jwtUtil, PessoaRepository pessoaRepository){
		_jwtUtil = jwtUtil;
		_pessoaRepository = pessoaRepository;
	}
	
	@Override
	public UserDetails loadUserByUsername(String email) throws UsernameNotFoundException {
		Pessoa pessoa = _pessoaRepository.findByEmail(email);
		if (pessoa == null) {
			throw new UsernameNotFoundException(email);
		}
		return new User(pessoa.getId(), pessoa.getEmail(), pessoa.getSenha(), pessoa.getPerfis());
	}
	

	@PostMapping(value = "/refresh_token")
	public ResponseEntity<Void> refreshToken(HttpServletResponse response) {
		User user = User.authenticated();
		String token = _jwtUtil.generateToken(user.getUsername());
		response.addHeader("Authorization", "Bearer " + token);
		response.addHeader("access-control-expose-headers", "Authorization");
		return ResponseEntity.noContent().build();
	}
	
}
