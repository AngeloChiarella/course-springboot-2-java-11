package com.educandoweb.coursejpa.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.educandoweb.coursejpa.entities.Order;

public interface OrderRepository extends JpaRepository<Order, Long>
{

}
