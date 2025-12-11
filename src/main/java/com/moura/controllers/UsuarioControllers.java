package com.moura.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.moura.UsuarioServices;
import com.moura.model.Usuario;

@RestController
@RequestMapping("/usuario")
public class UsuarioControllers {

	@Autowired
	/*
	 * OBS: com a anotation "@Autowired" o spring vai injetar a instancia da classe
	 * "UsuarioService" sem a necessidade de usar o "new UsuarioServices();" desta
	 * forma: "private UsuarioServices usuarioService = new UsuarioServices();"
	 */
	private UsuarioServices usuarioService;

	// http://localhost:8080/usuario
	@RequestMapping()
	public List<Usuario> findAll() {
		return usuarioService.findAll();
	}

	// http://localhost:8080/1
	@RequestMapping(value = "/{id}", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
	public Usuario findById(@PathVariable("id") String id) {
		return usuarioService.findById(id);
	}

	// CREATE
	@RequestMapping(method = RequestMethod.POST, consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
	public Usuario create(@RequestBody Usuario usuario) {
		return usuarioService.create(usuario);
	}

	// UPDATE
	@RequestMapping(method = RequestMethod.PUT, consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
	public Usuario update(@RequestBody Usuario usuario) {
		return usuarioService.update(usuario);
	}

	//DELETE
	@RequestMapping(value = "/{id}", method = RequestMethod.DELETE)
	public void delete(@PathVariable("id") String id) {
		usuarioService.delete(id);
	}
}