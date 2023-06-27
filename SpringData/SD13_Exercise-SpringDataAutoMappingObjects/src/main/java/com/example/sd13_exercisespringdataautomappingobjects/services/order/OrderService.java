package com.example.sd13_exercisespringdataautomappingobjects.services.order;

import com.example.sd13_exercisespringdataautomappingobjects.entities.Game;
import com.example.sd13_exercisespringdataautomappingobjects.entities.User;

import java.util.Set;

public interface OrderService {

    void createOrder(User user, Set<Game> shoppingCart);
}
