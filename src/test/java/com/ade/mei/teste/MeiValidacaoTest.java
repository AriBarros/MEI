package com.ade.mei.teste;

import static org.junit.Assert.*;

import org.junit.Test;

import com.ade.mei.validacao.ClienteValidacao;
import com.ade.mei.validacao.MeiValidacao;

import junit.framework.Assert;

public class MeiValidacaoTest {
	

	@Test
	public void validarCnpj() {
		
		String cnpj = "08119332181";
	
		
		MeiValidacao mei = new MeiValidacao();
		boolean validacaoDoCnpjRetornada = mei.validarCnpj(cnpj);
		Assert.assertEquals(true, validacaoDoCnpjRetornada);
			
	}
	
	@Test
	public void naoValidarCnpjNulo() {
		
		String cnpj = null;
	
		
		MeiValidacao mei = new MeiValidacao();
		boolean validacaoDoCnpjRetornada = mei.validarCnpj(cnpj);
		Assert.assertEquals(false, validacaoDoCnpjRetornada);
			
	}
	
	@Test
	public void naoValidarCnpjVazio() {
		
		String cnpj = "";
	
		
		MeiValidacao mei = new MeiValidacao();
		boolean validacaoDoCnpjRetornada = mei.validarCnpj(cnpj);
		Assert.assertEquals(false, validacaoDoCnpjRetornada);
			
	}
	
	@Test
	public void naoValidarCnpjComLetras() {
		
		String cnpj = "0811a332181";
	
		
		MeiValidacao mei = new MeiValidacao();
		boolean validacaoDoCnpjRetornada = mei.validarCnpj(cnpj);
		Assert.assertEquals(false, validacaoDoCnpjRetornada);
			
	}
	
	@Test
	public void naoValidarCnpjComMaisDeOnzeDigitos() {
		
		String cnpj = "0811a332181134435453343";
	
		
		MeiValidacao mei = new MeiValidacao();
		boolean validacaoDoCnpjRetornada = mei.validarCnpj(cnpj);
		Assert.assertEquals(false, validacaoDoCnpjRetornada);
			
	}

	

}
