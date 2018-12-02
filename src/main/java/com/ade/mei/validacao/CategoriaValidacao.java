package com.ade.mei.validacao;

public class CategoriaValidacao {
	
	public boolean validarNome(String nome) {
		
		for (int i = 0; i < nome.length(); i++) {
	          if (!Character.isAlphabetic((nome.charAt(i)))) {
	              
	        	  if(!nome.contains(" "))
	        	   return false;
	          }
	     }
			
		return true;
	
	}
	
}