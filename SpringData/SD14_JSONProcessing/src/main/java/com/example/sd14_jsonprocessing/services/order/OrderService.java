package com.example.sd14_jsonprocessing.services.order;

import com.example.sd14_jsonprocessing.entities.Game;
import com.example.sd14_jsonprocessing.entities.User;

import java.util.Set;

public interface OrderService {

    void createOrder(User user, Set<Game> shoppingCart);
}
