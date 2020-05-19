package com.notafilmes.app.domain;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

import com.fasterxml.jackson.annotation.JsonFormat;

@Entity
public class Filme {
	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Integer id;
	
	@NotNull
	@Size(max = 50)
	private String titulo;
	
	@Size(min = 50, max = 1000)
	@NotNull
	private String sinopse;
	
	@JsonFormat(pattern="dd/MM/yyyy")
	@NotNull
	private Date dataLancamento;
	
	@NotNull
	private String nomesProdutores;
		
	@NotNull
	private String nomesProtagonistas;
	
	@OneToMany(mappedBy="filme")
	private List<Avaliacao> avaliacoes;

	public Filme() {
		this.avaliacoes = new ArrayList<Avaliacao>();
	}
	
	public Filme(Integer id, String titulo, String sinopse, Date dataLancamento, String nomesProdutores,
			String nomesProtagonistas) {
		super();
		this.id = id;
		this.titulo = titulo;
		this.sinopse = sinopse;
		this.dataLancamento = dataLancamento;
		this.nomesProdutores = nomesProdutores;
		this.nomesProtagonistas = nomesProtagonistas;
		this.avaliacoes = new ArrayList<Avaliacao>();
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getTitulo() {
		return titulo;
	}

	public void setTitulo(String titulo) {
		this.titulo = titulo;
	}

	public String getSinopse() {
		return sinopse;
	}

	public void setSinopse(String sinopse) {
		this.sinopse = sinopse;
	}

	public Date getDataLancamento() {
		return dataLancamento;
	}

	public void setDataLancamento(Date dataLancamento) {
		this.dataLancamento = dataLancamento;
	}

	public String getNomesProdutores() {
		return nomesProdutores;
	}

	public void setNomesProdutores(String nomesProdutores) {
		this.nomesProdutores = nomesProdutores;
	}

	public String getNomesProtagonistas() {
		return nomesProtagonistas;
	}

	public void setNomesProtagonistas(String nomesProtagonistas) {
		this.nomesProtagonistas = nomesProtagonistas;
	}

	public List<Avaliacao> getAvaliacoes() {
		return avaliacoes;
	}

	public void setAvaliacoes(List<Avaliacao> avaliacoes) {
		this.avaliacoes = avaliacoes;
	}
	
}