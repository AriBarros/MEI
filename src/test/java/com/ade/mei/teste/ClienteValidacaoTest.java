package com.ade.mei.teste;

import static org.junit.Assert.*;

import org.junit.Test;

import com.ade.mei.validacao.ClienteValidacao;


public class ClienteValidacaoTest {

	@Test
	public void validarCpf() {
		
		String cpf = "08119332181";
	
		
		ClienteValidacao cliente = new ClienteValidacao();
		boolean validacaoDoCpfRetornada = cliente.validarCpf(cpf);
		assertEquals(true, validacaoDoCpfRetornada);
			
	}
	
	@Test
	public void naoValidarCpfComLetras() {
		
		String cpf = "0811a332181";
	
		
		ClienteValidacao cliente = new ClienteValidacao();
		boolean validacaoDoCpfRetornada = cliente.validarCpf(cpf);
		assertEquals(false, validacaoDoCpfRetornada);
			
	}
	
	@Test
	public void naoValidarCpfComVariosDigitos() {
		
		String cpf = "0811123533218123131";
	
		
		ClienteValidacao cliente = new ClienteValidacao();
		boolean validacaoDoCpfRetornada = cliente.validarCpf(cpf);
		assertEquals(false, validacaoDoCpfRetornada);
			
	}
	
	@Test
	public void naoValidarCpfNulo() {
		
		String cpf = null;
	
		
		ClienteValidacao cliente = new ClienteValidacao();
		boolean validacaoDoCpfRetornada = cliente.validarCpf(cpf);
		assertEquals(false, validacaoDoCpfRetornada);
			
	}
	
	@Test
	public void naoValidarCpfVazio() {
	
		String cpf = "";
	
		
		ClienteValidacao cliente = new ClienteValidacao();
		boolean validacaoDoCpfRetornada = cliente.validarCpf(cpf);
		assertEquals(false, validacaoDoCpfRetornada);
			
	}

}
