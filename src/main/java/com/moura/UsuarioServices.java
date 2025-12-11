package com.moura;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.atomic.AtomicLong;
import java.util.logging.Logger;

import org.springframework.stereotype.Service;

import com.moura.model.Usuario;

@Service
public class UsuarioServices {

	private final AtomicLong idUsuario = new AtomicLong();

	private Logger logger = Logger.getLogger(UsuarioServices.class.getName());
	/*
	 * Um logger é uma ferramenta usada em aplicações Java (e praticamente toda
	 * linguagem) para registrar mensagens, como: - erros - avisos - informações
	 * importantes - passos de execução - detalhes de requisições - eventos
	 * inesperados Logger é o jeito profissional de mostrar mensagens do sistema,
	 * substituindo System.out.println, com níveis, filtros e arquivos de log.
	 */

	public List<Usuario> findAll() {
		logger.info("Varios usuarios!");
		List<Usuario> usuarios = new ArrayList<>();
		for (int i = 0; i < 8; i++) {
			Usuario usuario = listaUsuario(i);
			usuarios.add(usuario);
		}

		return usuarios;
	}

	private Usuario listaUsuario(int i) {
		Usuario usuario = new Usuario();
		usuario.setId(idUsuario.incrementAndGet());
		usuario.setNome("Usuario - " + i);
		usuario.setIdade(25);
		usuario.setAltura(1.72);
		usuario.setPeso(78.5);
		double calculo = usuario.getPeso() / (usuario.getAltura() * usuario.getAltura());
		double imc = Math.round(calculo * 100.0) / 100.0;
		usuario.setImc(imc);

		if (imc < 18.5) {
			usuario.setClassificaçao("Magreza");
		} else if (imc <= 24.9) {
			usuario.setClassificaçao("Peso Normal");
		} else if (imc <= 29.9) {
			usuario.setClassificaçao("Sobrepeso");
		} else if (imc <= 34.9) {
			usuario.setClassificaçao("Obesidade Grau I");
		} else if (imc <= 39.9) {
			usuario.setClassificaçao("Obesidade Grau II");
		} else if (imc >= 40) {
			usuario.setClassificaçao("Obesiade Grau III - (mórbida)");
		}
		return usuario;
	}

	public Usuario findById(String id) {
		logger.info("Encontrando um usuario!");

		Usuario usuario = new Usuario();
		usuario.setId(idUsuario.incrementAndGet());
		usuario.setNome("Arruda");
		usuario.setIdade(25);
		usuario.setAltura(1.9);
		usuario.setPeso(50);
		double calculo = usuario.getPeso() / (usuario.getAltura() * usuario.getAltura());
		double imc = Math.round(calculo * 100.0) / 100.0;
		usuario.setImc(imc);

		if (imc < 18.5) {
			usuario.setClassificaçao("Magreza");
		} else if (imc <= 24.9) {
			usuario.setClassificaçao("Peso Normal");
		} else if (imc <= 29.9) {
			usuario.setClassificaçao("Sobrepeso");
		} else if (imc <= 34.9) {
			usuario.setClassificaçao("Obesidade Grau I");
		} else if (imc <= 39.9) {
			usuario.setClassificaçao("Obesidade Grau II");
		} else if (imc >= 40) {
			usuario.setClassificaçao("Obesiade Grau III - (mórbida)");
		}
		return usuario;
	}

	public Usuario create(Usuario usuario) {
		logger.info("Criando um usuario!");
		return usuario;
	}

	public Usuario update(Usuario usuario) {
		logger.info("Atualizando usuario!");
		return usuario;
	}

	public void delete(String id) {
		logger.info("Usuario deletado!");
	}
}
