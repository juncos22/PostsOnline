package com.dev.posts.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import com.dev.posts.services.CategoriaService;

@Controller
public class ContactoController {
	@Autowired
	private CategoriaService categoriaService;
	@GetMapping("/contacto")
	public String contacto(Model m) {
		m.addAttribute("categorias", categoriaService.listarCategorias());
		return "contact";
	}
}
