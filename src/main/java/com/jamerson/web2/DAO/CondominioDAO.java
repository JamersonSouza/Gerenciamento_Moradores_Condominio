package com.jamerson.web2.DAO;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.jamerson.web2.model.Condominio_Recibo;

@Repository
public interface CondominioDAO extends JpaRepository<Condominio_Recibo, Integer> {
	
	public List<Condominio_Recibo> findBynomeMoradorContainingIgnoreCase(String NomeMorador);

}
