package com.tienda.service;

import com.tienda.model.Order;
import com.tienda.repository.OrderRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

/**
 * Servicio con la lógica de negocio para órdenes.
 *
 * Proporciona operaciones CRUD sobre la entidad Order utilizando JPA.
 */
@Service
public class OrderService {

    @Autowired
    private OrderRepository orderRepository;

    /**
     * Crea una nueva orden en la base de datos.
     * @param order información de la orden
     * @return la orden persistida
     */
    public Order createOrder(Order order) {
        return orderRepository.save(order);
    }

    /**
     * Obtiene todas las órdenes almacenadas.
     * @return lista de órdenes
     */
    public List<Order> getAllOrders() {
        return orderRepository.findAll();
    }

    /**
     * Busca una orden por su id.
     * @param id identificador de la orden
     * @return Optional con la orden si existe
     */
    public Optional<Order> getOrderById(Long id) {
        return orderRepository.findById(id);
    }

    /**
     * Actualiza una orden existente.
     * @param id identificador de la orden a actualizar
     * @param orderDetails datos con los que actualizar
     * @return Optional con la orden actualizada o vacío si no existe
     */
    public Optional<Order> updateOrder(Long id, Order orderDetails) {
        Optional<Order> existingOrder = orderRepository.findById(id);

        if (existingOrder.isPresent()) {
            Order order = existingOrder.get();
            order.setCustomerName(orderDetails.getCustomerName());
            order.setCustomerEmail(orderDetails.getCustomerEmail());
            order.setProductDescription(orderDetails.getProductDescription());
            order.setQuantity(orderDetails.getQuantity());
            order.setTotalPrice(orderDetails.getTotalPrice());
            order.setStatus(orderDetails.getStatus());

            return Optional.of(orderRepository.save(order));
        }

        return Optional.empty();
    }

    /**
     * Elimina una orden por su id.
     * @param id identificador
     * @return true si se eliminó, false si no existía
     */
    public boolean deleteOrder(Long id) {
        if (orderRepository.existsById(id)) {
            orderRepository.deleteById(id);
            return true;
        }
        return false;
    }
}