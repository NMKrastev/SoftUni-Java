package bg.softuni.sa02_springsecurity.model.entity;

import bg.softuni.sa02_springsecurity.model.enums.RoleEnum;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "roles")
public class UserRole extends BaseEntity {

    @Column(nullable = false)
    @Enumerated(EnumType.STRING)
    private RoleEnum name;

    @Override
    public String toString() {
        return "RoleEntity{" +
                "name=" + name +
                '}';
    }
}
