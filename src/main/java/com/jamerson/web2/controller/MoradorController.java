package com.jamerson.web2.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Controller;
import org.springframework.validation.Errors;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.ModelAndView;

import com.jamerson.web2.DAO.MoradorDAO;
import com.jamerson.web2.model.CadastroMorador;

@Controller
public class MoradorController {


	@Autowired
	private MoradorDAO moradorRap;
	
	@GetMapping("Cadastro-Morador")
	public ModelAndView pageMorador() {
		ModelAndView mv = new ModelAndView("NewMorador");
		mv.addObject("cadastromorador", new CadastroMorador());
		return mv;
	}
	
	@PostMapping("/insertMorador")
	public ModelAndView inserirMorador(@ModelAttribute CadastroMorador cadastrar, Errors errors) {
			ModelAndView mv = new ModelAndView("NewMorador");
			if(errors.hasErrors()) {
				return mv;
			}
			moradorRap.save(cadastrar);
			System.out.println(cadastrar);
			mv.addObject("mensagem", "Morador Inserido Com sucesso!");
			mv.addObject("cadastromorador", new CadastroMorador());
			return mv;
	}
	
	@GetMapping("/listaMorador")
	public ModelAndView exibirMoradores() {
		ModelAndView mv = new ModelAndView("condominio");
		mv.addObject("listaMorador", this.moradorRap.findAll());
		return mv;
	}

}
