package com.ade.mei.model;

import javax.persistence.*;

@Entity
public class Mei extends Usuario {
	
	@Column
	private String cnpj;
	
	@Column
	private String DescricaoPessoal;
	
	@OneToOne
	private Oferta oferta;
	
	@ManyToOne
	private Servico servico;
	
	@OneToOne
	private Endereco endereco;
	

	public String getCnpj() {
		return cnpj;
	}

	public void setCnpj(String cnpj) {
		this.cnpj = cnpj;
	}

	public String getDescricaoPessoal() {
		return DescricaoPessoal;
	}

	public void setDescricaoPessoal(String descricaoPessoal) {
		DescricaoPessoal = descricaoPessoal;
	}

	public Oferta getOferta() {
		return oferta;
	}

	public void setOferta(Oferta oferta) {
		this.oferta = oferta;
	}

	public Servico getServico() {
		return servico;
	}

	public void setServico(Servico servico) {
		this.servico = servico;
	}

	public Endereco getEndereco() {
		return endereco;
	}

	public void setEndereco(Endereco endereco) {
		this.endereco = endereco;
	}
	
	
	
	
	
	
	
	

}
