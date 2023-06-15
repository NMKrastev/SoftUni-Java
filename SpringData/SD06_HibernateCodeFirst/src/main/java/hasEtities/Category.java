package hasEtities;

import jakarta.persistence.*;

import java.util.HashSet;
import java.util.Set;

@Entity
@Table(name = "categories")
public class Category {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "name")
    private String name;

    @ManyToMany(targetEntity = Article.class, mappedBy = "categories")
    private Set<Article> articles;

    public Category() {
        this.articles = new HashSet<>();
    }

    public Category(String name) {
        this();

        this.name = name;
    }
}
