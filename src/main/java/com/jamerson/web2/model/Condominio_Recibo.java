package com.jamerson.web2.model;


import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;
import javax.persistence.Table;

import com.jamerson.web2.model.CadastroMorador;

import org.springframework.format.annotation.DateTimeFormat;

@Entity
@Table(name = "tab_recibo")
public class Condominio_Recibo {
	
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Integer id_recibo;
	private String nomeMorador;
	private String Descricao_pagamento;
	@DateTimeFormat(pattern = "yyyy-MM-dd")
	private Date dataVencimento;
	private double valorPagamento;
	private String status;
	
	@ManyToOne
	private CadastroMorador cadastromorador;
	
	public Integer getId_recibo() {
		return id_recibo;
	}
	public void setId_recibo(Integer id_recibo) {
		this.id_recibo = id_recibo;
	}
	
	public String getNomeMorador() {
		return nomeMorador;
	}
	public void setNomeMorador(String nomeMorador) {
		this.nomeMorador = nomeMorador;
	}
	public String getDescricao_pagamento() {
		return Descricao_pagamento;
	}
	public void setDescricao_pagamento(String descricao_pagamento) {
		Descricao_pagamento = descricao_pagamento;
	}
	public Date getDataVencimento() {
		return dataVencimento;
	}
	public void setDataVencimento(Date dataVencimento) {
		this.dataVencimento = dataVencimento;
	}
	public double getValorPagamento() {
		return valorPagamento;
	}
	public void setValorPagamento(double valorPagamento) {
		this.valorPagamento = valorPagamento;
	}
	public String getStatus() {
		return status;
	}
	public void setStatus(String status) {
		this.status = status;
	}
	
	public CadastroMorador getCadastromorador() {
		return cadastromorador;
	}
	public void setCadastromorador(CadastroMorador cadastromorador) {
		this.cadastromorador = cadastromorador;
	}
	@Override
	public String toString() {
		// TODO Auto-generated method stub
		return nomeMorador;
	}
	
}
