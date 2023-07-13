package softuni.exam.instagraphlite.models.dtos.user;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import softuni.exam.instagraphlite.models.entities.User;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class UserByPostCountDTO {

    private User user;

    private Long postCount;

}
