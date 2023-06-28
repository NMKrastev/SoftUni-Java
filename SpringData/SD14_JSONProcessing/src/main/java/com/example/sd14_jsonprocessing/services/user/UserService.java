package com.example.sd14_jsonprocessing.services.user;

import com.example.sd14_jsonprocessing.entities.User;
import com.example.sd14_jsonprocessing.entities.dtos.user.UserBasicInfoDTO;
import com.example.sd14_jsonprocessing.entities.dtos.user.UserLoginDTO;

public interface UserService {

    UserBasicInfoDTO registerUser(String userData);

    UserBasicInfoDTO loginUser(String userData);

    String logoutUser();

    User getLoggedInUser();

    String getUserOwnedGames();

    String addItemToShoppingCart(String data);

    String removeItemFromShoppingCart(String data);

    String buyItemsFromShoppingCart();
}
