package com.codingdojo.lenguajes.controlador;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;

import com.codingdojo.lenguajes.modelo.ModeloLenguaje;
import com.codingdojo.lenguajes.servicio.ServicioLenguaje;

import jakarta.validation.Valid;

@Controller
public class ApiLenguaje {
	@Autowired
	private ServicioLenguaje  servicioLenguaje;

	
	@GetMapping("/")
	public String home(@ModelAttribute("modelolenguaje") ModeloLenguaje modeloLenguaje) {
		return "home.jsp"; 
	}
	
	
	//Obtener todos los lenguajes, con este se muestra la informacion
	@GetMapping("/lenguajes")
	public String create(Model model, @ModelAttribute("modelolenguaje") ModeloLenguaje modelolenguaje) {
		List<ModeloLenguaje> lenguajes = this.servicioLenguaje.obtenerTodos();
		model.addAttribute("lenguajesProgramacion", lenguajes); //el primer parametro debe coincidir con el nombre del jsp
		return "home.jsp"; 
	}
	
	//CrearLenguajes Controlador
	@PostMapping("/crearLenguaje")
	public String create(@Valid @ModelAttribute("modelolenguaje") ModeloLenguaje modelolenguaje,
						BindingResult result) {
		if(result.hasErrors()) {
			return "home.jsp";
		}
		else {
			servicioLenguaje.crearLenguaje(modelolenguaje);
			return "redirect:/lenguajes";
		}
	}


	
	
	
	//Quien lo elimina
	@DeleteMapping("/lenguaje/eliminar/{id}")
	public String eliminarLenguaje(@PathVariable("id") Long id, @ModelAttribute("modelolenguaje") ModeloLenguaje modelolenguaje) {
		this.servicioLenguaje.eliminarLenguaje(id);
		return "redirect:/lenguajes";
	}
	
	//Zona donde muestra informacion y se realiza el cambio
	@GetMapping("/lenguaje/modificar/{id}")
	public String mostrarInformacionAModificar(@PathVariable("id") Long id, 
												@ModelAttribute("modelolenguaje") ModeloLenguaje modelolenguaje,
												Model model) {
												
		ModeloLenguaje lenguajeActual= this.servicioLenguaje.obtenerPorId(id); 
		model.addAttribute("lenguajeActual", lenguajeActual); 
		return "editar.jsp"; 
	}
	//Proceso de cambio
	@PutMapping("/editar/{id}")
	public String editarLenguajeProceso(@Valid @ModelAttribute("modelolenguaje") ModeloLenguaje modelolenguaje, 
												BindingResult result,
												@PathVariable("id") Long id) {
		if(result.hasErrors()) {
			return "editar.jsp";
		}
		else {
			this.servicioLenguaje.modificarLenguaje(modelolenguaje); 
			return "redirect:/lenguajes";
		}
	}
}
