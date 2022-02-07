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
}
