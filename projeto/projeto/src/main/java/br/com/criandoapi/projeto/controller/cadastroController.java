package br.com.criandoapi.projeto.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.com.criandoapi.projeto.DAO.InterfaceUsuario;
import br.com.criandoapi.projeto.model.Usuario;


@RestController
@CrossOrigin("*")
@RequestMapping("/cadastrados")
public class cadastroController {
	
	@Autowired
	private InterfaceUsuario dao;
	
	@GetMapping
	public List<Usuario> ListaUsuarios() {
		return (List<Usuario>) dao.findAll();
	}
	
	@PostMapping
	public Usuario criaUsuario(@RequestBody Usuario usuario) {
		Usuario usuarioNovo = dao.save(usuario);
		return usuarioNovo;
	}
	@PutMapping
	public Usuario editaUsuario(@RequestBody Usuario usuario) {
		Usuario usuarioNovo = dao.save(usuario);
		return usuarioNovo;
	}
	@DeleteMapping("/{id}")
	public Optional<Usuario> deletaUsuario(@PathVariable Integer id) {
		Optional<Usuario> usuario = dao.findById(id);
		dao.deleteById(id);
		return usuario;
		
	}
	

}
