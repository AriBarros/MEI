package com.ade.mei.controllers;

import java.util.Optional;

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
import com.ade.mei.model.Categoria;
import com.ade.mei.model.Servico;
import com.ade.mei.repository.CategoriaRepository;



@RestController
public class CategoriaController {
	
	@Autowired
	private CategoriaRepository categoriaRepository;
	
	@GetMapping("/categoria")
	public Page<Categoria> getCategorias(Pageable pageable){
		return categoriaRepository.findAll(pageable);
	}
	
	@GetMapping("/categoria/{categoriaId}")
	public Categoria getCategoria(@PathVariable Long categoriaId)
	{
		
		return categoriaRepository.findById(categoriaId).
				orElseThrow(() -> new ResourceNotFoundException("categoria não encontrada com o ID: " + categoriaId));
	
	}
	
	
	@PostMapping("/categoria")
	public Categoria criarNovaCategoria(@Valid @RequestBody Categoria categoria) {
		return categoriaRepository.save(categoria);
	}
	
	
	@PutMapping("/categoria/{categoriaId}/addservico")
	public Categoria adicionarServico( @PathVariable Long categoriaId,@Valid @RequestBody Servico servico) {
		
		return categoriaRepository.findById(categoriaId)
		.map(categoria -> {
			
			categoria.addServico(servico);
				
			return categoriaRepository.save(categoria);
		}).orElseThrow(() -> new ResourceNotFoundException("Categoria não encontrada com o ID: " + categoriaId));	
		
		
	
	}
	
	
	@PutMapping("/categoria/{categoriaId}")
	public Categoria atualizarCategoria(@PathVariable Long categoriaId,
            								@Valid @RequestBody Categoria categoriaRequest) {
		return categoriaRepository.findById(categoriaId)
				.map(categoria -> {
					categoria.setNome(categoriaRequest.getNome());
					return categoriaRepository.save(categoria);
		}).orElseThrow(() -> new ResourceNotFoundException("Categoria não encontrada com o ID: " + categoriaId));
	}
	
	
	
	@DeleteMapping("/categoria/{categoriaId}")
	public ResponseEntity<?> deletarCategoria(@PathVariable Long categoriaId){
		
		return categoriaRepository.findById(categoriaId)
				.map(categoria -> {
					categoriaRepository.delete(categoria);
					return ResponseEntity.ok().build();
				}).orElseThrow(() -> new ResourceNotFoundException("categoria não encontrada com o ID: " + categoriaId));
	}


	
		
	
	
	
	
	
	
	

}
