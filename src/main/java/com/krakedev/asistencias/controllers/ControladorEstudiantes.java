package com.krakedev.asistencias.controllers;

import java.util.ArrayList;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.krakedev.asistencias.Estudiante;
import com.krakedev.asistencias.servicios.ServicioEstudiantes;

@RestController
@RequestMapping("/estudiantes")
public class ControladorEstudiantes {

	private final ServicioEstudiantes servicioEstudiantes;
	public ControladorEstudiantes(ServicioEstudiantes servicioEstudiantes) {
		this.servicioEstudiantes = servicioEstudiantes;
	}
		
		@GetMapping
	public ArrayList<Estudiante> listar() {
			return servicioEstudiantes.listar();
	}
		
		@GetMapping("/{cedula}")
		public Estudiante buscarPorCedula(@PathVariable String cedula) {
			return servicioEstudiantes.buscarPorCedula(cedula);
		}
		
	@PostMapping
	public void agregar(@RequestBody Estudiante estudiante) {
		servicioEstudiantes.agregar(estudiante);
	}
	
}
