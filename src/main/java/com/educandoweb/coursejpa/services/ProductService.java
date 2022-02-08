package com.educandoweb.coursejpa.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.educandoweb.coursejpa.entities.Product;
import com.educandoweb.coursejpa.repositories.ProductRepository;

@Service // Registra como componente para ser injetado automaticamente com @Autowired
public class ProductService
{
	@Autowired
	private ProductRepository repository;

	public List<Product> findAll()
	{
		return repository.findAll();
	}

	public Product findById(Long id)
	{
		Optional<Product> obj = repository.findById(id);
		return obj.get();
	}
}
