package bg.softuni.mobilelele.user;

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

    private String email;

    private String firstName;

    private String fullName;

    private boolean loggedIn;

    private boolean isAdmin;

    public void clear() {
        this.email = null;
        this.firstName = null;
        this.fullName = null;
        this.loggedIn = false;
        this.isAdmin = false;
    }

    public boolean isAnonymous() {
        return !isLoggedIn();
    }

    public boolean isUserAdmin() {
        return !isAdmin();
    }

}
