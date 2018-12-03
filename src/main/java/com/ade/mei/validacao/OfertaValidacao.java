package com.ade.mei.validacao;

public class OfertaValidacao {
	
	public boolean validarPreco(String preco) {
		
		if(preco.contains("-") || preco == null) return false;
	
		return true;
	}
	

	public boolean validarDisponibilidade(String disponibilidade) {
		
		if(disponibilidade.contains("N") || disponibilidade.contains("n")) return false;
	
		return true;
	}
	
	
	
	

}
