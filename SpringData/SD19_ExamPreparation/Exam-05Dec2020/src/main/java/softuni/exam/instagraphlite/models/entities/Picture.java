package softuni.exam.instagraphlite.models.entities;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.hibernate.annotations.Fetch;
import org.hibernate.annotations.FetchMode;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.validation.constraints.Max;
import javax.validation.constraints.Min;
import java.util.List;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "pictures")
public class Picture extends BaseEntity {

    @Column(unique = true, nullable = false)
    private String path;

    @Column(nullable = false)
    @Min(500)
    @Max(60000)
    private Double size;

    @OneToMany(mappedBy = "picture")
    @Fetch(FetchMode.JOIN)
    private List<Post> post;
}
