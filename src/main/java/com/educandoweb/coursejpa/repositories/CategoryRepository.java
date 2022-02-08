package com.educandoweb.coursejpa.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.educandoweb.coursejpa.entities.Category;

public interface CategoryRepository extends JpaRepository<Category, Long>
{

}
