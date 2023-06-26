package com.example.sd13_exercisespringdataautomappingobjects.repositories;

import com.example.sd13_exercisespringdataautomappingobjects.entities.Game;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.Optional;
import java.util.Set;

@Repository
public interface GameRepository extends JpaRepository<Game, Long> {

    Optional<Game> findFirstByTitle(String title);

    @Query(nativeQuery = true, value = "SELECT * FROM games AS g JOIN user_shopping_cart__games AS uscg ON g.id = uscg.game_id WHERE user_id = ?1")
    Optional<Set<Game>> findAllGamesInUserCart(Long userId);
}
