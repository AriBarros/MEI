package com.ade.mei.validacao;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class ServicoValidacao {
	
	public boolean validarServico(String nome) {
		
		
        Pattern pattern = Pattern.compile("[0-9]");
  		Matcher match = pattern.matcher(nome);
              
        if(match.find() || nome == null || !nome.contains("^[a-Z]")) return false;
        
    	
        return true;

		
	}
	
	
	
}