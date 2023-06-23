package com.example.A2_UserSystem.models;


import com.example.A2_UserSystem.models.annotations.email.Email;
import com.example.A2_UserSystem.models.annotations.password.Password;
import jakarta.persistence.*;
import jakarta.validation.constraints.Size;
import lombok.*;

import java.time.LocalDate;
import java.util.Set;

@Getter
@Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "users")
public class User extends BaseEntity {

    @Column(nullable = false)
    @Size(min = 4, max = 30)
    private String username;

    @Column(nullable = false)
    //"Contains" fields are grayed out because that is their default value(true)
    @Password(minLength = 8, maxLength = 20, containsDigit = true,
            containsLowercase = true, containsUppercase = true, containsSpecialSymbol = true)
    private String password;

    @Column(nullable = false)
    @Email
    private String email;

    @Column(name = "registered_on", columnDefinition = "DATETIME", nullable = false)
    private LocalDate registeredOn;

    @Column(name = "last_time_logged_in", columnDefinition = "DATETIME")
    private LocalDate lastTimeLoggedIn;

    @Column
    private Integer age;

    @Column(name = "is_deleted", nullable = false)
    private Boolean isDeleted;

    @ManyToOne
    private Town bornInTown;

    @ManyToOne
    private Town currentlyLivingInTown;

    @Column(name = "first_name")
    private String firstName;

    @Column(name = "last_name")
    private String lastName;

    private String fullName;

    @ManyToMany
    @JoinTable(name = "users_friends", joinColumns = @JoinColumn(name = "user_id"), inverseJoinColumns = @JoinColumn(name = "friend_id"))
    private Set<User> friends;

    @OneToMany
    @JoinTable(name = "users_albums", joinColumns = @JoinColumn(name = "user_id"), inverseJoinColumns = @JoinColumn(name = "album_id"))
    private Set<Album> albums;

}
