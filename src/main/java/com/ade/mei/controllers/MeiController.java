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


import com.ade.mei.model.Mei;

import exception.ResourceNotFoundException;
import repository.MeiRepository;

@RestController
public class MeiController {
	
	@Autowired
	MeiRepository meiRepository;
	
	@GetMapping("/mei")
	public Page<Mei> getMeis(Pageable pageable){
		return meiRepository.findAll(pageable);
	}
	
	@PostMapping("/mei")
	public Mei criarNovoMei(@Valid @RequestBody Mei  mei) {
		return meiRepository.save(mei);
	}
	
	@PutMapping("/mei/{meiId}")
	public Mei atualizarMei(@PathVariable Long meiId,
            								@Valid @RequestBody Mei meiRequest) {
		return meiRepository.findById(meiId)
				.map(mei -> {
					mei.setNome(meiRequest.getNome());
					mei.setDescricaoPessoal(meiRequest.getDescricaoPessoal());
					mei.setEmail(meiRequest.getEmail());
					mei.setTelefone(meiRequest.getTelefone());
					mei.setCnpj(meiRequest.getCnpj());
					mei.setServico(meiRequest.getServico());
					mei.setEndereco(meiRequest.getEndereco());
					mei.setSenha(meiRequest.getSenha());
					return meiRepository.save(mei);
		}).orElseThrow(() -> new ResourceNotFoundException("Mei não encontrado com o ID: " + meiId));
	}
	
	

	@DeleteMapping("/mei/{meiId}")
	public ResponseEntity<?> deletarMei(@PathVariable Long meiId){
		
		return meiRepository.findById(meiId)
				.map(mei -> {
					meiRepository.delete(mei);
					return ResponseEntity.ok().build();
				}).orElseThrow(() -> new ResourceNotFoundException("mei não encontrado com o ID: " + meiId));
	}

}
