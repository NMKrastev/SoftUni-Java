package softuni.exam.domain.entities;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.hibernate.annotations.Fetch;
import org.hibernate.annotations.FetchMode;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.validation.constraints.Size;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "teams")
public class Team extends BaseEntity{

    @Column(nullable = false)
    @Size(min = 3, max = 20)
    private String name;

    @ManyToOne(optional = false)
    @Fetch(FetchMode.JOIN)
    private Picture picture;

}
