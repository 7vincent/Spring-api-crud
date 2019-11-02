package dev.fujioka.java.avancado.web.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import dev.fujioka.java.avancado.web.domain.Curso;
import dev.fujioka.java.avancado.web.repository.CursoRepository;

@Service
public class CursoService implements CrudInterface<Curso> {
	
	@Autowired
	private CursoRepository cursoRepository;

	@Override
	public List<Curso> findAll() {
		// TODO Auto-generated method stub
		return cursoRepository.findAll();
	}

	@Override
	public Optional<Curso> save(Curso entity) {
		return Optional.ofNullable(cursoRepository.save(entity));
	}

	@Override
	public Optional<Curso> findById(long id) {
		// TODO Auto-generated method stub
		return cursoRepository.findById(id);
	}

	@Override
	public void delete(Curso entity) {
		cursoRepository.delete(entity);
		
	}

	@Override
	public void deleteById(long id) {
		cursoRepository.deleteById(id);
		
	}

	@Override
	public long count() {
		// TODO Auto-generated method stub
		return 0;
	}
}
