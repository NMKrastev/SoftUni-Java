package com.example.planner_app.user;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.stereotype.Component;
import org.springframework.web.context.annotation.SessionScope;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Component
@SessionScope
public class CurrentUser {

    private Long id;

    private String email;

    private String username;

    private boolean loggedIn;

    public void clear() {
        this.id = null;
        this.email = null;
        this.username = null;
        this.loggedIn = false;
    }

    public boolean isAnonymous() {
        return !isLoggedIn();
    }
}
