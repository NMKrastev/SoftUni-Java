package A6_FootballBettingDatabase;

import jakarta.persistence.*;

@Entity
@Table(name = "colors")
public class Color {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    @Column
    private String name;

    public Color() {}
}
