package com.ade.mei.teste;

import static org.junit.Assert.*;

import org.junit.Test;

import br.edu.ifal.servico.ServicoValidacao;
import junit.framework.Assert;

public class ServicoValidacaoTest {

	public void naoValidarNomeComNumeros() {
		
		String nome = "Consert0";
		
		com.ade.mei.validacao.ServicoValidacao servico = new com.ade.mei.validacao.ServicoValidacao();
		boolean validacaoDoServicoRetornada = servico.validarServico(nome);
		Assert.assertEquals(false, validacaoDoServicoRetornada);
			
			
	}
	
	public void naoValidarNomeComCaracteresEspeciais() {
		
		String nome = "Cons&rto";
		
		com.ade.mei.validacao.ServicoValidacao servico = new com.ade.mei.validacao.ServicoValidacao();
		boolean validacaoDoUsuarioRetornada = servico.validarServico(nome);
		Assert.assertEquals(false, validacaoDoUsuarioRetornada);
		
	}
	
	public void naoValidarNomeNulo() {
		
		String nome = null;
		
		com.ade.mei.validacao.ServicoValidacao servico = new com.ade.mei.validacao.ServicoValidacao();
		boolean validacaoDoUsuarioRetornada = servico.validarServico(nome);
		Assert.assertEquals(false, validacaoDoUsuarioRetornada);
		
	}
	
	public void naoValidarNomeVazio() {
		
		String nome = "";
		
		com.ade.mei.validacao.ServicoValidacao servico = new com.ade.mei.validacao.ServicoValidacao();
		boolean validacaoDoUsuarioRetornada = servico.validarServico(nome);
		Assert.assertEquals(false, validacaoDoUsuarioRetornada);
		
	}
	
	
	

}
