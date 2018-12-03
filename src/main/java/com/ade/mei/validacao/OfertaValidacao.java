package com.ade.mei.validacao;

public class OfertaValidacao {
	
	public boolean validarPreco(String preco) {
		
		if(preco == null) return false;
		if(preco.isEmpty()) return false;
		if(preco.contains("-")) return false;
	
		return true;
	}
	

	public boolean validarDisponibilidade(String disponibilidade) {
		
		if(disponibilidade.contains("N") || disponibilidade.contains("n")) return false;
	
		return true;
	}
	
	
	
	

}
