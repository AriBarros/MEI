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

import com.ade.mei.exception.ResourceNotFoundException;
import com.ade.mei.model.Servico;
import com.ade.mei.repository.ServicoRepository;


@RestController
public class ServicoController {
	
	@Autowired
	ServicoRepository servicoRepository;
	
	@GetMapping("/servico")
	public Page<Servico> getServicos(Pageable pageable){
		return servicoRepository.findAll(pageable);
	}
	
	@GetMapping("/servico/{servicoId}")
	public Servico getServico(Long servicoId){
		return servicoRepository.findById(servicoId).orElseThrow(() -> new ResourceNotFoundException("servico não encontrado com o ID: " + servicoId));
	}
	
	@PostMapping("/servico")
	public Servico criarNovoServico(@Valid @RequestBody Servico servico)
	{
		
		return servicoRepository.save(servico);
		
	}
	
	
	@PutMapping("/servico/{servicoId}")
	public Servico atualizarServico(@PathVariable Long servicoId, @Valid @RequestBody Servico servicoRequest)
	{
		return servicoRepository.findById(servicoId)
				.map(servico -> {
					servico.setNome(servicoRequest.getNome());
					servico.setDescricao(servicoRequest.getDescricao());
					servico.setCategorias(servicoRequest.getCategorias());
					servico.setMeis(servicoRequest.getMeis());
					servico.setOfertas(servicoRequest.getOfertas());
					return servicoRepository.save(servico);
		}).orElseThrow(() -> new ResourceNotFoundException("servico não encontrado com o ID: " + servicoId));
	}
	
	@DeleteMapping("/servico/{servicoId}")
	public ResponseEntity<?> deletarServico(@PathVariable Long servicoId){
		
		return servicoRepository.findById(servicoId)
				.map(servico -> {
					servicoRepository.delete(servico);
					return ResponseEntity.ok().build();
				}).orElseThrow(() -> new ResourceNotFoundException("servico não encontrado com o ID: " + servicoId));
	}

}
