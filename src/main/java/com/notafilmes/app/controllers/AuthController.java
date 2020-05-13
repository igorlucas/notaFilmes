package com.notafilmes.app.controllers;

import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.notafilmes.app.security.JwtUtil;
import com.notafilmes.app.security.User;

@RestController
@RequestMapping(value = "/auth")
public class AuthController {

	private final JwtUtil _jwtUtil;

	@Autowired(required = true)
	AuthController(JwtUtil jwtUtil) {
		_jwtUtil = jwtUtil;
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