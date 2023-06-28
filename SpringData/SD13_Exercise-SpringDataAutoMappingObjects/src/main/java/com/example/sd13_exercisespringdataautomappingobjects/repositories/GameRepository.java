package com.example.sd13_exercisespringdataautomappingobjects.repositories;

import com.example.sd13_exercisespringdataautomappingobjects.entities.Game;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface GameRepository extends JpaRepository<Game, Long> {

    Optional<Game> findFirstByTitle(String title);

    @Query(nativeQuery = true, value = "DELETE FROM orders_products WHERE product_id = ?1")
    @Modifying
    void deleteGameInOrdersById(Long gameId);

    @Query(nativeQuery = true, value = "DELETE FROM users_games WHERE game_id = ?1")
    @Modifying
    void deleteGameInUsersById(Long gameId);

    @Query(nativeQuery = true, value = "DELETE FROM users_shopping_cart__products WHERE product_id = ?1")
    @Modifying
    void deleteGameInCartsById(Long gameId);
}
