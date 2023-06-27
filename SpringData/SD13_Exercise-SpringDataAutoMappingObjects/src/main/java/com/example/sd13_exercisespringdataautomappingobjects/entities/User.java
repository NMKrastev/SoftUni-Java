package com.example.sd13_exercisespringdataautomappingobjects.entities;

import jakarta.persistence.*;
import jakarta.validation.constraints.Email;

import java.util.HashSet;
import java.util.LinkedHashSet;
import java.util.Set;

import static com.example.sd13_exercisespringdataautomappingobjects.constants.Validations.EMAIL_PATTERN;

@Entity
@Table(name = "users")
public class User extends BaseEntity {

    @Column(nullable = false, unique = true)
    @Email(regexp = EMAIL_PATTERN)
    private String email;

    @Column(nullable = false)
    private String password;

    @Column(name = "full_name", nullable = false)
    private String fullName;

    @Column(columnDefinition = "TINYINT")
    private Boolean isAdministrator;

    @ManyToMany(cascade = CascadeType.ALL,
            fetch = FetchType.EAGER)
    @JoinTable(name = "users_games",
            joinColumns = @JoinColumn(name = "user_id"),
            inverseJoinColumns = @JoinColumn(name = "game_id"))
    private Set<Game> games;


    @OneToMany(mappedBy = "user",
            cascade = CascadeType.ALL,
            targetEntity = Order.class,
            fetch = FetchType.EAGER)
    private Set<Order> orders;

    @OneToMany(cascade = CascadeType.ALL, fetch = FetchType.EAGER)
    @JoinTable(name = "user_shopping_cart__games",
            joinColumns = @JoinColumn(name = "user_id"),
            inverseJoinColumns = @JoinColumn(name = "game_id"))
    private Set<Game> shoppingCart;


    public User() {
        this.games = new HashSet<>();
        this.orders = new HashSet<>();
        this.shoppingCart = new LinkedHashSet<>();
    }

    public User(String email, String password, String fullName) {
        this();
        this.email = email;
        this.password = password;
        this.fullName = fullName;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getFullName() {
        return fullName;
    }

    public void setFullName(String fullName) {
        this.fullName = fullName;
    }

    public Boolean getAdministrator() {
        return isAdministrator;
    }

    public void setAdministrator(Boolean administrator) {
        isAdministrator = administrator;
    }

    public Set<Game> getGames() {
        return games;
    }

    public void setGames(Set<Game> games) {
        this.games = games;
    }

    public Set<Order> getOrders() {
        return orders;
    }

    public void setOrders(Set<Order> orders) {
        this.orders = orders;
    }

    public Set<Game> getShoppingCart() {
        return shoppingCart;
    }

    public void setShoppingCart(Set<Game> shoppingCart) {
        this.shoppingCart = shoppingCart;
    }
}
