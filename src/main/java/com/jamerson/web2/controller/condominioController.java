package com.jamerson.web2.controller;

import java.util.List;

import org.aspectj.apache.bcel.classfile.Module.Require;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.jamerson.web2.DAO.CondominioDAO;
import com.jamerson.web2.model.Condominio_Recibo;
import com.sun.org.apache.bcel.internal.generic.NEW;

@Controller
public class condominioController {
	
	@Autowired
	private CondominioDAO condRep;

	@GetMapping("/index")
	public ModelAndView exibirRecebimento() {
		ModelAndView mv = new ModelAndView("condominio");
		mv.addObject("condominio_recibo", new Condominio_Recibo());
		mv.addObject("lista", condRep.findAll());
		//variavel condominio_recibo faz referencia ao th:object no html
		return mv;
	}
	
	@PostMapping("/addRecibo")
	public ModelAndView salvarNoBanco(@ModelAttribute Condominio_Recibo recibo) {
		System.out.println(recibo);
		condRep.save(recibo);
		ModelAndView mv = new ModelAndView("condominio");
		mv.addObject("condominio_recibo", new Condominio_Recibo());
		mv.addObject("lista", condRep.findAll());
		return mv;
	}
	
	public ModelAndView listar() {
		ModelAndView mv = new ModelAndView("condominio");
		mv.addObject("lista", condRep.findAll());
		return mv;
}

		//Editar Condominio
	@GetMapping("/editarRecibo")
	public ModelAndView editarRecibo(@RequestParam Integer id_recibo) {
		ModelAndView mv = new ModelAndView("condominio");
		mv.addObject("condominio_recibo", condRep.findById(id_recibo));
		condRep.deleteById(id_recibo);
		return mv;		
	}
	
	//remover Recibo
	@GetMapping("/removerRecibo")
	public ModelAndView removerRecibo(@RequestParam Integer id_recibo) {
		ModelAndView mv = new ModelAndView("condominio");
		mv.addObject("condominio_recibo", new Condominio_Recibo());
		condRep.deleteById(id_recibo);
		return mv;
	}
	
	//PESQUISAR MORADOR
	@PostMapping("/pesquisaMorador")
	public ModelAndView pesquisaMorador(@RequestParam(required = false) String nomeMorador) {
		ModelAndView mv = new ModelAndView("lista-Moradores");
		List<Condominio_Recibo> listaMoradores;
		
		if(nomeMorador == null || nomeMorador.trim().isEmpty()) {
			listaMoradores = this.condRep.findAll(Sort.by("nomeMorador"));
		}else {
			listaMoradores = this.condRep.findBynomeMoradorContainingIgnoreCase(nomeMorador);
		}
		
		mv.addObject("listaMoradores", listaMoradores);
		return mv;
		
	}
	
	
}	
	