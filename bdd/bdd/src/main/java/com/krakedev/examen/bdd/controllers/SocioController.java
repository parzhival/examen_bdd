package com.krakedev.examen.bdd.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.krakedev.examen.bdd.entidades.Socio;
import com.krakedev.examen.bdd.services.ServicioSocio;

@RestController
@RequestMapping("/socios")
public class SocioController {
	
	@Autowired
	private ServicioSocio servicioSocio;
	
	@PostMapping
	public ResponseEntity<Socio> crearSocio(@RequestBody Socio socioRecibido) {
        Socio socioCreado = servicioSocio.crear(socioRecibido);
        return new ResponseEntity<>(socioCreado, HttpStatus.CREATED);
    }
	
	@GetMapping
    public ResponseEntity<List<Socio>> obtenerTodosLosSocios() {
        List<Socio> todosLosSocios = servicioSocio.listar();
        return new ResponseEntity<>(todosLosSocios, HttpStatus.OK);
    }

   
    @GetMapping("/estado")
    public ResponseEntity<List<Socio>> obtenerSociosPorEstado(@RequestParam boolean activo) {
        List<Socio> sociosFiltrados = servicioSocio.buscarPorEstado(activo);
        return new ResponseEntity<>(sociosFiltrados, HttpStatus.OK);
    }

}
