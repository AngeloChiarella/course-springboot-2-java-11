package com.educandoweb.coursejpa.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.educandoweb.coursejpa.entities.OrderItem;

public interface OrderItemRepository extends JpaRepository<OrderItem, Long>
{

}
