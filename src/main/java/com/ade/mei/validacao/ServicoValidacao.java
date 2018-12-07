package com.ade.mei.validacao;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class ServicoValidacao {
	
	public boolean validarServico(String nome) {
		
		if(nome == null) return false;
		
        Pattern pattern = Pattern.compile("[0-9]");
  		Matcher match = pattern.matcher(nome);
              
        if(match.find()) return false;
        if(!nome.contains("^[a-Z]")) return false;
		if(nome.isEmpty()) return false;
		
	
        
    	
        return true;

		
	}
	
	
	
}