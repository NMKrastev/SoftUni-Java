package A4_HospitalDatabase;

import jakarta.persistence.*;

import java.util.HashSet;
import java.util.Set;

@Entity
@Table(name = "diagnoses")
public class Diagnose {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    @Column
    private String name;
    @Column(columnDefinition = "TEXT", length = 1000)
    private String comment;
    @OneToMany(mappedBy = "diagnose")
    private Set<Visitation> visitations;

    public Diagnose() {
        this.visitations = new HashSet<>();
    }

    public Diagnose(String name, String comment) {
        this();
        this.name = name;
        this.comment = comment;
    }

    public Integer getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getComment() {
        return comment;
    }

    public void setComment(String comment) {
        this.comment = comment;
    }

    public Set<Visitation> getVisitations() {
        return visitations;
    }

    public void setVisitations(Set<Visitation> visitations) {
        this.visitations = visitations;
    }
}
