package com.educandoweb.coursejpa.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.educandoweb.coursejpa.entities.User;
import com.educandoweb.coursejpa.repositories.UserRepository;

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
		return obj.get();
	}

	public User insert(User obj)
	{
		return repository.save(obj);
	}

	public void delete(Long id)
	{
		repository.deleteById(id);
	}

	public User update(Long id, User obj)
	{
		User entity = repository.getOne(id);// getOne - instancia usuário antes de efetuar operação com o bd
		updateData(entity, obj);
		return repository.save(entity);
	}
	
	private void updateData(User entity, User obj)
	{
		entity.setName(obj.getName());
		entity.setEmail(obj.getEmail());
		entity.setPhone(obj.getPhone());
	}
}
