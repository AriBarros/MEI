package com.ade.mei.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.ade.mei.model.Oferta;

@Repository
public interface OfertaRepository extends JpaRepository<Oferta, Long>{

}
