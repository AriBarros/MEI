package com.ade.mei.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.ade.mei.model.Endereco;

@Repository
public interface EnderecoRepository extends JpaRepository<Endereco, Long>{

}
