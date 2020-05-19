package com.notafilmes.app.domain.dto;

import java.util.Date;
import java.util.List;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

public class NovoFilmeDTO  {

	@NotNull
	@Size(max = 20)
	private String titulo;
	
	@Size(min = 50, max = 1000)
	@NotNull
	private String sinopse;
	
	@NotNull
	private Date dataLancamento;
	
	private List<String> nomesProdutores;
		
	private List<String> nomesProtagonistas;
	
	
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

	public List<String> getNomesProdutores() {
		return nomesProdutores;
	}

	public void setNomesProdutores(List<String> nomesProdutores) {
		this.nomesProdutores = nomesProdutores;
	}

	public List<String> getNomesProtagonistas() {
		return nomesProtagonistas;
	}
	
	public void setNomesProtagonistas(List<String> nomesProtagonistas) {
		this.nomesProtagonistas = nomesProtagonistas;
	}	
	
}
