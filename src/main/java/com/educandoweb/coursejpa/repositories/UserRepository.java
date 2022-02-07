package com.educandoweb.coursejpa.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.educandoweb.coursejpa.entities.User;

public interface UserRepository extends JpaRepository<User, Long>
{

}
