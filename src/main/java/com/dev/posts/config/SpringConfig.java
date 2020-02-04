package com.dev.posts.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;

import com.dev.posts.services.UsuarioService;

@Configuration
@EnableWebSecurity
public class SpringConfig extends WebSecurityConfigurerAdapter {
	@Autowired
	private UsuarioService usuarioService;
	
	@Bean
	PasswordEncoder encoder() {
		return new BCryptPasswordEncoder();
	}
	
	@Override
	protected void configure(AuthenticationManagerBuilder auth) throws Exception {
		// TODO Auto-generated method stub
		auth.userDetailsService(usuarioService).passwordEncoder(encoder());
	}
	
	@Override
	protected void configure(HttpSecurity http) throws Exception {
		// TODO Auto-generated method stub
		http.authorizeRequests()
		.antMatchers("/", "/registro", "/registrarse", "/login", "/contacto", 
				"/css/**", "/img/**", "/js/**", "/icon-fonts/**",
				"/articulos/categoria", "/articulos/detalles").permitAll()
		.antMatchers("/articulos/nuevo", "/articulos/publicar").authenticated()
		.and().formLogin().loginPage("/login").defaultSuccessUrl("/").failureUrl("/login?error=true")
		.usernameParameter("username").passwordParameter("password")
		.and().logout().logoutUrl("/logout").logoutSuccessUrl("/");
	}
}
