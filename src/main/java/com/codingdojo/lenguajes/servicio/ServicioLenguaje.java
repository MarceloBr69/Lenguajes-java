package com.codingdojo.lenguajes.servicio;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.codingdojo.lenguajes.modelo.ModeloLenguaje;
import com.codingdojo.lenguajes.repositorio.RepositorioLenguaje;

@Service
public class ServicioLenguaje {
	@Autowired
	private RepositorioLenguaje repositorioLenguaje;
	
	//Mostrar todo 
	public List<ModeloLenguaje> obtenerTodos(){
		return repositorioLenguaje.findAll(); 
	}
	//Obtener x id
	public ModeloLenguaje obtenerPorId(Long id) {
		Optional<ModeloLenguaje> lenguajeEncontrados = repositorioLenguaje.findById(id); 
		return lenguajeEncontrados.get();
	}
	//Crear
	public ModeloLenguaje crearLenguaje(ModeloLenguaje modelolenguaje) {
		return repositorioLenguaje.save(modelolenguaje); 	
	}
	//Eliminar lenguaje
	public void eliminarLenguaje(Long id) {
		repositorioLenguaje.deleteById(id);
	}
	
	//Modificar
	public ModeloLenguaje modificarLenguaje(ModeloLenguaje modelolenguaje) {
		return repositorioLenguaje.save(modelolenguaje); 
	}
	
}
