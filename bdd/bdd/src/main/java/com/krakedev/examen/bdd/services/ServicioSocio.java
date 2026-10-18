package com.krakedev.examen.bdd.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.krakedev.examen.bdd.entidades.Socio;
import com.krakedev.examen.bdd.repository.SocioRepository;

@Service
public class ServicioSocio {
	
	@Autowired
	private SocioRepository socioRepository;
	public Socio crear(Socio s) {
        int edadDelSocio = s.getEdad();
        
        if (edadDelSocio < 14) {
            throw new IllegalArgumentException("La edad mínima permitida es 14 años.");
        } else {
            Socio socioGuardado = socioRepository.save(s);
            return socioGuardado;
        }
    }
	
	public List<Socio> listar() {
        List<Socio> listaSocios = socioRepository.findAll();
        return listaSocios;
    }

    public List<Socio> buscarPorEstado(boolean estadoActivo) {
        List<Socio> listaFiltrada = socioRepository.findByActivo(estadoActivo);
        return listaFiltrada;
    }

}
