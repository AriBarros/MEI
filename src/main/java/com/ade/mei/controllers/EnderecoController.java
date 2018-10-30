package com.ade.mei.controllers;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.ade.mei.model.Cliente;
import com.ade.mei.model.Endereco;

import exception.ResourceNotFoundException;
import repository.EnderecoRepository;

@RestController
public class EnderecoController {

	@Autowired
	private EnderecoRepository enderecoRepository;
	
	@GetMapping("/endereco")
	public Page<Endereco> getEnderecos(Pageable pageable){
		return enderecoRepository.findAll(pageable);
	}
	
	@PostMapping("/endereco")
	public Endereco criarNovoEndereco(@Valid @RequestBody Endereco endereco) {
		return enderecoRepository.save(endereco);
	}
	
	@PutMapping("/endereco/{enderecoId}")
	public Endereco atualizarEndereco(@PathVariable Long enderecoId,
            								@Valid @RequestBody Endereco enderecoRequest) {
		return enderecoRepository.findById(enderecoId)
				.map(endereco -> {
					endereco.setEstado(enderecoRequest.getEstado());
					endereco.setCidade(enderecoRequest.getCidade());
					endereco.setBairro(enderecoRequest.getBairro());
					endereco.setRua(enderecoRequest.getRua());
					endereco.setNumero(enderecoRequest.getNumero());
					endereco.setMei(enderecoRequest.getMei());
					return enderecoRepository.save(endereco);
		}).orElseThrow(() -> new ResourceNotFoundException("Endereço não encontrado com o ID: " + enderecoId));
	}
	
	@DeleteMapping("/endereco/{enderecoId}")
	public ResponseEntity<?> deletarEndereco(@PathVariable Long enderecoId){
		
		return enderecoRepository.findById(enderecoId)
				.map(endereco -> {
					enderecoRepository.delete(endereco);
					return ResponseEntity.ok().build();
				}).orElseThrow(() -> new ResourceNotFoundException("endereco não encontrado com o ID: " + enderecoId));
	}
	
	
}
