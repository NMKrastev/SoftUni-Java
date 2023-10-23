package bg.softuni.sa01_webapiandrestcontrollers.model.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;
import lombok.*;

import java.util.List;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Entity
@Table(name = "authors")
public class Author extends BaseEntity{

    private String name;

    @OneToMany(mappedBy = "author")
    private List<Book> books;
}
