package com.ade.mei.teste;

import static org.junit.Assert.*;

import org.junit.Test;

import com.ade.mei.validacao.OfertaValidacao;

public class OfertaValidacaoTest {

	@Test
	public void naoValidarPrecoNegativo() {
		
		String preco = "-123.82";
		
		OfertaValidacao ofertav = new OfertaValidacao();
		boolean validacaoDoPrecoRetornada = ofertav.validarPreco(preco);
		assertEquals(false, validacaoDoPrecoRetornada);
			
	}
	
	@Test
	public void naoValidarPrecoNulo() {
		
		String preco = null;
		
		OfertaValidacao ofertav = new OfertaValidacao();
		boolean validacaoDoPrecoRetornada = ofertav.validarPreco(preco);
		assertEquals(false, validacaoDoPrecoRetornada);
			
	}
	
	@Test
	public void naoValidarPrecoVazio() {
		
		String preco = "";
		
		OfertaValidacao ofertav = new OfertaValidacao();
		boolean validacaoDoPrecoRetornada = ofertav.validarPreco(preco);
		assertEquals(false, validacaoDoPrecoRetornada);
			
	}
	
	@Test
	public void validarDisponibilidade() {
		
		String disponibilidade = "Sim";
		
		OfertaValidacao ofertav = new OfertaValidacao();
		boolean validacaoDaDisponibilidadeRetornada = ofertav.validarDisponibilidade(disponibilidade);
		
		assertEquals(true, validacaoDaDisponibilidadeRetornada);
			
	}
	
	

}
