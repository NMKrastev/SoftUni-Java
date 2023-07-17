package exam.model.entity;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.hibernate.annotations.Fetch;
import org.hibernate.annotations.FetchMode;

import javax.persistence.*;
import javax.validation.constraints.Email;
import javax.validation.constraints.Size;
import java.time.LocalDate;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "customers")
public class Customer extends BaseEntity {

    @Column(name = "first_name")
    @Size(min = 2)
    private String firstName;

    @Column(name = "last_name")
    @Size(min = 2)
    private String lastName;

    @Column(unique = true)
    @Email
    private String email;

    @Column(name = "registered_on")
    private LocalDate registeredOn;

    @ManyToOne(fetch = FetchType.EAGER)
    @Fetch(FetchMode.JOIN)
    private Town town;

    public String getFullName() {
        return this.firstName + " " + this.lastName;
    }
}
