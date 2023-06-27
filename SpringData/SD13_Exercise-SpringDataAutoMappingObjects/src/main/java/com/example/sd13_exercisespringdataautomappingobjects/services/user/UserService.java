package com.example.sd13_exercisespringdataautomappingobjects.services.user;

import com.example.sd13_exercisespringdataautomappingobjects.entities.User;

public interface UserService {

    String registerUser(String[] args);

    String loginUser(String[] userData);

    String logoutUser();

    User getLoggedInUser();

    String getUserOwnedGames();

    String addItemToShoppingCart(String[] data);

    String removeItemFromShoppingCart(String[] data);

    String buyItemsFromShoppingCart();
}
