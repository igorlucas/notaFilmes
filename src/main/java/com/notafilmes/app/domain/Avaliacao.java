package com.notafilmes.app.domain;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.validation.constraints.Max;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.notafilmes.app.domain.dto.NovaAvaliacaoDTO;

@Entity
public class Avaliacao {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;

	@ManyToOne
	@JsonIgnore
	@JoinColumn(name = "pessoa_id")
	private Pessoa pessoa;

	private String comentario;

	@ManyToOne
	@JsonIgnore
	@JoinColumn(name = "filme_id")
	private Filme filme;

	@NotNull
	@Min(1)
	@Max(5)
	private int nota;

	public Avaliacao() {
	}

	public Avaliacao(NovaAvaliacaoDTO novaAvaliacaoDto) {
		this.pessoa.setId(novaAvaliacaoDto.getPessoa_id());
		this.filme.setId(novaAvaliacaoDto.getFilme_id());
		this.comentario = novaAvaliacaoDto.getComentario();
		this.nota = novaAvaliacaoDto.getNota();
	}

	public Avaliacao(int id, Pessoa pessoa, String comentario, Filme filme, int nota) {
		super();
		this.id = id;
		this.pessoa = pessoa;
		this.comentario = comentario;
		this.filme = filme;
		this.nota = nota;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public Pessoa getPessoa() {
		return pessoa;
	}

	public void setPessoa(Pessoa pessoa) {
		this.pessoa = pessoa;
	}

	public String getComentario() {
		return comentario;
	}

	public void setComentario(String comentario) {
		this.comentario = comentario;
	}

	public Filme getFilme() {
		return filme;
	}

	public void setFilme(Filme filme) {
		this.filme = filme;
	}

	public int getNota() {
		return nota;
	}

	public void setNota(int nota) {
		this.nota = nota;
	}

}