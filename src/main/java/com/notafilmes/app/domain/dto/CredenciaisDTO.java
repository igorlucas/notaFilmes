package com.notafilmes.app.domain.dto;

import javax.validation.constraints.NotNull;

public class CredenciaisDTO {
	
	@NotNull
	public String email;
	
	@NotNull
	public String senha;

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getSenha() {
		return senha;
	}

	public void setSenha(String senha) {
		this.senha = senha;
	}
	
	
}