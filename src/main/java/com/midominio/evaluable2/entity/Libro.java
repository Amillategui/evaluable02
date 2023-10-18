package com.midominio.evaluable2.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table (name ="libros")
public class Libro {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY ) 
	private Long id;
	@Column (name  = "nobre_libro")
	private String nombreDeLibro;
	@Column(name = "cantidad_Ejemplares")
	private int cantidadDejemplares;
	private String editorial;
	private String tematica;
	public Long getId() {
		return id;
	}
	public String getNombreDeLibro() {
		return nombreDeLibro;
	}
	public void setNombreDeLibro(String nombreDeLibro) {
		this.nombreDeLibro = nombreDeLibro;
	}
	public int getCantidadDejemplares() {
		return cantidadDejemplares;
	}
	public void setCantidadDejemplares(int cantidadDejemplares) {
		this.cantidadDejemplares = cantidadDejemplares;
	}
	public String getEditorial() {
		return editorial;
	}
	public void setEditorial(String editorial) {
		this.editorial = editorial;
	}
	public String getTematica() {
		return tematica;
	}
	public void setTematica(String tematica) {
		this.tematica = tematica;
	}
	public void setId(Long id) {
		this.id = id;
	}
	

}
