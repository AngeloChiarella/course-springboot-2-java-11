package com.educandoweb.coursejpa.services;

import java.util.List;
import java.util.Optional;

import javax.persistence.EntityNotFoundException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.stereotype.Service;

import com.educandoweb.coursejpa.entities.User;
import com.educandoweb.coursejpa.repositories.UserRepository;
import com.educandoweb.coursejpa.services.exceptions.DatabaseException;
import com.educandoweb.coursejpa.services.exceptions.ResourceNotFoundException;

@Service // Registra como componente para ser injetado automaticamente com @Autowired
public class UserService
{
	@Autowired
	private UserRepository repository;

	public List<User> findAll()
	{
		return repository.findAll();
	}

	public User findById(Long id)
	{
		Optional<User> obj = repository.findById(id);
		return obj.orElseThrow(() -> new ResourceNotFoundException(id));
	}

	public User insert(User obj)
	{
		return repository.save(obj);
	}

	public void delete(Long id)
	{
		try
		{
			repository.deleteById(id);
		}
//		catch (RuntimeException e) { // para ver o nome da exception 'e.printStackTrace();'
		catch (EmptyResultDataAccessException e)
		{
			throw new ResourceNotFoundException(id);
		}
		catch (DataIntegrityViolationException e)
		{
			throw new DatabaseException(e.getMessage());
		}
	}

	public User update(Long id, User obj)
	{
		try
		{
			User entity = repository.getOne(id);// getOne - instancia usuário antes de efetuar operação com o bd
			updateData(entity, obj);
			return repository.save(entity);
		}
		catch (EntityNotFoundException e)
		{
			throw new ResourceNotFoundException(id);
		}
	}

	private void updateData(User entity, User obj)
	{
		entity.setName(obj.getName());
		entity.setEmail(obj.getEmail());
		entity.setPhone(obj.getPhone());
	}
}
