package com.educandoweb.coursejpa.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.educandoweb.coursejpa.entities.Category;
import com.educandoweb.coursejpa.repositories.CategoryRepository;

@Service // Registra como componente para ser injetado automaticamente com @Autowired
public class CategoryService
{
	@Autowired
	private CategoryRepository repository;

	public List<Category> findAll()
	{
		return repository.findAll();
	}

	public Category findById(Long id)
	{
		Optional<Category> obj = repository.findById(id);
		return obj.get();
	}
}
