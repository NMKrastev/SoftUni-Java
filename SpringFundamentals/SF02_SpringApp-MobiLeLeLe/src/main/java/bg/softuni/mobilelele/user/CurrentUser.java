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

    private String fullName;

    private boolean loggedIn;

    public void clear() {
        this.loggedIn = false;
        this.fullName = null;
    }

    public boolean isAnonymous() {
        return !isLoggedIn();
    }

}
