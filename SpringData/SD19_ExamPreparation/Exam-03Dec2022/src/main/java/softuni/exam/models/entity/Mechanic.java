package softuni.exam.models.entity;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;
import javax.validation.constraints.Email;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "mechanics")
public class Mechanic extends BaseEntity {

    @Column(name = "first_name", unique = true, nullable = false)
    private String firstName;

    @Column(name = "last_name", nullable = false)
    private String lastName;

    @Column(unique = true, nullable = false)
    @Email
    private String email;

    @Column(unique = true)
    private String phone;

    public String getFullName() {

        return this.firstName + " " + this.lastName;
    }
}
