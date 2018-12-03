package com.ade.mei.teste;

import static org.junit.Assert.*;

import org.junit.Test;

import com.ade.mei.validacao.CategoriaValidacao;

public class CategoriaValidacaoTest {

	@Test
	public void validarNome() {
		
		//int id = 1;
		String nome = "Jogos";
		
		CategoriaValidacao categoria = new CategoriaValidacao();
		boolean validacaoDaCategoriaRetornada = categoria.validarNome(nome);
		assertEquals(true, validacaoDaCategoriaRetornada);
		
	}
	
	@Test
	public void naoValidarNomeComNumeros() {
		
		//int id = 1;
		String nome = "El3trônicos";
		
		CategoriaValidacao categoria = new CategoriaValidacao();
		boolean validacaoDaCategoriaRetornada = categoria.validarNome(nome);
		assertEquals(false, validacaoDaCategoriaRetornada);
			
	}
	
	@Test
	public void naoValidarNomeNulo() {
		
		//int id = 1;
		String nome = null;
		
		CategoriaValidacao categoria = new CategoriaValidacao();
		boolean validacaoDaCategoriaRetornada = categoria.validarNome(nome);
		assertEquals(false, validacaoDaCategoriaRetornada);
			
	}
	
	@Test
	public void naoValidarNomeVazio() {
		
		//int id = 1;
		String nome = "";
		
		CategoriaValidacao categoria = new CategoriaValidacao();
		boolean validacaoDaCategoriaRetornada = categoria.validarNome(nome);
		assertEquals(false, validacaoDaCategoriaRetornada);
			
	}

}
