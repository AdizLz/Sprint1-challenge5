package com.tienda.repository;

import com.tienda.model.Order;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

/**
 * Repositorio para gestionar operaciones de base de datos.
 */
@Repository
public interface OrderRepository extends JpaRepository<Order, Long> {
}