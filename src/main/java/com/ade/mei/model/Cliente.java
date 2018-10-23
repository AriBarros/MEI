package com.ade.mei.model;

import javax.persistence.*;

@Entity
public class Cliente extends Usuario{

	@Column
	private String cpf;
	

	public String getCpf() {
		return cpf;
	}

	public void setCpf(String cpf) {
		this.cpf = cpf;
	}
	

	
	
	
	

}
