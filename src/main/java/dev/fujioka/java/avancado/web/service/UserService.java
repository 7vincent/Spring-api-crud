package dev.fujioka.java.avancado.web.service;

import dev.fujioka.java.avancado.web.domain.User;
import dev.fujioka.java.avancado.web.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class UserService implements CrudInterface<User> {

	@Autowired
	private UserRepository userRepository;
	
	@Override
	public List<User> findAll() {
		// TODO Auto-generated method stub
		return userRepository.findAll();
	}

	@Override
	public Optional<User> save(User entity) {
		
		return Optional.ofNullable(userRepository.save(entity));
	}

	@Override
	public Optional<User> findById(long id) {
		// TODO Auto-generated method stub
		return userRepository.findById(id);
	}

	@Override
	public void delete(User entity) {
		userRepository.delete(entity);
		
	}

	@Override
	public void deleteById(long id) {
		userRepository.deleteById(id);
		
	}

	@Override
	public long count() {
		// TODO Auto-generated method stub
		return 0;
	}


  
}
