package com.ade.mei.validacao;

public class ServicoValidacao {
	
	public boolean validarServico(String nome) {
		
		
		for (int i = 0; i < nome.length(); i++)  
			if (!Character.isAlphabetic((nome.charAt(i))) || nome == null)  return false;
	         
		return true;
		
		
	}
	
	
	
}