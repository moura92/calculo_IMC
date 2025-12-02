package com.moura.controllers;

import java.util.concurrent.atomic.AtomicLong;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.moura.model.Dados;

@RestController
public class DadosControllers {

	private final AtomicLong id = new AtomicLong(); // Cria o ID

	// localhost:8080/dados
	@RequestMapping("/dados")
	public Dados dados(@RequestParam(defaultValue = "78") double peso,
			@RequestParam(defaultValue = "1.72") double altura) {

		double calculo = peso / (altura * altura); // calculo IMC
		double imc = Math.round(calculo * 100.0) / 100.0; // arredonda para duas casas decimais

		return new Dados(id.incrementAndGet(), altura, peso, imc);
	}
}
