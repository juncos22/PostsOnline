package com.dev.posts.controllers;

import java.util.Optional;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

import com.dev.posts.entities.Rol;
import com.dev.posts.entities.Usuario;
import com.dev.posts.services.CategoriaService;
import com.dev.posts.services.RolService;
import com.dev.posts.services.UsuarioService;

@Controller
public class RegisterController {
	@Autowired
	private UsuarioService usuarioService;
	@Autowired
	private RolService rolService;
	@Autowired
	private CategoriaService categoriaService;
	
	@GetMapping("/registro")
	public String register(Model m) {
		m.addAttribute("usuario", new Usuario());
		m.addAttribute("categorias", categoriaService.listarCategorias());
		return "register";
	}
	
	private boolean existeUsuario(String nombre) {
		Optional<Usuario> usuarioOptional = usuarioService.buscarUsuario(nombre);
		return usuarioOptional.isPresent();
	}
	
	@PostMapping("/registrarse")
	public String registrarse(Usuario usuario, Model m, HttpServletRequest request) {
		if (existeUsuario(usuario.getNombre())) {
			m.addAttribute("mensaje", "El usuario ya existe");
			return register(m);
		}
		String pass = request.getParameter("pass");
		if (pass.equals(usuario.getContrasenia())) {
			Rol rol = rolService.getRol("USER");
			if (rol == null) {
				rol = new Rol();
				rol.setTipo("USER");
				rol.getUsuarios().add(usuario);
				rolService.crearRol(rol);
			}
			rol.getUsuarios().add(usuario);
			usuario.setRol(rol);
			usuarioService.crearUsuario(usuario); 
		}else {
			m.addAttribute("mensaje", "Las contraseñas no coinciden");
			return register(m);
		}
		return "redirect:/";
	}
}
