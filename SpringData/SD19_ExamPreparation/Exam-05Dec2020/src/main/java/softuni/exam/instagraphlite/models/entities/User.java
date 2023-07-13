package softuni.exam.instagraphlite.models.entities;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.hibernate.annotations.Fetch;
import org.hibernate.annotations.FetchMode;

import javax.persistence.*;
import javax.validation.constraints.Size;
import java.util.List;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "users")
public class User extends BaseEntity {

    @Column(unique = true, nullable = false)
    @Size(min = 2, max = 18)
    private String username;

    @Column(nullable = false)
    @Size(min = 4)
    private String password;

    @ManyToOne(optional = false)
    @JoinColumn(name = "profile_picture")
    @Fetch(FetchMode.JOIN)
    private Picture profilePicture;

    @OneToMany(mappedBy = "user")
    @Fetch(FetchMode.JOIN)
    private List<Post> posts;
}
