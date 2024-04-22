package com.codingdojo.lenguajes.modelo;

import java.util.Date;

import org.springframework.format.annotation.DateTimeFormat;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.PrePersist;
import jakarta.persistence.PreUpdate;
import jakarta.persistence.Table;
import jakarta.validation.constraints.Size;

@Entity
@Table(name="lenguajesProgramacion")
public class ModeloLenguaje {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY) 
	private Long id; 
	
	@Size(min = 2, max = 20) 
	private String nombre;
	@Size(min = 2, max = 20)
	private String creador;
	private String version; //Decido hacerlo string por si alguna version posea letras
	
	//Creacion y update
	@Column(updatable=false)
	@DateTimeFormat(pattern="dd-MM-yyyy")
	private Date fechaCreacion;
	@DateTimeFormat(pattern="dd-MM-yyyy")
	private Date fechaActualizacion;
	
	
	@PrePersist
	protected void onCreate() {
		this.fechaCreacion = new Date(); 
	}
	@PreUpdate
	protected void onUpdate() {
		this.fechaActualizacion =  new Date();
	}
	
	
	//Constructores
	public ModeloLenguaje() {}
	
	public ModeloLenguaje(@Size(min = 2, max = 20) String nombre, @Size(min = 2, max = 20) String creador,
			String version) {
		this.nombre = nombre;
		this.creador = creador;
		this.version = version;
	}

	
	//Getters and Setters
	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public String getCreador() {
		return creador;
	}

	public void setCreador(String creador) {
		this.creador = creador;
	}

	public String getVersion() {
		return version;
	}

	public void setVersion(String version) {
		this.version = version;
	}

	public Date getFechaCreacion() {
		return fechaCreacion;
	}

	public void setFechaCreacion(Date fechaCreacion) {
		this.fechaCreacion = fechaCreacion;
	}

	public Date getFechaActualizacion() {
		return fechaActualizacion;
	}

	public void setFechaActualizacion(Date fechaActualizacion) {
		this.fechaActualizacion = fechaActualizacion;
	}


	
	
	
	
	
	
}
