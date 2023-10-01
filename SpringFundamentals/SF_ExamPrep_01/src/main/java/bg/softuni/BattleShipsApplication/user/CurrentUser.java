package bg.softuni.BattleShipsApplication.user;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.stereotype.Component;
import org.springframework.web.context.annotation.SessionScope;

@Getter
@Setter
@NoArgsConstructor
@Component
@SessionScope
public class CurrentUser {

    private Long id;

    private String email;

    private String username;

    private String fullName;

    private boolean loggedIn;

    public void clear() {
        this.id = null;
        this.email = null;
        this.username = null;
        this.fullName = null;
        this.loggedIn = false;
    }

    public boolean isAnonymous() {
        return !isLoggedIn();
    }
}
