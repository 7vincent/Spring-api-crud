package dev.fujioka.java.avancado.web.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import dev.fujioka.java.avancado.web.domain.Disciplina;
import dev.fujioka.java.avancado.web.repository.DisciplinaRepository;

@Service
public class DisciplinaService implements CrudInterface<Disciplina> {
	
	@Autowired
	private DisciplinaRepository disciplinaRepository;

	@Override
	public List<Disciplina> findAll() {
		// TODO Auto-generated method stub
		return disciplinaRepository.findAll();
	}

	@Override
	public Optional<Disciplina> save(Disciplina entity) {
		return Optional.ofNullable(disciplinaRepository.save(entity));
	}

	@Override
	public Optional<Disciplina> findById(long id) {
		// TODO Auto-generated method stub
		return disciplinaRepository.findById(id);
	}

	@Override
	public void delete(Disciplina entity) {
		disciplinaRepository.delete(entity);
		
	}

	@Override
	public void deleteById(long id) {
		disciplinaRepository.deleteById(id);
		
	}

	@Override
	public long count() {
		// TODO Auto-generated method stub
		return 0;
	}




}
