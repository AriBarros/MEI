package com.ade.mei.validacao;

public class MeiValidacao {
	
	public boolean validarCnpj(String cnpj) {
		
		if(cnpj.contains("^[a-Z]") || cnpj.length() > 11 || cnpj == null) return false;
		
		return true;
	
	}

}
