package com.notafilmes.app.domain.dto;

import javax.validation.constraints.Max;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;


public class NovaAvaliacaoDTO {
	
	@NotNull
	private Integer pessoa_id;

	@NotNull
	private Integer filme_id;
	
	private String comentario;
	
	@NotNull
	@Min(1)
	@Max(5)
	private int nota;
	
	NovaAvaliacaoDTO(){}

	public Integer getPessoa_id() {
		return pessoa_id;
	}

	public void setPessoa_id(Integer pessoa_id) {
		this.pessoa_id = pessoa_id;
	}

	public Integer getFilme_id() {
		return filme_id;
	}

	public void setFilme_id(Integer filme_id) {
		this.filme_id = filme_id;
	}

	public String getComentario() {
		return comentario;
	}

	public void setComentario(String comentario) {
		this.comentario = comentario;
	}

	public int getNota() {
		return nota;
	}

	public void setNota(int nota) {
		this.nota = nota;
	};
	
}
