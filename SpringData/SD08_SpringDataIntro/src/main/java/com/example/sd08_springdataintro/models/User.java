package com.example.sd08_springdataintro.models;

import jakarta.persistence.*;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

@Entity
@Table(name = "users")
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(unique = true)
    private String username;

    @Column
    private Integer age;

    @OneToMany(cascade = CascadeType.ALL )
    private List<Account> accounts;

    public User() {
        this.accounts = new ArrayList<>();
    }

    public User(String username, int age, Account account) {
        this();
        this.username =  username;
        this.age = age;
        this.accounts.add(account);
    }

    public Long getId() {
        return id;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public Integer getAge() {
        return age;
    }

    public void setAge(Integer age) {
        this.age = age;
    }

    public List<Account> getAccounts() {
        return Collections.unmodifiableList(accounts);
    }

    public void addAccount(Account account) {

    }

    public void removeAccount(Account account) {

    }
}
