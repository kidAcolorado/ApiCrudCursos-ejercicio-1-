package com.viewnext.kidaprojects.apicrudcursos.service;

import java.util.List;

import com.viewnext.kidaprojects.apicrudcursos.model.Curso;

/**
 * La interfaz {@code CursoService} define los métodos para gestionar cursos.
 * 
 * <p>
 * El autor de esta interfaz es Víctor Colorado "Kid A".
 * </p>
 *
 * @version 1.0
 * @since 02 de Octubre de 2023
 */
public interface CursoService {
	
	public List<Curso> mostrarCursos();
	
	/**
     * Da de alta un nuevo curso.
     *
     * @param curso El curso que se va a dar de alta.
     * @return Una lista de cursos que incluye el curso recién agregado.
     */
	public List<Curso> darAltaCurso(Curso curso);
	
    /**
     * Elimina un curso por su código.
     *
     * @param codigoCurso El código del curso que se va a eliminar.
     * @return Una lista de cursos que excluye el curso eliminado.
     */
	public List<Curso> eliminarCurso(String codigoCurso);
	
    /**
     * Actualiza la duración de un curso por su código.
     *
     * @param codigoCurso El código del curso que se va a actualizar.
     * @param duracion La nueva duración del curso.
     */
	public void actualizarDuracionCurso(String codigoCurso, int duracion);
	
    /**
     * Busca un curso por su código.
     *
     * @param codigoCurso El código del curso que se desea buscar.
     * @return El curso encontrado o null si no se encuentra.
     */
	public Curso buscarCursoPorCodigo(String codigoCurso);
	
    /**
     * Busca cursos cuyos precios estén dentro de un rango especificado.
     *
     * @param precioMinimo Precio mínimo del rango.
     * @param precioMaximo Precio máximo del rango.
     * @return Una lista de cursos que cumplen con el rango de precios especificado.
     */
	public List<Curso> buscarCursosPorRangoPrecios(int precioMinimo, int precioMaximo);

}
