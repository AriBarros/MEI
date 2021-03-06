package com.ade.mei.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.ade.mei.model.Mei;

@Repository
public interface MeiRepository extends JpaRepository <Mei, Long>{

	public Mei findByEmailAndSenha(String email, String senha);
	
}