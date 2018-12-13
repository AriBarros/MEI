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

import com.ade.mei.model.Categoria;
import com.ade.mei.model.Endereco;
import com.ade.mei.model.Mei;
import com.ade.mei.repository.EnderecoRepository;
import com.ade.mei.repository.MeiRepository;
import com.ade.mei.repository.OfertaRepository;
import com.ade.mei.repository.ServicoRepository;
import com.ade.mei.exception.ResourceNotFoundException;

@RestController
public class MeiController {
	
	@Autowired
	MeiRepository meiRepository;
	
	@Autowired
	private EnderecoRepository enderecoRepository;
	
	@Autowired
	ServicoRepository servicoRepository;
	
	@Autowired
	OfertaRepository ofertaRepository;
	
	@GetMapping("/mei")
	public Page<Mei> getMeis(Pageable pageable){
		return meiRepository.findAll(pageable);
	}
	
	@GetMapping("/mei/{meiId}")
	public Mei getMei(@PathVariable Long meiId)
	{
		
		return meiRepository.findById(meiId).
				orElseThrow(() -> new ResourceNotFoundException("categoria não encontrada com o ID: " + meiId));
	
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
	
	
	
	@PutMapping("/mei/{meiId}/{endId}")
	public Mei AdicionarEnd(@PathVariable Long meiId, @PathVariable Long endId,
            @Valid @RequestBody Mei meiRequest) {
		
		
		return meiRepository.findById(meiId)
				.map(mei -> {
					
					mei.setEndereco( enderecoRepository.findById(endId).orElseThrow(()  -> new ResourceNotFoundException("Endereco não encontrado: " + endId )));
					
					return meiRepository.save(mei);
		}).orElseThrow(() -> new ResourceNotFoundException("Mei não encontrado com o ID: " + meiId));
	}
	
	

	@PutMapping("/mei/servico/{meiId}/{servId}")
	public Mei AdicionarServico(@PathVariable Long meiId, @PathVariable Long servId,
            @Valid @RequestBody Mei meiRequest) {
		
		
		return meiRepository.findById(meiId)
				.map(mei -> {
					
					mei.setServico( servicoRepository.findById(servId).orElseThrow(()  -> new ResourceNotFoundException("Serviço não encontrado: " + servId )));
					
					return meiRepository.save(mei);
		}).orElseThrow(() -> new ResourceNotFoundException("Mei não encontrado com o ID: " + meiId));
	}
	
	@PutMapping("/mei/oferta/{meiId}/{ofertaId}")
	public Mei AdicionarOferta(@PathVariable Long meiId, @PathVariable Long ofertaId,
            @Valid @RequestBody Mei meiRequest) {
		
		
		return meiRepository.findById(meiId)
				.map(mei -> {
					
					mei.setOferta( ofertaRepository.findById(ofertaId).orElseThrow(()  -> new ResourceNotFoundException("Oferta não encontrada: " + ofertaId )));
					
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
