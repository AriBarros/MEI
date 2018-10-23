package com.ade.mei.model;

import javax.persistence.*;

@Entity
public class Oferta {
	
	@Id
	@GeneratedValue
	private Long id;
	
	@Column
	private String preco;
	
	@Column 
	private String disponibilidade;
	
	@OneToOne(mappedBy = "oferta", cascade=CascadeType.ALL)
	private Mei mei;
	
	@ManyToOne
	private Servico servico;
	
	public Oferta ()
	{
		
	}


	public Long getId() {
		return id;
	}


	public void setId(Long id) {
		this.id = id;
	}


	public String getPreco() {
		return preco;
	}


	public void setPreco(String preco) {
		this.preco = preco;
	}


	public String getDisponibilidade() {
		return disponibilidade;
	}


	public void setDisponibilidade(String disponibilidade) {
		this.disponibilidade = disponibilidade;
	}


	public Mei getMei() {
		return mei;
	}


	public void setMei(Mei mei) {
		this.mei = mei;
	}


	public Servico getServico() {
		return servico;
	}


	public void setServico(Servico servico) {
		this.servico = servico;
	}
	
	
	
	
	
	
	
	

}
