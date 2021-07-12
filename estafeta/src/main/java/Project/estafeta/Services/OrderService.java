package Project.estafeta.Services;

import Project.estafeta.Models.Order;
import Project.estafeta.Repositories.OrderRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Service;

import java.lang.annotation.Annotation;
import java.util.*;

@Service
public class OrderService {

    private final OrderRepository orderRepository;
    private long id = 1;

    @Autowired
    public OrderService(OrderRepository orderRepository) {
        this.orderRepository = orderRepository;
        this.id = id;
    }

    public long getIdCounter() {
        return this.id;
    }

    //Method to add an order to the orders queue
    public void addOrder(Order o) {
        o.setId(id);
        Optional<Order> orderOptional = orderRepository.findOrderById(id);
        if (orderOptional.isPresent()) {
            throw new IllegalStateException("order already exists");
        }
        orderRepository.save(o);
        id++;
    }

    public List getAllOrders() {
        return orderRepository.findAllOrders();
    }

    public Order getCourierOrder(Long courier_id) {
        Optional<Order> orderOptional = orderRepository.findOrderByCourier_id(courier_id);
        if (orderOptional.isPresent()) {
            return orderOptional.get();
        }
        return null;
    }

    public Class<? extends Annotation> annotationType() {
        return null;
    }

    public List<Order> findAllOrders() {
        return orderRepository.findAllOrders();
    }

    public List<Order> getOrdersByCourierId(Long courier_id) {
        return orderRepository.findOrderCourier_id(courier_id);
    }

    public List findActiveOrders() {
        return orderRepository.findActiveOrders();
    }
}