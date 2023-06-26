package com.example.sd13_exercisespringdataautomappingobjects.services.order;

import com.example.sd13_exercisespringdataautomappingobjects.entities.Game;
import com.example.sd13_exercisespringdataautomappingobjects.entities.Order;
import com.example.sd13_exercisespringdataautomappingobjects.entities.User;
import com.example.sd13_exercisespringdataautomappingobjects.repositories.OrderRepository;
import com.example.sd13_exercisespringdataautomappingobjects.repositories.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

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
    public void createOrder() {

        final User user = this.userRepository.findUserById(1L).get();

        final Set<Game> games = user.getGames();

        final Order order = new Order(user, games);

        this.orderRepository.save(order);


        System.out.println();
    }
}
