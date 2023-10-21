package bg.softuni.dictionaryApp.user;

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

    private String username;

    private boolean loggedIn;

    public void clear() {
        this.username = null;
        this.loggedIn = false;
    }

    public boolean isAnonymous() {
        return !isLoggedIn();
    }
}
