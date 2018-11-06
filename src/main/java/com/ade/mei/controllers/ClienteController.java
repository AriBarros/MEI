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

import com.ade.mei.model.Categoria;
import com.ade.mei.model.Cliente;
import com.ade.mei.repository.ClienteRepository;

import com.ade.mei.exception.ResourceNotFoundException;

@RestController
public class ClienteController {
	
	@Autowired
	private ClienteRepository clienteRepository;
	
	@GetMapping("/cliente")
	public Page<Cliente> getClientes(Pageable pageable){
		return clienteRepository.findAll(pageable);
	}
	
	@GetMapping("/cliente/{clienteId}")
	public Cliente getCliente(@PathVariable Long clienteId)
	{
		
		return clienteRepository.findById(clienteId).
				orElseThrow(() -> new ResourceNotFoundException("cliente não encontrada com o ID: " + clienteId));
	
	}
	
	
	@PostMapping("/cliente")
	public Cliente criarNovoCliente(@Valid @RequestBody Cliente cliente) {
		return clienteRepository.save(cliente);
	}
	
	@PutMapping("/cliente/{clienteId}")
	public Cliente atualizarCliente(@PathVariable Long clienteId,
            								@Valid @RequestBody Cliente clienteRequest) {
		return clienteRepository.findById(clienteId)
				.map(cliente -> {
					cliente.setNome(clienteRequest.getNome());
					cliente.setEmail(clienteRequest.getEmail());
					cliente.setTelefone(clienteRequest.getTelefone());
					cliente.setCpf(clienteRequest.getCpf());
					cliente.setSenha(clienteRequest.getSenha());
					return clienteRepository.save(cliente);
		}).orElseThrow(() -> new ResourceNotFoundException("Cliente não encontrado com o ID: " + clienteId));
	}
	
	@DeleteMapping("/cliente/{clienteId}")
	public ResponseEntity<?> deletarCliente(@PathVariable Long clienteId){
		
		return clienteRepository.findById(clienteId)
				.map(cliente -> {
					clienteRepository.delete(cliente);
					return ResponseEntity.ok().build();
				}).orElseThrow(() -> new ResourceNotFoundException("cliente não encontrado com o ID: " + clienteId));
	}



}
