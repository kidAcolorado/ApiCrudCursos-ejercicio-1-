package com.viewnext.kidaprojects.apicrudcursos.repository;

import java.util.List;

import org.springframework.data.jdbc.repository.query.Query;
import org.springframework.data.jpa.repository.JpaRepository;

import com.viewnext.kidaprojects.apicrudcursos.model.Curso;

/**
 * La interfaz {@code CursoRepository} proporciona métodos para acceder y gestionar cursos en la base de datos.
 * 
 * <p>
 * El autor de esta interfaz es Víctor Colorado "Kid A".
 * </p>
 *
 * @version 1.0
 * @since 02 de Octubre de 2023
 */
public interface CursoRepository extends JpaRepository<Curso, String> {

	/**
	 * Busca cursos cuyo precio se encuentra en el rango especificado, incluyendo los extremos.
	 *
	 * @param precioMinimo El precio mínimo del rango.
	 * @param precioMaximo El precio máximo del rango.
	 * @return Una lista de objetos {@code Curso} cuyos precios están dentro del rango especificado.
	 */
	@Query("SELECT c FROM Curso c WHERE c.precio >= :precioMinimo AND c.precio <= :precioMaximo")
	List<Curso> findByPrecioBetween(int precioMinimo, int precioMaximo);


	

}
