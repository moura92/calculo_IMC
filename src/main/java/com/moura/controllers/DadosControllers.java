package com.moura.controllers;

import java.util.concurrent.atomic.AtomicLong;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.moura.exception.ParametroInvalidoException;
import com.moura.model.Dados;

@RestController
public class DadosControllers {

	private final AtomicLong id = new AtomicLong(); // Cria o ID

	@RequestMapping("/")
	public String teste() {
		return "Pagina Inicial";
	}

	// localhost:8080/dados
	@RequestMapping("/dados")
	public Dados dados(@RequestParam(required = false) Double peso, @RequestParam(required = false) Double altura) {

		if (peso == null || peso <= 0) {
			throw new ParametroInvalidoException("ERRO! O peso não deve estar vazia.");
		}

		if (altura == null || altura <= 0) {
			throw new ParametroInvalidoException("ERRO! A altura não deve estar vazia.");
		}
		double calculo = peso / (altura * altura); // calculo IMC
		double imc = Math.round(calculo * 100.0) / 100.0; // arredonda para duas casas decimais

		String tabela = "";

		if (imc < 18.5) {tabela = "Magreza";
		}
		else if(imc <= 24.9) {tabela = "Peso Normal";
		}
		else if(imc <= 29.9) {tabela = "Sobrepeso";
		}
		else if(imc <= 34.9) {tabela = "Obesidade Grau I";
		}
		else if(imc <= 39.9) {tabela = "Obesidade Grau II";
		}
		else if(imc >= 40) {tabela = "Obesiade Grau III - (mórbida)";
		}
		
		return new Dados(id.incrementAndGet(), altura, peso, imc, tabela);
	}
}
