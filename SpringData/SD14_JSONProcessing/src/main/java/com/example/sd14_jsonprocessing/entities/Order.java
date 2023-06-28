package com.example.sd14_jsonprocessing.entities;

import jakarta.persistence.*;

import java.util.HashSet;
import java.util.Set;

@Entity
@Table(name = "orders")
public class Order extends BaseEntity {

    @ManyToOne(cascade = CascadeType.ALL, fetch = FetchType.EAGER)
    private User buyer;

    @ManyToMany(cascade = CascadeType.ALL,
            targetEntity = Game.class,
            fetch = FetchType.EAGER)
    @JoinTable(name = "orders_products",
            joinColumns = @JoinColumn(name = "order_id"),
            inverseJoinColumns = @JoinColumn(name = "product_id"))
    private Set<Game> products;

    public Order() {
        this.products = new HashSet<>();
    }

    public Order(User buyer, Set<Game> games) {
        this.buyer = buyer;
        this.products = games;
    }

    public User getBuyer() {
        return buyer;
    }

    public void setBuyer(User user) {
        this.buyer = user;
    }

    public Set<Game> getProducts() {
        return products;
    }

    public void setProducts(Set<Game> games) {
        this.products = games;
    }
}
