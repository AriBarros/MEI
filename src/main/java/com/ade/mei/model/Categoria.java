package com.ade.mei.model;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.*;


@Entity
public class Categoria {
	
	@Id
	@GeneratedValue
	private Long id;
	
	@Column
	private String nome;
	
	@ManyToMany
	private List<Servico> servicos = new ArrayList<>();

	public Categoria ()
	{
		
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public List<Servico> getServicos() {
		return servicos;
	}

	public void setServicos(List<Servico> servicos) {
		this.servicos.clear();
		this.servicos.addAll(servicos);
	}
	
	
	
	
}
