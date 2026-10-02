package com.krakedev.asistencias.servicios;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.ArrayList;

import org.springframework.stereotype.Service;

import com.krakedev.asistencias.Asistencia;
import com.krakedev.asistencias.Estudiante;
import com.krakedev.asistencias.RegistroAsistencia;

@Service
public class ServicioAsistencia {
 private ArrayList<RegistroAsistencia> registro = new ArrayList<RegistroAsistencia>();
 
 private final ServicioEstudiantes servicioEstudiantes;
 
 public ServicioAsistencia(ServicioEstudiantes servicioEstudiantes) {
	 this.servicioEstudiantes = servicioEstudiantes;
	 
 }
 
 public RegistroAsistencia registrarAsistencia(String cedula) {
	 Estudiante encontrado = servicioEstudiantes.buscarPorCedula(cedula);
	 if(encontrado == null) {
		 return null;
	 }
	 Asistencia asistencia = new Asistencia(LocalDate.now(), LocalDateTime.now(), "P");
	 RegistroAsistencia registroAsistencia  = new RegistroAsistencia(encontrado, asistencia);
	 registro.add(registroAsistencia);
	 
	 return registroAsistencia;
 }
 
 public ArrayList<Asistencia>consultarAsistencia(String cedula){
	 ArrayList<Asistencia> asistencias = new ArrayList<Asistencia>();
	 
	 for(RegistroAsistencia reg : registro) {
		 if(reg.getEstudiante().getCedula().equals(cedula)) {
			 asistencias.add(reg.getAsistencia());
		 }
	 }
	 return asistencias;
 }
 
}
