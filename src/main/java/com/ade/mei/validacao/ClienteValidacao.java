package com.ade.mei.validacao;

public class ClienteValidacao {
	
	public boolean validarCpf(String cpf) {
		
		if(cpf == null) return false;
		
		
		
		
		if(cpf.isEmpty()) return false;
		
		if(cpf.length()>11) return false;
		
		if(!cpf.matches("[0-9]+")) return false;
		
		
		return true;
	
	}

}
