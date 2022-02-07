package com.educandoweb.coursejpa.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.educandoweb.coursejpa.entities.Order;
import com.educandoweb.coursejpa.repositories.OrderRepository;

@Service // Registra como componente para ser injetado automaticamente com @Autowired
public class OrderService
{
	@Autowired
	private OrderRepository repository;

	public List<Order> findAll()
	{
		return repository.findAll();
	}

	public Order findById(Long id)
	{
		Optional<Order> obj = repository.findById(id);
		return obj.get();
	}
}
