package com.ade.mei.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.ade.mei.model.Cliente;

@Repository
public interface ClienteRepository extends JpaRepository <Cliente, Long>{

}
