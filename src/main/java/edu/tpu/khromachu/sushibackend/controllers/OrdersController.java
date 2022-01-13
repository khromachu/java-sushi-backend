package edu.tpu.khromachu.sushibackend.controllers;

import edu.tpu.khromachu.sushibackend.domain.Order;
import edu.tpu.khromachu.sushibackend.domain.User;
import edu.tpu.khromachu.sushibackend.repository.OrderRepository;

import edu.tpu.khromachu.sushibackend.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.time.OffsetDateTime;
import java.util.List;
import java.util.Map;
import java.util.Optional;

@RestController
public class OrdersController {

    @Autowired
    private OrderRepository or;

    @Autowired
    private UserRepository ur;

    @GetMapping("/api/orders/get/all")
    public List<Order> getAllOrders() {
            System.out.println(or.findAll().toString());
            return or.findAll();
    }

    @GetMapping("/api/orders/get/by/id/")
    public Order getOrderById(Integer id) {
        Optional<Order> order = or.findById(id);
        return order.orElse(null);
    }

    @PostMapping("/api/orders/create")
    public void createOrder(@RequestBody Map<String, Object> order){
        System.out.println(order);
        Order newOrder = new Order();
        User clientId = ur.getById((Integer) order.get("clientId"));

        newOrder.setAddress((String)order.get("address"));
        newOrder.setClientName((String) order.get("clientName"));
        newOrder.setClientPhone((String)order.get("clientPhone"));
        newOrder.setCreatedAt(OffsetDateTime.now());
        newOrder.setUpdatedAt(OffsetDateTime.now());
        newOrder.setStatus((Integer) order.get("status"));
        newOrder.setClientId(clientId);

        or.save(newOrder);
    }

    @PostMapping("/api/orders/updateStatus/{id}")
    public void updateOrderStatus(@PathVariable Integer id,@RequestBody Map<String, Object> orderDetails){

        System.out.println(id);
        Order order = or.getById(id);

        order.setStatus((Integer)orderDetails.get("status"));

        or.save(order);
    }
}
