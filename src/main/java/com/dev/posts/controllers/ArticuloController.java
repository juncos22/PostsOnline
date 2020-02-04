package com.dev.posts.controllers;

import java.sql.Date;
import java.time.LocalDate;
import java.util.Optional;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.dev.posts.entities.Articulo;
import com.dev.posts.entities.Categoria;
import com.dev.posts.entities.Usuario;
import com.dev.posts.services.ArticuloService;
import com.dev.posts.services.CategoriaService;
import com.dev.posts.services.UsuarioService;

@Controller
@RequestMapping("articulos")
public class ArticuloController {
	@Autowired
	private ArticuloService articuloService;
	@Autowired
	private CategoriaService categoriaService;
	@Autowired
	private HomeController homeController;
	@Autowired
	private UsuarioService usuarioService;
	
	@GetMapping("categoria")
	public String categoria(@RequestParam long id, Model m) {
		Categoria c = categoriaService.buscarCategoria(id);
		m.addAttribute("articulos", articuloService.buscarArticulosPorCategoria(c));
		m.addAttribute("categorias", categoriaService.listarCategorias());
		return "articulos";
	}
	
	@GetMapping("nuevo")
	public String nuevo(Model m) {
		m.addAttribute("categorias", categoriaService.listarCategorias());
		m.addAttribute("articulo", new Articulo());
		return "nuevo";
	}
	
	@PostMapping("publicar")
	public String publicar(Articulo articulo, Model m, HttpServletRequest request) {
		Optional<Usuario> uOptional = usuarioService.buscarUsuario(request.getRemoteUser());
		if (uOptional.isPresent()) {
			Usuario u = uOptional.get();
			articulo.setCreacion(Date.valueOf(LocalDate.now()));
			articuloService.guardarArticulo(articulo, u); 
			m.addAttribute("mensaje", "Articulo Publicado Exitosamente");
		}
		
		return homeController.home(m);
	}
	
	@GetMapping("detalles")
	public String leer(@RequestParam long id, Model m) {
		Articulo a = articuloService.buscarArticulo(id);
		m.addAttribute("articulo", a);
		m.addAttribute("categorias", categoriaService.listarCategorias());
		return "detalles";
	}
}
