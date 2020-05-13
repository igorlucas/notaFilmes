package com.notafilmes.app.domain;

import java.util.HashSet;
import java.util.Set;
import java.util.stream.Collectors;

import javax.persistence.CollectionTable;
import javax.persistence.Column;
import javax.persistence.ElementCollection;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.validation.constraints.NotNull;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.notafilmes.app.domain.enums.Perfil;

@Entity
public class Pessoa {
		
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Integer id;
		
	@NotNull
	private String nome;
	
	@Column(unique=true)
	@NotNull
	private String email;
	
	@JsonIgnore
	@NotNull
	private String senha;
	
	private String fotoPerfil;


	@ElementCollection(fetch=FetchType.EAGER)
	@CollectionTable(name="PERFIS")
	private Set<Integer> perfis = new HashSet<Integer>();
	
	
	public Pessoa() {
		
	}


	public Pessoa(Integer id, String nome, String email, String senha,String fotoPerfil) {
		super();
		this.id = id;
		this.nome = nome;
		this.email = email;
		this.senha = senha;
		this.fotoPerfil = fotoPerfil;
		addPerfil(Perfil.PADRAO);
	}


	public Integer getId() {
		return id;
	}


	public void setId(Integer id) {
		this.id = id;
	}


	public String getNome() {
		return nome;
	}


	public void setNome(String nome) {
		this.nome = nome;
	}


	public String getEmail() {
		return email;
	}


	public void setEmail(String email) {
		this.email = email;
	}


	public String getFotoPerfil() {
		return fotoPerfil;
	}


	public void setFotoPerfil(String fotoPerfil) {
		this.fotoPerfil = fotoPerfil;
	}
	
	public String getSenha() {
		return senha;
	}


	public void setSenha(String senha) {
		this.senha = senha;
	}
	

	public Set<Perfil> getPerfis() {
		return perfis.stream().map(x -> Perfil.toEnum(x)).collect(Collectors.toSet());
	}
	
	public void addPerfil(Perfil perfil) {
		perfis.add(perfil.getCod());
	}
}
