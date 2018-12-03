package com.ade.mei.teste;

import static org.junit.Assert.*;

import org.junit.Test;

import junit.framework.Assert;

public class ServicoValidacaoTest {
	
	@Test
	public void naoValidarNomeComNumeros() {
		
		String nome = "Consert0";
		
		com.ade.mei.validacao.ServicoValidacao servico = new com.ade.mei.validacao.ServicoValidacao();
		boolean validacaoDoServicoRetornada = servico.validarServico(nome);
		Assert.assertEquals(false, validacaoDoServicoRetornada);
			
			
	}
	
	@Test
	public void naoValidarNomeComCaracteresEspeciais() {
		
		String nome = "Cons&rto";
		
		com.ade.mei.validacao.ServicoValidacao servico = new com.ade.mei.validacao.ServicoValidacao();
		boolean validacaoDoUsuarioRetornada = servico.validarServico(nome);
		Assert.assertEquals(false, validacaoDoUsuarioRetornada);
		
	}
	
	@Test
	public void naoValidarNomeNulo() {
		
		String nome = null;
		
		com.ade.mei.validacao.ServicoValidacao servico = new com.ade.mei.validacao.ServicoValidacao();
		boolean validacaoDoUsuarioRetornada = servico.validarServico(nome);
		Assert.assertEquals(false, validacaoDoUsuarioRetornada);
		
	}
	
	@Test
	public void naoValidarNomeVazio() {
		
		String nome = "";
		
		com.ade.mei.validacao.ServicoValidacao servico = new com.ade.mei.validacao.ServicoValidacao();
		boolean validacaoDoUsuarioRetornada = servico.validarServico(nome);
		Assert.assertEquals(false, validacaoDoUsuarioRetornada);
		
	}
	
	
	

}
