package com.notafilmes.app.domain.dto;

import java.util.Arrays;
import java.util.Date;
import java.util.List;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.notafilmes.app.domain.Avaliacao;
import com.notafilmes.app.domain.Filme;

public class FilmeMediaAvaliacaoDTO {

	private Integer id;
	
	private String titulo;
	
	private String sinopse;
	
	@JsonFormat(pattern="dd/MM/yyyy")
	private Date dataLancamento;
	
	private List<String> nomesProdutores;
		
	private List<String> nomesProtagonistas;
	
	private List<Avaliacao> avaliacoes;

	private double mediaAvaliacao;
	
	public FilmeMediaAvaliacaoDTO(Filme filme) {
		this.id = filme.getId();
		this.titulo = filme.getTitulo();
		this.sinopse = filme.getSinopse();
		this.dataLancamento = filme.getDataLancamento();
		this.nomesProdutores = Arrays.asList(filme.getNomesProdutores().split(";"));;
		this.nomesProtagonistas = Arrays.asList(filme.getNomesProtagonistas().split(";"));
		this.avaliacoes = filme.getAvaliacoes();
		this.mediaAvaliacao = calcularMediaAvaliacao();
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

	public List<Avaliacao> getAvaliacoes() {
		return avaliacoes;
	}

	public void setAvaliacoes(List<Avaliacao> avaliacoes) {
		this.avaliacoes = avaliacoes;
	}

	public double getMediaAvaliacao() {
		return mediaAvaliacao;
	}

	public void setMediaAvaliacao(double mediaAvaliacao) {
		this.mediaAvaliacao = mediaAvaliacao;
	}

	double calcularMediaAvaliacao(){
		return avaliacoes.stream()
				.map(Avaliacao::getNota)
				.mapToDouble(Integer::doubleValue).average().orElse(0.0);
	}
	
}