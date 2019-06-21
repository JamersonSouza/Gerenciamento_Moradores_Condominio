package com.jamerson.web2.model;

import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import org.springframework.format.annotation.DateTimeFormat;

@Entity
@Table(name = "tab_morador")
public class CadastroMorador {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Integer idMorador;
	private String nome;
	private String telefone;
	private String placaCarro;
	private double valorCondominio;
	private String numApt;
	@DateTimeFormat(pattern = "yyyy-MM-dd")
	private Date dataVencimentoRecibo;
	private String formaPagamento;
	private String moradorOuProprietario;


	public Integer getIdMorador() {
		return idMorador;
	}

	public void setIdMorador(Integer idMorador) {
		this.idMorador = idMorador;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public String getTelefone() {
		return telefone;
	}

	public void setTelefone(String telefone) {
		this.telefone = telefone;
	}

	public String getPlacaCarro() {
		return placaCarro;
	}

	public void setPlacaCarro(String placaCarro) {
		this.placaCarro = placaCarro;
	}

	public Double getValorCondominio() {
		return valorCondominio;
	}

	public void setValorCondominio(Double valorCondominio) {
		this.valorCondominio = valorCondominio;
	}

	public String getNumApt() {
		return numApt;
	}

	public void setNumApt(String numApt) {
		this.numApt = numApt;
	}

	public Date getDataVencimentoRecibo() {
		return dataVencimentoRecibo;
	}

	public void setDataVencimentoRecibo(Date dataVencimentoRecibo) {
		this.dataVencimentoRecibo = dataVencimentoRecibo;
	}

	public String getFormaPagamento() {
		return formaPagamento;
	}

	public void setFormaPagamento(String formaPagamento) {
		this.formaPagamento = formaPagamento;
	}

	public String getMoradorOuProprietario() {
		return moradorOuProprietario;
	}

	public void setMoradorOuProprietario(String moradorOuProprietario) {
		this.moradorOuProprietario = moradorOuProprietario;
	}

	public void setValorCondominio(double valorCondominio) {
		this.valorCondominio = valorCondominio;
	}

	@Override
	public String toString() {
		return nome;
	}

}
