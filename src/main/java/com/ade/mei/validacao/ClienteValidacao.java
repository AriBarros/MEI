package com.ade.mei.validacao;

public class ClienteValidacao {
	
	public boolean validarCpf(String cpf) {
		
		if(cpf.contains("^[a-Z]") || cpf.length() > 11) return false;
		
		return true;
	
	}

}
