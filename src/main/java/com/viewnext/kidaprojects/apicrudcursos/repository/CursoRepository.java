package com.viewnext.kidaprojects.apicrudcursos.repository;

import java.util.List;

import org.springframework.data.jdbc.repository.query.Query;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.query.Param;

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
     * Recupera una lista de cursos cuyos precios están dentro de un rango especificado.
     *
     * @param precioMinimo Precio mínimo del rango.
     * @param precioMaximo Precio máximo del rango.
     * @return Una lista de cursos que cumplen con el rango de precios especificado.
     */
	@Query("SELECT c FROM Curso c WHERE c.precio >= :precioMinimo AND c.precio <= :precioMaximo")
	public List<Curso> findCursosPriceRange(@Param("precioMinimo") int precioMinimo, @Param("precioMaximo")  int precioMaximo);
}
