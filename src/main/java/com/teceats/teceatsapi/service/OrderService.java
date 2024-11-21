package com.teceats.teceatsapi.service;

import com.teceats.teceatsapi.model.*;
import com.teceats.teceatsapi.repository.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class OrderService {

    private final OrderRepository orderRepository;

    @Autowired
    public OrderService(OrderRepository orderRepository) {
        this.orderRepository = orderRepository;
    }

    public List<Order> getAllOrders() {
        return orderRepository.findAll();
    }

    public Optional<Order> getOrderById(Long id) {
        return orderRepository.findById(id);
    }

    public Order createOrder(Order order) {
        return orderRepository.save(order);
    }

    public Order updateOrder(Long id, Order updatedOrder) {
        Optional<Order> existingOrderOpt = orderRepository.findById(id);
        if (existingOrderOpt.isPresent()) {
            Order existingOrder = existingOrderOpt.get();
            existingOrder.setEstado(updatedOrder.getEstado());
            existingOrder.setDireccionEntrega(updatedOrder.getDireccionEntrega());
            existingOrder.setRepartidor(updatedOrder.getRepartidor());
            return orderRepository.save(existingOrder);
        } else {
            throw new RuntimeException("Order not found with id " + id);
        }
    }

    public void deleteOrder(Long id) {
        orderRepository.deleteById(id);
    }
}

