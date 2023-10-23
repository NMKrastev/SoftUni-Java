package bg.softuni.sa01_webapiandrestcontrollers.model.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import lombok.*;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Entity
@Table(name = "books")
public class Book extends BaseEntity {

    private String title;

    private String isbn;

    @ManyToOne
    private Author author;
}
