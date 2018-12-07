package com.ade.mei.validacao;

public class MeiValidacao {
	
	public boolean validarCnpj(String cnpj) {
		
		if(cnpj == null) return false;
		
		if(cnpj.isEmpty()) return false;
		
		if(cnpj.length()>11) return false;
		
		if(!cnpj.matches("[0-9]+")) return false;
		
		
		return true;
	
	}

}
