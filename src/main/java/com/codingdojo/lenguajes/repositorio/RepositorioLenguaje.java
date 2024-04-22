package com.codingdojo.lenguajes.repositorio;

import java.util.List;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.codingdojo.lenguajes.modelo.ModeloLenguaje;

@Repository
public interface RepositorioLenguaje extends CrudRepository <ModeloLenguaje, Long>{
	
	//Encontrar todos
	List<ModeloLenguaje> findAll();
	//Eliminar x id
	void deleteById(Long id);
	
	
}	
