package com.dev.posts.controllers;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import com.dev.posts.services.CategoriaService;

@Controller
public class LoginController {
	@Autowired
	private CategoriaService categoriaService;
	@Autowired
	private HomeController homeController;
	
	@GetMapping("/login")
	public String login(Model m) {
		m.addAttribute("categorias", categoriaService.listarCategorias());
		return "login";
	}
	
	@GetMapping("/logout")
	public String logout(Model m, HttpServletRequest request) {
		try {
			request.logout();
		} catch (ServletException e) {
			// TODO Auto-generated catch block
			System.out.println(e.getMessage());
		}
		return homeController.home(m);
	}
}
