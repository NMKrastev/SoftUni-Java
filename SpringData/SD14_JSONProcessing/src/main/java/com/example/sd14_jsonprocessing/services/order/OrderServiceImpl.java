package com.example.sd14_jsonprocessing.services.order;


import com.example.sd14_jsonprocessing.entities.Game;
import com.example.sd14_jsonprocessing.entities.Order;
import com.example.sd14_jsonprocessing.entities.User;
import com.example.sd14_jsonprocessing.repositories.OrderRepository;
import com.example.sd14_jsonprocessing.repositories.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Set;

@Service
public class OrderServiceImpl implements OrderService {

    private final OrderRepository orderRepository;
    private final UserRepository userRepository;

    @Autowired
    public OrderServiceImpl(OrderRepository orderRepository, UserRepository userRepository) {
        this.orderRepository = orderRepository;
        this.userRepository = userRepository;
    }

    @Override
    @Transactional
    public void createOrder(User user, Set<Game> shoppingCart) {

        final Order order = new Order(user, shoppingCart);

        this.orderRepository.save(order);
    }
}
