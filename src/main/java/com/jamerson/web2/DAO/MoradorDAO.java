package com.jamerson.web2.DAO;

import org.springframework.data.jpa.repository.JpaRepository;

import com.jamerson.web2.model.CadastroMorador;

public interface MoradorDAO extends JpaRepository<CadastroMorador, Integer> {

}
