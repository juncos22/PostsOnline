package com.dev.posts;

import java.sql.Date;
import java.time.LocalDate;
import java.util.Optional;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.dev.posts.entities.Articulo;
import com.dev.posts.entities.Categoria;
import com.dev.posts.entities.Usuario;
import com.dev.posts.services.ArticuloService;
import com.dev.posts.services.CategoriaService;
import com.dev.posts.services.UsuarioService;

@SpringBootTest
class PostsOnlineApplicationTests {
	@Autowired
	private CategoriaService categoriaService;
	@Autowired
	private ArticuloService articuloService;
	@Autowired
	private UsuarioService usuarioService;
	
	/*
	 * @Test void crearCategorias() { Categoria c1, c2, c3, c4; c1 = new
	 * Categoria(); c1.setTipo("VIDEOJUEGOS");
	 * 
	 * 
	 * c2 = new Categoria(); c2.setTipo("PELICULAS");
	 * 
	 * 
	 * c3 = new Categoria(); c3.setTipo("MUSICA");
	 * 
	 * 
	 * c4 = new Categoria(); c4.setTipo("INFORMATICA");
	 * 
	 * 
	 * categoriaService.registrarCategoria(c1);
	 * categoriaService.registrarCategoria(c2);
	 * categoriaService.registrarCategoria(c3);
	 * categoriaService.registrarCategoria(c4); }
	 */
	
	@Test
	void crearArticulos() {
		Articulo a1, a2, a3, a4;
		
		a1 = new Articulo();
		a1.setTitulo("Assasins Creed");
		a1.setDescripcion("Esta es la descripcion de la saga de Assasins Creed");
		a1.setCuerpo("Este es el cuerpo del articulo sobre la saga de Assasins Creed");
		a1.setCreacion(Date.valueOf(LocalDate.now()));
		Categoria c1 = categoriaService.buscarCategoria(6);
		a1.setCategoria(c1);
		a1.setFoto("https://ubistatic19-a.akamaihd.net/ubicomstatic/es-es/global/game-info/acu_nakedbox_mobile_164378.jpg");
		
		a2 = new Articulo();
		a2.setTitulo("Avengers Endgame");
		a2.setDescripcion("Esta es la descripcion de la pelicula Avengers Endgame");
		a2.setCuerpo("Este es el cuerpo del articulo sobre la pelicula Avengers Endgame");
		a2.setCreacion(Date.valueOf(LocalDate.now()));
		Categoria c2 = categoriaService.buscarCategoria(7);
		a2.setCategoria(c2);
		a2.setFoto("https://www.tematika.com/media/catalog/Ilhsa/Imagenes/667681.jpg");
		
		a3 = new Articulo();
		a3.setTitulo("Musica Popular");
		a3.setDescripcion("Esta es la descripcion de la Musica Popular");
		a3.setCuerpo("Este es el cuerpo del articulo sobre la Musica Popular");
		a3.setCreacion(Date.valueOf(LocalDate.now()));
		Categoria c3 = categoriaService.buscarCategoria(8);
		a3.setCategoria(c3);
		a3.setFoto("https://pl.scdn.co/images/pl/default/f34489893123dd5aa8dd90a510ff5c06cdbcb73a");
		
		a4 = new Articulo();
		a4.setTitulo("Spring Boot");
		a4.setDescripcion("Esta es la descripcion de Spring Boot");
		a4.setCuerpo("Este es el cuerpo del articulo sobre Spring Boot");
		a4.setCreacion(Date.valueOf(LocalDate.now()));
		Categoria c4 = categoriaService.buscarCategoria(9);
		a4.setCategoria(c4);
		a4.setFoto("https://programaenlinea.net/wp-content/uploads/2019/07/java.spring.png");
		
		Optional<Usuario> u1 = usuarioService.getUsuario(4);
		if (u1.isPresent()) {
			Usuario u = u1.get();
			articuloService.guardarArticulo(a1, u);
		}
		
		Optional<Usuario> u2 = usuarioService.getUsuario(3);
		if (u2.isPresent()) {
			Usuario u = u2.get();
			articuloService.guardarArticulo(a2, u);
		}
		
		Optional<Usuario> u3 = usuarioService.getUsuario(4);
		if (u3.isPresent()) {
			Usuario u = u3.get();
			articuloService.guardarArticulo(a3, u);
		}
		
		Optional<Usuario> u4 = usuarioService.getUsuario(3);
		
		if (u4.isPresent()) {
			Usuario u = u4.get();
			articuloService.guardarArticulo(a4, u);
		}
	}

}
