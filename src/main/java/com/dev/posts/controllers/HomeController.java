package com.dev.posts.controllers;

import java.sql.Date;
import java.time.LocalDate;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import com.dev.posts.services.ArticuloService;
import com.dev.posts.services.CategoriaService;

@Controller
public class HomeController {
	@Autowired
	private CategoriaService categoriaService;
	@Autowired
	private ArticuloService articuloService;
	
	@GetMapping("/")
	public String home(Model m) {
		m.addAttribute("categorias", categoriaService.listarCategorias());
		m.addAttribute("articulos", articuloService.buscarArticulosPorCreacion(Date.valueOf(LocalDate.now())));
		m.addAttribute("articulosList", articuloService.listarArticulos());
		return "home";
	}
}
