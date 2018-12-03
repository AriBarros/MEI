package com.ade.mei.teste;

import static org.junit.Assert.*;

import org.junit.Test;

import com.ade.mei.validacao.UsuarioValidacao;

import junit.framework.Assert;

public class UsuarioValidacaoTest {

	@Test
	public void naoValidarNomeComNumeros() {
		
		String nome = "edmils0njunior";
		
		UsuarioValidacao user = new UsuarioValidacao();
		boolean validacaoDoUsuarioRetornada = user.validarUsuario(nome);
		Assert.assertEquals(false, validacaoDoUsuarioRetornada);
		
	}
	
	@Test
	public void naoValidarNomeComCaracteresEspeciais() {
		
		String nome = "Vit@o";
		
		
		UsuarioValidacao user = new UsuarioValidacao();
		boolean validacaoDoUsuarioRetornada = user.validarUsuario(nome);
		Assert.assertEquals(false, validacaoDoUsuarioRetornada);
		
	}
	
	@Test
	public void naoValidarNomeNulo() {
		
		String nome = null;
		
		
		UsuarioValidacao user = new UsuarioValidacao();
		boolean validacaoDoUsuarioRetornada = user.validarUsuario(nome);
		Assert.assertEquals(false, validacaoDoUsuarioRetornada);
		
	}
	
	@Test
	public void naoValidarNomeVazio() {
		
		String nome = "";
		
		
		UsuarioValidacao user = new UsuarioValidacao();
		boolean validacaoDoUsuarioRetornada = user.validarUsuario(nome);
		Assert.assertEquals(false, validacaoDoUsuarioRetornada);
		
	}
	
	
	@Test
	public void validarDominioDoEmail() {
		
		String nome = "Janaine";
		String email = "janaine@gmail.com";
		
		UsuarioValidacao user = new UsuarioValidacao();
		boolean validacaoDoUsuarioRetornada = user.validarEmail(email);
		Assert.assertEquals(false, validacaoDoUsuarioRetornada);
		
	}
	
	@Test
	public void naoValidarNumeroDeTelefoneComLetras() {
		
		String telefone = "abc-8912";
		
		
		UsuarioValidacao user = new UsuarioValidacao();
		boolean validacaoDoUsuarioRetornada = user.validarTelefone(telefone);
		Assert.assertEquals(false, validacaoDoUsuarioRetornada);
		
	}
	


}
