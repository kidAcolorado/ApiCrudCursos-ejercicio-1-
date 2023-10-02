package com.viewnext.kidaprojects.apicrudcursos.restcontroller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;


import com.viewnext.kidaprojects.apicrudcursos.model.Curso;
import com.viewnext.kidaprojects.apicrudcursos.service.CursoService;

import jakarta.persistence.EntityNotFoundException;

/**
 * La clase {@code CursoRestController} proporciona un controlador REST para gestionar las operaciones relacionadas
 * con cursos en la base de datos. Permite crear, leer, actualizar y eliminar cursos, así como buscar cursos por
 * código y por rango de precios.
 *
 * <p>
 * El autor de esta clase es Víctor Colorado "Kid A".
 * </p>
 *
 * @version 1.0
 * @since 2 de octubre de 2023
 */
@RestController
public class CursoRestController {

	@Autowired
	private CursoService cursoService;

	private static final String CURSO_NOT_FOUND = "Curso/s con los argumentos introducidos no encontrado";

	/**
     * Crea un nuevo curso en la base de datos.
     *
     * @param curso El curso que se va a crear.
     * @return Una respuesta HTTP con la lista de cursos en formato JSON después de crear el curso.
     */
	@PostMapping(value = "curso", produces = MediaType.APPLICATION_JSON_VALUE, consumes = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<?> darAltaCurso(Curso curso) {
		try {
			List<Curso> listaCursos = cursoService.darAltaCurso(curso);
			return ResponseEntity.ok(listaCursos);
		} catch (EntityNotFoundException e) {
			return ResponseEntity.status(HttpStatus.NOT_FOUND).body(CURSO_NOT_FOUND);
		}

	}

	/**
     * Elimina un curso de la base de datos por su código.
     *
     * @param codigo El código del curso que se va a eliminar.
     * @return Una respuesta HTTP con la lista de cursos en formato JSON después de eliminar el curso.
     */
	@DeleteMapping(value = "curso/{codigo}", produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<?> eliminarCurso(@PathVariable("codigo") String codigo) {

		try {
			List<Curso> listaCursos = cursoService.eliminarCurso(codigo);
			return ResponseEntity.ok(listaCursos);
		} catch (EntityNotFoundException e) {
			return ResponseEntity.status(HttpStatus.NOT_FOUND).body(CURSO_NOT_FOUND);
		}
	}

	/**
     * Actualiza la duración de un curso en la base de datos por su código.
     *
     * @param codigo   El código del curso que se va a actualizar.
     * @param duracion La nueva duración del curso.
     * @return Una respuesta HTTP sin contenido (204) después de actualizar la duración del curso.
     */
	@PutMapping(value = "curso/{codigo}/{duracion}")
	public ResponseEntity<?> actualizarDuracionCurso(@RequestParam("codigo") String codigo,
			@RequestParam("duracion") int duracion) {
		try {
			cursoService.actualizarDuracionCurso(codigo, duracion);
			return ResponseEntity.ok().build();
		} catch (EntityNotFoundException e) {
			return ResponseEntity.status(HttpStatus.NOT_FOUND).body(CURSO_NOT_FOUND);
		}

	}

	 /**
     * Busca un curso por su código.
     *
     * @param codigo El código del curso que se desea obtener.
     * @return Una respuesta HTTP con el curso en formato JSON.
     */
	@GetMapping(value = "curso/{codigo}", produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<?> buscarCursoPorCodigo(@PathVariable("codigo") String codigo) {
		try {
			Curso curso = cursoService.buscarCursoPorCodigo(codigo);
			return ResponseEntity.ok(curso);
		} catch (EntityNotFoundException e) {
			return ResponseEntity.status(HttpStatus.NOT_FOUND).body(CURSO_NOT_FOUND);
		}

	}

	/**
     * Busca cursos por rango de precios.
     *
     * @param precioMinimo El precio mínimo de los cursos a buscar.
     * @param precioMaximo El precio máximo de los cursos a buscar.
     * @return Una respuesta HTTP con la lista de cursos en formato JSON que se encuentran en el rango de precios especificado.
     */
	@GetMapping(value = "curso/precios/{precioMinimo}/{precioMaximo}", produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<?> buscarCursosPorRangoPrecios(@RequestParam("precioMinimo") int precioMinimo,
			@RequestParam("precioMaximo") int precioMaximo) {

		try {
			List<Curso> listaCursos = cursoService.buscarCursosPorRangoPrecios(precioMinimo, precioMaximo);
			return ResponseEntity.ok(listaCursos);
		} catch (EntityNotFoundException e) {
			return ResponseEntity.status(HttpStatus.NOT_FOUND).body(CURSO_NOT_FOUND);
		}
	}

}
