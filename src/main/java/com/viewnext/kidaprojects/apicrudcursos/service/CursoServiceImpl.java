package com.viewnext.kidaprojects.apicrudcursos.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.viewnext.kidaprojects.apicrudcursos.model.Curso;
import com.viewnext.kidaprojects.apicrudcursos.repository.CursoRepository;

import jakarta.persistence.EntityNotFoundException;

/**
 * La clase {@code CursoServiceImpl} implementa la interfaz {@code CursoService} y proporciona
 * métodos para gestionar cursos.
 *
 * <p>
 * El autor de esta clase es Víctor Colorado "Kid A".
 * </p>
 *
 * @version 1.0
 * @since 02 de Octubre de 2023
 */
@Service
public class CursoServiceImpl implements CursoService{
	
	@Autowired
	private CursoRepository cursoRepository;

	/**
     * Da de alta un curso en el sistema.
     *
     * @param curso El curso que se va a dar de alta.
     * @return Una lista de todos los cursos después de dar de alta el nuevo curso.
     */
	@Override
	public List<Curso> darAltaCurso(Curso curso) {
		cursoRepository.save(curso);
				
		return cursoRepository.findAll();
	}

	/**
     * Elimina un curso del sistema por su código.
     *
     * @param codigoCurso El código del curso que se va a eliminar.
     * @return Una lista de todos los cursos después de eliminar el curso.
     * @throws EntityNotFoundException Si no se encuentra ningún curso con el código dado.
     */
	@Override
	public List<Curso> eliminarCurso(String codigoCurso) throws EntityNotFoundException{
		if(!cursoRepository.existsById(codigoCurso)) {
			throw new EntityNotFoundException();
		}
		
		cursoRepository.deleteById(codigoCurso);
		
		return cursoRepository.findAll();
	}

	/**
     * Actualiza la duración de un curso en el sistema por su código.
     *
     * @param codigoCurso El código del curso cuya duración se va a actualizar.
     * @param duracion La nueva duración del curso.
     * @throws EntityNotFoundException Si no se encuentra ningún curso con el código dado.
     */
	@Override
	public void actualizarDuracionCurso(String codigoCurso, int duracion) throws EntityNotFoundException {
		Optional<Curso> optionalCurso = cursoRepository.findById(codigoCurso);
		
		if(optionalCurso.isEmpty()) {
			throw new EntityNotFoundException();
		}
		
		Curso curso = optionalCurso.get();
		
		curso.setDuracion(duracion);
		
		cursoRepository.save(curso);
		
	}

	/**
     * Busca un curso por su código.
     *
     * @param codigoCurso El código del curso que se desea buscar.
     * @return El curso encontrado.
     * @throws EntityNotFoundException Si no se encuentra ningún curso con el código dado.
     */
	@Override
	public Curso buscarCursoPorCodigo(String codigoCurso) throws EntityNotFoundException{
		Optional<Curso> optionalCurso = cursoRepository.findById(codigoCurso);
		
		if(optionalCurso.isEmpty()) {
			throw new EntityNotFoundException();
		}
		
		return optionalCurso.get();
	}

	/**
     * Busca cursos por rango de precios.
     *
     * @param precioMinimo El precio mínimo del rango.
     * @param precioMaximo El precio máximo del rango.
     * @return Una lista de cursos que se encuentran en el rango de precios.
     * @throws EntityNotFoundException Si no se encuentra ningún curso en el rango de precios dado.
     */
	@Override
	public List<Curso> buscarCursosPorRangoPrecios(int precioMinimo, int precioMaximo) throws EntityNotFoundException{
		List<Curso> listaCursos = cursoRepository.findCursosPriceRange(precioMinimo, precioMaximo);
		
		if(listaCursos.isEmpty()) {
			throw new EntityNotFoundException();
		}
		
		
		return listaCursos;
	}
	
	

}
