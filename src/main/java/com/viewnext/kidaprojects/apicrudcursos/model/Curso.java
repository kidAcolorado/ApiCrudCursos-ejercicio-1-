package com.viewnext.kidaprojects.apicrudcursos.model;

import java.util.Objects;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;

/**
 * La clase {@code Curso} representa un curso con la siguiente información:
 * - Código del curso.
 * - Nombre del curso.
 * - Número de horas de duración del curso.
 * - Precio del curso.
 * 
 * <p>
 * El autor de esta clase es Víctor Colorado "Kid A".
 * </p>
 *
 * @version 1.0
 * @since 02 de Octubre de 2023
 */
@Entity
public class Curso {

	@Id
	private String codigoCurso;
	private String nombre;
	private int duracion; 
	private int precio;
	
	public Curso(String codigoCurso, String nombre, int duracion, int precio) {
		super();
		this.codigoCurso = codigoCurso;
		this.nombre = nombre;
		this.duracion = duracion;
		this.precio = precio;
	}

	public Curso() {
		super();
	}

	public String getCodigoCurso() {
		return codigoCurso;
	}

	public void setCodigoCurso(String codigoCurso) {
		this.codigoCurso = codigoCurso;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public int getDuracion() {
		return duracion;
	}

	public void setDuracion(int duracion) {
		this.duracion = duracion;
	}

	public int getPrecio() {
		return precio;
	}

	public void setPrecio(int precio) {
		this.precio = precio;
	}

	@Override
	public int hashCode() {
		return Objects.hash(codigoCurso);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Curso other = (Curso) obj;
		return Objects.equals(codigoCurso, other.codigoCurso);
	}

	@Override
	public String toString() {
		return "Curso [codigoCurso=" + codigoCurso + ", nombre=" + nombre + ", duracion=" + duracion + ", precio="
				+ precio + "]";
	}
	
	
	
}
