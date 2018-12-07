package com.ade.mei.teste;

import static org.junit.Assert.*;

import org.junit.Test;

import com.ade.mei.validacao.CategoriaValidacao;

public class CategoriaValidacaoTest {

	@Test
	public void validarNome() {
		
		
		String nome = "Jogos";
		
		CategoriaValidacao categoria = new CategoriaValidacao();
		boolean validacaoDaCategoriaRetornada = categoria.validarNome(nome);
		assertEquals(true, validacaoDaCategoriaRetornada);
		
	}
	
	@Test
	public void validarNomeComEspaco() {
		
		
		String nome = "Montagem e manutenção";
		
		CategoriaValidacao categoria = new CategoriaValidacao();
		boolean validacaoDaCategoriaRetornada = categoria.validarNome(nome);
		assertEquals(true, validacaoDaCategoriaRetornada);
		
	}
	
	@Test
	public void naoValidarNomeComNumeros() {
		
		
		String nome = "El3trônicos";
		
		CategoriaValidacao categoria = new CategoriaValidacao();
		boolean validacaoDaCategoriaRetornada = categoria.validarNome(nome);
		assertEquals(false, validacaoDaCategoriaRetornada);
			
	}
	

	
	@Test
	public void naoValidarNomeVazio() {
		
		
		String nome = "";
		
		CategoriaValidacao categoria = new CategoriaValidacao();
		boolean validacaoDaCategoriaRetornada = categoria.validarNome(nome);
		assertEquals(false, validacaoDaCategoriaRetornada);
			
	}

}
