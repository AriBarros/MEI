package com.ade.mei.model;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.*;

import com.fasterxml.jackson.annotation.JsonIgnore;



@Entity
public class Servico {
	
	@Id
	@GeneratedValue
	private Long id;
	
	@Column(unique = true)
	private String nome;
	
	@Column 
	private String descricao;
	
	@OneToMany(mappedBy = "servico")
	private List<Mei> meis = new ArrayList<>();
	
	@OneToMany(mappedBy = "servico")
	private List<Oferta> ofertas = new ArrayList<>() ;
	
	@ManyToMany(mappedBy = "servicos")
	private List<Categoria> categorias = new ArrayList<>() ;
	
	public Servico ()
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

	public String getDescricao() {
		return descricao;
	}

	public void setDescricao(String descricao) {
		this.descricao = descricao;
	}

	
	@JsonIgnore
	public List<Mei> getMeis() {
		return meis;
	}

	public void setMeis(List<Mei> meis) {
		this.meis.clear();
		this.meis.addAll(meis);
	}

	
	@JsonIgnore
	public List<Oferta> getOfertas() {
		return ofertas;
	}

	public void setOfertas(List<Oferta> ofertas) {
		this.ofertas.clear();
		this.ofertas.addAll(ofertas);
	}

	@JsonIgnore
	public List<Categoria> getCategorias() {
		return categorias;
	}

	public void setCategorias(List<Categoria> categorias) {
		this.categorias.clear();
		this.categorias.addAll(categorias);
	}
	
	

	
	
	
	
	
	
	
	

}
