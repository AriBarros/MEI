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

import com.ade.mei.model.Oferta;

import exception.ResourceNotFoundException;
import repository.OfertaRepository;

@RestController
public class OfertaController {
	
	@Autowired
	OfertaRepository ofertaRepository;
	
	
	@GetMapping("/oferta")
	public Page<Oferta> getOfertas(Pageable pageable){
		return ofertaRepository.findAll(pageable);
	}
	
	@PostMapping("/oferta")
	public Oferta criarNovaOferta(@Valid @RequestBody Oferta oferta)
	{
		
		return ofertaRepository.save(oferta);
		
	}
	
	@PutMapping("/oferta/{ofertaId}")
	public Oferta atualizarOferta(@PathVariable Long ofertaId, @Valid @RequestBody Oferta ofertaRequest)
	{
		return ofertaRepository.findById(ofertaId)
				.map(oferta -> {
					oferta.setServico(ofertaRequest.getServico());
					oferta.setPreco(ofertaRequest.getPreco());
					oferta.setDisponibilidade(ofertaRequest.getDisponibilidade());
					oferta.setMei(ofertaRequest.getMei());
					
					return ofertaRepository.save(oferta);
		}).orElseThrow(() -> new ResourceNotFoundException("Oferta não encontrada com o ID: " + ofertaId));
	}
	
	@DeleteMapping("/oferta/{ofertaId}")
	public ResponseEntity<?> deletarOferta(@PathVariable Long ofertaId){
		
		return ofertaRepository.findById(ofertaId)
				.map(oferta -> {
					ofertaRepository.delete(oferta);
					return ResponseEntity.ok().build();
				}).orElseThrow(() -> new ResourceNotFoundException("oferta não encontrada com o ID: " + ofertaId));
	}
	

}
