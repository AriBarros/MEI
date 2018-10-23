package com.ade.mei.model;

import javax.persistence.*;

@Entity
public class Endereco {
	
	@Id
	@GeneratedValue
	private Long id;
	
	@Column
	private String estado;
	
	@Column
	private String bairro;
	
	@Column 
	private String rua;
	
	@Column
	private String numero;
	
	@OneToOne(mappedBy = "endereco", cascade=CascadeType.ALL)
	private Mei mei;
	
	
	public Endereco ()
	{
		
	}


	public Long getId() {
		return id;
	}


	public void setId(Long id) {
		this.id = id;
	}


	public String getEstado() {
		return estado;
	}


	public void setEstado(String estado) {
		this.estado = estado;
	}


	public String getBairro() {
		return bairro;
	}


	public void setBairro(String bairro) {
		this.bairro = bairro;
	}


	public String getRua() {
		return rua;
	}


	public void setRua(String rua) {
		this.rua = rua;
	}


	public String getNumero() {
		return numero;
	}


	public void setNumero(String numero) {
		this.numero = numero;
	}


	public Mei getMei() {
		return mei;
	}


	public void setMei(Mei mei) {
		this.mei = mei;
	}
	
	
	
	
	
	
	
	

}
