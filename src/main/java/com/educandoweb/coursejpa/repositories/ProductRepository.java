package com.educandoweb.coursejpa.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.educandoweb.coursejpa.entities.Product;

public interface ProductRepository extends JpaRepository<Product, Long>
{

}
